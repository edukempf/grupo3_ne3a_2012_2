/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Funcionario;
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
public class FuncionarioDAO extends DBConnection {

    private static Connection conn;
    private static PreparedStatement ps;
    private static String sqlInsert = "INSERT INTO Funcionario(nome,cpf,rg,data_nascimento,`estadocivil`,funcao) VALUES(?,?,?,?,?,?)";
    private static String sqlUpdate = "UPDATE Funcionario SET nome = ?, cpf = ?, rg = ?, data_nascimento = ?, `estadocivil` = ?, funcao = ? WHERE id = ?";
    private static String sqlDelete = "DELETE FROM Funcionario WHERE id = ?";
    private static String sqlFind = "SELECT id, nome, cpf, rg, data_nascimento, `estadocivil`, funcao FROM Funcionario WHERE id = ?";
    private static String sqlList = "SELECT id, nome, cpf, rg, data_nascimento, `estadocivil`, funcao FROM Funcionario";
    private static String sqlListPorNome = "SELECT id, nome, cpf, rg, data_nascimento, `estadocivil`, funcao FROM Funcionario WHERE nome LIKE ?";
    private static ResultSet rs;

    public static void insert(Funcionario funcionario) throws SQLException {
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getRg());
            ps.setString(4, Utilitarios.dateToString(funcionario.getDataNasc()));
            ps.setString(5, funcionario.getEstadoCivil());
            ps.setString(6, funcionario.getFuncao());
            ps.execute();

        } finally {
            ps.close();
            closeConnect(conn);
        }
    }

    public static void update(Funcionario funcionario) throws SQLException {
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlUpdate, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getRg());
            ps.setString(4, Utilitarios.dateToString(funcionario.getDataNasc()));
            ps.setString(5, funcionario.getEstadoCivil());
            ps.setString(6, funcionario.getFuncao());
            ps.setInt(7, funcionario.getCodFuncionario());

            ps.execute();
            System.out.println(funcionario.getNome());
        } finally {
            ps.close();
            closeConnect(conn);
        }
    }

    public static void delete(int idFunc) throws SQLException {
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, idFunc);
            ps.execute();
        } finally {
            ps.close();
            closeConnect(conn);
        }
    }

    public static ArrayList<Funcionario> list() throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlList);
            rs = ps.executeQuery();
            Funcionario funcionario = null;

            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCodFuncionario(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setDataNasc(rs.getDate("data_nascimento"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setEstadoCivil(rs.getString("estadocivil"));
                funcionarios.add(funcionario);
            }

            return funcionarios;

        } finally {
            ps.close();
            rs.close();
            closeConnect(conn);
        }
    }

    public static Funcionario find(int idFunc) throws SQLException {
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlFind);
            ps.setInt(1, idFunc);
            rs = ps.executeQuery();
            Funcionario funcionario = null;

            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCodFuncionario(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setDataNasc(rs.getDate("data_nascimento"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setEstadoCivil(rs.getString("estadocivil"));
            }
            return funcionario;

        } finally {
            ps.close();
            rs.close();
            closeConnect(conn);
        }
    }

    public static ArrayList<Funcionario> findPorNome(String nome) throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = connect();
            ps = conn.prepareStatement(sqlListPorNome);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            Funcionario funcionario = null;

            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCodFuncionario(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setDataNasc(rs.getDate("data_nascimento"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setEstadoCivil(rs.getString("estadocivil"));
                funcionarios.add(funcionario);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ps.close();
            rs.close();
            closeConnect(conn);
        }
                  return funcionarios;
    }
}
