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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

//Vista de Agregar Viviendas
public class AgregarAmbiente extends Activity implements OnClickListener {
    //Declaración de variables para almacenar en la base de datos
    DatePicker fechaRegAmb;
    Button btnAgregar;
    SQLControladorAmbiente dbconeccion;
    String tipoAmb, tipoDiv, paredAmb, techoAmb, pisoAmb, manttoAmb, limpiezaAmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_ambiente);

        //Almacena la selección del Radio button del tipo de Ambiente
        RadioButton rb_habitacion = (RadioButton)findViewById(R.id.rb_habitacion);
        RadioButton rb_cocina = (RadioButton)findViewById(R.id.rb_cocina);
        RadioButton rb_ducha = (RadioButton)findViewById(R.id.rb_ducha);
        RadioButton rb_letrina = (RadioButton)findViewById(R.id.rb_letrina);
        RadioButton rb_lavadero = (RadioButton)findViewById(R.id.rb_lavadero);
        View.OnClickListener list_tipoAmb = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_habitacion:
                        tipoAmb = "habitacion";
                        break;
                    case R.id.rb_cocina:
                        tipoAmb = "cocina";
                        break;
                    case R.id.rb_ducha:
                        tipoAmb = "ducha";
                        break;
                    case R.id.rb_letrina:
                        tipoAmb = "letrina";
                        break;
                    case R.id.rb_lavadero:
                        tipoAmb = "lavadero";
                        break;
                }
            }
        };
        rb_habitacion.setOnClickListener(list_tipoAmb);
        rb_cocina.setOnClickListener(list_tipoAmb);
        rb_ducha.setOnClickListener(list_tipoAmb);
        rb_letrina.setOnClickListener(list_tipoAmb);
        rb_lavadero.setOnClickListener(list_tipoAmb);

        //Almacena la selección del Radio button del tipo de Division
        RadioButton rb_maderaD = (RadioButton)findViewById(R.id.rb_maderaD);
        RadioButton rb_blockD = (RadioButton)findViewById(R.id.rb_blockD);
        RadioButton rb_paloD = (RadioButton)findViewById(R.id.rb_paloD);
        RadioButton rb_bambuD = (RadioButton)findViewById(R.id.rb_bambuD);
        RadioButton rb_tanilD = (RadioButton)findViewById(R.id.rb_tanilD);
        RadioButton rb_costalD = (RadioButton)findViewById(R.id.rb_costalD);
        RadioButton rb_nylonD = (RadioButton)findViewById(R.id.rb_nylonD);
        RadioButton rb_mixtoD = (RadioButton)findViewById(R.id.rb_mixtoD);
        RadioButton rb_sin_paredD = (RadioButton)findViewById(R.id.rb_sin_paredD);
        View.OnClickListener list_divisionAmb = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_maderaD:
                        tipoDiv = "pared";
                        break;
                    case R.id.rb_blockD:
                        tipoDiv = "block";
                        break;
                    case R.id.rb_paloD:
                        tipoDiv = "palo";
                        break;
                    case R.id.rb_bambuD:
                        tipoDiv = "bambu";
                        break;
                    case R.id.rb_tanilD:
                        tipoDiv = "tañil";
                        break;
                    case R.id.rb_costalD:
                        tipoDiv = "costal";
                        break;
                    case R.id.rb_nylonD:
                        tipoDiv = "nylon";
                        break;
                    case R.id.rb_mixtoD:
                        tipoDiv = "mixto";
                        break;
                    case R.id.rb_sin_paredD:
                        tipoDiv = "sin pared";
                        break;
                }
            }
        };
        rb_maderaD.setOnClickListener(list_divisionAmb);
        rb_blockD.setOnClickListener(list_divisionAmb);
        rb_paloD.setOnClickListener(list_divisionAmb);
        rb_bambuD.setOnClickListener(list_divisionAmb);
        rb_tanilD.setOnClickListener(list_divisionAmb);
        rb_costalD.setOnClickListener(list_divisionAmb);
        rb_nylonD.setOnClickListener(list_divisionAmb);
        rb_mixtoD.setOnClickListener(list_divisionAmb);
        rb_sin_paredD.setOnClickListener(list_divisionAmb);

        //Almacena la selección del Radio button del tipo de pared
        RadioButton rb_maderaA = (RadioButton)findViewById(R.id.rb_maderaA);
        RadioButton rb_blockA = (RadioButton)findViewById(R.id.rb_blockA);
        RadioButton rb_paloA = (RadioButton)findViewById(R.id.rb_paloA);
        RadioButton rb_bambuA = (RadioButton)findViewById(R.id.rb_bambuA);
        RadioButton rb_tanilA = (RadioButton)findViewById(R.id.rb_tanilA);
        RadioButton rb_costalA = (RadioButton)findViewById(R.id.rb_costalA);
        RadioButton rb_nylonA = (RadioButton)findViewById(R.id.rb_nylonA);
        RadioButton rb_mixtoA = (RadioButton)findViewById(R.id.rb_mixtoA);
        RadioButton rb_sin_paredA = (RadioButton)findViewById(R.id.rb_sin_paredA);
        View.OnClickListener list_paredAmb = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_maderaA:
                        paredAmb = "pared";
                        break;
                    case R.id.rb_blockA:
                        paredAmb = "block";
                        break;
                    case R.id.rb_paloA:
                        paredAmb = "palo";
                        break;
                    case R.id.rb_bambuA:
                        paredAmb = "bambu";
                        break;
                    case R.id.rb_tanilA:
                        paredAmb = "tañil";
                        break;
                    case R.id.rb_costalA:
                        paredAmb = "costal";
                        break;
                    case R.id.rb_nylonA:
                        paredAmb = "nylon";
                        break;
                    case R.id.rb_mixtoA:
                        paredAmb = "mixto";
                        break;
                    case R.id.rb_sin_paredA:
                        paredAmb = "sin pared";
                        break;
                }
            }
        };
        rb_maderaA.setOnClickListener(list_paredAmb);
        rb_blockA.setOnClickListener(list_paredAmb);
        rb_paloA.setOnClickListener(list_paredAmb);
        rb_bambuA.setOnClickListener(list_paredAmb);
        rb_tanilA.setOnClickListener(list_paredAmb);
        rb_costalA.setOnClickListener(list_paredAmb);
        rb_nylonA.setOnClickListener(list_paredAmb);
        rb_mixtoA.setOnClickListener(list_paredAmb);
        rb_sin_paredA.setOnClickListener(list_paredAmb);

        //Almacena la selección del Radio button del tipo de techo del Ambiente
        RadioButton rb_laminaA = (RadioButton)findViewById(R.id.rb_laminaA);
        RadioButton rb_pajaA = (RadioButton)findViewById(R.id.rb_pajaA);
        RadioButton rb_nylon_2A = (RadioButton)findViewById(R.id.rb_nylon_2A);
        RadioButton rb_costal_2A = (RadioButton)findViewById(R.id.rb_costal_2A);
        RadioButton rb_mallaA = (RadioButton)findViewById(R.id.rb_mallaA);
        RadioButton rb_sin_techoA = (RadioButton)findViewById(R.id.rb_sin_techoA);
        View.OnClickListener list_techoAmb = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_laminaA:
                        techoAmb = "lamina";
                        break;
                    case R.id.rb_pajaA:
                        techoAmb = "paja";
                        break;
                    case R.id.rb_nylon_2A:
                        techoAmb = "nylon";
                        break;
                    case R.id.rb_costal_2A:
                        techoAmb = "costal";
                        break;
                    case R.id.rb_mallaA:
                        techoAmb = "malla";
                        break;
                    case R.id.rb_sin_techoA:
                        techoAmb = "sin techo";
                        break;
                }
            }
        };
        rb_laminaA.setOnClickListener(list_techoAmb);
        rb_pajaA.setOnClickListener(list_techoAmb);
        rb_nylon_2A.setOnClickListener(list_techoAmb);
        rb_costal_2A.setOnClickListener(list_techoAmb);
        rb_mallaA.setOnClickListener(list_techoAmb);
        rb_sin_techoA.setOnClickListener(list_techoAmb);

        //Almacena la selección del Radio button del tipo de piso
        RadioButton rb_tierraA = (RadioButton)findViewById(R.id.rb_tierraA);
        RadioButton rb_cementoA = (RadioButton)findViewById(R.id.rb_cementoA);
        RadioButton rb_piedrasA = (RadioButton)findViewById(R.id.rb_piedrasA);
        RadioButton rb_arenaA = (RadioButton)findViewById(R.id.rb_arenaA);
        View.OnClickListener list_pisoAmb = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_tierraA:
                        pisoAmb = "tierra";
                        break;
                    case R.id.rb_cementoA:
                        pisoAmb = "cemento";
                        break;
                    case R.id.rb_piedrasA:
                        pisoAmb = "piedras";
                        break;
                    case R.id.rb_arenaA:
                        pisoAmb = "arena";
                        break;
                }
            }
        };
        rb_tierraA.setOnClickListener(list_pisoAmb);
        rb_cementoA.setOnClickListener(list_pisoAmb);
        rb_piedrasA.setOnClickListener(list_pisoAmb);
        rb_arenaA.setOnClickListener(list_pisoAmb);

        //Almacena la selección del Radio button el mantenimiento del ambiente
        RadioButton rb_bueno = (RadioButton)findViewById(R.id.rb_bueno);
        RadioButton rb_regular = (RadioButton)findViewById(R.id.rb_regular);
        RadioButton rb_malo = (RadioButton)findViewById(R.id.rb_malo);
        View.OnClickListener list_manttoAmb = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_bueno:
                        manttoAmb = "bueno";
                        break;
                    case R.id.rb_regular:
                        manttoAmb = "regular";
                        break;
                    case R.id.rb_malo:
                        manttoAmb = "malo";
                        break;
                }
            }
        };
        rb_bueno.setOnClickListener(list_manttoAmb);
        rb_regular.setOnClickListener(list_manttoAmb);
        rb_malo.setOnClickListener(list_manttoAmb);

        //Almacena la selección del Radio button el mantenimiento del ambiente
        RadioButton rb_bueno2 = (RadioButton)findViewById(R.id.rb_bueno2);
        RadioButton rb_regular2 = (RadioButton)findViewById(R.id.rb_regular2);
        RadioButton rb_malo2 = (RadioButton)findViewById(R.id.rb_malo2);
        View.OnClickListener list_limpiezaAmb = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_bueno2:
                        limpiezaAmb = "bueno";
                        break;
                    case R.id.rb_regular2:
                        limpiezaAmb = "regular";
                        break;
                    case R.id.rb_malo2:
                        limpiezaAmb = "malo";
                        break;
                }
            }
        };
        rb_bueno2.setOnClickListener(list_limpiezaAmb);
        rb_regular2.setOnClickListener(list_limpiezaAmb);
        rb_malo2.setOnClickListener(list_limpiezaAmb);

        //Almaacena la fecha en la que se crea la vivienda
        fechaRegAmb = (DatePicker)findViewById(R.id.fechaRegAmb);

        //Boton para almacenar la información
        btnAgregar = (Button) findViewById(R.id.btnAgregarAmbiente);

        dbconeccion = new SQLControladorAmbiente(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarAmbiente:
                //Datos almacenados en SQLite
                String idVivienda = getIntent().getStringExtra("idVivienda");
                String tipoAmbiente = tipoAmb;
                String tipoDivision = tipoDiv;
                String paredAmbiente = paredAmb;
                String techoAmbiente = techoAmb;
                String pisoAmbiente = pisoAmb;
                String manttoAmbiente = manttoAmb;
                String limpiezaAmbiente = limpiezaAmb;
                String fechaAmbiente = fechaRegAmb.getYear()+"-"+(fechaRegAmb.getMonth()+1)+"-"+fechaRegAmb.getDayOfMonth();

                //Metodo de insercción a la base de datos
                dbconeccion.insertarDatos(idVivienda, tipoAmbiente, tipoDivision, paredAmbiente, pisoAmbiente, techoAmbiente, manttoAmbiente, limpiezaAmbiente, fechaAmbiente);
                //Acción en la que se almacenan los valores y reenvia al formulario de ambiente, mobiliario y accesorios
                Intent main = new Intent(AgregarAmbiente.this, MyActivity_Ambiente.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("idVivienda", idVivienda);
                startActivity(main);
                break;

            default:
                break;
        }
    }
}
