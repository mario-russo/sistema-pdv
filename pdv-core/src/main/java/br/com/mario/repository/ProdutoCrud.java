package br.com.mario.repository;

import br.com.mario.database.SQLiteConnection;
import br.com.mario.model.Produto;
import br.com.mario.repository.contract.ListRepository;
import br.com.mario.repository.contract.Salve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoCrud implements ListRepository<Produto>, Salve<Produto> {

    @Override
    public List<Produto> listExec() {

        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM  produtos";

        try {
            Connection connection = SQLiteConnection.getConnection();

            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            while (resultSet.next()) {

                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setNome(resultSet.getString("nome"));
                produto.setPreco(resultSet.getDouble("preco"));
                produto.setQuantidadeEstoque(resultSet.getInt("quantidadeEstoque"));

                produtos.add(produto);
                // connection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return produtos;
    }

    @Override
    public Produto salveExec(Produto produto) {
        String sql = "INSERT INTO produtos (nome, descricao, preco,quantidadeEstoque, codigo) VALUES(?, ?, ?, ?, ?)";

        try {

            Connection connection = SQLiteConnection.getConnection();

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setDouble(3, produto.getPreco());
            pstm.setInt(4, produto.getQuantidadeEstoque());
            pstm.setInt(5, produto.getCodigo());
            pstm.executeUpdate();
            // connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            
        }
        return produto;
    }

}
