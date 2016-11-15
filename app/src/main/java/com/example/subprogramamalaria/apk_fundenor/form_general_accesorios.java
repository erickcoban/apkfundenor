package com.example.subprogramamalaria.apk_fundenor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Subprograma Malaria on 02/11/2016.
 */

public class form_general_accesorios extends Activity implements View.OnClickListener{
    DatePicker fechaAccesorio;
    LinearLayout LLHabitacion, LLCocina, LLLetrina, LLDucha, LLLavadero;
    Button btnAgregar;
    SQLControladorAmbienteAccesorios dbconeccion;
    String dataHabi="", dataCocina="" , dataLetrina="", dataDucha="", dataLavadero="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_general_accesorios);

        LLHabitacion = (LinearLayout)findViewById(R.id.LHabitacion);
        LLCocina = (LinearLayout)findViewById(R.id.LCocina);
        LLLetrina = (LinearLayout)findViewById(R.id.LLetrina);
        LLDucha = (LinearLayout)findViewById(R.id.LDucha);
        LLLavadero = (LinearLayout)findViewById(R.id.LLavadero);

        switch (getIntent().getStringExtra("ambiente")){
            case "habitacion" : LLHabitacion.setVisibility(View.VISIBLE);
                break;
            case "cocina" : LLCocina.setVisibility(View.VISIBLE);
                break;
            case "letrina" : LLLetrina.setVisibility(View.VISIBLE);
                break;
            case "ducha" : LLDucha.setVisibility(View.VISIBLE);
                break;
            case "lavadero" : LLLavadero.setVisibility(View.VISIBLE);
                break;
        }

