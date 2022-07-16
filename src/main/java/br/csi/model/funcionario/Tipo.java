package br.csi.model.funcionario;

public class Tipo {

    private int id_permissao;
    private String nome_permissao;

    public Tipo() {
    }

    public int getId_permissao() {
        return id_permissao;
    }

    public void setId_permissao(int id_permissao) {
        this.id_permissao = id_permissao;
    }

    public String getNome_permissao() {
        return nome_permissao;
    }

    public void setNome_permissao(String nome_permissao) {
        this.nome_permissao = nome_permissao;
    }
}
