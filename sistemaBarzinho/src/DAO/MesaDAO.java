/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Mesa;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Juliana
 */
public class MesaDAO extends DaoBasic<Mesa>{

    public MesaDAO() {
        super(Mesa.class);
    }
    
     public List<Mesa> buscaMesa(int cod){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        Query query=session.createQuery("from Mesa as m where m.id = :nmesa").setParameter("nmesa", cod);
        List list=query.list();
        session.close(); 
        return list;
    }
    
    
}
