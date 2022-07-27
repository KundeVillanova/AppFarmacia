package br.csi.model.produto;

import br.csi.model.farmacia.Farmacia;
public class Produto {
    private int id_produto;
    private String marca;
    private int quantidade;
    private Farmacia farmacia;
    private Categoria categoria;

    public Produto(int id_produto, String marca, int quantidade, Farmacia farmacia, Categoria categoria) {
        this.id_produto = id_produto;
        this.marca = marca;
        this.quantidade = quantidade;
        this.farmacia = farmacia;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public Produto() { }
    public Produto(int id_produto, String marca, int quantidade) {
        this.id_produto = id_produto;
        this.marca = marca;
        this.quantidade = quantidade;
    }

    public Produto(String marca, int quantidade) {
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