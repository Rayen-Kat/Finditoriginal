package com.martinez.findit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton imgbtnUsuario, imgbtnVisita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtnUsuario = findViewById(R.id.imgbtnUsuario);
        imgbtnVisita = findViewById(R.id.imgbtnVisita);

        imgbtnUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, IngresoUsuario.class);
                startActivity(intento);
            }
        });

        imgbtnVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento2 = new Intent(MainActivity.this, prox.class);
                startActivity(intento2);
            }
        });
    }
}