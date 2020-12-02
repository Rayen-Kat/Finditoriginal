package com.martinez.findit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class RegistroUsuario extends AppCompatActivity {

    private EditText txtUser, txtEmail, txtPassword, txtPasswordConf;
    private Button btnRegistro;
    private boolean UserOK = false;
    private boolean EmailOk = false;
    private boolean PassOk = false;
    Usuarios usuario;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        txtUser = findViewById(R.id.txtUser);
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        txtPasswordConf = findViewById(R.id.txtPasswordConf);
        btnRegistro = findViewById(R.id.btnRegistro);
        conectarFirebase();

        txtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 3){
                    txtUser.setError("Nombre Muy Corto");
                    UserOK = false;
                }else {
                    UserOK = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 3){
                    txtEmail.setError("Email Muy Corto");
                    EmailOk = false;
                }else {
                    EmailOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 5){
                    txtPassword.setError("Contraseña Muy Corta");
                    PassOk = false;
                }else {
                    PassOk = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtPassword.getText().toString().equals(txtPasswordConf.getText().toString())) {
                    String Id = UUID.randomUUID().toString();
                    String Nombre = txtUser.getText().toString().trim();
                    String Correo = txtEmail.getText().toString().trim();
                    String Contrasenia = txtPassword.getText().toString().trim();
                    Usuarios usuario = new Usuarios(Id,Nombre,Correo,Contrasenia);
                    insertarUsuario(usuario);
                }else {
                    mensajeToast("Error Datos Invalidos");
                    txtPassword.setText("");
                    txtPasswordConf.setText("");
                }
            }
        });
    }

    public void conectarFirebase(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }
    public void insertarUsuario(Usuarios u){
        if(u != null){
            reference.child("usuarios").child(u.getId()).setValue(u, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                    Toast.makeText(getApplicationContext(), "Usuario creado",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    public void mensajeToast(String mensaje){
        Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
    }
}