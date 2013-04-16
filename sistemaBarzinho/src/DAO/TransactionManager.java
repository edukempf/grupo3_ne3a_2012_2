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

    private static Session session = null;
    private static Transaction transaction = null;

    public static void beginTransaction() {
        if(transaction != null){
            throw new RuntimeException("Já existe uma transação iniciada.");
        }
        session = HibernateConexao.getSession();
        transaction = session.beginTransaction();
        transaction.begin();

    }

    public static void comitTransaction() {
        if(transaction == null){
            throw new RuntimeException("Erro ao executar comit() sem antes executar beginTransaction()");
        }
        transaction.commit();
        closeCurrentSession();
    }

    public static Session getCurrentSession() {
        return session;
    }
    
    public static void rollbackTransaction() {
        if(transaction == null){
            throw new RuntimeException("Erro ao executar comit() sem antes executar beginTransaction()");
        }
        transaction.rollback();
        closeCurrentSession();
    }
    
    private static void closeCurrentSession(){
        session.close();
        transaction = null;
        session = null;
    }
    
}
