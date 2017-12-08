package br.com.projeto.beans;

import br.com.projeto.domain.Gravadora;
import br.com.projeto.repository.ProfissionalRepository;
import br.com.projeto.repository.UsuarioRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;

/**
 *
 * @author leand
 */
@ManagedBean(name = "managedGravadoraBean")
@ViewScoped
public class GravadoraBean implements Serializable{
    
    @EJB
    private ProfissionalRepository GravadoraRepository;
    
    @EJB
    private UsuarioRepository usuarioRepository;
    
    private Gravadora gravadora;
    private List<Gravadora> listaGravadora;
    

 

    public Gravadora getGravadora() {
        return gravadora;
    }

    public void setGravadora(Gravadora gravadora) {
        this.gravadora = gravadora;
    }

    
    
    public void salvar(){
    
    
    }

    public ProfissionalRepository getGravadoraRepository() {
        return GravadoraRepository;
    }

    public void setGravadoraRepository(ProfissionalRepository GravadoraRepository) {
        this.GravadoraRepository = GravadoraRepository;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Gravadora> getListaGravadora() {
        return listaGravadora;
    }

    public void setListaGravadora(List<Gravadora> listaGravadora) {
        this.listaGravadora = listaGravadora;
    }

   
    
}
