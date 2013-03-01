/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Bebida;
import Utilitarios.Utilitarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class BebidaDAO extends DBConnection{
    
    private static Connection conn;
    private static PreparedStatement ps;
    private static String sqlInsert = "INSERT INTO Bebidas(nome,quantidade,data_validade,`tipo`,preco) VALUES(?,?,?,?,?)";
    private static String sqlUpdate = "UPDATE Bebidas SET nome = ?, quantidade = ?, data_validade = ?, `tipo` = ?, preco = ? WHERE id = ?";
    private static String sqlDelete = "DELETE FROM Bebidas WHERE id = ?";
    private static String sqlFind = "SELECT id, nome,quantidade,data_validade,`tipo`,preco FROM Bebidas WHERE id = ?";
    private static String sqlList = "SELECT id, nome,quantidade,data_validade,`tipo`,preco FROM Bebidas";
   private static String sqlListPorNome = "SELECT id, nome,quantidade,data_validade,`tipo`,preco FROM Bebidas WHERE nome LIKE ?";
    private static ResultSet rs;
    
    public static void insert(Bebida bebida) throws SQLException {
        try {
            conn = connect();
              conn.setAutoCommit(false);
            ps = conn.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, bebida.getNome());
            ps.setInt(2, bebida.getQtde());
            ps.setString(3, Utilitarios.dateToString(bebida.getDataValidade()));
            ps.setString(4, bebida.getTipo());
            ps.setDouble(5, bebida.getPreco());
            ps.execute();
            conn.commit();

        } finally {
            ps.close();
            closeConnect(conn);
        }
    }

    public static void update(Bebida bebida) throws SQLException {
        try {
            conn = connect();
              conn.setAutoCommit(false);
            ps = conn.prepareStatement(sqlUpdate, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, bebida.getNome());
            ps.setInt(2, bebida.getQtde());
            ps.setString(3, Utilitarios.dateToString(bebida.getDataValidade()));
            ps.setString(4, bebida.getTipo());
            ps.setDouble(5, bebida.getPreco());
            ps.setInt(6, bebida.getId());
            ps.execute();
            conn.commit();
        } finally {
            ps.close();
            closeConnect(conn);
        }
    }

    public static void delete(int idBebida) throws SQLException {
        try {
            conn = connect();
              conn.setAutoCommit(false);
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, idBebida);
            ps.execute();
            conn.commit();
        } finally {
            ps.close();
            closeConnect(conn);
        }
    }

    public static ArrayList<Bebida> list() throws SQLException {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlList);
            rs = ps.executeQuery();
            Bebida bebida = null;

            while (rs.next()) {
                bebida = new Bebida();
                bebida.setId(rs.getInt("id"));
                bebida.setNome(rs.getString("nome"));
                bebida.setPreco(rs.getDouble("preco"));
                bebida.setQtde(rs.getInt("quantidade"));
                bebida.setDataValidade(rs.getDate("data_validade"));
                bebidas.add(bebida);
            }

            return bebidas;

        } finally {
            ps.close();
            rs.close();
            closeConnect(conn);
        }
    }

    public static Bebida find(int idBebida) throws SQLException {
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlFind);
            ps.setInt(1, idBebida);
            rs = ps.executeQuery();
            Bebida bebida = null;

            if (rs.next()) {
                bebida = new Bebida();
                bebida.setId(rs.getInt("id"));
                bebida.setNome(rs.getString("nome"));
                bebida.setPreco(rs.getDouble("preco"));
                bebida.setQtde(rs.getInt("quantidade"));
                bebida.setDataValidade(rs.getDate("data_validade"));
            }
            return bebida;

        } finally {
            ps.close();
            rs.close();
            closeConnect(conn);
        }
    }
    public static ArrayList<Bebida> findPorNome(String nome) throws SQLException {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlListPorNome);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            Bebida bebida = null;

            while (rs.next()) {
                bebida = new Bebida();
                bebida.setId(rs.getInt("id"));
                bebida.setNome(rs.getString("nome"));
                bebida.setQtde(rs.getInt("quantidade"));
                bebida.setTipo(rs.getString("tipo"));
                bebida.setPreco(rs.getDouble("preco"));
                bebida.setDataValidade(rs.getDate("data_validade"));
                bebidas.add(bebida);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ps.close();
            rs.close();
            closeConnect(conn);
        }
                  return bebidas;
    }
    
}
