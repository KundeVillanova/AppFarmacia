package br.csi.model.farmacia;

public class Farmacia {
    private int id_farm;
    private String alias_farm;
    private String telefone;
    private String sigla_estado;
    private String nome_cidade;
    private String rua;
    private String cep;

    public Farmacia() {}

    public Farmacia(int id_farm, String alias_farm, String telefone, String sigla_estado, String nome_cidade, String rua, String cep) {
        this.id_farm = id_farm;
        this.alias_farm = alias_farm;
        this.telefone = telefone;
        this.sigla_estado = sigla_estado;
        this.nome_cidade = nome_cidade;
        this.rua = rua;
        this.cep = cep;
    }

    public Farmacia(String alias_farm, String telefone, String sigla_estado, String nome_cidade, String rua, String cep) {
        this.alias_farm = alias_farm;
        this.telefone = telefone;
        this.sigla_estado = sigla_estado;
        this.nome_cidade = nome_cidade;
        this.rua = rua;
        this.cep = cep;
    }

    public int getId_farm() {
        return id_farm;
    }

    public void setId_farm(int id_farm) {
        this.id_farm = id_farm;
    }

    public String getAlias_farm() {
        return alias_farm;
    }

    public void setAlias_farm(String alias_farm) {
        this.alias_farm = alias_farm;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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

    public void getSigla_estado(String sigla_estado) {
    }
}
