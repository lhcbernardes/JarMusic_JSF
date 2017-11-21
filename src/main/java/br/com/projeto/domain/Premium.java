/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author leand
 */
@Entity
@Table(name="TB_PREMIUM") 
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name="ID_USUARIO", referencedColumnName = "ID_USUARIO")
public class Premium extends Usuario implements Serializable
{
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "ID_CARTAO_CREDITO", referencedColumnName = "ID_CARTAO_CREDITO")
    private CartaoCredito cartaoCredito;
    
    @OneToMany(mappedBy = "comprador", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Musica> musicas;
    
    public List<Musica> getOfertas() {
        return musicas;
    }

    public boolean adicionar(Musica musica) {
        return musicas.add(musica);
    }

    public CartaoCredito getCartaoCredito() {
	return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
	this.cartaoCredito = cartaoCredito;
    }

    public List<Musica> getMusicas() {
	return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
	this.musicas = musicas;
    }
    
    
}
