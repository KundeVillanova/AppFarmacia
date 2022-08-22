package br.csi.model.produto;

import br.csi.model.farmacia.Farmacia;
public class Produto {
    private int id_produto;
    private String nome_produto;
    private String categoria;
    private String marca;
    private int quantidade;
    private Farmacia farmacia;

    public String getCategoria() {return categoria;}
    public void setCategoria(String categoria) {this.categoria = categoria;}
    public Farmacia getFarmacia() {
        return farmacia;
    }
    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }
    public Produto() { }
    public Produto(int id_produto, String nome_produto, String categoria, String marca, int quantidade, Farmacia farmacia) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.categoria = categoria;
        this.marca = marca;
        this.quantidade = quantidade;
        this.farmacia = farmacia;
    }
    public String getNome_produto() {return nome_produto;}
    public void setNome_produto(String nome_produto) {this.nome_produto = nome_produto;}
    public int getId_produto() {return id_produto;}
    public void setId_produto(int id_produto) {this.id_produto = id_produto;}
    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}
    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
}