        //Almacena la cadena de accesorios de la Habitacion
        final CheckBox dHabi1 = (CheckBox)findViewById(R.id.almohadas);
        dHabi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dHabi1.isChecked()){
                    dataHabi += " "+"almohada";
                }
            }
        });
        final CheckBox dHabi2 = (CheckBox)findViewById(R.id.chamarras);
        dHabi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dHabi2.isChecked()){
                    dataHabi += " "+"chamarras";}
            }
        });
        final CheckBox dHabi3 = (CheckBox)findViewById(R.id.espejo);
        dHabi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dHabi3.isChecked()){
                    dataHabi += " "+"espejo";}
            }
        });
        final CheckBox dHabi4 = (CheckBox)findViewById(R.id.palita);
        dHabi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dHabi4.isChecked()){
                    dataHabi += " "+"palita";}
            }
        });
        final CheckBox dHabi5 = (CheckBox)findViewById(R.id.escoba);
        dHabi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dHabi5.isChecked()){
                    dataHabi += " "+"escoba";}
            }
        });
        final CheckBox dHabi6 = (CheckBox)findViewById(R.id.sabanas);
        dHabi6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dHabi6.isChecked()){
                    dataHabi += " "+"sabanas";}
            }
        });
        final CheckBox dHabi7 = (CheckBox)findViewById(R.id.peine);
        dHabi7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dHabi7.isChecked()){
                    dataHabi += " "+"peine";}
            }
        });
        final CheckBox dHabi8 = (CheckBox)findViewById(R.id.ningunoHA);
        dHabi8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dHabi8.isChecked()){
                    dataHabi += " "+"ninguno";}
            }
        });

        //Almacena la cadena de accesorios de la cocina
        final CheckBox dCoci1 = (CheckBox)findViewById(R.id.salero);
        dCoci1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dCoci1.isChecked()){
                    dataCocina += " "+"salero";
                }
            }
        });
        final CheckBox dCoci2 = (CheckBox)findViewById(R.id.azucarera);
        dCoci2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dCoci2.isChecked()){
                    dataCocina += " "+"azucarera";}
            }
        });
        final CheckBox dCoci3 = (CheckBox)findViewById(R.id.cubiertos);
        dCoci3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dCoci3.isChecked()){
                    dataCocina += " "+"cubiertos";}
            }
        });
        final CheckBox dCoci4 = (CheckBox)findViewById(R.id.cuchillos);
        dCoci4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dCoci4.isChecked()){
                    dataCocina += " "+"cuchillos";}
            }
        });
        final CheckBox dCoci5 = (CheckBox)findViewById(R.id.ningunoCO);
        dCoci5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dCoci5.isChecked()){
                    dataCocina += " "+"ninguno";}
            }
        });

        //Almacena la cadena de accesorios de la Ducha
        final CheckBox dDuc1 = (CheckBox)findViewById(R.id.jabon);
        dDuc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dDuc1.isChecked()){
                    dataDucha += " "+"jabon";
                }
            }
        });
        final CheckBox dDuc2 = (CheckBox)findViewById(R.id.shampoo);
        dDuc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dDuc2.isChecked()){
                    dataDucha += " "+"shampoo";}
            }
        });
        final CheckBox dDuc3 = (CheckBox)findViewById(R.id.toallero);
        dDuc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dDuc3.isChecked()){
                    dataDucha += " "+"toallero";}
            }
        });
        final CheckBox dDuc4 = (CheckBox)findViewById(R.id.toalla_ducha);
        dDuc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dDuc4.isChecked()){
                    dataDucha += " "+"toalla";}
            }
        });
        final CheckBox dDuc5 = (CheckBox)findViewById(R.id.detergente_ducha);
        dDuc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dDuc5.isChecked()){
                    dataDucha += " "+"detergente";}
            }
        });
        final CheckBox dDuc6 = (CheckBox)findViewById(R.id.pashte);
        dDuc6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dDuc6.isChecked()){
                    dataDucha += " "+"pashte";}
            }
        });
        final CheckBox dDuc7 = (CheckBox)findViewById(R.id.ninguno_ducha);
        dDuc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dDuc7.isChecked()){
                    dataDucha += " "+"ninguno";}
            }
        });

        //Almacena la cadena de accesorios de la Letrina
        final CheckBox dLetri1 = (CheckBox)findViewById(R.id.basurero);
        dLetri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLetri1.isChecked()){
                    dataLetrina += " "+"basurero";
                }
            }
        });
        final CheckBox dLetri2 = (CheckBox)findViewById(R.id.porta_toilet);
        dLetri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLetri2.isChecked()){
                    dataLetrina += " "+"porta_toilet";}
            }
        });
        final CheckBox dLetri3 = (CheckBox)findViewById(R.id.toilet);
        dLetri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLetri3.isChecked()){
                    dataLetrina += " "+"toilet";}
            }
        });
        final CheckBox dLetri4 = (CheckBox)findViewById(R.id.prensa);
        dLetri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLetri4.isChecked()){
                    dataLetrina += " "+"prensa";}
            }
        });
        final CheckBox dLetri5 = (CheckBox)findViewById(R.id.olotes);
        dLetri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLetri5.isChecked()){
                    dataLetrina += " "+"olotes";}
            }
        });
        final CheckBox dLetri6 = (CheckBox)findViewById(R.id.plantas);
        dLetri6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLetri6.isChecked()){
                    dataLetrina += " "+"plantas";}
            }
        });
        final CheckBox dLetri7 = (CheckBox)findViewById(R.id.toallas_sani);
        dLetri7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLetri7.isChecked()){
                    dataLetrina += " "+"toallas_sanitarias";}
            }
        });
        final CheckBox dLetri8 = (CheckBox)findViewById(R.id.toallitas);
        dLetri8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLetri8.isChecked()){
                    dataLetrina += " "+"toallitas";}
            }
        });
        final CheckBox dLetri9 = (CheckBox)findViewById(R.id.tuza);
        dLetri9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLetri9.isChecked()){
                    dataLetrina += " "+"tuza";}
            }
        });
        final CheckBox dLetri10 = (CheckBox)findViewById(R.id.ninguno_letrina);
        dLetri10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLetri10.isChecked()){
                    dataLetrina += " "+"ninguno";}
            }
        });

        //Almacena la cadena de accesorios de la Lavadero
        final CheckBox dLava1 = (CheckBox)findViewById(R.id.cepilleros);
        dLava1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLava1.isChecked()){
                    dataLavadero += " "+"cepilleros";
                }
            }
        });
        final CheckBox dLava2 = (CheckBox)findViewById(R.id.cepillo_diente);
        dLava2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLava2.isChecked()){
                    dataLavadero += " "+"cepillo_diente";}
            }
        });
        final CheckBox dLava3 = (CheckBox)findViewById(R.id.jabon_ropa);
        dLava3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLava3.isChecked()){
                    dataLavadero += " "+"jabon_ropa";}
            }
        });
        final CheckBox dLava4 = (CheckBox)findViewById(R.id.detergente_lava);
        dLava4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLava4.isChecked()){
                    dataLavadero += " "+"detergente";}
            }
        });
        final CheckBox dLava5 = (CheckBox)findViewById(R.id.cepillo_ropa);
        dLava5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLava5.isChecked()){
                    dataLavadero += " "+"cepillo_ropa";}
            }
        });
        final CheckBox dLava6 = (CheckBox)findViewById(R.id.pasta_dental);
        dLava6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLava6.isChecked()){
                    dataLavadero += " "+"pasta_dental";}
            }
        });
        final CheckBox dLava7 = (CheckBox)findViewById(R.id.jabon_trastos);
        dLava7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLava7.isChecked()){
                    dataLavadero += " "+"jabon_trastos";}
            }
        });
        final CheckBox dLava8 = (CheckBox)findViewById(R.id.pashte_lava);
        dLava8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLava8.isChecked()){
                    dataLavadero += " "+"pashte";}
            }
        });
        final CheckBox dLava9 = (CheckBox)findViewById(R.id.ninguno_lava);
        dLava9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dLava9.isChecked()){
                    dataLavadero += " "+"ninguno";}
            }
        });

        fechaAccesorio = (DatePicker)findViewById(R.id.fechaAccesorio);

        btnAgregar = (Button) findViewById(R.id.btnAgregarAccesorio);

        dbconeccion = new SQLControladorAmbienteAccesorios(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarAccesorio:
                String idAmbiente = getIntent().getStringExtra("idAmbiente");
                String ambiente = getIntent().getStringExtra("ambiente");
                String accesoHabi = dataHabi;
                String accesoCoci = dataCocina;
                String accesoLetri = dataLetrina;
                String accesoDucha = dataDucha;
                String accesoLava = dataLavadero;
                String fecha = fechaAccesorio.getYear()+"-"+(fechaAccesorio.getMonth()+1)+"-"+fechaAccesorio.getDayOfMonth();

                dbconeccion.insertarDatos(idAmbiente, ambiente, accesoHabi, accesoCoci, accesoLetri, accesoDucha, accesoLava, fecha);
                Intent main = new Intent(form_general_accesorios.this, formulariosAmbientes.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //main.putExtra("idAmbiente",idAmbiente);
                Toast.makeText(getApplicationContext(), "Elementos Guardados Correctamente ", Toast.LENGTH_SHORT).show();
                startActivity(main);
                break;

            default:
                break;
        }
    }
}