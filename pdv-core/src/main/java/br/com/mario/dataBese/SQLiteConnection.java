package br.com.mario.dataBese;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {

    private final static String url = "jdbc:sqlite:database/pdv.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public static void criarTabelas() {
        String sqlProdutos = "CREATE TABLE IF NOT EXISTS produtos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "codigo INTEGER NOT NULL, " +
                "nome TEXT NOT NULL, " +
                "descricao TEXT NOT NULL, " +
                "preco REAL NOT NULL, " +
                "quantidadeEstoque INTEGER NOT NULL)";

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sqlProdutos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
