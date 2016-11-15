package com.example.subprogramamalaria.apk_fundenor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Subprograma Malaria on 20/10/2016.
 */
public class formularios extends ActionBarActivity {

    //Declaramos las Variables
    ListViewAdapter adapter;
    String[] menu = {"PARTICIPANTE", "HUERTOS FAMILIARES", "ETNOVETERINARIA", "TRANSFORMACION DE ALIMENTOS"};
    int[] img = {R.drawable.icono1, R.drawable.icono1, R.drawable.icono1 , R.drawable.icono1};

    Button btn_cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formularios);

        //Asigna el numero de la familia a la que pertenece
        final String idFam = getIntent().getStringExtra("miembroId");

        //CREA LOS MENUS
        final ListView lista = (ListView) findViewById(R.id.list_formularios);
        adapter = new ListViewAdapter(this, menu, img);
        lista.setAdapter(adapter);

        //ENVIA A DONDE CORRESPONDA
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int posicion, long l) {
                //Toast.makeText(getApplicationContext(), "presiono " + i, Toast.LENGTH_SHORT).show();

                switch (posicion){
                    case 0 :
                        Intent i = new Intent(getApplicationContext(), MyActivityParticipante.class);
                        //Envia el id del menu
                        i.putExtra("idFam",idFam);
                        Toast.makeText(getApplicationContext(), "envia " + idFam, Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(getApplicationContext(), MyActivityHuertos.class);
                        //Envia el Usuario que ingresa
                        i.putExtra("idFam",idFam);
                        Toast.makeText(getApplicationContext(), "envia " + idFam, Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(getApplicationContext(), MyActivityEtno.class);
                        //Envia el Usuario que ingresa
                        i.putExtra("idFam",idFam);
                        Toast.makeText(getApplicationContext(), "envia " + idFam, Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(getApplicationContext(), form_general_transformacion.class);
                        //Envia el Usuario que ingresa
                        i.putExtra("idFam",idFam);
                        Toast.makeText(getApplicationContext(), "envia " + idFam, Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        break;
                }
            }
        });

        //Inicalizamos el Botón Cerrar
        btn_cerrar = (Button) findViewById(R.id.btnCerrar);
    }

    //Boton para finalizar sesion
    public void onclicBtnClose (View view){
        //Source for close app
        finish();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
