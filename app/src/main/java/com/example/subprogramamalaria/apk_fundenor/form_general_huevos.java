package com.example.subprogramamalaria.apk_fundenor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Subprograma Malaria on 02/11/2016.
 */

public class form_general_huevos extends Activity implements View.OnClickListener {
    EditText cantidadH, consumoH, reproduccionH ,ventaH;
    DatePicker fechaHuev;
    Button btnAgregarHue;
    SQLControladorEtnoHuevos dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_general_huevos);

        //Almacena lo que le solicita a cada campo
        cantidadH = (EditText)findViewById(R.id.cantHue);
        consumoH = (EditText)findViewById(R.id.consuHue);
        reproduccionH = (EditText)findViewById(R.id.prodHue);
        ventaH = (EditText)findViewById(R.id.ventHue);

        fechaHuev = (DatePicker)findViewById(R.id.fechaHuevos);

        btnAgregarHue = (Button) findViewById(R.id.btnAgregarHuevos);

        dbconeccion = new SQLControladorEtnoHuevos(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarHue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarHuevos:
                String idEtno = getIntent().getStringExtra("idEtno");
                String cantidadSemanal = cantidadH.getText().toString();
                String consumoSemanal = consumoH.getText().toString();
                String reproduccion = reproduccionH.getText().toString();
                String venta = ventaH.getText().toString();
                String fecha = fechaHuev.getYear()+"-"+(fechaHuev.getMonth()+1)+"-"+fechaHuev.getDayOfMonth();

                dbconeccion.insertarDatos(idEtno, cantidadSemanal, consumoSemanal, reproduccion, venta, fecha);
                Intent main = new Intent(form_general_huevos.this, formulariosEtno.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("idEtno",idEtno);
                Toast.makeText(getApplicationContext(), "Elementos Guardados Correctamente ", Toast.LENGTH_SHORT).show();
                startActivity(main);
                break;

            default:
                break;
        }
    }
}
