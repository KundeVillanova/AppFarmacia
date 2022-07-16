package br.csi.dao;

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
            this.sql = "SELECT id_func, nome_func, telefone, data_nasc FROM funcionario";
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(this.sql);

            while (this.resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setId_func(this.resultSet.getInt("id_func"));
                funcionario.setNome_func(this.resultSet.getString("nome_func"));
                funcionario.setTelefone(this.resultSet.getString("telefone"));
                funcionario.setData_nasc(this.resultSet.getString("data_nasc"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    public Funcionario setFuncionario(Funcionario func) {
        try (Connection connection = new ConexaoBD().getConexao()) {
            this.sql = "INSERT INTO funcionario (nome_func, telefone, data_nasc) VALUES (?, ?, ?)";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, func.getNome_func());
            this.preparedStatement.setString(2, func.getTelefone());
            this.preparedStatement.setString(3, func.getData_nasc());
            this.preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return func;
    }

    public Funcionario getFuncionarioUnico(int id_func) {
        Funcionario funcionario = new Funcionario();

        try(Connection connection = new ConexaoBD().getConexao()){
            this.sql = "select id_func, nome_func, telefone, data_nasc from funcionario where id_func = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id_func);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                funcionario.setId_func(this.resultSet.getInt("id_func"));
                funcionario.setNome_func(this.resultSet.getString("nome_func"));
                funcionario.setTelefone(this.resultSet.getString("telefone"));
                funcionario.setData_nasc(this.resultSet.getString("data_nasc"));
//                funcionario.getid_cargo(this.resultSet.getInt("id_cargo"));
//                Permissao permissao = new Permissao(
//                        this.resultSet.getInt("id_permissao"),
//                        this.resultSet.getString("nome_permissao")
//                );
//                funcionario.setPermissao(permissao);
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
            this.sql = "update funcionario  set nome_func =?, telefone=?, data_nasc=?  where id_func = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, f.getNome_func());
            this.preparedStatement.setString(2, f.getTelefone());
            this.preparedStatement.setString(3, f.getData_nasc());
            this.preparedStatement.setInt(4, f.getId_func());
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
}
