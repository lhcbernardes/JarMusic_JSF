
package br.com.projeto.beans;

import br.com.projeto.domain.Premium;
import br.com.projeto.repository.CompradorRepository;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author leand
 */
@ManagedBean(name = "managedCompradorBean")
@ViewScoped
public class PremiumBean implements Serializable{
    
    @EJB
    private CompradorRepository PremiumRepository;
    
    private Premium premium;
}
