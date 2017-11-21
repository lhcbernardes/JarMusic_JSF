
package br.com.projeto.repository;

import br.com.projeto.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author leand
 */
@Stateless
public class UsuarioRepository extends GenericDao<Usuario>{
    
    public UsuarioRepository(){
        super(Usuario.class);
    }
    
    public String autenticar(String login, String senha){
        EntityManager entityManager = getEntityManager();
        //mudar
        //mudar
        //mudar
        //mudar
        //mudar
        //mudar
        String sql = "FROM Usuario u WHERE u.txtLogin = " + login + " and u.txtSenha = " + senha;
        
        Usuario usuario = null;
        usuario = (Usuario) entityManager.createQuery(sql).getSingleResult();
        
        if(usuario == null){
            return "falha";
        } else{
            return "sucesso";
        }
    }
    
     //mudar
        //mudar
        //mudar
        //mudar
        //mudar
        //mudar
    public List<String> buscaEstados(){
        EntityManager entityManager = getEntityManager();
        
        String sql = " DISTINCT u.endTxtEstado From Usuario u";
        
        return entityManager.createQuery(sql).getResultList();
    }
     //mudar
        //mudar
        //mudar
        //mudar
        //mudar
        //mudar
    public List<String> buscaCidades(String estado){
        EntityManager entityManager = getEntityManager();
        
        String sql = " DISTINCT u.endTxtCidade From Usuario u WHERE u.endTxtEstado like " + estado;
        
        return entityManager.createQuery(sql).getResultList();
    }
}
