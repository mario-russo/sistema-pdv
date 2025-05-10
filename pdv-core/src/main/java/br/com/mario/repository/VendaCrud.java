package br.com.mario.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.mario.dataBese.SQLiteConnection;
import br.com.mario.model.Venda;
import br.com.mario.repository.contract.Salve;

public class VendaCrud implements Salve<Venda>{

    @Override
    public Venda salveExec(Venda venda) {
        String sql = "INSERT INTO produtos (valor, formaPagamento,ItemVendas) VALUES(?, ?, ?)";
        try {
            Connection connection = SQLiteConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setDouble(1, venda.getValorTotal());
            statement.setString(2, venda.getFormaPagamento());
            statement.setLong(3,venda.getId());

            
            statement.executeUpdate();
            return venda;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
     
}
