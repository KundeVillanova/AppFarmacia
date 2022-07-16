package br.csi.model.farmacia;

public class Farmacia {
    private int id;

    private int telefone;
    private Localizacao localizacao;

    public Farmacia() {
    }

    public Farmacia(int id, Localizacao localizacao) {
        this.id = id;
        this.localizacao = localizacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}
