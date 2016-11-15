package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AgregarEtno extends Activity implements OnClickListener {
    EditText name;
    Button btnAgregar;
    SQLControladorEtno dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_etno);
        name = (EditText) findViewById(R.id.etno);
        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        dbconeccion = new SQLControladorEtno(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarId:
                String idFamilia = getIntent().getStringExtra("idFam");
                String nombre = name.getText().toString();
                dbconeccion.insertarDatos(idFamilia, nombre);
                Intent main = new Intent(AgregarEtno.this, MyActivityEtno.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("idFam",idFamilia);
                startActivity(main);
                break;

            default:
                break;
        }
    }
}
