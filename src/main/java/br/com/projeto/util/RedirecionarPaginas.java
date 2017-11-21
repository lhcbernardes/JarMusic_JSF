
package br.com.projeto.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author leand
 */
@ManagedBean(name = "managedRedicerionar")
@ViewScoped
public class RedirecionarPaginas implements Serializable {
    
    public String cadastrar2(){
        return "/pages/public/novoCadastroUsuario.xhtml?faces-redirect=true";
    }

    public void cadastrar() {
        try {
            //Pode-se colocar a linha abaixo no action do <p:commandButton>
            //"/cadastroUsuario.xhtml?faces-redirect=true";

            FacesContext.getCurrentInstance().getExternalContext().redirect("JarMusic/pages/public/novoCadastroUsuario.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(RedirecionarPaginas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void entrar() {
        try {
            //Pode-se colocar a linha abaixo no action do <p:commandButton>
            //"/cadastroUsuario.xhtml?faces-redirect=true";

            FacesContext.getCurrentInstance().getExternalContext().redirect("/pages/public/login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(RedirecionarPaginas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
