/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private ProfissionalRepository profissionalRepository;
    
    @EJB
    private UsuarioRepository usuarioRepository;
    
    private Gravadora profissional;
    private List<Gravadora> listaProfissionais;
    
    private List<String> listaCidades;
    private String estado, cidade, profissaoEscolhida;
    
//    @PostConstruct
//    public void constroiProfissional(){
//        profissional = new Profissional();
//        profissao = new Profissoes();
//        listaProfissoes = new ArrayList<>();
//        
//        listarProfissoes();
//    }
//    
    public void resetProfissao(){
        profissao = new Profissoes();
    }
    
    public void createNew() {
        if(listaProfissoes.contains(profissao)) {
            Messages.addGlobalError("Esta profissão já foi adicionada");
        } 
        else {
            listaProfissoes.add(profissao);
            resetProfissao();
        }
    }

    public Gravadora getProfissional() {
        return profissional;
    }

    public void setProfissional(Gravadora profissional) {
        this.profissional = profissional;
    }

    public Profissoes getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissoes profissao) {
        this.profissao = profissao;
    }

    public List<Gravadora> getListaProfissionais() {
        return listaProfissionais;
    }

    public void setListaProfissionais(List<Gravadora> listaProfissionais) {
        this.listaProfissionais = listaProfissionais;
    }

    public List<Profissoes> getListaProfissoes() {
        return listaProfissoes;
    }

    public void setListaProfissoes(List<Profissoes> listaProfissoes) {
        this.listaProfissoes = listaProfissoes;
    }
    

    public List<String> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<String> listaCidades) {
        this.listaCidades = listaCidades;
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

    public String getProfissaoEscolhida() {
        return profissaoEscolhida;
    }

    public void setProfissaoEscolhida(String profissaoEscolhida) {
        this.profissaoEscolhida = profissaoEscolhida;
    }
    
    public void listarProfissionais(){
        listaProfissionais = profissionalRepository.listar();
    }
    
    public void listarProfissionaisProfissoes(){
        listaProfissionais = profissionalRepository.buscaProfissionaisProfissao(profissao.getTxtProfissoes());
    }
    
    public void listarProfissoes(){
        listaProfissoes = profissionalRepository.buscaProfissoes();
    }
    
    public void salvar(){}
    
    public void onCidadeChange() {
        if(estado != null && !estado.equals("")){
//            listarCidades();
        }else
            listaCidades = new ArrayList<>();
    }
}
