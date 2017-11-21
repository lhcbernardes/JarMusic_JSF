package br.com.projeto.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author leand
 */
@Entity
@Table(name = "TB_USUARIO")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Usuario.PorNome",
                    query = "SELECT c FROM Usuario c WHERE c.nome LIKE :nome ORDER BY c.id"
            )
        }
)
@NamedNativeQueries(
        {
            @NamedNativeQuery(
                    name = "Usuario.PorNomeSQL",
                    query = "SELECT ID_USUARIO, TXT_NOME, TXT_EMAIL, TXT_SENHA FROM TB_USUARIO WHERE TXT_NOME LIKE ? ORDER BY ID_USUARIO",
                    resultClass = Usuario.class
            ),
            @NamedNativeQuery(
                    name = "Usuario.QuantidadePlaylistSQL",
                    query = "SELECT c.ID_USUARIO, c.TXT_NOME, c.TXT_EMAIL, c.TXT_SENHA count(ic.ID_USUARIO) as TOTAL_PLAYLISTS from TB_USUARIO c, TB_PLAYLIST_MUSICA ic where c.TXT_NOME LIKE ? and c.ID_USUARIO = ic.ID_USUARIO GROUP BY c.ID_USUARIO",
                    resultSetMapping = "Usuario.QuantidadePlaylists"
            )
        }
)
@SqlResultSetMapping(
        name = "Usuario.QuantidadePlaylists",
        entities = {
            @EntityResult(entityClass = Usuario.class)},
        columns = {
            @ColumnResult(name = "TOTAL_PLAYLISTS", type = Long.class)}
)
public class Usuario implements Serializable {
    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "\\p{Upper}{1}\\p{Lower}+")
    @Column(name = "TXT_NOME", nullable = false)
    protected String nome;
    
    @NotBlank
    @Size(max = 50)
    @Column(name = "TXT_EMAIL", nullable = false)
    protected String email;
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Playlist> playlist;
    
    @NotBlank
    @Size(min = 6, max = 10)
    @Pattern(regexp = "((?=.*\\p{Digit})(?=.*\\p{Lower}).{6,10})")
    @Column(name = "TXT_SENHA", nullable = false)
    protected String senha;
    
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }
    
    public List<Playlist> getPlaylist() {
	return playlist;
    } 

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public void setPlaylist(List<Playlist> playlist) {
        this.playlist = playlist;
    }

  
    
}
