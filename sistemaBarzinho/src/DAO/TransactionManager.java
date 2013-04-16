/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Eduardo
 */
public class TransactionManager {

    private  Session session = null;
    private  Transaction transaction = null;

    public void beginTransaction() {
        if(transaction != null){
            throw new RuntimeException("Já existe uma transação iniciada.");
        }
        session = HibernateConexao.getSession();
        transaction = session.beginTransaction();

    }

    public void comitTransaction() {
        if(transaction == null){
            throw new RuntimeException("Erro ao executar comit() sem antes executar beginTransaction()");
        }
        transaction.commit();
        closeCurrentSession();
    }

    public Session getCurrentSession() {
        this.session=HibernateConexao.getSession();
        return session;
    }
    
    public void rollbackTransaction() {
        if(transaction == null){
            throw new RuntimeException("Erro ao executar comit() sem antes executar beginTransaction()");
        }
        transaction.rollback();
        closeCurrentSession();
    }
    
    private void closeCurrentSession(){
        session.close();
        transaction = null;
        session = null;
    }
    
}
