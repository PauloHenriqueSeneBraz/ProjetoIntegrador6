package com.example.projetointegrador6.model;

public class NovoCartao  {

    //Atributos
    private int id;
    private String nomeTitular;
    private String numeroC;
    private String data;
    private int cdgv;

    //Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroC() {
        return numeroC;
    }

    public void setNumeroC(String numeroC) {
        this.numeroC = numeroC;
    }

    public int getCdgv() {
        return cdgv;
    }

    public void setCdgv(int cdgv) {
        this.cdgv = cdgv;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}