package com.martinez.findit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class IngresoUsuario extends AppCompatActivity {

    private EditText txtUsuoemail, txtContrasena;
    private Button btnIniciar, btnRegistrarse;
    FirebaseDatabase database;
    DatabaseReference reference;
    Usuarios usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_usuario);

        txtUsuoemail = findViewById(R.id.txtUsuoemail);
        txtContrasena = findViewById(R.id.txtContrasena);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnRegistrarse = findViewById(R.id.btnRegistarse);
        conectarFirebase();

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
                reference.child("usuarios").addValueEventListener(new ValueEventListener() {
                    boolean usuarioExiste = false;
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot dato : snapshot.getChildren()){
                            usuario = dato.getValue(Usuarios.class);
                            if (usuario.getEmail().equals(txtUsuoemail.getText().toString())){
                                usuarioExiste = true;
                                if (usuario.getPassword().equals(txtContrasena.getText().toString())){
                                    mensajeToast("Sesion iniciada");
                                    Intent intento = new Intent(IngresoUsuario.this, MapaUsuario.class);
                                    startActivity(intento);
                                }else{
                                    mensajeToast("Error Clave");
                                }
                            }
                        }
                        if (usuarioExiste == false){
                            mensajeToast("El Email no se Encuentra Registrado");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
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
    public void conectarFirebase(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }
    public void mensajeToast(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }
}