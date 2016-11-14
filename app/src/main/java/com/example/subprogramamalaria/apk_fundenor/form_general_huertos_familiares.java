package com.example.subprogramamalaria.apk_fundenor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by Subprograma Malaria on 02/11/2016.
 */

public class form_general_huertos_familiares extends ActionBarActivity{

    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_general_huertos_familiares);

        //Boton para almacenar la información
        btnAgregar = (Button) findViewById(R.id.btnAgregarAmbiente);
    }

    //Boton para finalizar sesion
    public void onclicBtnReturn (View view){
        //Source for close app
        finish();
        Intent i = new Intent(getApplicationContext(), MyActivityHuertos.class);
        startActivity(i);
    }
}