package br.com.projeto.domain;

/**
 *
 * @author leand
 */

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_CARTAO_CREDITO")
public class CartaoCredito implements Serializable {
    @Id
    @Column(name = "ID_CARTAO_CREDITO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;  
    
    @NotNull
    @OneToOne(mappedBy = "cartaoCredito", optional = false)
    private Premium dono;
    
    @NotBlank
    @Size(max = 15)
    @Column(name = "TXT_BANDEIRA", nullable = false, length = 100)
    private String bandeira;
    
    @NotNull
    @CreditCardNumber
    @Column(name = "TXT_NUMERO", nullable = false, length = 30)
    private String numero;
    
    @NotNull
    @Future    
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_EXPIRACAO", nullable = false)
    private Date dataExpiracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Premium getDono() {
        return dono;
    }

    public void setDono(Premium dono) {
        this.dono = dono;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
    
}