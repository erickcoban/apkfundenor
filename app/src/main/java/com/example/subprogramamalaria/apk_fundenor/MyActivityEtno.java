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

public class MyActivityEtno extends ActionBarActivity {

    Button btnAgregarEtno;
    ListView lista;
    SQLControladorEtno dbconeccion;
    TextView tv_miemID, tv_miemNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_etno);

        //Asigna el id de la familia a la que pertenece
        final String idFam = getIntent().getStringExtra("idFam");

        dbconeccion = new SQLControladorEtno(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarEtno = (Button) findViewById(R.id.btnAgregarEtno);
        lista = (ListView) findViewById(R.id.listViewEtno);

        //acción del boton agregar miembro
        btnAgregarEtno.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MyActivityEtno.this, AgregarEtno.class);
                iagregar.putExtra("idFam",idFam);
                Toast.makeText(getApplicationContext(), "envia " + idFam, Toast.LENGTH_SHORT).show();
                startActivity(iagregar);
            }
        });

        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();

        String[] from = new String[] {
                DBhelperEtno.ETNO_ID,
                DBhelperEtno.ETNO_NOMBRE,
                DBhelperEtno.ETNO_FAMILIA
        };
        int[] to = new int[] {
                R.id.miembro_id,
                R.id.miembro_nombre,
                R.id.miembro_3
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MyActivityEtno.this, R.layout.formato_fila, cursor, from, to);

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

                Intent modify_intent = new Intent(getApplicationContext(), formulariosEtno.class);
                modify_intent.putExtra("idEtno", aux_miembroId);
                modify_intent.putExtra("idFam", aux_miembroNombre);

                Toast.makeText(getApplicationContext(), "envia " + aux_miembroId, Toast.LENGTH_SHORT).show();
                startActivity(modify_intent);
            }
        });
    }  //termina el onCreate
} //termina clase