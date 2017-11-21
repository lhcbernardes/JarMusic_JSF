package br.com.projeto.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author guthe_000
 */
@Entity
@Table(name="TB_ANUNCIO")
public class Anuncio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ANUNCIO")
    private Long id;
    
    @Column(name = "TXT_EMPRESA")
    private String empresa;
    
    @Column(name = "TXT_DESCRICAO")
    private String descricao;
    
    @Column(name = "TXT_CAMINHO_IMAGEM")
    private String caminhoImagem;
    
    @Column(name = "TXT_DURACAO")
    private float duracao;

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getDuracao() {
        return duracao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public Long getId() {
        return id;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
