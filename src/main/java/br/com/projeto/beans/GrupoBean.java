
package br.com.projeto.beans;

import br.com.projeto.domain.Grupo;
import br.com.projeto.repository.GrupoRepository;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author leand
 */
@ManagedBean(name = "grupoBean")
@ViewScoped
public class GrupoBean implements Serializable{

    @EJB
    private GrupoRepository grupoRepository;

    public GrupoBean() {

    }

    public Grupo getGrupo(String nomeGrupo) {
        return grupoRepository.getGrupo(Grupo.GRUPO_POR_NOME, new String[]{nomeGrupo});
    }

}
