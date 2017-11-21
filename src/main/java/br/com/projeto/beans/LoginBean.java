
package br.com.projeto.beans;

import br.com.projeto.util.Recaptcha;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "managedLoginBean")
@RequestScoped
public class LoginBean {

    @NotBlank
    private String usuario;

    @NotBlank
    private String senha;
    private FacesContext facesContext;

    public String login() throws ServletException {

        try {

            facesContext = FacesContext.getCurrentInstance();
            Recaptcha recaptcha = new Recaptcha(facesContext);

            if (recaptcha.validar()) {
                HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
                request.login(usuario, senha);

                facesContext.getExternalContext().getSession(true);
            } else {

                setUsuario(null);
                adicionarMensagem("Captcha inválido!");

                return "falha";
            }

        } catch (ServletException ex) {

            setUsuario(null);
            adicionarMensagem("Senha ou usuário inválidos!");

            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);

            if (session != null) {
                session.invalidate();
            }

            HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
            request.logout();

            return "falha";
        }

        return "sucesso";
    }

    private void adicionarMensagem(String mensagem) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null);
        facesContext.addMessage(null, message);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
