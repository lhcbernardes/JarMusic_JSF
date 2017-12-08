/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.repository;

import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Usuario
 * @param <Entidade>
 */
public abstract class GenericDao<Entidade> {

    private final Class<Entidade> classe;

    // Captura a classe passada no local de Entidade
    // Quando o dao específico implementa o Generic Dao passando a sua classe
    // nesse método no getGenericSuperClass() ele recebe o "GenericDao<Usuario>"
    // De GenerecDao<Usuario> ele extrai o parâmetro passado (Usuario) e atribui a classe
    public GenericDao(Class<Entidade> classe) {
        this.classe = classe;
    }
//
    //
    //
    //
    //MUdar nome
    //Mudar nome
    //Mudar nome
    //Mudar nome
    //Mudar nome
    @PersistenceContext(unitName = "jarmusic")
    private EntityManager em;
    
    public EntityManager getEntityManager(){
        return em;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void salvar(Entidade entidade) {
        em.persist(entidade);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Entidade atualizar(Entidade entidade) {
        Entidade retorno = (Entidade) em.merge(entidade);
        
        return retorno;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remover(Entidade entidade) {
        em.remove(em.merge(entidade));
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Entidade buscar(Long idEntidade) {
        return em.find(classe, idEntidade);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Entidade> listar() {

        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(classe));

        //return (List<Entidade>) em.createQuery("From " + classe + " c").getResultList();
        return em.createQuery(criteria).getResultList();
    }
}
