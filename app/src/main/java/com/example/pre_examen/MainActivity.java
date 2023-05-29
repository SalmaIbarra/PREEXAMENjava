package com.example.pre_examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnIngresar;
    private Button btnSalir;
    private EditText txtNombre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    iniciarComponentes();
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtnIngresar();
            }
        });


        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSalir();
            }
        });



    }


    private void iniciarComponentes()
    {
        btnIngresar=findViewById(R.id.btnEntrar);
        btnSalir=findViewById(R.id.btnSalir);
        txtNombre=findViewById(R.id.txtNombre);
    }


    private void BtnIngresar()
    {
        String strUsuario;
        strUsuario=getResources().getString(R.string.nombre);

        if (strUsuario.equals(txtNombre.getText().toString()))
        {
            Intent intent = new Intent(MainActivity.this,Activity_Recibo.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"El Usuario es incorrecto o el campo esta vacio",Toast.LENGTH_SHORT).show();
        }
    }


    private void btnSalir() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);

        confirmar.setTitle("Recibo Nomina");
        confirmar.setMessage("¿Desea Salir?");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // No hacer nada
            }
        });

        confirmar.show();
    }


}