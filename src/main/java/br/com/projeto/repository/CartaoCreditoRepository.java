package br.com.projeto.repository;

import br.com.projeto.domain.CartaoCredito;
import javax.ejb.Stateless;

/**
 *
 * @author leand
 */
@Stateless
public class CartaoCreditoRepository extends GenericDao<CartaoCredito>{
    
    public CartaoCreditoRepository() {
        super(CartaoCredito.class);
    }
}
