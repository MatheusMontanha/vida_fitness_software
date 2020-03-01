package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Conexao {

    private static Connection conexao;

    public static Connection realizarConexão() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:db/vida_fitness_db.db";

            conexao = DriverManager.getConnection(url);
            return conexao;
        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro de conexão. Verifique a Base de Dados indicada !" + "\n" + erro.getMessage(), "Conexão", 3);
            throw new RuntimeException("Erro ao efetuar a conexão.", erro);
        }
    }

    public static void fecharConexao(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
