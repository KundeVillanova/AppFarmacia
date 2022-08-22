package br.csi.dao;
import br.csi.model.farmacia.Farmacia;
import br.csi.model.funcionario.Funcionario;

import java.sql.*;
import java.util.ArrayList;

public class FarmaciaDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    public Farmacia criarFarmacia(Farmacia f){
        try (Connection connection = new ConexaoBD().getConexao()) {
            this.sql = "INSERT INTO farmacia (alias_farm, telefone, estado, cidade, rua, cep) VALUES (?, ?, ?, ?, ?, ?)";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, f.getAlias_farm());
            this.preparedStatement.setString(2, f.getTelefone());
            this.preparedStatement.setString(3, f.getEstado());
            this.preparedStatement.setString(4, f.getCidade());
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
            this.sql = "SELECT id_farm, alias_farm, telefone, estado, cidade, rua, cep FROM farmacia";
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(this.sql);
            while (this.resultSet.next()){
                Farmacia farmacia = new Farmacia();
                farmacia.setId_farm(this.resultSet.getInt("id_farm"));
                farmacia.setAlias_farm(this.resultSet.getString("alias_farm"));
                farmacia.setTelefone(this.resultSet.getString("telefone"));
                farmacia.setEstado(this.resultSet.getString("estado"));
                farmacia.setCidade(this.resultSet.getString("cidade"));
                farmacia.setRua(this.resultSet.getString("rua"));
                farmacia.setCep(this.resultSet.getString("cep"));
                franquias.add(farmacia);
            }
        } catch (SQLException E){
            E.printStackTrace();
        }
        return franquias;
    }

    public Farmacia getFarmaciaUnica(int id_farm) {
        Farmacia farmacia = new Farmacia();

        try(Connection connection = new ConexaoBD().getConexao()){
            this.sql = "select id_farm, alias_farm, telefone, estado, cidade, rua, cep from farmacia where id_farm = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id_farm);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                farmacia.setId_farm(this.resultSet.getInt("id_farm"));
                farmacia.setAlias_farm(this.resultSet.getString("alias_farm"));
                farmacia.setTelefone(this.resultSet.getString("telefone"));
                farmacia.setEstado(this.resultSet.getString("estado"));
                farmacia.setCidade(this.resultSet.getString("cidade"));
                farmacia.setRua(this.resultSet.getString("rua"));
                farmacia.setCep(this.resultSet.getString("cep"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return farmacia;
    }
    public String editar(Farmacia f) {

        try (Connection connection = new ConexaoBD().getConexao()) {
            connection.setAutoCommit(false);
            this.sql = "update farmacia  set alias_farm =?, telefone=?, estado=?, cidade=?, rua=?, cep=?  where id_farm = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, f.getAlias_farm());
            this.preparedStatement.setString(2, f.getTelefone());
            this.preparedStatement.setString(3, f.getEstado());
            this.preparedStatement.setString(4, f.getCidade());
            this.preparedStatement.setString(5, f.getRua());
            this.preparedStatement.setString(6, f.getCep());
            this.preparedStatement.setInt(7, f.getId_farm());
            this.preparedStatement.executeUpdate();
            if (this.preparedStatement.getUpdateCount() > 0) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
    public String excluir(int id) {
        try (Connection connection = new ConexaoBD().getConexao()) {

            connection.setAutoCommit(false);
            this.sql = "delete from farmacia where id_farm = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();
            if (this.preparedStatement.getUpdateCount() > 0) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

}
