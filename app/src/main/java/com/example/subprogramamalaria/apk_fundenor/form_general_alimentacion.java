package com.example.subprogramamalaria.apk_fundenor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class form_general_alimentacion extends Activity implements View.OnClickListener {
    DatePicker fechaAlim;
    LinearLayout tipConce;
    Button btnAgregar;
    SQLControladorEtnoAlimentacion dbconeccion;
    String otroAlimento="", usaConcen , tipoConc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_general_alimentacion);

        //Almacena y Habilita si utiliza Concentrado
        RadioButton rb_siConc = (RadioButton)findViewById(R.id.rb_siConc);
        RadioButton rb_noConc = (RadioButton)findViewById(R.id.rb_noConc);
        tipConce = (LinearLayout)findViewById(R.id.LTipoCon);
        View.OnClickListener list_usaConc = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_siConc:
                        usaConcen = "si";
                        tipConce.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_noConc:
                        usaConcen = "no";
                        tipConce.setVisibility(View.GONE);
                        break;
                }
            }
        };
        rb_siConc.setOnClickListener(list_usaConc);
        rb_noConc.setOnClickListener(list_usaConc);

        //Almacena que tipo concentrado usa
        RadioButton rb_casero = (RadioButton)findViewById(R.id.rb_casero);
        RadioButton rb_industial = (RadioButton)findViewById(R.id.rb_industrial);
        tipConce = (LinearLayout)findViewById(R.id.LTipoCon);
        View.OnClickListener list_tipoConc = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_casero:
                        tipoConc = "casero";
                        break;
                    case R.id.rb_industrial:
                        tipoConc = "industrial";
                        break;
                }
            }
        };
        rb_casero.setOnClickListener(list_tipoConc);
        rb_industial.setOnClickListener(list_tipoConc);

        //Almacena la cadena de otros Alimentos
        final CheckBox ali1 = (CheckBox)findViewById(R.id.cbMMol);
        ali1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali1.isChecked()){
                    otroAlimento += " "+"maiz_molido";}
            }
        });
        final CheckBox ali2 = (CheckBox)findViewById(R.id.cbME);
        ali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali2.isChecked()){
                    otroAlimento += " "+"maiz_entero";}
            }
        });
        final CheckBox ali3 = (CheckBox)findViewById(R.id.cbM);
        ali3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali3.isChecked()){
                    otroAlimento += " "+"masa";}
            }
        });
        final CheckBox ali4 = (CheckBox)findViewById(R.id.cbDes);
        ali4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali4.isChecked()){
                    otroAlimento += " "+"desperdicio";}
            }
        });
        final CheckBox ali5 = (CheckBox)findViewById(R.id.cbHier);
        ali5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali5.isChecked()){
                    otroAlimento += " "+"hierbas";}
            }
        });

        fechaAlim = (DatePicker)findViewById(R.id.fechaAlimen);

        btnAgregar = (Button) findViewById(R.id.btnAgregarAliment);

        dbconeccion = new SQLControladorEtnoAlimentacion(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarAliment:
                String idEtno = getIntent().getStringExtra("idEtno");
                String usaConcentrado = usaConcen;
                String tipoConcentrado = tipoConc;
                String otrosAlimentos = otroAlimento;
                String fecha = fechaAlim.getYear()+"-"+(fechaAlim.getMonth()+1)+"-"+fechaAlim.getDayOfMonth();

                dbconeccion.insertarDatos(idEtno, usaConcentrado, tipoConcentrado, otrosAlimentos, fecha);
                Intent main = new Intent(form_general_alimentacion.this, formulariosEtno.class)
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
