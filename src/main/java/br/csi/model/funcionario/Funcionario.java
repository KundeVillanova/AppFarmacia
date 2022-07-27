package br.csi.model.funcionario;

import br.csi.model.farmacia.Farmacia;

public class Funcionario {
    private int id_func;
    private String nome_func;
    private String telefone;
    private String data_nasc;

    private String funcao;
    private Farmacia farmacia;
    public Farmacia getFarmacia() {
        return farmacia;
    }
    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }
    public Funcionario(int id_func, String nome_func, String telefone, String data_nasc) {
        this.id_func = id_func;
        this.nome_func = nome_func;
        this.telefone = telefone;
        this.data_nasc = data_nasc;
    }
    public Funcionario() { }
    public Funcionario( String nome_func, String telefone, String data_nasc) {
        this.nome_func = nome_func;
        this.telefone = telefone;
        this.data_nasc = data_nasc;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getId_func() {
        return id_func;
    }
    public void setId_func(int id_func) {
        this.id_func = id_func;
    }
    public String getNome_func() {
        return nome_func;
    }
    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getData_nasc() {
        return data_nasc;
    }
    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }
}
