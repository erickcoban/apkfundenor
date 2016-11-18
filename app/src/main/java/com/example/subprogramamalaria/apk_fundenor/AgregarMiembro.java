package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//Vista de Agregar Viviendas
public class AgregarMiembro extends ActionBarActivity implements OnClickListener {
    //Declaración de variables para almacenar en la base de datos
    DatePicker fechaVivienda;
    EditText numeroVivienda;
    Button btnAgregar;
    SQLControlador dbconeccion;
    String paredV, techoV, tieneD, accesoAgua, almacenAgua, tecnicaP, pisoV;

    // Progress Dialog
    private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();

    //testing on Emulator:
    private static final String CREAR_CASO_URL = "http://fundenorcoban.esy.es/funsys/ingresotbvivienda.php";

    //ids
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_miembro);

    //Asignación atributos en las variables declaradas

        //Almacena el numero de la vivienda
        numeroVivienda = (EditText) findViewById(R.id.et_numeroVivienda);

        //Almacena la selección del Radio button del tipo de pared
        RadioButton rb_madera = (RadioButton)findViewById(R.id.rb_madera);
        RadioButton rb_block = (RadioButton)findViewById(R.id.rb_block);
        RadioButton rb_palo = (RadioButton)findViewById(R.id.rb_palo);
        RadioButton rb_bambu = (RadioButton)findViewById(R.id.rb_bambu);
        RadioButton rb_tanil = (RadioButton)findViewById(R.id.rb_tanil);
        RadioButton rb_costal = (RadioButton)findViewById(R.id.rb_costal);
        RadioButton rb_nylon = (RadioButton)findViewById(R.id.rb_nylon);
        RadioButton rb_mixto = (RadioButton)findViewById(R.id.rb_mixto);
        RadioButton rb_sin_pared = (RadioButton)findViewById(R.id.rb_sin_pared);
        View.OnClickListener list_paredVivienda = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_madera:
                        paredV = "pared";
                        break;
                    case R.id.rb_block:
                        paredV = "block";
                        break;
                    case R.id.rb_palo:
                        paredV = "palo";
                        break;
                    case R.id.rb_bambu:
                        paredV = "bambu";
                        break;
                    case R.id.rb_tanil:
                        paredV = "tañil";
                        break;
                    case R.id.rb_costal:
                        paredV = "costal";
                        break;
                    case R.id.rb_nylon:
                        paredV = "nylon";
                        break;
                    case R.id.rb_mixto:
                        paredV = "mixto";
                        break;
                    case R.id.rb_sin_pared:
                        paredV = "sin pared";
                        break;
                }
            }
        };
        rb_madera.setOnClickListener(list_paredVivienda);
        rb_block.setOnClickListener(list_paredVivienda);
        rb_palo.setOnClickListener(list_paredVivienda);
        rb_bambu.setOnClickListener(list_paredVivienda);
        rb_tanil.setOnClickListener(list_paredVivienda);
        rb_costal.setOnClickListener(list_paredVivienda);
        rb_nylon.setOnClickListener(list_paredVivienda);
        rb_mixto.setOnClickListener(list_paredVivienda);
        rb_sin_pared.setOnClickListener(list_paredVivienda);

        //Almacena la selección del Radio button del tipo de techo
        RadioButton rb_lamina = (RadioButton)findViewById(R.id.rb_lamina);
        RadioButton rb_paja = (RadioButton)findViewById(R.id.rb_paja);
        RadioButton rb_nylon_2 = (RadioButton)findViewById(R.id.rb_nylon_2);
        RadioButton rb_costal_2 = (RadioButton)findViewById(R.id.rb_costal_2);
        RadioButton rb_malla = (RadioButton)findViewById(R.id.rb_malla);
        RadioButton rb_sin_techo = (RadioButton)findViewById(R.id.rb_sin_techo);
        View.OnClickListener list_techoVivienda = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_lamina:
                        techoV = "lamina";
                        break;
                    case R.id.rb_paja:
                        techoV = "paja";
                        break;
                    case R.id.rb_nylon_2:
                        techoV = "nylon";
                        break;
                    case R.id.rb_costal_2:
                        techoV = "costal";
                        break;
                    case R.id.rb_malla:
                        techoV = "malla";
                        break;
                    case R.id.rb_sin_techo:
                        techoV = "sin techo";
                        break;
                }
            }
        };
        rb_lamina.setOnClickListener(list_techoVivienda);
        rb_paja.setOnClickListener(list_techoVivienda);
        rb_nylon_2.setOnClickListener(list_techoVivienda);
        rb_costal_2.setOnClickListener(list_techoVivienda);
        rb_malla.setOnClickListener(list_techoVivienda);
        rb_sin_techo.setOnClickListener(list_techoVivienda);

        //Almacena la selección del Radio button del tipo de piso
        RadioButton rb_tierra = (RadioButton)findViewById(R.id.rb_tierra);
        RadioButton rb_cemento = (RadioButton)findViewById(R.id.rb_cemento);
        RadioButton rb_piedras = (RadioButton)findViewById(R.id.rb_piedras);
        RadioButton rb_arena = (RadioButton)findViewById(R.id.rb_arena);
        View.OnClickListener list_pisoVivienda = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_tierra:
                        pisoV = "tierra";
                        break;
                    case R.id.rb_cemento:
                        pisoV = "cemento";
                        break;
                    case R.id.rb_piedras:
                        pisoV = "piedras";
                        break;
                    case R.id.rb_arena:
                        pisoV = "arena";
                        break;
                }
            }
        };
        rb_tierra.setOnClickListener(list_pisoVivienda);
        rb_cemento.setOnClickListener(list_pisoVivienda);
        rb_piedras.setOnClickListener(list_pisoVivienda);
        rb_arena.setOnClickListener(list_pisoVivienda);

        //Almacena la selección del Radio button cuenta con divisiones
        RadioButton rb_no = (RadioButton)findViewById(R.id.rb_si);
        RadioButton rb_si = (RadioButton)findViewById(R.id.rb_no);
        View.OnClickListener list_divisionesVivienda = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_no:
                        tieneD = "no";
                        break;
                    case R.id.rb_si:
                        tieneD = "si";
                        break;
                }
            }
        };
        rb_no.setOnClickListener(list_divisionesVivienda);
        rb_si.setOnClickListener(list_divisionesVivienda);

        //Almacena la selección del Radio button tipo de acceso de agua
        RadioButton rb_entubda = (RadioButton)findViewById(R.id.rb_entubada);
        RadioButton rb_potable = (RadioButton)findViewById(R.id.rb_potable);
        RadioButton rb_pozo = (RadioButton)findViewById(R.id.rb_pozo);
        RadioButton rb_quebrada = (RadioButton)findViewById(R.id.rb_quebrada);
        RadioButton rb_naciemiento = (RadioButton)findViewById(R.id.rb_nacimiento);
        RadioButton rb_rio = (RadioButton)findViewById(R.id.rb_rio);
        View.OnClickListener list_accesoAgua = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_entubada:
                        accesoAgua = "entubada";
                        break;
                    case R.id.rb_potable:
                        accesoAgua = "potable";
                        break;
                    case R.id.rb_pozo:
                        accesoAgua = "pozo";
                        break;
                    case R.id.rb_quebrada:
                        accesoAgua = "quebrada";
                        break;
                    case R.id.rb_nacimiento:
                        accesoAgua = "nacimiento";
                        break;
                    case R.id.rb_rio:
                        accesoAgua = "rio";
                        break;
                }
            }
        };
        rb_entubda.setOnClickListener(list_accesoAgua);
        rb_potable.setOnClickListener(list_accesoAgua);
        rb_pozo.setOnClickListener(list_accesoAgua);
        rb_quebrada.setOnClickListener(list_accesoAgua);
        rb_naciemiento.setOnClickListener(list_accesoAgua);
        rb_rio.setOnClickListener(list_accesoAgua);

        //Almacena la selección del Radio button forma de almacenamiento de agua
        final EditText otroTipoAlmacen = (EditText)findViewById(R.id.otroTipoAlmacen);
        RadioButton rb_tinaco = (RadioButton)findViewById(R.id.rb_tinaco);
        RadioButton rb_toneles = (RadioButton)findViewById(R.id.rb_toneles);
        RadioButton rb_cubeta = (RadioButton)findViewById(R.id.rb_cubeta);
        RadioButton rb_botella = (RadioButton)findViewById(R.id.rb_botella);
        RadioButton rb_tanque = (RadioButton)findViewById(R.id.rb_tanque);
        RadioButton rb_otro = (RadioButton)findViewById(R.id.rb_otro);
        View.OnClickListener list_tipoAlmacen = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_tinaco:
                        almacenAgua = "tinaco";
                        otroTipoAlmacen.setVisibility(View.GONE);
                        break;
                    case R.id.rb_toneles:
                        almacenAgua = "toneles";
                        otroTipoAlmacen.setVisibility(View.GONE);
                        break;
                    case R.id.rb_cubeta:
                        almacenAgua = "cubeta";
                        otroTipoAlmacen.setVisibility(View.GONE);
                        break;
                    case R.id.rb_botella:
                        almacenAgua = "botella";
                        otroTipoAlmacen.setVisibility(View.GONE);
                        break;
                    case R.id.rb_tanque:
                        almacenAgua = "tanque";
                        otroTipoAlmacen.setVisibility(View.GONE);
                        break;
                    case R.id.rb_otro:
                        almacenAgua = otroTipoAlmacen.getText().toString();
                        otroTipoAlmacen.setVisibility(View.VISIBLE);
                        break;
                }
            }
        };
        rb_tinaco.setOnClickListener(list_tipoAlmacen);
        rb_toneles.setOnClickListener(list_tipoAlmacen);
        rb_cubeta.setOnClickListener(list_tipoAlmacen);
        rb_botella.setOnClickListener(list_tipoAlmacen);
        rb_tanque.setOnClickListener(list_tipoAlmacen);
        rb_otro.setOnClickListener(list_tipoAlmacen);

        //Almacena la selección del Radio button técnica de purificación
        RadioButton rb_clorada = (RadioButton)findViewById(R.id.rb_clorada);
        RadioButton rb_hervida = (RadioButton)findViewById(R.id.rb_hervida);
        RadioButton rb_ecofiltro = (RadioButton)findViewById(R.id.rb_ecofiltro);
        RadioButton rb_ninguna = (RadioButton)findViewById(R.id.rb_ninguna);
        View.OnClickListener list_tipoPurificacion = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_clorada:
                        tecnicaP = "clorada";
                        break;
                    case R.id.rb_hervida:
                        tecnicaP = "hervida";
                        break;
                    case R.id.rb_ecofiltro:
                        tecnicaP = "ecofiltro";
                        break;
                    case R.id.rb_ninguna:
                        tecnicaP = "botella";
                        break;
                }
            }
        };
        rb_clorada.setOnClickListener(list_tipoPurificacion);
        rb_hervida.setOnClickListener(list_tipoPurificacion);
        rb_ecofiltro.setOnClickListener(list_tipoPurificacion);
        rb_ninguna.setOnClickListener(list_tipoPurificacion);

        //Almaacena la fecha en la que se crea la vivienda
        fechaVivienda = (DatePicker)findViewById(R.id.fechaVivienda);

        //Boton para almacenar la información
        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        new CreateUser().execute();

    }

    class CreateUser extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(AgregarMiembro.this);
            pDialog.setMessage("Creando Vivienda...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
           //switch (v.getId()) {
                //case R.id.btnAgregarId:
                    //Datos almacenados en SQLite
                    int success;
                    String numVivienda = numeroVivienda.getText().toString();
                    String idLocal = "1610";
                    String username = getIntent().getStringExtra("usuario");
                    String paredVivienda = paredV;
                    String techoVivienda = techoV;
                    String pisoVivienda = pisoV;
                    String tieneDivision = tieneD;
                    String tipoAgua = accesoAgua;
                    String tipoAlmacen = almacenAgua;
                    String tipoPur = tecnicaP;
                    String estadoAct = "ACTIVO";
                    String fecha = fechaVivienda.getYear()+"-"+(fechaVivienda.getMonth()+1)+"-"+fechaVivienda.getDayOfMonth();

                    //Metodo de insercción a SQLite
                    dbconeccion.insertarDatos(numVivienda, idLocal, username, paredVivienda, techoVivienda,
                                              pisoVivienda, tieneDivision, tipoAgua, tipoAlmacen, tipoPur, estadoAct, fecha);

                    /*break;
                default:
                    break;
            }*/

            try {
                //Clase para guardar datos en MySQL
                List params = new ArrayList();
                //params.add(new BasicNameValuePair("numVivienda", numVivienda));
                params.add(new BasicNameValuePair("idLocalidad", idLocal));
                params.add(new BasicNameValuePair("tecnico",username));
                params.add(new BasicNameValuePair("tipoPared",paredVivienda));
                params.add(new BasicNameValuePair("tipoTecho",techoVivienda));
                params.add(new BasicNameValuePair("tipoPiso",pisoVivienda));
                params.add(new BasicNameValuePair("divisiones",tieneDivision));
                params.add(new BasicNameValuePair("accesoAgua", tipoAgua));
                params.add(new BasicNameValuePair("almacenAgua",tipoAlmacen));
                params.add(new BasicNameValuePair("purificacionAgua",tipoPur));
                params.add(new BasicNameValuePair("estadoAsignacion",estadoAct));
                params.add(new BasicNameValuePair("fecha",fecha));

                Log.d("request!", "starting");

                //Posting user data to script
                JSONObject json = jsonParser.makeHttpRequest(
                        CREAR_CASO_URL, "POST", params);

                // full json response
                Log.d("Creando Vivienda", json.toString());

                // json success element
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("Vivienda Creado!", json.toString());
                    finish();
                    return json.getString(TAG_MESSAGE);
                }else{
                    Log.d("Creacion Erronea!", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;

        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null){
                Toast.makeText(AgregarMiembro.this, file_url, Toast.LENGTH_LONG).show();

                //Acción en la que se almacenan los valores y reenvia al formulario de ambiente, mobiliario y accesorios
                Intent main = new Intent(AgregarMiembro.this, MyActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("usuario", getIntent().getStringExtra("usuario"));
                startActivity(main);
            }
        }
    }
}
