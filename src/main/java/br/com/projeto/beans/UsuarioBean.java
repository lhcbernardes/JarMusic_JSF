
package br.com.projeto.beans;

import br.com.projeto.domain.Grupo;
import br.com.projeto.domain.Telefone;
import br.com.projeto.domain.Usuario;
import br.com.projeto.repository.GrupoRepository;
import br.com.projeto.repository.UsuarioRepository;
import br.com.projeto.util.WebServiceCep;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "managedUsuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

    @EJB
    private UsuarioRepository usuarioRepository;
    
    @EJB
    private GrupoRepository grupoRepository;
    
    private final String PATH_FOTO = "C:/Users/Usuario/Documents/Projetos_Github/SourceTree_Projetos/IService/uploads";

    private Usuario usuario;
    private List<Usuario> listaUsuarios;
    private Telefone telefone;
    private List<Telefone> listaTelefones;
    private List<String> listaCidades;
    private List<String> listaEstados;
    private String estado, cidade;
    
    private boolean skip;

    public UsuarioBean() {

    }

    @PostConstruct
    public void constroi() {
        usuario = new Usuario();
        telefone = new Telefone();
        listaTelefones = new ArrayList<>();
        listaCidades = new ArrayList<>();
        listaEstados = new ArrayList<>();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public List<Telefone> getListaTelefones() {
        return listaTelefones;
    }

    public void setListaTelefones(List<Telefone> listaTelefones) {
        this.listaTelefones = listaTelefones;
    }

    public List<String> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<String> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public List<String> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<String> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public void inserir() {

        String successMsg = "Usuário inserido com sucesso!";
        String errorMsg = "Erro ao inserir o usuário. Por favor, tente novamente.";
        
        try {
            usuario.setGrupo(grupoRepository.getGrupo(Grupo.GRUPO_POR_NOME, new String[]{Usuario.USUARIO}));
            Usuario usuarioRetorno = usuarioRepository.atualizar(usuario);
            
            if(usuario.getCaminhoFoto() != null){
                //Pega o caminho do arvuido temporário e associa a origem
                Path origem = Paths.get(usuario.getCaminhoFoto());
                Path destino = Paths.get(PATH_FOTO + usuarioRetorno.getIdUsuario() + ".png");
            
                Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
            }

            Messages.addGlobalInfo(successMsg);
        } catch (RuntimeException | IOException ex) {

            Messages.addGlobalError(errorMsg);
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void atualizar(ActionEvent evento) {
        usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
    }

    public void remover(ActionEvent evento) {

        String successMsg = "Usuário removido com sucesso!";
        String errorMsg = "Erro ao remover usuário. Por favor, tente novamente.";

        try {
            usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
            usuarioRepository.remover(usuario);
            
            //Remove a foto
            Path caminhoArquivo = Paths.get(PATH_FOTO + usuario.getIdUsuario() + ".png");
            Files.deleteIfExists(caminhoArquivo);

            Messages.addGlobalInfo(successMsg);
        } catch (Exception ex) {
            
            Messages.addGlobalError(errorMsg);
            
            ex.printStackTrace();
        }
    }

    public void listar() {
        
        String errorMsg = "Erro ao carregar a lista.";
        
        try {
            listaUsuarios = usuarioRepository.listar();
        } catch(Exception ex){
            Messages.addGlobalError(errorMsg);
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public String autenticar(){
        try{
            String resultado = usuarioRepository.autenticar(usuario.getTxtLogin(), usuario.getTxtSenha());
            
            if(resultado.equalsIgnoreCase("sucesso")){
                return "sucesso";
            } else {
                return "falha";
            }
            
        } catch(Exception ex){
            return "falha";
        }
    }
    
    public void uploadFoto(FileUploadEvent evento){
        
        try{
            //PrimeFaces já tem o tipo uploadedfile para facilitar o upload de arquivos
            //Pegamos o arquivo no evento (upload)
            UploadedFile arquivo = evento.getFile();
            
            //Criamos um novo arquivo temporario no nosso diretorio
            //Salvamos o caminho desse arquivo temporário na nossa variável arquivoTemporario
            //Já que o arquivo (UploadedFile) é deletado assim que o método terminar, precisaremos salvar o arquivo em algum lugar no computador
            Path arquivoTemporario = Files.createTempFile(null, null);
            
            //Copiamos o nosso arquivo
            //1º parâmetro: é para pegar os bytes que serão copiados para o novo arquivo
            //2º parâmetro: É o local que será copiado
            //3º parâmetro: Método de cópia (substitui se já existir)
            Files.copy(arquivo.getInputstream(), arquivoTemporario, StandardCopyOption.REPLACE_EXISTING);
            
            //Salvamos o caminho da foto (já existente  no pc), na nossa variável
            usuario.setCaminhoFoto(arquivoTemporario.toString());
            
            Messages.addGlobalInfo("Upload realizado com sucesso");
            
        } catch(IOException exception){
            Messages.addGlobalError("Ocorreu um erro realizar o upload da foto");
            exception.printStackTrace();
        }
    }
    
    public void buscaCep() {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(usuario.getEndTxtCep());

        if (webServiceCep.wasSuccessful()) {

            usuario.setEndTxtLogradouro(webServiceCep.getLogradouroFull());
            usuario.setEndTxtCidade(webServiceCep.getCidade());
            usuario.setEndTxtEstado(webServiceCep.getUf());
            usuario.setEndTxtBairro(webServiceCep.getBairro());

            Messages.addGlobalInfo("Cep encontrado!");
        } else {
            
            Messages.addGlobalError("Cep não encontrado");
        }
    }
    
    public void listaEstados(){
        listaEstados = usuarioRepository.buscaEstados();
    }
    
    public void listaCidades(){
        listaEstados = usuarioRepository.buscaCidades(estado);
    }
    
    public void onEstadoChange() {
        if(estado != null && !estado.equals(""))
            listaCidades();
        else
            listaCidades = new ArrayList<>();
    }
    
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
    
    public boolean isSkip(){
        return skip;
    }
    
    public void setSkip(boolean skip){
        this.skip = skip;
    }

}
