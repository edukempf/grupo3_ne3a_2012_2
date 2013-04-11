/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Bebida;
import java.util.List;
import org.hibernate.criterion.Restrictions;



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
        List list = session.createCriteria(classe).add(Restrictions.like("nome", "%"+nome+"%")).list();
        session.close(); 
        return list;
    }
    
    
}
    

