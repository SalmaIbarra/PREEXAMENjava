package com.example.pre_examen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Activity_Recibo extends AppCompatActivity {


    private Button btnGenerar;
    private Button btnLimpiar;
    private Button btnRegresar;

    private TextView lblUsuario;

    private EditText txtNombre;
    private EditText txtNumeroRecibo;
    private EditText txtHorasTrabajadas;
    private EditText txtHorasExtras;

    private RadioButton rbAuxiliar;
    private RadioButton rbAlbañil;
    private RadioButton rbingObra;

    private EditText txtSubtotal;
    private EditText txtImpuesto;
    private EditText txtTotalPagar;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    private ReciboNomina reciboNomina = new ReciboNomina(0,"",0.0,0.0,0,0.0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo);

        iniciarComponentes();
        String strUsuario;
        strUsuario = getResources().getString(R.string.nombre);
        lblUsuario.setText(strUsuario.toString());

        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNombre.getText().toString().equals("") || txtNumeroRecibo.getText().toString().equals("") || txtHorasTrabajadas.getText().toString().equals("") || txtHorasExtras.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"No deje campos vacios",Toast.LENGTH_SHORT).show();

                }
                else{
                    btnGenerar();
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLimpiar();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegresar();
            }
        });


    }







    private void iniciarComponentes()
    {
        btnGenerar = findViewById(R.id.btnCalcular);
        btnLimpiar=findViewById(R.id.btnLimpiar);
        btnRegresar=findViewById(R.id.btnRegresar);

        lblUsuario= findViewById(R.id.lblUsuario);

        txtNombre= findViewById(R.id.txtNombre);
        txtNumeroRecibo= findViewById(R.id.txtNumero);
        txtHorasTrabajadas=findViewById(R.id.txtHoras);
        txtHorasExtras=findViewById(R.id.txtHorasExtras);

        rbAuxiliar=findViewById(R.id.rbAuxiliar);
        rbAlbañil=findViewById(R.id.rbAlbañil);
        rbingObra=findViewById(R.id.rbIngObra);

        txtSubtotal=findViewById(R.id.txtSubTotal);
        txtImpuesto=findViewById(R.id.txtImpuestos);
        txtTotalPagar=findViewById(R.id.txttotalPagar);
    }


    private void btnGenerar()
    {
        int puesto=0;
        reciboNomina.setHorasTrabajadas(Integer.parseInt(txtHorasTrabajadas.getText().toString()));
        reciboNomina.setHorasExtras(Double.parseDouble((txtHorasExtras.getText().toString())));
        if(rbAuxiliar.isChecked())
        {
            puesto=1;
        }
        else if(rbAlbañil.isChecked())
        {
            puesto=2;
        }
        else if(rbingObra.isChecked())
        {
            puesto=3;
        }
        reciboNomina.setPuesto(puesto);
        double subtotal=reciboNomina.calcularSubtotal();

        txtSubtotal.setText(decimalFormat.format(subtotal));


        double impuesto=reciboNomina.calcularImpuesto();
        txtImpuesto.setText(decimalFormat.format(impuesto));

        double total=reciboNomina.calcularTotalPagar();
        txtTotalPagar.setText(decimalFormat.format(total));




    }

    private void btnLimpiar()
    {
        txtNombre.setText("");
        txtNumeroRecibo.setText("");
        txtHorasExtras.setText("");
        txtHorasTrabajadas.setText("");
        txtSubtotal.setText("");
        txtImpuesto.setText("");
        txtTotalPagar.setText("");

    }

    private void btnRegresar()
    {
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