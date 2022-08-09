package br.csi.dao;
import br.csi.model.farmacia.Farmacia;

import java.sql.*;
import java.util.ArrayList;

public class FarmaciaDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private Statement statement;
    private String status;
    public Farmacia criarFarmacia(Farmacia f){
        try (Connection connection = new ConexaoBD().getConexao()) {
            this.sql = "INSERT INTO farmacia (alias_farm, telefone, sigla_estado, nome_cidade, rua, cep) VALUES (?, ?, ?, ?, ?,?)";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, f.getAlias_farm());
            this.preparedStatement.setString(2, f.getTelefone());
            this.preparedStatement.setString(3, f.getSigla_estado());
            this.preparedStatement.setString(4, f.getNome_cidade());
            this.preparedStatement.setString(5, f.getRua());
            this.preparedStatement.setString(6, f.getCep());
            this.preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return f;
    }



    public ArrayList<Farmacia> getFranquias(){

        ArrayList<Farmacia> franquias = new ArrayList<>();
        try (Connection connection = new ConexaoBD().getConexao()) {
            this.sql = "SELECT id_farm, alias_farm, telefone, sigla_estado, nome_cidade, rua, cep FROM farmacia";
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(this.sql);
            while (this.resultSet.next()){
                Farmacia farmacia = new Farmacia();
                farmacia.setId_farm(this.resultSet.getInt("id_farm"));
                farmacia.setAlias_farm(this.resultSet.getString("alias_farm"));
                farmacia.setTelefone(this.resultSet.getString("telefone"));
                farmacia.setSigla_estado(this.resultSet.getString("sigla_estado"));
                farmacia.setNome_cidade(this.resultSet.getString("nome_cidade"));
                farmacia.setRua(this.resultSet.getString("rua"));
                farmacia.setCep(this.resultSet.getString("cep"));
                franquias.add(farmacia);
            }
        } catch (SQLException E){
            E.printStackTrace();
        }
        return franquias;




    }
}
