
package br.com.projeto.repository;

import br.com.projeto.domain.Premium;
import javax.ejb.Stateless;

/**
 *
 * @author leand
 */
@Stateless
public class CompradorRepository extends GenericDao<Premium>{

    public CompradorRepository(){
        super(Premium.class);
    }
}
