/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoweb.iservice2.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "managedLogoutBean")
@ViewScoped
public class LogoutBean {

    public LogoutBean() {
    }

    public String logout() throws ServletException {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        
        if (session != null) {
            session.invalidate();
        }

        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        request.logout();
        
        return "sair";
    }
}
