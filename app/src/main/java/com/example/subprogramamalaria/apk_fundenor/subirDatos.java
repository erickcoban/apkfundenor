package com.example.subprogramamalaria.apk_fundenor;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Subprograma Malaria on 18/11/2016.
 */

public class subirDatos extends ActionBarActivity implements View.OnClickListener {
    Button btnAgregarMiembro;
    ListView lista;
    SQLControlador dbconeccion;
    TextView tv_miemID, tv_miemNombre;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final String usuarioActual = getIntent().getStringExtra("usuario");

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarMiembro = (Button) findViewById(R.id.btnAgregarVivienda);
        lista = (ListView) findViewById(R.id.listViewVivienda);

        //acción del boton agregar viviendas
        btnAgregarMiembro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(subirDatos.this, AgregarMiembro.class);
                //envia el usuario que se logea
                iagregar.putExtra("usuario", usuarioActual);
                Toast.makeText(getApplicationContext(), "envia " + usuarioActual, Toast.LENGTH_SHORT).show();
                startActivity(iagregar);
            }
        });



        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();
        String[] from = new String[]{
                DBhelper.VIVIENDA_ID,
                DBhelper.VIVIENDA_NOMBRE,
                DBhelper.VIVIENDA_LOCALIDAD,
                DBhelper.VIVIENDA_USER,
                DBhelper.VIVIENDA_PARED,
                DBhelper.VIVIENDA_TECHO,
                DBhelper.VIVIENDA_PISO,
                DBhelper.VIVIENDA_DIVISION,
                DBhelper.VIVIENDA_TIPOAGUA,
                DBhelper.VIVIENDA_TIPOALMACENAGUA,
                DBhelper.VIVIENDA_PURIFICACION,
                DBhelper.VIVIENDA_ESTADO,
                DBhelper.VIVIENDA_FECHA
        };
        int[] to = new int[]{
                R.id.miembro_id,
                R.id.miembro_nombre,
                R.id.miembro_3,
                R.id.miembro_4,
                R.id.miembro_5,
                R.id.miembro_6,
                R.id.miembro_7,
                R.id.miembro_8,
                R.id.miembro_9,
                R.id.miembro_10,
                R.id.miembro_11,
                R.id.miembro_12,
                R.id.miembro_13

        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this, R.layout.formato_fila, cursor, from, to);

        adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);

        // acción cuando hacemos click en item para poder modificarlo o eliminarlo
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                tv_miemID = (TextView) view.findViewById(R.id.miembro_id);
                tv_miemNombre = (TextView) view.findViewById(R.id.miembro_nombre);

                String aux_miembroId = tv_miemID.getText().toString();
                String aux_miembroNombre = tv_miemNombre.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), MyActivityFamilia.class);
                //Identificador de la vivienda
                modify_intent.putExtra("idVivienda", aux_miembroId);
                modify_intent.putExtra("miembroNombre", aux_miembroNombre);
                startActivity(modify_intent);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }  //termina el onCreate

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("My Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    @Override
    public void onClick(View v) {
        /*switch (v.getId()) {
            case R.id.btnActualizar:
                //Variables se asignan las variables que se enviaran a la base de datos
                String memName_upd = et.getText().toString();


                dbconeccion.actualizarDatos(member_id, memName_upd);
                this.returnHome();
                break;
        }*/
    }
} //termina clase