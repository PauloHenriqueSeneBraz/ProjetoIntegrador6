package com.example.projetointegrador6.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetointegrador6.R;

public class Usuario extends AppCompatActivity {
    private Button Registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        iniciarCDT();
        trocarTela();
    }

    private void iniciarCDT() {
        Registrar = findViewById(R.id.registro);
    }
    private void trocarTela(){
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });
    }

}