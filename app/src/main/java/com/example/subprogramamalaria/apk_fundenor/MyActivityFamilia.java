package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.Intent;
import android.database.Cursor;
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

public class MyActivityFamilia extends ActionBarActivity {

    Button btnAgregarMiembro;
    ListView lista;
    SQLControladorFamilia dbconeccion;
    TextView tv_miemID, tv_miemNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_familia);

        //Asigna el numero de la vivienda a la que pertenece
        final String idV = getIntent().getStringExtra("miembroId");
        final String idVivienda = idV;

        dbconeccion = new SQLControladorFamilia(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarMiembro = (Button) findViewById(R.id.btnAgregarFamilia);
        lista = (ListView) findViewById(R.id.listViewFamilia);

        //acción del boton agregar miembro
        btnAgregarMiembro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MyActivityFamilia.this, AgregarFamilia.class);
                //envia el id de la vivienda
                iagregar.putExtra("miembroId", idV);
                Toast.makeText(getApplicationContext(), "presiono " + idV, Toast.LENGTH_SHORT).show();
                startActivity(iagregar);
            }
        });

        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();

        String[] from = new String[] {
                DBhelperFamilia.FAMILIA_ID,
                DBhelperFamilia.FAMILIA_NOMBRE,
                DBhelperFamilia.FAMILIA_VIVIENDA
        };
        int[] to = new int[] {
                R.id.miembro_id,
                R.id.miembro_nombre,
                R.id.miembro_3
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MyActivityFamilia.this, R.layout.formato_fila, cursor, from, to);

        adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);

        // acción cuando hacemos click en item para poder modificarlo o eliminarlo
        lista.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                tv_miemID = (TextView) view.findViewById(R.id.miembro_id);
                tv_miemNombre = (TextView) view.findViewById(R.id.miembro_nombre);

                String aux_miembroId = tv_miemID.getText().toString();
                String aux_miembroNombre = tv_miemNombre.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), formularios.class);
                modify_intent.putExtra("miembroId", aux_miembroId);
                modify_intent.putExtra("miembroNombre", aux_miembroNombre);
                startActivity(modify_intent);
            }
        });
    }  //termina el onCreate
} //termina clase