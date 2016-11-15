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

public class form_general_instalaciones extends Activity implements View.OnClickListener {
    EditText medidaG, medidaC;
    DatePicker fechaInsta;
    Button btnAgregar;
    SQLControladorEtnoInstalaciones dbconeccion;
    String gallinero, corral, comedero, bebedero, nidales, tieneModulo, estadoModulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_general_instalaciones);

        //Almacena si tiene Gallinero y habilita sus dimensiones
        RadioButton rb_siG = (RadioButton)findViewById(R.id.rb_siG);
        RadioButton rb_noG = (RadioButton)findViewById(R.id.rb_noG);
        medidaG = (EditText)findViewById(R.id.medidaG);
        View.OnClickListener list_tieneG = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_siG:
                        gallinero = "si";
                        medidaG.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_noG:
                        gallinero = "no";
                        medidaG.setVisibility(View.GONE);
                        break;
                }
            }
        };
        rb_siG.setOnClickListener(list_tieneG);
        rb_noG.setOnClickListener(list_tieneG);

        //Almacena si tiene Corral y habilita sus dimensiones
        RadioButton rb_siC = (RadioButton)findViewById(R.id.rb_siC);
        RadioButton rb_noC = (RadioButton)findViewById(R.id.rb_noC);
        medidaC = (EditText)findViewById(R.id.medidaC);
        View.OnClickListener list_tieneC = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_siC:
                        corral = "si";
                        medidaC.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_noC:
                        corral = "no";
                        medidaC.setVisibility(View.GONE);
                        break;
                }
            }
        };
        rb_siC.setOnClickListener(list_tieneC);
        rb_noC.setOnClickListener(list_tieneC);

        //Almacena si tiene Comedero
        RadioButton rb_siCo = (RadioButton)findViewById(R.id.rb_siCo);
        RadioButton rb_noCo = (RadioButton)findViewById(R.id.rb_noCo);
        View.OnClickListener list_tieneCo = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_siCo:
                        comedero = "si";
                        break;
                    case R.id.rb_noCo:
                        comedero = "no";
                        break;
                }
            }
        };
        rb_siCo.setOnClickListener(list_tieneCo);
        rb_noCo.setOnClickListener(list_tieneCo);

        //Almacena si tiene Bebedero
        RadioButton rb_siBe = (RadioButton)findViewById(R.id.rb_siBe);
        RadioButton rb_noBe = (RadioButton)findViewById(R.id.rb_noBe);
        View.OnClickListener list_tieneBe = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_siBe:
                        bebedero = "si";
                        break;
                    case R.id.rb_noBe:
                        bebedero = "no";
                        break;
                }
            }
        };
        rb_siBe.setOnClickListener(list_tieneBe);
        rb_noBe.setOnClickListener(list_tieneBe);

        //Almacena si tiene Nidales
        RadioButton rb_siN = (RadioButton)findViewById(R.id.rb_siN);
        RadioButton rb_noN = (RadioButton)findViewById(R.id.rb_noN);
        View.OnClickListener list_tieneN = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_siN:
                        nidales = "si";
                        break;
                    case R.id.rb_noN:
                        nidales = "no";
                        break;
                }
            }
        };
        rb_siN.setOnClickListener(list_tieneN);
        rb_noN.setOnClickListener(list_tieneN);

        //Almacena si cuenta con Modulo Pecuario
        RadioButton rb_siMP = (RadioButton)findViewById(R.id.rb_siMP);
        RadioButton rb_noMP = (RadioButton)findViewById(R.id.rb_noMP);
        View.OnClickListener list_tieneMP = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_siMP:
                        tieneModulo = "si";
                        break;
                    case R.id.rb_noMP:
                        tieneModulo = "no";
                        break;
                }
            }
        };
        rb_siMP.setOnClickListener(list_tieneMP);
        rb_noMP.setOnClickListener(list_tieneMP);

        //Almacena si tiene el Modulo limpio
        RadioButton rb_buenoML = (RadioButton)findViewById(R.id.rb_buenoML);
        RadioButton rb_regularML = (RadioButton)findViewById(R.id.rb_regularML);
        RadioButton rb_maloML = (RadioButton)findViewById(R.id.rb_maloML);
        View.OnClickListener list_tieneML = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_buenoML:
                        estadoModulo = "bueno";
                        break;
                    case R.id.rb_regularML:
                        estadoModulo = "regular";
                        break;
                    case R.id.rb_maloML:
                        estadoModulo = "malo";
                        break;
                }
            }
        };
        rb_buenoML.setOnClickListener(list_tieneML);
        rb_regularML.setOnClickListener(list_tieneML);
        rb_maloML.setOnClickListener(list_tieneML);

        fechaInsta = (DatePicker)findViewById(R.id.fechaInstalan);

        btnAgregar = (Button) findViewById(R.id.btnAgregarInstalacion);

        dbconeccion = new SQLControladorEtnoInstalaciones(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarInstalacion:
                String idEtno = getIntent().getStringExtra("idEtno");
                String tieneGallinero = gallinero;
                String medidaGallinero = medidaG.getText().toString();
                String tieneCorral = corral;
                String medidaCorral = medidaC.getText().toString();
                String tieneComedero = comedero;
                String tieneBebedero = bebedero;
                String tieneNidales = nidales;
                String tieneModuloP = tieneModulo;
                String estadoModuloP = estadoModulo;
                String fecha = fechaInsta.getYear()+"-"+(fechaInsta.getMonth()+1)+"-"+fechaInsta.getDayOfMonth();

                dbconeccion.insertarDatos(idEtno, tieneGallinero, medidaGallinero, tieneCorral, medidaCorral, tieneComedero, tieneBebedero,
                        tieneNidales, tieneModuloP,estadoModuloP, fecha);
                Intent main = new Intent(form_general_instalaciones.this, formulariosEtno.class)
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
