package com.example.ruben.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Contacto extends AppCompatActivity {
    private Toolbar toolbar;
    private TextInputEditText tpTextEmail,TpTextNombre,
            tpTextComentario;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //para dar soporte al boton de atras para la app
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tpTextEmail = (TextInputEditText) findViewById(R.id.tpTextEmail);
        TpTextNombre = (TextInputEditText) findViewById(R.id.tpTextNombre);
        tpTextComentario = (TextInputEditText) findViewById(R.id.tpTextComentario);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarCorreo();
            }
        });

    }

    private void enviarCorreo() {
        String mail = tpTextEmail.getText().toString().trim();
        String name = TpTextNombre.getText().toString().trim();
        String message = tpTextComentario.getText().toString();

        //Enviar correo
        JavaMailAPI javaMailAPI = new JavaMailAPI(this,mail,name,message);
        javaMailAPI.execute();
    }
}