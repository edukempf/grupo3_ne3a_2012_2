package DAO;

import Modelo.Comida;
import Utilitarios.Utilitarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComidaDAO extends DBConnection {

    private static Connection conn;
    private static PreparedStatement ps;
    private static String sqlInsert = "INSERT INTO Comidas(nome,quantidade,data_validade,`tipo`) VALUES(?,?,?,?)";
    private static String sqlUpdate = "UPDATE Comidas SET nome = ?, quantidade = ?, data_validade = ?, `tipo` = ? WHERE id = ?";
    private static String sqlDelete = "DELETE FROM Comidas WHERE id = ?";
    private static String sqlFind = "SELECT id, nome,quantidade,data_validade,`tipo` FROM Comidas WHERE id = ?";
    private static String sqlList = "SELECT id, nome,quantidade,data_validade,`tipo` FROM Comidas";
    private static String sqlListPorNome = "SELECT id,nome,quantidade,data_validade,`tipo` FROM Comidas WHERE nome LIKE ?";
    private static ResultSet rs;

    public static void insert(Comida comida) throws SQLException {
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNome());
            ps.setInt(2, comida.getQuantidade());
            ps.setString(3, Utilitarios.dateToString(comida.getDataValidade()));
            ps.setString(4, comida.getTipo());
            ps.execute();

        } finally {
            ps.close();
            closeConnect(conn);
        }
    }

    public static void update(Comida comida) throws SQLException {
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlUpdate, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNome());
            ps.setInt(2, comida.getQuantidade());
            ps.setString(3, Utilitarios.dateToString(comida.getDataValidade()));
            ps.setString(4, comida.getTipo());
            ps.setInt(5, comida.getId());
            ps.execute();
        } finally {
            ps.close();
            closeConnect(conn);
        }
    }

    public static void delete(int idComida) throws SQLException {
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, idComida);
            ps.execute();
        } finally {
            ps.close();
            closeConnect(conn);
        }
    }

    public static ArrayList<Comida> list() throws SQLException {
        ArrayList<Comida> comidas = new ArrayList<Comida>();
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlList);
            rs = ps.executeQuery();
            Comida comida = null;

            while (rs.next()) {
                comida = new Comida();
                comida.setId(rs.getInt("id"));
                comida.setNome(rs.getString("nome"));
                comida.setQuantidade(rs.getInt("quantidade"));
                comida.setDataValidade(rs.getDate("data_validade"));
                comida.setTipo(rs.getString("tipo"));
                comidas.add(comida);
            }


        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ps.close();
            rs.close();
            closeConnect(conn);
            return comidas;
        }
    }

    public static Comida find(int idBebida) throws SQLException {
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlFind);
            ps.setInt(1, idBebida);
            rs = ps.executeQuery();
            Comida comida = null;

            if (rs.next()) {
                comida = new Comida();
                comida.setId(rs.getInt("id"));
                comida.setNome(rs.getString("nome"));
                comida.setQuantidade(rs.getInt("quantidade"));
                comida.setDataValidade(rs.getDate("data_validade"));
            }
            return comida;

        } finally {
            ps.close();
            rs.close();
            closeConnect(conn);
        }
    }
    public static ArrayList<Comida> findPorNome(String nome) throws SQLException {
        ArrayList<Comida> comidas = new ArrayList<>();
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlListPorNome);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            Comida comida = null;

            while (rs.next()) {
                System.out.println("a");
                comida = new Comida();
                comida.setId(rs.getInt("id"));
                comida.setNome(rs.getString("nome"));
                comida.setQuantidade(rs.getInt("quantidade"));
                comida.setTipo(rs.getString("tipo"));
                comida.setDataValidade(rs.getDate("data_validade"));
                
                comidas.add(comida);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ps.close();
            rs.close();
            closeConnect(conn);
        }
                  return comidas;
    }
}
