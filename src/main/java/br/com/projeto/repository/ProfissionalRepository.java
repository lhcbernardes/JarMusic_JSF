
package br.com.projeto.repository;

import br.com.projeto.domain.Gravadora;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author leand
 */
@Stateless
public class ProfissionalRepository extends GenericDao<Gravadora> {

    public ProfissionalRepository() {
        super(Gravadora.class);
    }


    public List<Gravadora> buscaGravadoras(String profissao) {
        EntityManager entityManager = getEntityManager();
	//mudar
	//mudar
	//mudar
	//mudar
	//mudar
	//mudar
        String sql = "SELECT ID_USUARIO, DISC_USUARIO, DT_NASCIMENTO, END_NUMERO, END_TXT_BAIRRO, END_TXT_CEP, END_TXT_CIDADE, END_TXT_COMPLEMENTO, END_TXT_ESTADO, END_TXT_LOGRADOURO, TXT_CPF, TXT_EMAIL, TXT_FOTO, TXT_LOGIN, TXT_NOME, TXT_SAL, TXT_SENHA, SERVICOS, TXT_REPUTACAO FROM tb_profissional p INNER JOIN tb_profissoes ps ON p.id_profissional = ps.id_usuario WHERE ps.txt_nome LIKE " + profissao;

        return entityManager.createNativeQuery(sql).getResultList();
    }
}
