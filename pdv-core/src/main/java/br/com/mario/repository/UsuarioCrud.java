package br.com.mario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.mario.dataBese.SQLiteConnection;
import br.com.mario.model.Usuario;

import br.com.mario.repository.contract.Salve;

public class UsuarioCrud implements Salve<Usuario> {

    @Override
    public Usuario salveExec(Usuario typeT) {

        String sql = "INSERT INTO usuarios (nome,permissao,status,senha,?) VALUES(?,?,?,?,)";
        try {
            Connection connection = SQLiteConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, typeT.getNome());
            statement.setString(2, typeT.getPermissao());
            statement.setString(3, typeT.getStatus());
            statement.setString(4, typeT.getSenhaHash());
            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return typeT;
    }

    public Usuario usuarioById(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        Connection connection = SQLiteConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet executeQuery = statement.executeQuery();
        if (executeQuery.next()) {
            Usuario usuario = new Usuario(executeQuery.getString("id"),
                    executeQuery.getString("Permissao"),
                    executeQuery.getString("status"),
                    executeQuery.getString("senhaHash"));
            usuario.setId(executeQuery.getInt("id"));
            usuario.getDataCriacao();
            return usuario;
        }
        return null;
    }

}
