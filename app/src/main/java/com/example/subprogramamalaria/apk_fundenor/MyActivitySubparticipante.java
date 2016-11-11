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

public class MyActivitySubparticipante extends ActionBarActivity {

    Button btnAgregarMiembro;
    ListView lista;
    SQLControladorSubparticipante dbconeccion;
    TextView tv_miemID, tv_miemNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_subparticipante);

        //Asigna el id del participante a la que pertenece
        final String idPart = getIntent().getStringExtra("idPart");

        dbconeccion = new SQLControladorSubparticipante(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarMiembro = (Button) findViewById(R.id.btnAgregarSubparticipante);
        lista = (ListView) findViewById(R.id.listViewSubparticipante);

        //acción del boton agregar miembro
        btnAgregarMiembro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MyActivitySubparticipante.this, AgregarSubparticipante.class);
                iagregar.putExtra("idPart",idPart);
                Toast.makeText(getApplicationContext(), "envia " + idPart, Toast.LENGTH_SHORT).show();
                startActivity(iagregar);
            }
        });

        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();

        String[] from = new String[] {
                DBhelperSubparticipante.SUBPARTICIPANTE_ID,
                DBhelperSubparticipante.SUBPARTICIPANTE_IDPART,
                DBhelperSubparticipante.SUBPARTICIPANTE_NOMBRE1,
                DBhelperSubparticipante.SUBPARTICIPANTE_NOMBRE2,
                DBhelperSubparticipante.SUBPARTICIPANTE_NOMBRE3,
                DBhelperSubparticipante.SUBPARTICIPANTE_APELLIDO1,
                DBhelperSubparticipante.SUBPARTICIPANTE_APELLIDO2,
                DBhelperSubparticipante.SUBPARTICIPANTE_APELLIDOC,
                DBhelperSubparticipante.SUBPARTICIPANTE_GENERO,
                DBhelperSubparticipante.SUBPARTICIPANTE_CONSANGUINIDAD,
                DBhelperSubparticipante.SUBPARTICIPANTE_FECHANAC,
                DBhelperSubparticipante.SUBPARTICIPANTE_TALLA,
                DBhelperSubparticipante.SUBPARTICIPANTE_PESO,
                DBhelperSubparticipante.SUBPARTICIPANTE_DESNUTICION,
                DBhelperSubparticipante.SUBPARTICIPANTE_CUI,
                DBhelperSubparticipante.SUBPARTICIPANTE_GRADOACA,
                DBhelperSubparticipante.SUBPARTICIPANTE_ESTADOCIV,
                DBhelperSubparticipante.SUBPARTICIPANTE_TELEFONO,
                DBhelperSubparticipante.SUBPARTICIPANTE_CARGOCOM,
                DBhelperSubparticipante.SUBPARTICIPANTE_IDIOMA,
                DBhelperSubparticipante.SUBPARTICIPANTE_OFICIO,
                DBhelperSubparticipante.SUBPARTICIPANTE_RELIGION,
                DBhelperSubparticipante.SUBPARTICIPANTE_GRUPO,
                DBhelperSubparticipante.SUBPARTICIPANTE_INGRESOE,
                DBhelperSubparticipante.SUBPARTICIPANTE_FECHAREG
        };
        int[] to = new int[] {
                R.id.miembro_id,
                R.id.miembro_nombre
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MyActivitySubparticipante.this, R.layout.formato_fila, cursor, from, to);

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

                Intent modify_intent = new Intent(getApplicationContext(), ModificarSubparticipante.class);
                modify_intent.putExtra("miembroId", aux_miembroId);
                modify_intent.putExtra("miembroNombre", aux_miembroNombre);
                startActivity(modify_intent);
            }
        });
    }  //termina el onCreate
} //termina clase