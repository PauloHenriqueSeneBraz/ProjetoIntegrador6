package com.example.projetointegrador6.datamodel;

public class PagamentoDataModel {

    // 1 - Atributo nome da tabela
    public static final String TABELA = "Pagamentos";

    // 2 - Atributos um para um com os nomes dos campos

    public static final String ID = "id"; // integer
    public static final String NOMEP = "Nome_Titular"; // text
    public static final String NUMP = "Numero_do_Cartao"; // integer
    public static final String DATAP = "Data_de_Validade"; // date
    public static final String CDGVP = "Codigo_de_Verificacao"; // integer
    public static final String TERMOS = "Termos"; // integer

    // 3 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    // // 4 - Método para gerar o Script para criar a tabela;
    public static String criarTabela(){

        // Concatenação de String

        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " integer primary key autoincrement, ";
        queryCriarTabela += NOMEP + " text, ";
        queryCriarTabela += NUMP + " integer, ";
        queryCriarTabela += DATAP + " integer, ";
        queryCriarTabela += CDGVP + " integer, ";
        queryCriarTabela += TERMOS + " integer ";
        queryCriarTabela += ")";

        // queryCriarTabela = "Parte 01, Parte 02, Parte 03, Parte 04, Parte 05, Parte 06, Parte 07"

        return queryCriarTabela;
    }

    // 5 - Queries de consulta gerais

}

