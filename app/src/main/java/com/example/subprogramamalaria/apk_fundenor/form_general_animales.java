package com.example.subprogramamalaria.apk_fundenor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Subprograma Malaria on 02/11/2016.
 */

public class form_general_animales extends Activity implements View.OnClickListener {
    DatePicker fechaAni;
    Button btnAgregar;
    SQLControladorEtnoOtrosAnimales dbconeccion;
    EditText noVa , noCe, noCa, noCo, noPa;
    String otroAni="", estadoHabi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_general_animales);

        //Almacena la cadena de otros Alimentos
        final CheckBox ani1 = (CheckBox)findViewById(R.id.cbVaca);
        ani1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ani1.isChecked()){
                    otroAni += " "+"vaca";
                    noVa.setVisibility(View.VISIBLE);}
                else{noVa.setVisibility(View.GONE);}
            }
        });
        final CheckBox ali2 = (CheckBox)findViewById(R.id.cbCerdo);
        ali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali2.isChecked()){
                    otroAni += " "+"cerdo";
                    noCe.setVisibility(View.VISIBLE);}
                else{noCe.setVisibility(View.GONE);}
            }
        });
        final CheckBox ali3 = (CheckBox)findViewById(R.id.cbCabra);
        ali3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali3.isChecked()){
                    otroAni += " "+"cabra";
                    noCa.setVisibility(View.VISIBLE);}
                else{noCa.setVisibility(View.GONE);}
            }
        });
        final CheckBox ali4 = (CheckBox)findViewById(R.id.cbConejo);
        ali4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali4.isChecked()){
                    otroAni += " "+"conejo";
                    noCo.setVisibility(View.VISIBLE);}
                else{noCo.setVisibility(View.GONE);}
            }
        });
        final CheckBox ali5 = (CheckBox)findViewById(R.id.cbPaloma);
        ali5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali5.isChecked()){
                    otroAni += " "+"paloma";
                    noPa.setVisibility(View.VISIBLE);}
                else{noPa.setVisibility(View.GONE);}
            }
        });

        noVa = (EditText)findViewById(R.id.noVacas);
        noCe = (EditText)findViewById(R.id.noCerdos);
        noCa = (EditText)findViewById(R.id.noCabras);
        noCo = (EditText)findViewById(R.id.noConejos);
        noPa = (EditText)findViewById(R.id.noPalomas);

        //Almacena las condiciones del Habitat
        RadioButton rb_buenaOA = (RadioButton)findViewById(R.id.rb_buenaOA);
        RadioButton rb_regularOA = (RadioButton)findViewById(R.id.rb_regularOA);
        RadioButton rb_maloOA = (RadioButton)findViewById(R.id.rb_maloOA);
        View.OnClickListener list_estaHab = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_buenaOA:
                        estadoHabi = "bueno";
                        break;
                    case R.id.rb_regularOA:
                        estadoHabi = "regular";
                        break;
                    case R.id.rb_maloOA:
                        estadoHabi = "malo";
                        break;
                }
            }
        };
        rb_buenaOA.setOnClickListener(list_estaHab);
        rb_regularOA.setOnClickListener(list_estaHab);
        rb_maloOA.setOnClickListener(list_estaHab);


        fechaAni = (DatePicker)findViewById(R.id.fechaAnimal);

        btnAgregar = (Button) findViewById(R.id.btnAgregarAnimal);

        dbconeccion = new SQLControladorEtnoOtrosAnimales(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarAnimal:
                String idEtno = getIntent().getStringExtra("idEtno");
                String otroAnimal = otroAni;
                String noVaca = noVa.getText().toString();
                String noCerdo = noCe.getText().toString();
                String noCabra = noCa.getText().toString();
                String noConejo = noCo.getText().toString();
                String noPaloma = noPa.getText().toString();
                String habitat = estadoHabi;
                String fechaAnimal = fechaAni.getYear()+"-"+(fechaAni.getMonth()+1)+"-"+fechaAni.getDayOfMonth();

                dbconeccion.insertarDatos(idEtno, otroAnimal, noVaca, noCerdo, noCabra, noConejo, noPaloma, habitat, fechaAnimal);
                Intent main = new Intent(form_general_animales.this, formulariosEtno.class)
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
