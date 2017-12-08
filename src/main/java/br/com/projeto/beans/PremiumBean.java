
package br.com.projeto.beans;

import br.com.projeto.domain.Premium;
import br.com.projeto.repository.CompradorRepository;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;

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

    public void setPremium(Premium premium) {
        this.premium = premium;
    }

    public Premium getPremium() {
        return premium;
    }
    
    
    
    public void inserir() {

        String successMsg = "Usuário inserido com sucesso!";
        String errorMsg = "Erro ao inserir o usuário. Por favor, tente novamente.";

        try {

            PremiumRepository.salvar(this.premium);

            Messages.addGlobalInfo(successMsg);
        } catch (RuntimeException ex) {

            Messages.addGlobalError(errorMsg);
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
