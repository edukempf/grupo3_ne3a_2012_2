package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnection {

    private static String host = "localhost";
    private static String login = "aluno";
    private static String password = "aluno";
    private static String port = "3306";
    private static String database = "aluno";

    public static Connection getMyDBConnection() throws SQLException, ClassNotFoundException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        String x = "jdbc:mysql://" + host + ":" + port + "/" + database;
        return DriverManager.getConnection(x, login, password);
    }

    public static Connection connect() {
        try {
            return getMyDBConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void closeConnect(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}