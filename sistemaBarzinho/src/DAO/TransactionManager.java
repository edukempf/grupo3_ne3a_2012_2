/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Session;

/**
 *
 * @author Eduardo
 */
public class TransactionManager {

    public static Transaction beginTransaction() {
        return new Transaction(HibernateConexao.getSession());

    }

    public static class Transaction {

        private Session session = null;

        private Transaction(Session session) {
            this.session = session;
            this.session.beginTransaction();
        }

        public void commit() {
            if (session.isOpen()) {
                session.getTransaction().commit();
                this.session.close();
            } else {
            }
        }

        public Session getCurrentSession() {
            return session;
        }

        public void rollback() {
            session.getTransaction().rollback();
            this.session.close();
        }
    }
}
