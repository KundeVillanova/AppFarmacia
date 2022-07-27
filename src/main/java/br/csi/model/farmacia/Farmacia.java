package br.csi.model.farmacia;

public class Farmacia {
    private int id;
    private String alias;
    private int telefone;
    private String sigla_estado;
    private String nome_cidade;
    private String rua;
    private String cep;

    public Farmacia() {}

    public Farmacia(int id, String alias, int telefone, String sigla_estado, String nome_cidade, String rua, String cep) {
        this.id = id;
        this.alias = alias;
        this.telefone = telefone;
        this.sigla_estado = sigla_estado;
        this.nome_cidade = nome_cidade;
        this.rua = rua;
        this.cep = cep;
    }

    public Farmacia(String alias, int telefone, String sigla_estado, String nome_cidade, String rua, String cep) {
        this.alias = alias;
        this.telefone = telefone;
        this.sigla_estado = sigla_estado;
        this.nome_cidade = nome_cidade;
        this.rua = rua;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getSigla_estado() {
        return sigla_estado;
    }

    public void setSigla_estado(String sigla_estado) {
        this.sigla_estado = sigla_estado;
    }

    public String getNome_cidade() {
        return nome_cidade;
    }

    public void setNome_cidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
