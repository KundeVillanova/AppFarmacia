package br.csi.dao;

import br.csi.model.farmacia.Farmacia;
import br.csi.model.funcionario.Funcionario;

import java.sql.*;
import java.util.ArrayList;

public class FuncionarioDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;
    private String status;

    public ArrayList<Funcionario> getFuncionarios(){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try (Connection connection = new ConexaoBD().getConexao()){
            this.sql = "SELECT * FROM funcionario";
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(this.sql);

            while (this.resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId_func(this.resultSet.getInt("id_func"));
                funcionario.setNome_func(this.resultSet.getString("nome_func"));
                funcionario.setTelefone(this.resultSet.getString("telefone"));
                funcionario.setData_nasc(this.resultSet.getString("data_nasc"));
                funcionario.setFuncao(this.resultSet.getString("cargo"));
                funcionario.setFarmacia(new FarmaciaDao().getFarmaciaUnica(resultSet.getInt("id_farm")));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    public Funcionario setFuncionario(Funcionario func) {
        try (Connection connection = new ConexaoBD().getConexao()) {
            this.sql = "INSERT INTO funcionario (nome_func, telefone, data_nasc, cargo, id_farm) VALUES (?, ?, ?, ?, ?)";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, func.getNome_func());
            this.preparedStatement.setString(2, func.getTelefone());
            this.preparedStatement.setString(3, func.getData_nasc());
            this.preparedStatement.setString(4, func.getFuncao());
            this.preparedStatement.setInt(5, func.getFarmacia().getId_farm());
            System.out.println(sql);
            this.preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return func;
    }

    public Funcionario getFuncionarioUnico(int id_func) {
        Funcionario funcionario = new Funcionario();

        try(Connection connection = new ConexaoBD().getConexao()){
            this.sql = "select * from funcionario where id_func = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id_func);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                funcionario.setId_func(this.resultSet.getInt("id_func"));
                funcionario.setNome_func(this.resultSet.getString("nome_func"));
                funcionario.setTelefone(this.resultSet.getString("telefone"));
                funcionario.setData_nasc(this.resultSet.getString("data_nasc"));
                funcionario.setFuncao(this.resultSet.getString("cargo"));
                funcionario.setFarmacia(new FarmaciaDao().getFarmaciaUnica(resultSet.getInt("id_farm")));

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    public String excluir(int id) {
        try (Connection connection = new ConexaoBD().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "delete from funcionario where id_func = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();

            if (this.preparedStatement.getUpdateCount() > 0) {
                this.status = "OK";
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }
    public String editar(Funcionario f) {

        try (Connection connection = new ConexaoBD().getConexao()) {
            connection.setAutoCommit(false);
            this.sql = "update funcionario  set nome_func =?, telefone=?, data_nasc=?, cargo = ?   where id_func = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, f.getNome_func());
            this.preparedStatement.setString(2, f.getTelefone());
            this.preparedStatement.setString(3, f.getData_nasc());
            this.preparedStatement.setString(4, f.getFuncao());
            this.preparedStatement.setInt(5, f.getId_func());
            this.preparedStatement.executeUpdate();
            if (this.preparedStatement.getUpdateCount() > 0) {
                this.status = "OK";
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }

    public ArrayList<Funcionario> getFuncionarios2(int id_farm){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try (Connection connection = new ConexaoBD().getConexao()){
            this.sql = "SELECT * FROM funcionario where id_farm = ? ";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id_farm);
            this.resultSet = this.preparedStatement.executeQuery();
            while (this.resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId_func(this.resultSet.getInt("id_func"));
                funcionario.setNome_func(this.resultSet.getString("nome_func"));
                funcionario.setTelefone(this.resultSet.getString("telefone"));
                funcionario.setData_nasc(this.resultSet.getString("data_nasc"));
                funcionario.setFuncao(this.resultSet.getString("cargo"));
                funcionario.setFarmacia(new FarmaciaDao().getFarmaciaUnica(resultSet.getInt("id_farm")));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
}
