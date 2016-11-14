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

public class MyActivityHuertos extends ActionBarActivity {

    Button btnAgregarHuerto;
    ListView lista;
    SQLControladorHuertos dbconeccion;
    TextView tv_miemID, tv_miemNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_huertos);

        //Asigna el id del participante a la que pertenece
        final String idFam = getIntent().getStringExtra("idFam");

        dbconeccion = new SQLControladorHuertos(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarHuerto = (Button) findViewById(R.id.btnAgregarHuerto);
        lista = (ListView) findViewById(R.id.listViewHuerto);

        //acción del boton agregar miembro
        btnAgregarHuerto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MyActivityHuertos.this, AgregarHuertos.class);
                iagregar.putExtra("idFam",idFam);
                Toast.makeText(getApplicationContext(), "envia " + idFam, Toast.LENGTH_SHORT).show();
                startActivity(iagregar);
            }
        });

        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();
        String[] from = new String[] {
                DBhelperHuertos.HUERTO_ID,
                DBhelperHuertos.HUERTO_IDFAM,
                DBhelperHuertos.HUERTO_NOMBRE,
                DBhelperHuertos.HUERTO_FECHA,
                DBhelperHuertos.HUERTO_BUENAP,
                DBhelperHuertos.HUERTO_INGRESOS,
                DBhelperHuertos.HUERTO_MANTTOT,
                DBhelperHuertos.HUERTO_PRODUCCIONORG,
                DBhelperHuertos.HUERTO_PRACTICAAGUA,
                DBhelperHuertos.HUERTO_FECHAHUERTO
        };
        int[] to = new int[] {
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
                MyActivityHuertos.this, R.layout.formato_fila, cursor, from, to);

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

                Intent modify_intent = new Intent(getApplicationContext(), form_general_huertos_familiares.class);
                modify_intent.putExtra("idHuerto", aux_miembroId);
                modify_intent.putExtra("miembroNombre", aux_miembroNombre);

                Toast.makeText(getApplicationContext(), "envia " + aux_miembroId, Toast.LENGTH_SHORT).show();
                startActivity(modify_intent);
            }
        });
    }  //termina el onCreate
} //termina clase