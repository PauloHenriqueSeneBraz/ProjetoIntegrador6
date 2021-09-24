package com.example.projetointegrador6.model;

public class NovoPagamento {

    private int id;
    private String nomeTitularP;
    private String numeroCP;
    private String dataP;
    private String erro;
    private String token;
    private int cdgvP;
    private boolean concordo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTitularP() {
        return nomeTitularP;
    }

    public void setNomeTitularP(String nomeTitularP) {
        this.nomeTitularP = nomeTitularP;
    }

    public String getNumeroCP() {
        return numeroCP;
    }

    public void setNumeroCP(String numeroCP) {
        this.numeroCP = numeroCP;
    }

    public String getDataP() {
        return dataP;
    }

    public void setDataP(String dataP) {
        this.dataP = dataP;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCdgvP() {
        return cdgvP;
    }

    public boolean isConcordo() {
        return concordo;
    }

    public void setConcordo(boolean concordo) {
        this.concordo = concordo;
    }

    public void setCdgvP(int cdgvP) {
        this.cdgvP = cdgvP;
    }
}
