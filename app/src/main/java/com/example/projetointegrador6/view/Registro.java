package com.example.projetointegrador6.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.projetointegrador6.R;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.InputMismatchException;

public class Registro extends AppCompatActivity {
    private EditText Nome;
    private EditText Sobrenome;
    private EditText Cpf;
    private EditText Senha;
    private EditText confSenha;
    private Button Avancar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        iniciarCDT();
        trocarTela();
        MascarasDeTexto();
    }

    private void iniciarCDT() {
        Nome = findViewById(R.id.nome);
        Sobrenome = findViewById(R.id.sobrenome);
        Cpf = findViewById(R.id.cpf);
        Senha = findViewById(R.id.senha);
        confSenha = findViewById(R.id.cSenha);
        Avancar = findViewById(R.id.avanco);
    }

    private void trocarTela() {

        Avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean dadosOK = true;

                if (TextUtils.isEmpty(Nome.getText().toString())) {
                    Nome.setError("Insira seu Nome");

                    Nome.requestFocus();

                    dadosOK = false;
                }
                if (TextUtils.isEmpty(Sobrenome.getText().toString())) {
                    Sobrenome.setError("Insira seu Sobrenome");

                    Sobrenome.requestFocus();

                    dadosOK = false;
                }

                if (TextUtils.isEmpty(Cpf.getText().toString())) {
                    Cpf.setError("Insira seu CPF");

                    Cpf.requestFocus();

                    dadosOK = false;
                }

                if (Cpf.length() != 11) {

                    Cpf.setError("Insira um CPF Valido");

                    Cpf.requestFocus();

                    dadosOK = false;
                }


                if (TextUtils.isEmpty(Senha.getText().toString())) {
                    Senha.setError("Insira uma Senha");

                    Senha.requestFocus();

                    dadosOK = false;
                }

                if (TextUtils.isEmpty(confSenha.getText().toString())) {
                    confSenha.setError("Insira uma Senha");

                    confSenha.requestFocus();

                    dadosOK = false;
                }

                if (Senha != confSenha) {
                    confSenha.setError("As senhas são diferentes");
                    Senha.setError("As senhas são diferentes");

                    confSenha.requestFocus();
                    Senha.requestFocus();

                    dadosOK = false;
                } else {

                }

                if (dadosOK) {
                    Intent intent = new Intent(getApplicationContext(), Admin.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void MascarasDeTexto() {

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(Cpf, smf);
        Cpf.addTextChangedListener(mtw);

    }


    public boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

    public static String imprimeCPF(String CPF) {
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

}