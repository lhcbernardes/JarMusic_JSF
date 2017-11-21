package br.com.projeto.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author leand
 */
@Entity
@Table(name="TB_GRAVADORA") 
@DiscriminatorValue(value = "G")
@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "ID_USUARIO")
public class Gravadora extends Usuario implements Serializable 
{
    @Column(name = "NUM_PRODUCAO")
    private Double producoes;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TXT_REPUTACAO", length = 20, nullable = false)
    private Reputacao reputacao;

    public Double getProducoes() {
	return producoes;
    }

    public void setProducoes(Double producoes) {
	this.producoes = producoes;
    }

    public Reputacao getReputacao() {
	return reputacao;
    }

    public void setReputacao(Reputacao reputacao) {
	this.reputacao = reputacao;
    }
    
    
}
