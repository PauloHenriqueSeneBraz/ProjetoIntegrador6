package com.example.projetointegrador6.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.projetointegrador6.API.APPUtil;
import com.example.projetointegrador6.datamodel.NovoCartaoDataModel;
import com.example.projetointegrador6.datamodel.NovoProdutoModel;
import com.example.projetointegrador6.datamodel.PagamentoDataModel;
import com.example.projetointegrador6.datamodel.UsuarioDataModel;
import com.example.projetointegrador6.model.NovoCartao;
import com.example.projetointegrador6.model.NovoPagamento;
import com.example.projetointegrador6.model.NovoProduto;
import com.example.projetointegrador6.model.NovoUsuario;

import java.util.ArrayList;
import java.util.List;

public class AppDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "ProjetoIntegrador6.SQLite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(APPUtil.TAG, "AppDataBase: Criando Banco de Dados");

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(NovoProdutoModel.criarTabela());

        Log.d(APPUtil.TAG, "onCreate: Tabela Treinos criada... " + NovoProdutoModel.criarTabela());

        db.execSQL(NovoCartaoDataModel.criarTabela());

        Log.d(APPUtil.TAG, "onCreate: Tabela Cartoes criada... " + NovoCartaoDataModel.criarTabela());

        db.execSQL(PagamentoDataModel.criarTabela());

        Log.d(APPUtil.TAG, "onCreate: Tabela Pagamentos criada... " + PagamentoDataModel.criarTabela());

        db.execSQL(UsuarioDataModel.criarTabela());

        Log.d(APPUtil.TAG, "onCreate: Tabela Usuairos criada... " + UsuarioDataModel.criarTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //Método para inserir dados no Banco de Dados
    public boolean insert(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

        //Regra de negocio

        try {
            //O que deve ser realizado
            //Salvar os dados
            retorno = db.insert(tabela, null, dados) > 0;
        } catch (Exception e) {
            Log.d(APPUtil.TAG, "Insert:" + e.getMessage());
        }

        return retorno;
    }

    public boolean deleteByID(String tabela, int id) {
        db = getWritableDatabase();

        boolean retorno = false;

        try {
            //O que deve ser realizado
            //Salvar os dados
            //retorno = db.insert(tabela,null, dados) > 0;
            retorno = db.delete(tabela, "id = ?", new String[]{String.valueOf(id)}) > 0;
        } catch (Exception e) {
            Log.d(APPUtil.TAG, "delete:" + e.getMessage());
        }

        return retorno; //True or False
    }

    public boolean update(String tabela, ContentValues dados) {

        db = getWritableDatabase();

        boolean retorno = false;

        //Regra de negocio

        try {
            //O que deve ser realizado
            //Atualizar os dados
            retorno = db.update(tabela, dados, "id = ?", new String[]{String.valueOf(dados.get("id"))}) > 0;
        } catch (Exception e) {
            Log.d(APPUtil.TAG, "Insert:" + e.getMessage());
        }

        return retorno; //True or False
    }

    public List<NovoProduto> getAllProdutos(String tabela) {

        db = getWritableDatabase();

        List<NovoProduto> novosProdutos = new ArrayList<>();

        NovoProduto obj;

        String sql = "SELECT * FROM " + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj = new NovoProduto();

                obj.setId(cursor.getInt(cursor.getColumnIndex(NovoProdutoModel.ID)));
                obj.setNome(cursor.getString(cursor.getColumnIndex(NovoProdutoModel.NOME)));
                obj.setDescricao(cursor.getString(cursor.getColumnIndex(NovoProdutoModel.DESCRICAO)));
                obj.setPreco(cursor.getInt(cursor.getColumnIndex(NovoProdutoModel.PRECO)));

                novosProdutos.add(obj);

            }
            while (cursor.moveToNext());
        }

        return novosProdutos;

    }

    public List<NovoCartao> getAllCartoes(String tabela) {

        NovoCartao obj2;

        db = getWritableDatabase();

        List<NovoCartao> novosCartoes = new ArrayList<>();

        String sql = "SELECT * FROM " + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj2 = new NovoCartao();

                obj2.setId(cursor.getInt(cursor.getColumnIndex(NovoCartaoDataModel.ID)));
                obj2.setNomeTitular(cursor.getString(cursor.getColumnIndex(NovoCartaoDataModel.NOME)));
                obj2.setNumeroC(cursor.getString(cursor.getColumnIndex(NovoCartaoDataModel.NUM)));
                obj2.setData(cursor.getString(cursor.getColumnIndex(NovoCartaoDataModel.DATA)));
                obj2.setCdgv(cursor.getInt(cursor.getColumnIndex(NovoCartaoDataModel.CDGV)));

                novosCartoes.add(obj2);

             }
            while (cursor.moveToNext());
            }
            return novosCartoes;
        }
    public List<NovoPagamento> getAllPg(String tabela) {

        NovoPagamento obj3;

        db = getWritableDatabase();

        List<NovoPagamento> novosPagamentos = new ArrayList<>();

        String sql = "SELECT * FROM " + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj3 = new NovoPagamento();

                obj3.setId(cursor.getInt(cursor.getColumnIndex(PagamentoDataModel.ID)));
                obj3.setNomeTitularP(cursor.getString(cursor.getColumnIndex(PagamentoDataModel.NOMEP)));
                obj3.setNumeroCP(cursor.getString(cursor.getColumnIndex(PagamentoDataModel.NUMP)));
                obj3.setDataP(cursor.getString(cursor.getColumnIndex(PagamentoDataModel.DATAP)));
                obj3.setCdgvP(cursor.getInt(cursor.getColumnIndex(PagamentoDataModel.CDGVP)));

                novosPagamentos.add(obj3);

            }
            while (cursor.moveToNext());
        }
        return novosPagamentos;
    }

    public List<NovoUsuario> getAllUsers(String tabela) {

        db = getWritableDatabase();

        List<NovoUsuario> novosUsuarios = new ArrayList<>();

        NovoUsuario obj4;

        String sql = "SELECT * FROM " + tabela;

        Cursor cursor;

        cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            do {

                obj4 = new NovoUsuario();

                obj4.setId(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.ID)));
                obj4.setNome(cursor.getString(cursor.getColumnIndex(UsuarioDataModel.NOME)));
                obj4.setCpf(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.CPF)));
                obj4.setSenha(cursor.getInt(cursor.getColumnIndex(UsuarioDataModel.SENHA)));

                novosUsuarios.add(obj4);

            }
            while (cursor.moveToNext());
        }

        return novosUsuarios;

    }

    }





