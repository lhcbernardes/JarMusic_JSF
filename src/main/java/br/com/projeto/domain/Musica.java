package br.com.projeto.domain;

/**
 *
 * @author leand
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_MUSICA")
@NamedQueries(
	{
	    @NamedQuery(
		    name = "Musica.PorTitulo",
		    query = "SELECT c FROM Musica c WHERE c.titulo LIKE :nome ORDER BY c.id"
	    )
	}
)
@NamedNativeQueries(
	{
	    @NamedNativeQuery(
		    name = "Musica.PorNomeSQL",
		    query = "SELECT ID_MUSICA, TXT_TITULO, TXT_DURACAO, TXT_LINK, TXT_REPUTACAO FROM TB_MUSICA WHERE TXT_NOME LIKE ? ORDER BY ID_MUSICA",
		    resultClass = Musica.class)
	}
)
@SqlResultSetMapping(
	name = "Musica.Quantidade",
	entities = {
	    @EntityResult(entityClass = Musica.class)},
	columns = {
	    @ColumnResult(name = "TOTAL_MUSICAS", type = Long.class)}
)
public class Musica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MUSICA")
    private Long id;

    @NotBlank
    @Size(max = 20)
    @Column(name = "TXT_TITULO")
    private String titulo;


    @Column(name = "TXT_DURACAO")
    private float duracao;

    @NotBlank
    @Column(name = "TXT_LINK")
    private String link;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TXT_REPUTACAO")
    private Reputacao reputacao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_MUSICA_ARTISTA",
	    joinColumns = @JoinColumn(name = "ID_MUSICA"),
	    inverseJoinColumns = @JoinColumn(name = "ID_ARTISTA")
    )
    private List<Artista> artistas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_ALBUM_MUSICA",
	    joinColumns = @JoinColumn(name = "ID_MUSICA"),
	    inverseJoinColumns = @JoinColumn(name = "ID_ALBUM")
    )
    private List<Album> albuns;
    
    @ManyToOne
    @JoinTable(name = "")
    private GeneroMusica genero;

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

    public float getDuracao() {
	return duracao;
    }

    public void setDuracao(float duracao) {
	this.duracao = duracao;
    }

    public String getLink() {
	return link;
    }

    public void setLink(String link) {
	this.link = link;
    }

    public List<Artista> getArtistas() {
	return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
	this.artistas = artistas;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }

    public Reputacao getReputacao() {
	return reputacao;
    }

    public void setReputacao(Reputacao reputacao) {
	this.reputacao = reputacao;
    }

    public GeneroMusica getGenero() {
	return genero;
    }

    public void setGenero(GeneroMusica genero) {
	this.genero = genero;
    }

}
