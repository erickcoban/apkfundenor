package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MyActivity_Ambiente extends ActionBarActivity {

    Button btnAgregarAmbiente;
    ListView lista;
    SQLControladorAmbiente dbconeccion;
    TextView tv_miemID, tv_miemNombre;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ambiente);

        final String idViv = getIntent().getStringExtra("idVivienda");

        dbconeccion = new SQLControladorAmbiente(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarAmbiente = (Button) findViewById(R.id.btnAgregarAmbiente);
        lista = (ListView) findViewById(R.id.listViewAmbiente);

        //acción del boton agregar Ambiente
        btnAgregarAmbiente.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MyActivity_Ambiente.this, AgregarAmbiente.class);
                //envia el usuario que se logea
                iagregar.putExtra("idVivienda", idViv);
                Toast.makeText(getApplicationContext(), "envia " + idViv, Toast.LENGTH_SHORT).show();
                startActivity(iagregar);
            }
        });

        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();

        String[] from = new String[]{
                DBhelperAmbiente.AMBIENTE_ID,
                DBhelperAmbiente.AMBIENTE_AMBIENTE,
                DBhelperAmbiente.AMBIENTE_NOMBRE,
                DBhelperAmbiente.AMBIENTE_DIVISION,
                DBhelperAmbiente.AMBIENTE_PARED,
                DBhelperAmbiente.AMBIENTE_TECHO,
                DBhelperAmbiente.AMBIENTE_PISO,
                DBhelperAmbiente.AMBIENTE_MANTTO,
                DBhelperAmbiente.AMBIENTE_LIMPIEZA,
                DBhelperAmbiente.AMBIENTE_FECHA
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
                R.id.miembro_10

        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this, R.layout.formato_fila, cursor, from, to);

        adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);

        // acción cuando hacemos click en item para poder modificarlo o eliminarlo
        lista.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                tv_miemID = (TextView) view.findViewById(R.id.miembro_id);
                tv_miemNombre = (TextView) view.findViewById(R.id.miembro_nombre);

                String aux_miembroId = tv_miemID.getText().toString();
                String ambiente = tv_miemNombre.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), formulariosAmbientes.class);
                //Identificador de la vivienda
                modify_intent.putExtra("idAmbiente", aux_miembroId);
                modify_intent.putExtra("ambiente", ambiente);
                Toast.makeText(getApplicationContext(), "envia " + ambiente, Toast.LENGTH_SHORT).show();
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
} //termina clase