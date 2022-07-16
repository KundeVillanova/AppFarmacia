package br.csi.dao;

import br.csi.model.funcionario.Tipo;

import java.sql.*;
import java.util.ArrayList;

public class TipoDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;
    private String status;

    public ArrayList<Tipo> getTipos(){
        ArrayList<Tipo> tipos = new ArrayList<>();
        try (Connection connection = new ConexaoBD().getConexao()){
            this.sql = "SELECT id_cargo, cargo FROM tipo_funcionario";
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(this.sql);

            while (this.resultSet.next()){
                Tipo tipo = new Tipo();
                tipo.setId_permissao(this.resultSet.getInt("id_cargo"));
                tipo.setNome_permissao(this.resultSet.getString("cargo"));
                tipos.add(tipo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipos;
    }
}
