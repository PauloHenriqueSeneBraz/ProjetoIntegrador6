package com.example.projetointegrador6.Controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.projetointegrador6.datamodel.PagamentoDataModel;
import com.example.projetointegrador6.datasource.AppDatabase;

import java.util.List;


public class PagamentoController extends AppDatabase implements ICrud<com.example.projetointegrador6.model.NovoPagamento> {

    ContentValues dadoDoObjeto;

    public PagamentoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(com.example.projetointegrador6.model.NovoPagamento obj) {

        dadoDoObjeto = new ContentValues();
        // Key, Valor

        // dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        // ID é chave primária da tabela cliente
        // é gerada automaticamente pelo SQLite a cada
        // novo registro adicionado
        // SQL ->>> INSERT INTO TABLE (... ... .. ) VALUES (### ### ###)

        dadoDoObjeto.put(PagamentoDataModel.NOMEP,obj.getNomeTitularP());
        dadoDoObjeto.put(PagamentoDataModel.NUMP,obj.getNumeroCP());
        dadoDoObjeto.put(PagamentoDataModel.CDGVP,obj.getCdgvP());
        dadoDoObjeto.put(PagamentoDataModel.DATAP,obj.getDataP());
        dadoDoObjeto.put(PagamentoDataModel.TERMOS,obj.isConcordo());

        // Enviar os dados (dadoDoObjeto) para a classe AppDatabase
        // utilizando um método capaz de adicionar o OBJ no banco de
        // dados, tabela qualquer uma (Cliente)

        return insert(PagamentoDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {

        return deleteByID(PagamentoDataModel.TABELA, id);

    }

    @Override
    public boolean alterar(com.example.projetointegrador6.model.NovoPagamento obj) {

        dadoDoObjeto = new ContentValues();
        // Key, Valor

        // ID é chave primária da tabela cliente
        // é gerada automaticamente pelo SQLite a cada
        // novo registro adicionado
        // Alterar
        // SQL ->>> UPDATE

        dadoDoObjeto.put(PagamentoDataModel.ID,obj.getId());
        dadoDoObjeto.put(PagamentoDataModel.NOMEP,obj.getNomeTitularP());
        dadoDoObjeto.put(PagamentoDataModel.NUMP,obj.getNumeroCP());
        dadoDoObjeto.put(PagamentoDataModel.CDGVP,obj.getCdgvP());
        dadoDoObjeto.put(PagamentoDataModel.DATAP,obj.getDataP());

        // Enviar os dados (dadoDoObjeto) para a classe AppDatabase
        // utilizando um método capaz de alterar o OBJ no banco de
        // dados, tabela qualquer uma (Cliente), respeitando o ID
        // ou PK (Primary Key)

        return update (PagamentoDataModel.TABELA, dadoDoObjeto);

    }

    @Override
    public List<com.example.projetointegrador6.model.NovoPagamento> listar() {

        return getAllPg(PagamentoDataModel.TABELA);

    }

}
