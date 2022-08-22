package br.csi.dao;

import br.csi.model.funcionario.Funcionario;
import br.csi.model.produto.Produto;

import java.sql.*;
import java.util.ArrayList;

public class ProdutoDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ArrayList<Produto> getProdutos(int id_farm){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try (Connection connection = new ConexaoBD().getConexao()){
            this.sql = "SELECT * FROM produto where id_farm = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id_farm);
            this.resultSet = this.preparedStatement.executeQuery();
            while (this.resultSet.next()){
                Produto prod = new Produto();
                prod.setId_produto(this.resultSet.getInt("id_produto"));
                prod.setNome_produto(this.resultSet.getString("nome_produto"));
                prod.setCategoria(this.resultSet.getString("categoria"));
                prod.setMarca(this.resultSet.getString("marca"));
                prod.setQuantidade(this.resultSet.getInt("quantidade"));
                prod.setFarmacia(new FarmaciaDao().getFarmaciaUnica(resultSet.getInt("id_farm")));
                produtos.add(prod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public void setProduto(Produto prod) {
        try (Connection connection = new ConexaoBD().getConexao()) {
            this.sql = "INSERT INTO produto (nome_produto, categoria, marca, quantidade, id_farm) VALUES (?, ?, ?, ?, ?)";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, prod.getNome_produto());
            this.preparedStatement.setString(2, prod.getCategoria());
            this.preparedStatement.setString(3, prod.getMarca());
            this.preparedStatement.setInt(4, prod.getQuantidade());
            this.preparedStatement.setInt(5, prod.getFarmacia().getId_farm());
            System.out.println(sql);
            this.preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto getProdutoUnico(int id_produto) {
        Produto prod = new Produto();

        try(Connection connection = new ConexaoBD().getConexao()){
            this.sql = "select * from produto where id_produto = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id_produto);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                prod.setId_produto(this.resultSet.getInt("id_produto"));
                prod.setNome_produto(this.resultSet.getString("nome_produto"));
                prod.setCategoria(this.resultSet.getString("categoria"));
                prod.setMarca(this.resultSet.getString("marca"));
                prod.setQuantidade(this.resultSet.getInt("quantidade"));
                prod.setFarmacia(new FarmaciaDao().getFarmaciaUnica(resultSet.getInt("id_farm")));

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return prod;
    }

    public void excluir(int id) {
        try (Connection connection = new ConexaoBD().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "delete from produto where id_produto = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();

            if (this.preparedStatement.getUpdateCount() > 0) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editar(Produto f) {

        try (Connection connection = new ConexaoBD().getConexao()) {
            connection.setAutoCommit(false);
            this.sql = "update produto  set nome_produto = ?, categoria = ?, marca = ?, quantidade = ?   where id_produto = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, f.getNome_produto());
            this.preparedStatement.setString(2, f.getCategoria());
            this.preparedStatement.setString(3, f.getMarca());
            this.preparedStatement.setInt(4, f.getQuantidade());
            this.preparedStatement.setInt(5, f.getId_produto());
            this.preparedStatement.executeUpdate();
            if (this.preparedStatement.getUpdateCount() > 0) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
