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

    public static Transaction beginTransaction() {
        return new Transaction(HibernateConexao.getSession());

    }

    public static class Transaction {

        private  Session session = null;

        private Transaction(Session session) {
            this.session = session;
            this.session.beginTransaction();
        }

        public  void commit() {
            session.getTransaction().commit();
        }

        public  Session getCurrentSession() {
            return session;
        }

        public  void rollback() {
            session.getTransaction().rollback();
        }
    }
}
