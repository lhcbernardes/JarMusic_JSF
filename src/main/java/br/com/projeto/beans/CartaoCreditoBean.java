
package br.com.projeto.beans;

import br.com.projeto.domain.CartaoCredito;
import br.com.projeto.repository.CartaoCreditoRepository;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author leand
 */
@ManagedBean(name = "managedCartaoCreditoBean")
@ViewScoped
public class CartaoCreditoBean implements Serializable{
    
    @EJB
    private CartaoCreditoRepository cartaoCreditoRepository;
    
    private CartaoCredito cartaoCredito;
}
