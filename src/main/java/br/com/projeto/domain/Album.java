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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author leandro
 */
@Entity
@Table(name = "TB_ALBUM")

public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALBUM")
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "TXT_TITULO")
    private String titulo;

    @NotBlank
    @Size(max = 20)
    @Column(name = "TXT_GENERO")
    private String genero;

    @ManyToMany(fetch = FetchType.LAZY)

    @JoinTable(name = "TB_ALBUM_MUSICA", 
            joinColumns = @JoinColumn(name = "ID_ALBUM"),
            inverseJoinColumns = @JoinColumn(name = "ID_MUSICA")
    ) 
    private List<Musica> musicas;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getTitulo() {
	return titulo;
    }

    public void setTitulo(String titulo) {
	this.titulo = titulo;
    }

    public String getGenero() {
	return genero;
    }

    public void setGenero(String genero) {
	this.genero = genero;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }


}
