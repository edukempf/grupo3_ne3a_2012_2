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
        session.merge(o);
//        session.evict(o);
        return (T) o;
    }
    
    public T persisteObjeto(Object o){
        TransactionManager.Transaction t=TransactionManager.beginTransaction();
        o=persisteObjeto(o,t);
        try{
            t.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        }
        return (T) o;
    }
    
    public void delete(Object deletar, TransactionManager.Transaction t){
        session=t.getCurrentSession();
        session.delete(deletar);
        try{
            t.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        }
    }
    
    public void delete(Object deletar){
        TransactionManager.Transaction t=TransactionManager.beginTransaction();
        delete(deletar,t);
        try{
            t.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            t.rollback();
        }
    }
    
    public T get(int id){
        TransactionManager.Transaction t=TransactionManager.beginTransaction();
        session=t.getCurrentSession();
        Object busca=session.get(this.classe, id);
        t.commit();
        return (T) busca;
    }
    
    public List<T> lista(){
        TransactionManager.Transaction t=TransactionManager.beginTransaction();
        session=t.getCurrentSession();
        List list = session.createCriteria(classe).list();
        t.commit();
        return list;
    }
      
}
