package com.example.projetointegrador6.datamodel;

public class NovoProdutoModel {

        // 1 - Atributo nome da tabela
        public static final String TABELA = "produtos";

        // 2 - Atributos um para um com os nomes dos campos

        public static final String ID = "id"; // integer
        public static final String NOME = "Nome_Produto"; // text
        public static final String DESCRICAO = "Descricao_Produto"; // integer
        public static final String PRECO = "Valor_Produto"; // date

        // 3 - Query para criar a tabela no banco de dados
        public static String queryCriarTabela = "";

        // // 4 - Método para gerar o Script para criar a tabela;
        public static String criarTabela(){

            // Concatenação de String

            queryCriarTabela += "CREATE TABLE " + TABELA + " (";
            queryCriarTabela += ID + " integer primary key autoincrement, ";
            queryCriarTabela += NOME + " text, ";
            queryCriarTabela += DESCRICAO + " text, ";
            queryCriarTabela += PRECO + " float, ";
            queryCriarTabela += ")";

            // queryCriarTabela = "Parte 01, Parte 02, Parte 03, Parte 04, Parte 05, Parte 06, Parte 07"

            return queryCriarTabela;
        }

        // 5 - Queries de consulta gerais

    }

