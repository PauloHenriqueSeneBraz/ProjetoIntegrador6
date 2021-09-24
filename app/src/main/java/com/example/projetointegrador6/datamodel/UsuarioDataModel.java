package com.example.projetointegrador6.datamodel;

public class UsuarioDataModel {

    // 1 - Atributo nome da tabela
    public static final String TABELA = "usuarios";

    // 2 - Atributos um para um com os nomes dos campos

    public static final String ID = "id"; // integer
    public static final String NOME = "Nome_Usuario"; // text
    public static final String SOBRENOME = "Sobrenome_Usuario"; // integer
    public static final String CPF = "Cpf_Usuario"; // date
    public static final String SENHA = "Valor_Produto"; // date

    // 3 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    // // 4 - Método para gerar o Script para criar a tabela;
    public static String criarTabela(){

        // Concatenação de String

        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " integer primary key autoincrement, ";
        queryCriarTabela += NOME + " text, ";
        queryCriarTabela += SOBRENOME + " text, ";
        queryCriarTabela += CPF + " float, ";
        queryCriarTabela += SENHA + " integer, ";
        queryCriarTabela += ")";

        // queryCriarTabela = "Parte 01, Parte 02, Parte 03, Parte 04, Parte 05, Parte 06, Parte 07"

        return queryCriarTabela;
    }

    // 5 - Queries de consulta gerais

}
