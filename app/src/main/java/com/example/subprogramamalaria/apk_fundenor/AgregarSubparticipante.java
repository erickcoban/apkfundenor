package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AgregarSubparticipante extends Activity implements OnClickListener {
    EditText et;
    Button btnAgregar, read_bt;
    SQLControladorSubparticipante dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_subparticipante);
        et = (EditText) findViewById(R.id.et_miembro_id);
        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        dbconeccion = new SQLControladorSubparticipante(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);

        //Muestra el apellido de casada si es mujer
        final EditText apellidoP3 = (EditText)findViewById(R.id.apellidoP3);
        final RadioButton rb_amaCasa = (RadioButton)findViewById(R.id.rb_amaCasa);
        RadioButton rb_masculino = (RadioButton)findViewById(R.id.rb_masculino);
        RadioButton rb_femenino = (RadioButton)findViewById(R.id.rb_femenino);
        View.OnClickListener list_apellidoP3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_femenino:
                        apellidoP3.setVisibility(View.VISIBLE);
                        rb_amaCasa.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_masculino:
                        apellidoP3.setVisibility(View.GONE);
                        rb_amaCasa.setVisibility(View.GONE);
                        break;
                }
            }
        };
        rb_femenino.setOnClickListener(list_apellidoP3);
        rb_masculino.setOnClickListener(list_apellidoP3);

        //Muestra Especifique otro oficio
        final EditText otroOficio = (EditText)findViewById(R.id.otroOficio);
        RadioButton rb_otroOficio = (RadioButton)findViewById(R.id.rb_otroOficio);
        RadioButton rb_jornalero = (RadioButton)findViewById(R.id.rb_jornalero);
        RadioButton rb_comerciante = (RadioButton)findViewById(R.id.rb_comerciante);
        RadioButton rb_agricultor = (RadioButton)findViewById(R.id.rb_agricultor);
        View.OnClickListener list_otroOficio = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_otroOficio:
                        otroOficio.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_jornalero:
                        otroOficio.setVisibility(View.GONE);
                        break;
                    case R.id.rb_comerciante:
                        otroOficio.setVisibility(View.GONE);
                        break;
                    case R.id.rb_agricultor:
                        otroOficio.setVisibility(View.GONE);
                        break;
                }
            }
        };
        rb_otroOficio.setOnClickListener(list_otroOficio);
        rb_jornalero.setOnClickListener(list_otroOficio);
        rb_comerciante.setOnClickListener(list_otroOficio);
        rb_agricultor.setOnClickListener(list_otroOficio);

        //Muestra Especifique otra religión
        final EditText otraReligion = (EditText)findViewById(R.id.otraReligion);
        RadioButton rb_catolico = (RadioButton)findViewById(R.id.rb_catolico);
        RadioButton rb_evangelico = (RadioButton)findViewById(R.id.rb_evangelico);
        RadioButton rb_otraReligion = (RadioButton)findViewById(R.id.rb_otraReligion);
        View.OnClickListener list_otraReligion = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_otraReligion:
                        otraReligion.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_catolico:
                        otraReligion.setVisibility(View.GONE);
                        break;
                    case R.id.rb_evangelico:
                        otraReligion.setVisibility(View.GONE);
                        break;
                }
            }
        };
        rb_catolico.setOnClickListener(list_otraReligion);
        rb_evangelico.setOnClickListener(list_otraReligion);
        rb_otraReligion.setOnClickListener(list_otraReligion);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarId:
                String name = et.getText().toString();
                dbconeccion.insertarDatos(name);
                Intent main = new Intent(AgregarSubparticipante.this, MyActivitySubparticipante.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;

            default:
                break;
        }
    }
}
