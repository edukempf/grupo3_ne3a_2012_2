/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Bebida;
import java.util.List;



/**
 *
 * @author Eduardo
 */
public class BebidaDAO extends DaoBasic<Bebida> {

    public BebidaDAO() {
        super(Bebida.class);
    }
    
    public List<Bebida> buscaPorNome(String nome){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        List list = session.createQuery("from Bebida as f where f.nome like '%"+nome+"%'").list();
        session.beginTransaction().commit();
        HibernateConexao.fechaConexao(session);
        return list;
    }
    
}
    

