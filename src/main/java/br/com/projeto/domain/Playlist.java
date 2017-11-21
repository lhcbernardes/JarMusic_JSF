/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
/**
 *
 * @author leand
 */
@Entity
@Table(name = "TB_PLAYLIST")
public class Playlist implements Serializable{
    
    @Id
    @Column(name = "ID_PLAYLIST")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 50)
    @Column(name = "TXT_TITULO", nullable = false)
    protected String titulo;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_RADIO_PLAYLIST_MUSICA", 
            joinColumns = @JoinColumn(name = "ID_RADIO_PLAYLIST"),
            inverseJoinColumns = @JoinColumn(name = "ID_MUSICA")
    )        
    private List<Musica> musicas;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;
    
    public List<Musica> getMusicas() {
	return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
	this.musicas = musicas;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
	return usuario;
    }

    public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
