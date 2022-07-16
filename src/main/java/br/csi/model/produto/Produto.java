package br.csi.model.produto;

public class Produto {
    private int id_produto;
    private String marca;
    private int quantidade;

    public Produto() {
    }

    public Produto(int id_produto, String marca, int quantidade) {
        this.id_produto = id_produto;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
