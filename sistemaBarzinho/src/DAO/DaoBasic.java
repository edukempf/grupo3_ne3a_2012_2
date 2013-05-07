/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.util.List;
import org.hibernate.Session;


/**
 *
 * @author Eduardo
 */


public abstract class DaoBasic<T> {

    public DaoBasic() {
    }
    
    
   
    protected Class classe;
    public DaoBasic(Class classe) {
        this.classe=classe;
    }
        
    protected static Session session;
    
    public T persisteObjeto(Object o,TransactionManager.Transaction t){
        session=t.getCurrentSession();
        session.saveOrUpdate(o);
//        session.evict(o);
        return (T) o;
    }
    
    public T persisteObjeto(Object o){
        TransactionManager.Transaction t=TransactionManager.beginTransaction();
        o=persisteObjeto(o,t);
        t.commit();
        t.getCurrentSession().close();
        return (T) o;
    }
    
    public void delete(Object deletar, TransactionManager.Transaction t){
        session=t.getCurrentSession();
        session.delete(deletar);
    }
    
    public void delete(Object deletar){
        TransactionManager.Transaction t=TransactionManager.beginTransaction();
        delete(deletar,t);
        t.commit();
    }
    
    public T get(int id){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        Object busca=session.get(this.classe, id);
        session.close();
        return (T) busca;
    }
    
    public List<T> lista(){
        session=HibernateConexao.getSession();
        session.beginTransaction().begin();
        List list = session.createCriteria(classe).list();
        session.close(); 
        return list;
    }
      
}
