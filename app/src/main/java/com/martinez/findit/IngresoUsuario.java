package com.martinez.findit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IngresoUsuario extends AppCompatActivity {

    private EditText txtUsuoemail, txtContrasena;
    private Button btnIniciar, btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_usuario);

        txtUsuoemail = findViewById(R.id.txtUsuoemail);
        txtContrasena = findViewById(R.id.txtContrasena);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistrarse = findViewById(R.id.btnRegistarse);

        txtUsuoemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                /*if (){

                }else {

                }*/
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (){

                }else{
                    Intent intento2 = new Intent(IngresoUsuario.this, MapaUsuario.class);
                    startActivity(intento2);
                }*/
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(IngresoUsuario.this, RegistroUsuario.class);
                startActivity(intento);
            }
        });
    }
}