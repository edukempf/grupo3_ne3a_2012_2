/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import static DAO.DaoBasic.session;
import Modelo.PedidoPrato;
import Modelo.Prato;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Ligue01
 */
public class PratoDAO extends DaoBasic<Prato>{
     public PratoDAO() {
        super(Prato.class);
    }
     
      public List<Prato> buscaPorNome(String nome){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        Query query=session.createQuery("from Prato as p where p.nome like :nome group by (p.id)").setParameter("nome", nome);
//        List list = session.createCriteria(classe).add(Restrictions.like("nome", "%"+nome+"%")).setProjection(Projections.projectionList().add(Projections.groupProperty("id"))).list();
        List list=query.list();
        session.close(); 
        return list;
    }
    
}
