/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DaoBasic.session;
import Modelo.Funcionario;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Eduardo
 */
public class FuncionarioDAO extends DaoBasic<Funcionario> {

    public FuncionarioDAO() {
        super(Funcionario.class);
    }
//    private String sqlBuscaPorNome="from Funcionario as f where f.nome like :nome";

    public List<Funcionario> buscaPorNome(String nome) {
        session = HibernateConexao.getSession();
        session.beginTransaction().begin();
//        Query query=session.createSQLQuery(sqlBuscaPorNome).setParameter("nome", nome);
        List list = session.createCriteria(classe).add(Restrictions.like("nome", "%" + nome + "%")).list();
        session.close();
        return list;
    }

    public boolean buscaSeCpfJaExiste(String cpf) {
        session = HibernateConexao.getSession();
        session.beginTransaction().begin();
//        Query query=session.createSQLQuery(sqlBuscaPorNome).setParameter("nome", nome);
        List list = session.createCriteria(classe).add(Restrictions.eq("cpf", cpf)).list();
        session.close();
        if (!list.isEmpty()) {
            return true;
        }
        return false;
    }
}
