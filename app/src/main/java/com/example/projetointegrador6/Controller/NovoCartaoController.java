package com.example.projetointegrador6.Controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.projetointegrador6.datamodel.NovoCartaoDataModel;
import com.example.projetointegrador6.datasource.AppDatabase;

import java.util.List;

public class NovoCartaoController extends AppDatabase implements ICrud<com.example.projetointegrador6.model.NovoCartao> {

    ContentValues dadoDoObjeto;

    public NovoCartaoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(com.example.projetointegrador6.model.NovoCartao obj) {

        dadoDoObjeto = new ContentValues();
        // Key, Valor

        // dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        // ID é chave primária da tabela cliente
        // é gerada automaticamente pelo SQLite a cada
        // novo registro adicionado
        // SQL ->>> INSERT INTO TABLE (... ... .. ) VALUES (### ### ###)

        dadoDoObjeto.put(NovoCartaoDataModel.NOME,obj.getNomeTitular());
        dadoDoObjeto.put(NovoCartaoDataModel.NUM,obj.getNumeroC());
        dadoDoObjeto.put(NovoCartaoDataModel.CDGV,obj.getCdgv());
        dadoDoObjeto.put(NovoCartaoDataModel.DATA,obj.getData());

        // Enviar os dados (dadoDoObjeto) para a classe AppDatabase
        // utilizando um método capaz de adicionar o OBJ no banco de
        // dados, tabela qualquer uma (Cliente)

        return insert(NovoCartaoDataModel.TABELA, dadoDoObjeto);

    }

    @Override
    public boolean deletar(int id) {

        return deleteByID(NovoCartaoDataModel.TABELA, id);

    }

    @Override
    public boolean alterar(com.example.projetointegrador6.model.NovoCartao obj) {

        dadoDoObjeto = new ContentValues();
        // Key, Valor

        // ID é chave primária da tabela cliente
        // é gerada automaticamente pelo SQLite a cada
        // novo registro adicionado
        // Alterar
        // SQL ->>> UPDATE

        dadoDoObjeto.put(NovoCartaoDataModel.ID,obj.getId());
        dadoDoObjeto.put(NovoCartaoDataModel.NOME,obj.getNomeTitular());
        dadoDoObjeto.put(NovoCartaoDataModel.NUM,obj.getNumeroC());
        dadoDoObjeto.put(NovoCartaoDataModel.CDGV,obj.getCdgv());
        dadoDoObjeto.put(NovoCartaoDataModel.DATA,obj.getData());

        // Enviar os dados (dadoDoObjeto) para a classe AppDatabase
        // utilizando um método capaz de alterar o OBJ no banco de
        // dados, tabela qualquer uma (Cliente), respeitando o ID
        // ou PK (Primary Key)

        return update (NovoCartaoDataModel.TABELA, dadoDoObjeto);

    }

    @Override
    public List<com.example.projetointegrador6.model.NovoCartao> listar() {

        return getAllCartoes(NovoCartaoDataModel.TABELA);

    }
}


