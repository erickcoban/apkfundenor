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

public class MyActivityParticipante extends ActionBarActivity {

    Button btnAgregarMiembro;
    ListView lista;
    SQLControladorParticipante dbconeccion;
    TextView tv_miemID, tv_miemNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_participante);

        //Asigna el numero de la vivienda a la que pertenece
        final String idFam = getIntent().getStringExtra("idFam");

        dbconeccion = new SQLControladorParticipante(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarMiembro = (Button) findViewById(R.id.btnAgregarParticipante);
        lista = (ListView) findViewById(R.id.listViewParticipante);

        //acción del boton agregar miembro
        btnAgregarMiembro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MyActivityParticipante.this, AgregarParticipante.class);
                iagregar.putExtra("idFam", idFam);
                Toast.makeText(getApplicationContext(), "envia " + idFam, Toast.LENGTH_SHORT).show();
                startActivity(iagregar);
            }
        });

        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();

        String[] from = new String[] {
                DBhelperParticipante.PARTICIPANTE_ID,
                DBhelperParticipante.PARTICIPANTE_NOMBRE1,
                DBhelperParticipante.PARTICIPANTE_IDFAMILIA,
                DBhelperParticipante.PARTICIPANTE_NOMBRE2,
                DBhelperParticipante.PARTICIPANTE_NOMBRE3,
                DBhelperParticipante.PARTICIPANTE_APELLIDO1,
                DBhelperParticipante.PARTICIPANTE_APELLIDO2,
                DBhelperParticipante.PARTICIPANTE_APELLIDOC,
                DBhelperParticipante.PARTICIPANTE_GENERO,
                DBhelperParticipante.PARTICIPANTE_FECHANAC,
                DBhelperParticipante.PARTICIPANTE_CUI,
                DBhelperParticipante.PARTICIPANTE_GRADOACA,
                DBhelperParticipante.PARTICIPANTE_ESTADOCIV,
                DBhelperParticipante.PARTICIPANTE_TELEFONO,
                DBhelperParticipante.PARTICIPANTE_CARGOCOM,
                DBhelperParticipante.PARTICIPANTE_IDIOMA,
                DBhelperParticipante.PARTICIPANTE_OFICIO,
                DBhelperParticipante.PARTICIPANTE_RELIGION,
                DBhelperParticipante.PARTICIPANTE_GRUPO,
                DBhelperParticipante.PARTICIPANTE_TENECIAT,
                DBhelperParticipante.PARTICIPANTE_CERTEZA,
                DBhelperParticipante.PARTICIPANTE_MEDIDAT,
                DBhelperParticipante.PARTICIPANTE_INGRESOE,
                DBhelperParticipante.PARTICIPANTE_FECHAREG
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
                R.id.miembro_10,
                R.id.miembro_11,
                R.id.miembro_12,
                R.id.miembro_13,
                R.id.miembro_14,
                R.id.miembro_15,
                R.id.miembro_16,
                R.id.miembro_17,
                R.id.miembro_18,
                R.id.miembro_19,
                R.id.miembro_20,
                R.id.miembro_21,
                R.id.miembro_22,
                R.id.miembro_23,
                R.id.miembro_24

        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MyActivityParticipante.this, R.layout.formato_fila, cursor, from, to);

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

                Intent modify_intent = new Intent(getApplicationContext(), MyActivitySubparticipante.class);
                modify_intent.putExtra("idPart", aux_miembroId);
                Toast.makeText(getApplicationContext(), "envia " + aux_miembroId, Toast.LENGTH_SHORT).show();
                modify_intent.putExtra("miembroNombre", aux_miembroNombre);
                startActivity(modify_intent);
            }
        });
    }  //termina el onCreate
} //termina clase