/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DaoBasic.session;
import Modelo.PedidoBebida;
import Modelo.PedidoPrato;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Eduardo
 */
public class PedidoBebidaDAO extends DaoBasic<PedidoBebida> {

    public PedidoBebidaDAO() {
        super(PedidoBebida.class);
    }

    public List<PedidoBebida> buscaTodosPedidos() {
        session = HibernateConexao.getSession();
        session.beginTransaction().begin();
//        List list = session.createCriteria(classe).setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("id")))).list();
        Query query = session.createQuery("from PedidoBebida as p group by(p.id)");
        List list = query.list();
        session.close();
        return list;
    }

    public List<PedidoBebida> buscaPorMesa(int nmesa) {
        session = HibernateConexao.getSession();
        session.beginTransaction().begin();
//        List list = session.createCriteria(classe).add(Restrictions.eq("idMesa", nmesa)).list();
        Query query = session.createQuery("from PedidoBebida as p where p.idMesa.id = :nmesa").setParameter("nmesa", nmesa);
        List list = query.list();
        session.close();
        return list;
    }
}
