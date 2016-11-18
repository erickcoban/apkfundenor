package com.example.subprogramamalaria.apk_fundenor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Subprograma Malaria on 02/11/2016.
 */

public class form_general_mobiliario extends Activity implements View.OnClickListener{
    DatePicker fechaMobiliario;
    LinearLayout LLHabitacionMob, LLCocinaMob, LLpregCama, LLpregCoci, LLpregTrebe;
    Button btnAgregar;
    SQLControladorAmbientemMobiliario dbconeccion;
    String tRope, tCama, tipoCama, tPla, tMes, tSil, tEstu, tipoEstu, ubTre;
    EditText noRope, noCama, noPla, noMes, noSil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_general_mobiliario);

        LLHabitacionMob = (LinearLayout)findViewById(R.id.MobHab);
        LLCocinaMob = (LinearLayout)findViewById(R.id.MobCoci);

        LLpregCama = (LinearLayout)findViewById(R.id.preg_cama);
        LLpregCoci = (LinearLayout)findViewById(R.id.preg_coci);

        LLpregTrebe = (LinearLayout)findViewById(R.id.preg_trebe);

        switch (getIntent().getStringExtra("ambiente")){
            case "habitacion" : LLHabitacionMob.setVisibility(View.VISIBLE);
                break;
            case "cocina" : LLCocinaMob.setVisibility(View.VISIBLE);
                break;
        }

        //atributos de Habitación
        //Almacena si tiene Ropero y le solicita cuantos
        noRope = (EditText)findViewById(R.id.noRopMob);
        RadioButton rb_noRop = (RadioButton)findViewById(R.id.rb_noRop);
        RadioButton rb_siRop = (RadioButton)findViewById(R.id.rb_siRop);
        View.OnClickListener list_tienRop = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_noRop:
                        tRope = "no";
                        noRope.setVisibility(View.GONE);
                        break;
                    case R.id.rb_siRop:
                        tRope = "si";
                        noRope.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };
        rb_noRop.setOnClickListener(list_tienRop);
        rb_siRop.setOnClickListener(list_tienRop);

        //Almacena si tiene Cama, le solicita cuantos y de que tipo
        noCama = (EditText)findViewById(R.id.noCam);
        RadioButton rb_noCam = (RadioButton)findViewById(R.id.rb_noCam);
        RadioButton rb_siCam = (RadioButton)findViewById(R.id.rb_siCam);
        View.OnClickListener list_tienCam = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_noCam:
                        tCama = "no";
                        LLpregCama.setVisibility(View.GONE);
                        break;
                    case R.id.rb_siCam:
                        tCama = "si";
                        LLpregCama.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };
        rb_noCam.setOnClickListener(list_tienCam);
        rb_siCam.setOnClickListener(list_tienCam);

        noCama = (EditText)findViewById(R.id.noCam);

        RadioButton rb_tapesco = (RadioButton)findViewById(R.id.rb_tapesco);
        RadioButton rb_tabla = (RadioButton)findViewById(R.id.rb_tabla);
        RadioButton rb_catre = (RadioButton)findViewById(R.id.rb_catre);
        RadioButton rb_petate = (RadioButton)findViewById(R.id.rb_petate);
        RadioButton rb_madera = (RadioButton)findViewById(R.id.rb_cama_madera);
        RadioButton rb_sumier = (RadioButton)findViewById(R.id.rb_sumier);
        View.OnClickListener list_tipoCam = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_tapesco:
                        tipoCama = "tapesco";
                        break;
                    case R.id.rb_tabla:
                        tipoCama = "tabla";
                        break;
                    case R.id.rb_catre:
                        tipoCama = "catre";
                        break;
                    case R.id.rb_petate:
                        tipoCama = "petate";
                        break;
                    case R.id.rb_cama_madera:
                        tipoCama = "cama_madera";
                        break;
                    case R.id.rb_sumier:
                        tipoCama = "sumier";
                        break;
                }
            }
        };
        rb_tapesco.setOnClickListener(list_tipoCam);
        rb_tabla.setOnClickListener(list_tipoCam);
        rb_catre.setOnClickListener(list_tipoCam);
        rb_petate.setOnClickListener(list_tipoCam);
        rb_madera.setOnClickListener(list_tipoCam);
        rb_sumier.setOnClickListener(list_tipoCam);

        //atributos de Cocina
        //Almacena si tiene Platera y le solicita cuantas
        noPla = (EditText)findViewById(R.id.noPlaMob);
        RadioButton rb_noPla = (RadioButton)findViewById(R.id.rb_noPla);
        RadioButton rb_siPla = (RadioButton)findViewById(R.id.rb_siPla);
        View.OnClickListener list_tienPla = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_noPla:
                        tPla = "no";
                        noPla.setVisibility(View.GONE);
                        break;
                    case R.id.rb_siPla:
                        tPla = "si";
                        noPla.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };
        rb_noPla.setOnClickListener(list_tienPla);
        rb_siPla.setOnClickListener(list_tienPla);

        //Almacena si tiene Mesas y le solicita cuantas
        noMes = (EditText)findViewById(R.id.noMesa);
        RadioButton rb_noMes = (RadioButton)findViewById(R.id.rb_noMes);
        RadioButton rb_siMes = (RadioButton)findViewById(R.id.rb_siMes);
        View.OnClickListener list_tienMes = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_noMes:
                        tPla = "no";
                        noMes.setVisibility(View.GONE);
                        break;
                    case R.id.rb_siMes:
                        tPla = "si";
                        noMes.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };
        rb_noMes.setOnClickListener(list_tienMes);
        rb_siMes.setOnClickListener(list_tienMes);

        //Almacena si tiene Sillas y le solicita cuantas
        noSil = (EditText)findViewById(R.id.noSil);
        RadioButton rb_noSil = (RadioButton)findViewById(R.id.rb_noSil);
        RadioButton rb_siSil = (RadioButton)findViewById(R.id.rb_siSil);
        View.OnClickListener list_tienSil = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_noSil:
                        tPla = "no";
                        noSil.setVisibility(View.GONE);
                        break;
                    case R.id.rb_siSil:
                        tPla = "si";
                        noSil.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };
        rb_noSil.setOnClickListener(list_tienSil);
        rb_siSil.setOnClickListener(list_tienSil);

        //Almacena si tiene Estufa, le solicita cuantas y de que tipo
        RadioButton rb_noEst = (RadioButton)findViewById(R.id.rb_noEst);
        RadioButton rb_siEst = (RadioButton)findViewById(R.id.rb_siEst);
        View.OnClickListener list_tienEst = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_noEst:
                        tEstu = "no";
                        LLpregCoci.setVisibility(View.GONE);
                        break;
                    case R.id.rb_siEst:
                        tEstu = "si";
                        LLpregCoci.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };
        rb_noEst.setOnClickListener(list_tienEst);
        rb_siEst.setOnClickListener(list_tienEst);

        //especifica el tipo de Estufa que tiene
        RadioButton rb_plancha = (RadioButton)findViewById(R.id.rb_plancha);
        RadioButton rb_lorena = (RadioButton)findViewById(R.id.rb_lorena);
        RadioButton rb_fundenor = (RadioButton)findViewById(R.id.rb_fundenor);
        RadioButton rb_onil = (RadioButton)findViewById(R.id.rb_onil);
        RadioButton rb_trebe = (RadioButton)findViewById(R.id.rb_trebe);
        RadioButton rb_tresP = (RadioButton)findViewById(R.id.rb_tres_piedras);
        RadioButton rb_polleton = (RadioButton)findViewById(R.id.rb_polleton);
        RadioButton rb_chimenea = (RadioButton)findViewById(R.id.rb_chimenea);
        View.OnClickListener list_tipoEstu = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_plancha:
                        tipoEstu = "plancha";
                        LLpregTrebe.setVisibility(View.GONE);
                        break;
                    case R.id.rb_lorena:
                        tipoEstu = "lorena";
                        LLpregTrebe.setVisibility(View.GONE);
                        break;
                    case R.id.rb_fundenor:
                        tipoEstu = "fundenor";
                        LLpregTrebe.setVisibility(View.GONE);
                        break;
                    case R.id.rb_onil:
                        tipoEstu = "onil";
                        LLpregTrebe.setVisibility(View.GONE);
                        break;
                    case R.id.rb_trebe:
                        tipoEstu = "trebe";
                        LLpregTrebe.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_tres_piedras:
                        tipoEstu = "tres_piedras";
                        LLpregTrebe.setVisibility(View.GONE);
                        break;
                    case R.id.rb_polleton:
                        tipoEstu = "polleton";
                        LLpregTrebe.setVisibility(View.GONE);
                        break;
                    case R.id.rb_chimenea:
                        tipoEstu = "chimenea";
                        LLpregTrebe.setVisibility(View.GONE);
                        break;
                }
            }
        };
        rb_plancha.setOnClickListener(list_tipoEstu);
        rb_lorena.setOnClickListener(list_tipoEstu);
        rb_fundenor.setOnClickListener(list_tipoEstu);
        rb_onil.setOnClickListener(list_tipoEstu);
        rb_trebe.setOnClickListener(list_tipoEstu);
        rb_tresP.setOnClickListener(list_tipoEstu);
        rb_polleton.setOnClickListener(list_tipoEstu);
        rb_chimenea.setOnClickListener(list_tipoEstu);

        //Almacena si el trebe esta en suelo o no
        RadioButton rb_noTre = (RadioButton)findViewById(R.id.rb_noTre);
        RadioButton rb_siTre = (RadioButton)findViewById(R.id.rb_siTre);
        View.OnClickListener list_ubiTre = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_noTre:
                        ubTre = "no";
                        break;
                    case R.id.rb_siTre:
                        ubTre = "si";
                        break;
                }
            }
        };
        rb_noTre.setOnClickListener(list_ubiTre);
        rb_siTre.setOnClickListener(list_ubiTre);

        fechaMobiliario = (DatePicker)findViewById(R.id.fechaMobiliario);

        btnAgregar = (Button) findViewById(R.id.btnAgregarMobiliario);

        dbconeccion = new SQLControladorAmbientemMobiliario(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarMobiliario:
                //atributos de Habitacion
                String idAmbiente = getIntent().getStringExtra("idAmbiente");
                String ambiente = getIntent().getStringExtra("ambiente");
                String tieneRoperos = tRope;
                String noRoperos = noRope.getText().toString();
                String tieneCamas = tCama;
                String noCamas = noCama.getText().toString();
                String tipoCamas = tipoCama;
                //artributos de Cocina
                String tienePlatera = tPla;
                String noPlatera = noPla.getText().toString();
                String tieneMesa = tMes;
                String noMesa = noMes.getText().toString();
                String tieneSilla = tSil;
                String noSilla = noSil.getText().toString();
                String tieneEstufa = tEstu;
                String tipoEstufa = tipoEstu;
                String ubiTrebe = ubTre;
                String fecha = fechaMobiliario.getYear()+"-"+(fechaMobiliario.getMonth()+1)+"-"+fechaMobiliario.getDayOfMonth();

                dbconeccion.insertarDatos(idAmbiente, ambiente, tieneRoperos, noRoperos, tieneCamas, noCamas, tipoCamas, tienePlatera, noPlatera,
                                            tieneMesa, noMesa, tieneSilla, noSilla, tieneEstufa, tipoEstufa, ubiTrebe,fecha);

                Intent main = new Intent(form_general_mobiliario.this, formulariosAmbientes.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("idAmbiente",idAmbiente);
                main.putExtra("ambiente",ambiente);
                Toast.makeText(getApplicationContext(), "Elementos Guardados Correctamente ", Toast.LENGTH_SHORT).show();
                startActivity(main);
                break;

            default:
                break;
        }
    }

}