/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Funcionario;
import java.util.List;



/**
 *
 * @author Eduardo
 */
public class FuncionarioDAO extends DaoBasic<Funcionario> {

    public FuncionarioDAO() {
        super(Funcionario.class);
    }
    
    public List<Funcionario> buscaPorNome(String nome){
        session=HibernateConexao.iniciaConexao();
        session.beginTransaction().begin();
        List list = session.createQuery("from Funcionario as f where f.nome like '%"+nome+"%'").list();
        session.beginTransaction().commit();
        HibernateConexao.fechaConexao(session);
        return list;
    }
    
}
