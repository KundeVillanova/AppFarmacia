package br.csi.model.usuario;

import java.sql.Date;

public class Usuario {

    private int id;
    
    private String nome;
    private String email;
    private String senha;
    private Date dataCadastro;
    private boolean ativo;
    private Permissao permissao;

    public Usuario(String nome, String email, String senha, Date data_cadastro, boolean ativo, Permissao permissao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = data_cadastro;
        this.ativo = ativo;
        this.permissao = permissao;
    }

    public Usuario() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public void getSenha(String senha) {
    }
}
