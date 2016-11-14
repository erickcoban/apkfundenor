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
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

public class AgregarHuertosDiversificacion extends Activity implements OnClickListener {

    EditText medHuer, ingSem;
    DatePicker fechaImpl, fechaRegH;
    String buenasPrac, manteSuelo="", prodOrga, practAgua;
    Button btnAgregar;
    int conta = 0;
    SQLControladorHuertos dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_huertos);

        medHuer = (EditText)findViewById(R.id.medidaHuerto);
        ingSem = (EditText)findViewById(R.id.ingresoSemanal);

        fechaImpl = (DatePicker)findViewById(R.id.fechaImplementacion);
        fechaRegH = (DatePicker)findViewById(R.id.fechaRegH);

        //Almacena la selección del Radio button utiliza buenas practicas
        RadioButton rb_noH = (RadioButton)findViewById(R.id.rb_siH);
        RadioButton rb_siH = (RadioButton)findViewById(R.id.rb_noH);
        OnClickListener list_buenasPracticas = new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_noH:
                        buenasPrac = "no";
                        break;
                    case R.id.rb_siH:
                        buenasPrac = "si";
                        break;
                }
            }
        };
        rb_noH.setOnClickListener(list_buenasPracticas);
        rb_siH.setOnClickListener(list_buenasPracticas);

        //Almacena la cadena de las tecnicas empleadas y la cantidad de las mismas
        final CheckBox tecnica1 = (CheckBox)findViewById(R.id.cbAbonera);
        tecnica1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tecnica1.isChecked()){
                    manteSuelo += " "+"abonera";
                    conta = conta + 1;
                }
            }
        });
        final CheckBox tecnica2 = (CheckBox)findViewById(R.id.cbBarrerasV);
        tecnica2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tecnica2.isChecked()){
                    manteSuelo += " "+"barrera_viva";
                    conta = conta + 1;
                }
            }
        });
        final CheckBox tecnica3 = (CheckBox)findViewById(R.id.cbBarrerasM);
        tecnica3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tecnica3.isChecked()){
                    manteSuelo += " "+"barrera_muerta";
                    conta = conta + 1;
                }
            }
        });
        final CheckBox tecnica4 = (CheckBox)findViewById(R.id.cbCurvaNivel);
        tecnica4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tecnica4.isChecked()){
                    manteSuelo += " "+"curva_a_nivel";
                    conta = conta + 1;
                }
            }
        });
        final CheckBox tecnica5 = (CheckBox)findViewById(R.id.cbAcequias);
        tecnica5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tecnica5.isChecked()){
                    manteSuelo += " "+"acequias";
                    conta = conta + 1;
                }
            }
        });
        final CheckBox tecnica6 = (CheckBox)findViewById(R.id.cbTablonesD);
        tecnica6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tecnica6.isChecked()){
                    manteSuelo += " "+"tablones_dobles";
                    conta = conta + 1;
                }
            }
        });
        final CheckBox tecnica7 = (CheckBox)findViewById(R.id.cbRastrojo);
        tecnica7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tecnica7.isChecked()){
                    manteSuelo += " "+"Rastrojo";
                    conta = conta + 1;
                }
            }
        });
        final CheckBox tecnica8 = (CheckBox)findViewById(R.id.cbAbonoOrga);
        tecnica8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tecnica8.isChecked()){
                    manteSuelo += " "+"abono_organico";
                    conta = conta + 1;
                }
            }
        });

        //Almacena la selección del Radio button de Producción Organica
        RadioButton rb_noPO = (RadioButton)findViewById(R.id.rb_siPO);
        RadioButton rb_siPO = (RadioButton)findViewById(R.id.rb_noPO);
        OnClickListener list_prodOrga = new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_noPO:
                        prodOrga = "no";
                        break;
                    case R.id.rb_siPO:
                        prodOrga = "si";
                        break;
                }
            }
        };
        rb_noPO.setOnClickListener(list_prodOrga);
        rb_siPO.setOnClickListener(list_prodOrga);

        //Almacena la selección del Radio button de Practicas sin Agua
        RadioButton rb_noPA = (RadioButton)findViewById(R.id.rb_siPA);
        RadioButton rb_siPA = (RadioButton)findViewById(R.id.rb_noPA);
        OnClickListener list_practAgua = new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_noPA:
                        practAgua = "no";
                        break;
                    case R.id.rb_siPA:
                        practAgua = "si";
                        break;
                }
            }
        };
        rb_noPA.setOnClickListener(list_practAgua);
        rb_siPA.setOnClickListener(list_practAgua);

        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        dbconeccion = new SQLControladorHuertos(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarId:
                String idFam = getIntent().getStringExtra("idFam");
                String medHuerto = medHuer.getText().toString();
                String fechaImple = fechaImpl.getYear()+"-"+(fechaImpl.getMonth()+1)+"-"+fechaImpl.getDayOfMonth();
                String bPract = buenasPrac;
                String iSemanal = ingSem.getText().toString();
                String manttoSuelo = manteSuelo;
                String produOrganica = prodOrga;
                String practicaAgua = practAgua;
                String fechaRegHuerto = fechaRegH.getYear()+"-"+(fechaRegH.getMonth()+1)+"-"+fechaRegH.getDayOfMonth();

                dbconeccion.insertarDatos(idFam, medHuerto, fechaImple, bPract, iSemanal, manttoSuelo, produOrganica, practicaAgua, fechaRegHuerto);
                Intent main = new Intent(AgregarHuertosDiversificacion.this, MyActivityHuertos.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("idFam",idFam);
                startActivity(main);
                break;

            default:
                break;
        }
    }
}
