package com.example.projetointegrador6.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetointegrador6.R;

public class MainActivity extends AppCompatActivity {
    public Button User;
    public Button Adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User = (Button) findViewById(R.id.user);
        Adm = (Button) findViewById(R.id.adm);


        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Usuario.class);
                startActivity(intent);
            }
        });

        Adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Admin.class);
                startActivity(intent);
            }
        });

    }
}