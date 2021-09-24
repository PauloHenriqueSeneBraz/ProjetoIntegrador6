package com.example.projetointegrador6.Controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.projetointegrador6.datamodel.UsuarioDataModel;
import com.example.projetointegrador6.datasource.AppDatabase;
import com.example.projetointegrador6.model.NovoUsuario;

import java.util.List;

public class UsuarioController extends AppDatabase implements ICrud<com.example.projetointegrador6.model.NovoUsuario> {

    ContentValues dadoDoObjeto;

    public UsuarioController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(com.example.projetointegrador6.model.NovoUsuario obj) {

        dadoDoObjeto = new ContentValues();
        // Key, Valor

        // dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        // ID é chave primária da tabela cliente
        // é gerada automaticamente pelo SQLite a cada
        // novo registro adicionado
        // SQL ->>> INSERT INTO TABLE (... ... .. ) VALUES (### ### ###)

        dadoDoObjeto.put(UsuarioDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(UsuarioDataModel.SOBRENOME, obj.getSobrenome());
        dadoDoObjeto.put(UsuarioDataModel.CPF, obj.getCpf());
        dadoDoObjeto.put(UsuarioDataModel.SENHA, obj.getSenha());

        // Enviar os dados (dadoDoObjeto) para a classe AppDatabase
        // utilizando um método capaz de adicionar o OBJ no banco de
        // dados, tabela qualquer uma (Cliente)

        return insert(UsuarioDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean deletar(int id) {

        return deleteByID(UsuarioDataModel.TABELA, id);

    }

    @Override
    public boolean alterar(com.example.projetointegrador6.model.NovoUsuario obj) {

        dadoDoObjeto = new ContentValues();
        // Key, Valor

        // ID é chave primária da tabela cliente
        // é gerada automaticamente pelo SQLite a cada
        // novo registro adicionado
        // Alterar
        // SQL ->>> UPDATE

        dadoDoObjeto.put(UsuarioDataModel.ID, obj.getId());
        dadoDoObjeto.put(UsuarioDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(UsuarioDataModel.SOBRENOME, obj.getSobrenome());
        dadoDoObjeto.put(UsuarioDataModel.CPF, obj.getCpf());
        dadoDoObjeto.put(UsuarioDataModel.SENHA, obj.getSenha());

        // Enviar os dados (dadoDoObjeto) para a classe AppDatabase
        // utilizando um método capaz de alterar o OBJ no banco de
        // dados, tabela qualquer uma (Cliente), respeitando o ID
        // ou PK (Primary Key)

        return update(UsuarioDataModel.TABELA, dadoDoObjeto);

    }

    @Override
    public List<NovoUsuario> listar() {

        return getAllUsers(UsuarioDataModel.TABELA);

    }

}