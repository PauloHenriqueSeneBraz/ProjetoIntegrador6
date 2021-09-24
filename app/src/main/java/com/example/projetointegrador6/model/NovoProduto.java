package com.example.projetointegrador6.model;

public class NovoProduto {
        //Atributos
        private int id;
        private String nome;
        private String descricao;
        private int stock;
        private double preco;
        private int img;

        //Métodos

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}

