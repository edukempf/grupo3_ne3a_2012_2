/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.Pedido;
import java.util.List;
/**
 *
 * @author Ligue01
 */
public class PedidoDAO extends DaoBasic<Pedido>{
     public PedidoDAO() {
        super(Pedido.class);
    }
    
    public List<Pedido> buscaPorNome(String nome){
        session=HibernateConexao.iniciaConexao();
        session.beginTransaction().begin();
        List list = session.createQuery("from Pedido as p where p.nome like '%"+nome+"%'").list();
        session.beginTransaction().commit();
        HibernateConexao.fechaConexao(session);
        return list; 
    }
}