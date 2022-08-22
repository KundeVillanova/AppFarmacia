package br.csi.model.farmacia;

public class Farmacia {
    private int id_farm;
    private String alias_farm;
    private String telefone;
    private String estado;
    private String cidade;
    private String rua;
    private String cep;

    public Farmacia() {}

    public Farmacia(int id_farm, String alias_farm, String telefone, String estado, String cidade, String rua, String cep) {
        this.id_farm = id_farm;
        this.alias_farm = alias_farm;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.cep = cep;
    }

    public Farmacia(String alias_farm, String telefone, String estado, String cidade, String rua, String cep) {
        this.alias_farm = alias_farm;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
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
