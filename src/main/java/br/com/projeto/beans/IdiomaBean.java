
package br.com.projeto.beans;

import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author leand
 */
@ManagedBean(name = "managedIdiomaBean")
@SessionScoped
public class IdiomaBean implements Serializable {

    private Locale currentLocale = new Locale("pt", "BR");

    public void ingles() {
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        currentLocale = new Locale("en", "US");
        viewRoot.setLocale(currentLocale);
    }

    public void portugues() {
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        currentLocale = new Locale("pt", "BR");
        viewRoot.setLocale(currentLocale);
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }
}
