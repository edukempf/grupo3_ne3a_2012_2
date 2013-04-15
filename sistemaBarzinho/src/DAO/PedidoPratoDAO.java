/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import static DAO.DaoBasic.session;
import Modelo.PedidoPrato;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Ligue01
 */
public class PedidoPratoDAO extends DaoBasic<PedidoPrato>{
     public PedidoPratoDAO() {
        super(PedidoPrato.class); 
    }
     
     public List<PedidoPrato> buscaTodosPedidos(){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
//        List list = session.createCriteria(classe).setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("id")))).list();
        Query query = session.createQuery("from PedidoPrato as p group by(p.id)");
        List list = query.list();
        session.close();
        return list;
    }
    
       public List<PedidoPrato> buscaPorMesa(int nmesa){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
//        List list = session.createCriteria(classe).add(Restrictions.eq("idMesa", nmesa)).list();
        Query query=session.createQuery("from PedidoPrato as p where p.idMesa.id = :nmesa").setParameter("nmesa", nmesa);
        List list=query.list();
        session.close(); 
        return list;
    }
    
}