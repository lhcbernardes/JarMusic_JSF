/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.repository;

import br.com.projeto.domain.Grupo;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author leand
 */
@Stateless
public class GrupoRepository extends GenericDao<Grupo> {

    public GrupoRepository() {
        super(Grupo.class);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Grupo> listarGrupos() {
        EntityManager em = getEntityManager();

        return (List<Grupo>) em.createQuery("From Grupo g").getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Grupo getGrupo(String nomeGrupo, String[] grupos) {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Grupo> query = em.createQuery("SELECT g FROM Grupo g WHERE g.strNome = ?1", Grupo.class);

            int i = 1;
            for (String grupo : grupos) {
                query.setParameter(i++, grupo);
            }

            return (Grupo) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
