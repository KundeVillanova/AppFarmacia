
package br.csi.dao;

import br.csi.model.usuario.Permissao;
import br.csi.model.usuario.Usuario;

import java.sql.*;

public class UsuarioDao {

    private String sql;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private String status;


    public Usuario getUsuario(String email){
        Usuario usuario = null;


        try (Connection connection = new ConexaoBD().getConexao()){
            this.sql = " SELECT * FROM usuario WHERE email = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, email);
            this.resultSet = this.preparedStatement.executeQuery();
            System.out.println(this.sql);
            while (resultSet.next()){
                usuario = new Usuario();
                usuario.setId(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuario;
    }
    public Usuario criarUsuario(Usuario u){
//        Calendar calendar = Calendar.getInstance();
//
        try (Connection connection = new ConexaoBD().getConexao()) {
            this.sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
            System.out.println(u.getNome());
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, u.getNome());
            this.preparedStatement.setString(2, u.getEmail());
            this.preparedStatement.setString(3, u.getSenha());
            this.preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }
    public Usuario getUsuarioUnico(int id) {
        Usuario usuario = new Usuario();

        try(Connection connection = new ConexaoBD().getConexao()){
            this.sql = "select * from" +
                    " usuario U, permissao P " +
                    "where" +
                    " U.id_permissao = P.id_permissao " +
                    "and" +
                    " U.id_usuario = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                usuario.setId(this.resultSet.getInt("id_usuario"));
                usuario.setNome(this.resultSet.getString("nome"));
                usuario.setEmail(this.resultSet.getString("email"));
                usuario.setSenha(this.resultSet.getString("senha"));
                Permissao permissao = new Permissao(
                        this.resultSet.getInt("id_permissao"),
                        this.resultSet.getString("nome_permissao")
                );
//                usuario.setPermissao(permissao);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public String excluir(Usuario u) {
        try (Connection connection = new ConexaoBD().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "delete from usuario where id_usuario = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, u.getId());
            this.preparedStatement.executeUpdate();

            System.out.println(u.getId());

            if (this.preparedStatement.getUpdateCount() > 0) {
                this.status = "OK";
                System.out.println(this.status);
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            this.status = "OK";
        }
        return "";
    }
    public String editar(Usuario u) {

        try (Connection connection = new ConexaoBD().getConexao()) {

            connection.setAutoCommit(false);

            this.sql = "update usuario set nome = ?, email = ?, senha = ?, ativo = ? where ID_USUARIO = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, u.getNome());
            this.preparedStatement.setString(2, u.getEmail());
            this.preparedStatement.setString(3, u.getSenha());
            this.preparedStatement.setInt(5, u.getId());
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
