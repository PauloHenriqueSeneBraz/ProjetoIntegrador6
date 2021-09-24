package com.example.projetointegrador6.Controller;

import android.util.Log;

import com.example.projetointegrador6.API.APPUtil;


public class AppController {

    String TAG = "Curso_Android";

    String versaoApp;

    public AppController(){

        this.versaoApp = APPUtil.versaoDoApp();

        Log.i(TAG, "ClienteController: Versão do App "+versaoApp);
    }

}
