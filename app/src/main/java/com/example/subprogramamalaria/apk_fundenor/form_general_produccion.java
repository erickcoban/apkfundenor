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

public class form_general_produccion extends Activity implements View.OnClickListener {
    EditText cantGalli, prodGalli, vendeGalli, consuGalli,
             cantGallo, prodGallo, vendeGallo, consuGallo,
             cantPolli, prodPolli, vendePolli, consuPolli,
             cantPato, prodPato, vendePato, consuPato,
             cantPata, prodPata, vendePata, consuPata,
             cantChunta, prodChunta, vendeChunta, consuChunta,
             cantChunto, prodChunto, vendeChunto, consuChunto,
             cantChuntio, prodChuntio, vendeChuntio, consuChuntio;
    DatePicker fechaProdu;
    LinearLayout LLGallinas, LLGallos, LLPollitos, LLPatos, LLPatas, LLChuntas, LLChuntos, LLChuntios;
    Button btnAgregar;
    SQLControladorEntoProduccion dbconeccion;
    String prodAves="", aveEnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_general_produccion);

        LLGallinas = (LinearLayout)findViewById(R.id.LGallinas);
        LLGallos = (LinearLayout)findViewById(R.id.LGallos);
        LLPollitos = (LinearLayout)findViewById(R.id.LPollitos);
        LLPatos = (LinearLayout)findViewById(R.id.LPatos);
        LLPatas = (LinearLayout)findViewById(R.id.LPatas);
        LLChuntas = (LinearLayout)findViewById(R.id.LChuntas);
        LLChuntos = (LinearLayout)findViewById(R.id.LChuntos);
        LLChuntios = (LinearLayout)findViewById(R.id.LChuntios);

        //Almacena la cadena de las aves que tiene
        final CheckBox ave1 = (CheckBox)findViewById(R.id.cbGallina);
        ave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ave1.isChecked()){
                    prodAves += " "+"gallina";
                    LLGallinas.setVisibility(View.VISIBLE);
                }else{LLGallinas.setVisibility(View.GONE);}
            }
        });
        final CheckBox ave2 = (CheckBox)findViewById(R.id.cbGallo);
        ave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ave2.isChecked()){
                    prodAves += " "+"gallo";
                    LLGallos.setVisibility(View.VISIBLE);
                }else{LLGallos.setVisibility(View.GONE);}
            }
        });
        final CheckBox ave3 = (CheckBox)findViewById(R.id.cbPollitos);
        ave3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ave3.isChecked()){
                    prodAves += " "+"pollitos";
                    LLPollitos.setVisibility(View.VISIBLE);
                }else{LLPollitos.setVisibility(View.GONE);}
            }
        });
        final CheckBox ave4 = (CheckBox)findViewById(R.id.cbPatos);
        ave4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ave4.isChecked()){
                    prodAves += " "+"patos";
                    LLPatos.setVisibility(View.VISIBLE);
                }else{LLPatos.setVisibility(View.GONE);}
            }
        });
        final CheckBox ave5 = (CheckBox)findViewById(R.id.cbPatas);
        ave5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ave5.isChecked()){
                    prodAves += " "+"patas";
                    LLPatas.setVisibility(View.VISIBLE);
                }else{LLPatas.setVisibility(View.GONE);}
            }
        });
        final CheckBox ave6 = (CheckBox)findViewById(R.id.cbChuntas);
        ave6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ave6.isChecked()){
                    prodAves += " "+"chuntas";
                    LLChuntas.setVisibility(View.VISIBLE);
                }else{LLChuntas.setVisibility(View.GONE);}
            }
        });
        final CheckBox ave7 = (CheckBox)findViewById(R.id.cbChuntos);
        ave7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ave7.isChecked()){
                    prodAves += " "+"chuntos";
                    LLChuntos.setVisibility(View.VISIBLE);
                }else{LLChuntos.setVisibility(View.GONE);}
            }
        });
        final CheckBox ave8 = (CheckBox)findViewById(R.id.cbChuntios);
        ave8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ave8.isChecked()){
                    prodAves += " "+"chuntios";
                    LLChuntios.setVisibility(View.VISIBLE);
                }else{LLChuntios.setVisibility(View.GONE);}
            }
        });

        //Inicializamos los EditText
        cantGalli = (EditText)findViewById(R.id.noGallinas);
        prodGalli = (EditText)findViewById(R.id.noReprodGallina);
        vendeGalli = (EditText)findViewById(R.id.noVendeGallina);
        consuGalli = (EditText)findViewById(R.id.noConsumeGallina);

        cantGallo = (EditText)findViewById(R.id.noGallos);
        prodGallo = (EditText)findViewById(R.id.noReprodGallos);
        vendeGallo = (EditText)findViewById(R.id.noVendeGallos);
        consuGallo = (EditText)findViewById(R.id.noConsumeGallos);

        cantPolli = (EditText)findViewById(R.id.noPollitos);
        prodPolli = (EditText)findViewById(R.id.noReprodPollitos);
        vendePolli = (EditText)findViewById(R.id.noVendePollitos);
        consuPolli = (EditText)findViewById(R.id.noConsumePollitos);

        cantPato = (EditText)findViewById(R.id.noPatos);
        prodPato = (EditText)findViewById(R.id.noReprodPatos);
        vendePato = (EditText)findViewById(R.id.noVendePatos);
        consuPato = (EditText)findViewById(R.id.noConsumePatos);

        cantPata = (EditText)findViewById(R.id.noPatas);
        prodPata = (EditText)findViewById(R.id.noReprodPatas);
        vendePata = (EditText)findViewById(R.id.noVendePatas);
        consuPata = (EditText)findViewById(R.id.noConsumePatas);

        cantChunta = (EditText)findViewById(R.id.noChuntas);
        prodChunta = (EditText)findViewById(R.id.noReprodChuntas);
        vendeChunta = (EditText)findViewById(R.id.noVendeChuntas);
        consuChunta = (EditText)findViewById(R.id.noConsumeChuntas);

        cantChunto = (EditText)findViewById(R.id.noChuntos);
        prodChunto = (EditText)findViewById(R.id.noReprodChuntos);
        vendeChunto = (EditText)findViewById(R.id.noVendeChuntos);
        consuChunto = (EditText)findViewById(R.id.noConsumeChuntos);

        cantChuntio = (EditText)findViewById(R.id.noChuntios);
        prodChuntio = (EditText)findViewById(R.id.noReprodChuntios);
        vendeChuntio = (EditText)findViewById(R.id.noVendeChuntios);
        consuChuntio = (EditText)findViewById(R.id.noConsumeChuntios);

        //Muestra el apellido de casada si es mujer
        RadioButton rb_siAve = (RadioButton)findViewById(R.id.rb_siProd);
        RadioButton rb_noAve = (RadioButton)findViewById(R.id.rb_noProd);
        View.OnClickListener list_aveEncerrada = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_siProd:
                        aveEnce = "femenino";
                        break;
                    case R.id.rb_masculino:
                        aveEnce = "masculino";
                        break;
                }
            }
        };
        rb_siAve.setOnClickListener(list_aveEncerrada);
        rb_noAve.setOnClickListener(list_aveEncerrada);

        fechaProdu = (DatePicker)findViewById(R.id.fechaProduccion);

        btnAgregar = (Button) findViewById(R.id.btnAgregarProd);

        dbconeccion = new SQLControladorEntoProduccion(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarProd:
                String idEtno = getIntent().getStringExtra("idEtno");
                String nombre = prodAves;
                String gallinaCA = cantGalli.getText().toString();
                String gallinaP = prodGalli.getText().toString();
                String gallinaV = vendeGalli.getText().toString();
                String gallinaCO = consuGalli.getText().toString();
                String galloCA = cantGallo.getText().toString();
                String galloP = prodGallo.getText().toString();
                String galloV = vendeGallo.getText().toString();
                String galloCO = consuGallo.getText().toString();
                String pollitoCA = cantPolli.getText().toString();
                String pollitoP = prodPolli.getText().toString();
                String pollitoV = vendePolli.getText().toString();
                String pollitoCO = consuPolli.getText().toString();
                String patoCA = cantPato.getText().toString();
                String patoP = prodPato.getText().toString();
                String patoV = vendePato.getText().toString();
                String patoCO = consuPato.getText().toString();
                String pataCA = cantPata.getText().toString();
                String pataP = prodPata.getText().toString();
                String pataV = prodPata.getText().toString();
                String pataCO = consuPata.getText().toString();
                String chuntoCA = cantChunto.getText().toString();
                String chuntoP = prodChunto.getText().toString();
                String chuntoV = vendeChunto.getText().toString();
                String chuntoCO = consuChunto.getText().toString();
                String chuntaCA = cantChunta.getText().toString();
                String chuntaP = prodChunta.getText().toString();
                String chuntaV = vendeChunta.getText().toString();
                String chuntaCO = consuChunta.getText().toString();
                String chuntioCA = cantChuntio.getText().toString();
                String chuntioP = prodChuntio.getText().toString();
                String chuntioV = vendeChuntio.getText().toString();
                String chuntioCO = consuChuntio.getText().toString();
                String aveEncer = aveEnce;
                String fecha = fechaProdu.getYear()+"-"+(fechaProdu.getMonth()+1)+"-"+fechaProdu.getDayOfMonth();

                dbconeccion.insertarDatos(idEtno, nombre, gallinaCA, gallinaP, gallinaV, gallinaCO, galloCA, galloP, galloV, galloCO,
                                                          pollitoCA, pollitoP, pollitoV, pollitoCO, patoCA, patoP, patoV, patoCO,
                                                          pataCA, pataP, pataV, pataCO, chuntaCA, chuntaP, chuntaV, chuntaCO,
                                                          chuntoCA, chuntoP, chuntoV, chuntoCO, chuntioCA, chuntioP, chuntioV, chuntioCO, aveEncer, fecha);
                Intent main = new Intent(form_general_produccion.this, formulariosEtno.class)
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
