package com.example.subprogramamalaria.apk_fundenor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Subprograma Malaria on 02/11/2016.
 */

public class form_general_curacion extends Activity implements View.OnClickListener {
    DatePicker fechaCur;
    Button btnAgregar;
    SQLControladorEtnoCuracion dbconeccion;
    EditText noVacun , noMuert;
    String enferComnes="", usoMed="", usoVac="", quienVacuno="", ultimoVacuna, mesesMuerte="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_general_curacion);

        //Almacena la cadena de Enfermedades Comunes
        final CheckBox ani1 = (CheckBox)findViewById(R.id.cbPeste);
        ani1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ani1.isChecked()){
                    enferComnes += " "+"peste";
                    }
            }
        });
        final CheckBox ali2 = (CheckBox)findViewById(R.id.cbViruela);
        ali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali2.isChecked()){
                    enferComnes += " "+"viruela";}
            }
        });
        final CheckBox ali3 = (CheckBox)findViewById(R.id.cbRespi);
        ali3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali3.isChecked()){
                    enferComnes += " "+"respiratorias";}
            }
        });
        final CheckBox ali4 = (CheckBox)findViewById(R.id.cbParInt);
        ali4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali4.isChecked()){
                    enferComnes += " "+"parasitos_internos";}
            }
        });
        final CheckBox ali5 = (CheckBox)findViewById(R.id.cbParExt);
        ali5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali5.isChecked()){
                    enferComnes += " "+"parasitos_externos";}
            }
        });
        final CheckBox ali6 = (CheckBox)findViewById(R.id.cbGumboro);
        ali6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ali6.isChecked()){
                    enferComnes += " "+"gumboro";}
            }
        });

        //Almacena la cadena de Tipo de Medicamentos
        final CheckBox med1 = (CheckBox)findViewById(R.id.cbPlantas);
        med1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(med1.isChecked()){
                    usoMed += " "+"plantas_naturales";
                }
            }
        });
        final CheckBox med2 = (CheckBox)findViewById(R.id.cbVacu);
        med2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(med2.isChecked()){
                    usoMed += " "+"vacunas";}
            }
        });
        final CheckBox med3 = (CheckBox)findViewById(R.id.cbPast);
        med3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(med3.isChecked()){
                    usoMed += " "+"pastillas";}
            }
        });
        final CheckBox med4 = (CheckBox)findViewById(R.id.cbOtroMed);
        med4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(med4.isChecked()){
                    usoMed += " "+"otro_med";}
            }
        });

        //Almacena la cadena de Tipo de Vacunas que usa
        final CheckBox vac1 = (CheckBox)findViewById(R.id.cbTripeA);
        vac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vac1.isChecked()){
                    usoVac += " "+"trip_aviar";
                }
            }
        });
        final CheckBox vac2 = (CheckBox)findViewById(R.id.cbViruelaVac);
        vac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vac2.isChecked()){
                    usoVac += " "+"viruela";}
            }
        });
        final CheckBox vac3 = (CheckBox)findViewById(R.id.cbNewCas);
        vac3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vac3.isChecked()){
                    usoVac += " "+"new_castle";}
            }
        });
        final CheckBox vac4 = (CheckBox)findViewById(R.id.cbOtraVac);
        vac4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vac4.isChecked()){
                    usoVac += " "+"otra_vac";}
            }
        });
        noVacun = (EditText)findViewById(R.id.noVacunas);

        //Almacena la cadena de Tipo de Vacunas que usa
        final CheckBox vacuno1 = (CheckBox)findViewById(R.id.cbCuePro);
        vacuno1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vacuno1.isChecked()){
                    quienVacuno += " "+"cuenta_propia";
                }
            }
        });
        final CheckBox vacuno2 = (CheckBox)findViewById(R.id.cbFalFun);
        vacuno2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vacuno2.isChecked()){
                    quienVacuno += " "+"facilitador_fundenor";}
            }
        });
        final CheckBox vacuno3 = (CheckBox)findViewById(R.id.cbGrupVec);
        vacuno3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vacuno3.isChecked()){
                    quienVacuno += " "+"grupo_vecinos";}
            }
        });
        final CheckBox vacuno4 = (CheckBox)findViewById(R.id.cbPartFund);
        vacuno4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vacuno4.isChecked()){
                    quienVacuno += " "+"participante_fundenor";}
            }
        });
        final CheckBox vacuno5 = (CheckBox)findViewById(R.id.cbOtroVac);
        vacuno5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vacuno5.isChecked()){
                    quienVacuno += " "+"otra_vac";}
            }
        });

        //Almacena las el ultimo mes que Vacuno
        RadioButton rb_EneV = (RadioButton)findViewById(R.id.rb_eneV);
        RadioButton rb_FebV = (RadioButton)findViewById(R.id.rb_febV);
        RadioButton rb_MarV = (RadioButton)findViewById(R.id.rb_marV);
        RadioButton rb_AbrV = (RadioButton)findViewById(R.id.rb_abrV);
        RadioButton rb_MayV = (RadioButton)findViewById(R.id.rb_mayV);
        RadioButton rb_JunV = (RadioButton)findViewById(R.id.rb_junV);
        RadioButton rb_JulV = (RadioButton)findViewById(R.id.rb_julV);
        RadioButton rb_AgoV = (RadioButton)findViewById(R.id.rb_agoV);
        RadioButton rb_SepV = (RadioButton)findViewById(R.id.rb_sepV);
        RadioButton rb_OctV = (RadioButton)findViewById(R.id.rb_octV);
        RadioButton rb_NovV = (RadioButton)findViewById(R.id.rb_novV);
        RadioButton rb_DicV = (RadioButton)findViewById(R.id.rb_dicV);
        View.OnClickListener list_mesVac = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_eneV:
                        ultimoVacuna = "enero";
                        break;
                    case R.id.rb_febV:
                        ultimoVacuna = "febero";
                        break;
                    case R.id.rb_marV:
                        ultimoVacuna = "marzo";
                        break;
                    case R.id.rb_abrV:
                        ultimoVacuna = "abril";
                        break;
                    case R.id.rb_mayV:
                        ultimoVacuna = "mayo";
                        break;
                    case R.id.rb_junV:
                        ultimoVacuna = "junio";
                        break;
                    case R.id.rb_julV:
                        ultimoVacuna = "julio";
                        break;
                    case R.id.rb_agoV:
                        ultimoVacuna = "agosto";
                        break;
                    case R.id.rb_sepV:
                        ultimoVacuna = "septiembre";
                        break;
                    case R.id.rb_octV:
                        ultimoVacuna = "octubre";
                        break;
                    case R.id.rb_novV:
                        ultimoVacuna = "noviembre";
                        break;
                    case R.id.rb_dicV:
                        ultimoVacuna = "diciembre";
                        break;
                }
            }
        };
        rb_EneV.setOnClickListener(list_mesVac);
        rb_FebV.setOnClickListener(list_mesVac);
        rb_MarV.setOnClickListener(list_mesVac);
        rb_AbrV.setOnClickListener(list_mesVac);
        rb_MayV.setOnClickListener(list_mesVac);
        rb_JunV.setOnClickListener(list_mesVac);
        rb_JulV.setOnClickListener(list_mesVac);
        rb_AgoV.setOnClickListener(list_mesVac);
        rb_SepV.setOnClickListener(list_mesVac);
        rb_OctV.setOnClickListener(list_mesVac);
        rb_NovV.setOnClickListener(list_mesVac);
        rb_DicV.setOnClickListener(list_mesVac);

        //Almacena la cadena de Meses de Muertes
        final CheckBox mes1 = (CheckBox)findViewById(R.id.cbEneM);
        mes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes1.isChecked()){
                    mesesMuerte += " "+"enero";
                }
            }
        });
        final CheckBox mes2 = (CheckBox)findViewById(R.id.cbFebM);
        mes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes2.isChecked()){
                    mesesMuerte += " "+"febrero";
                }
            }
        });
        final CheckBox mes3 = (CheckBox)findViewById(R.id.cbMarM);
        mes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes3.isChecked()){
                    mesesMuerte += " "+"marzo";
                }
            }
        });
        final CheckBox mes4 = (CheckBox)findViewById(R.id.cbAbrM);
        mes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes4.isChecked()){
                    mesesMuerte += " "+"abril";
                }
            }
        });
        final CheckBox mes5 = (CheckBox)findViewById(R.id.cbMayM);
        mes5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes5.isChecked()){
                    mesesMuerte += " "+"mayo";
                }
            }
        });
        final CheckBox mes6 = (CheckBox)findViewById(R.id.cbJunM);
        mes6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes6.isChecked()){
                    mesesMuerte += " "+"junio";
                }
            }
        });
        final CheckBox mes7 = (CheckBox)findViewById(R.id.cbJulM);
        mes7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes7.isChecked()){
                    mesesMuerte += " "+"julio";
                }
            }
        });
        final CheckBox mes8 = (CheckBox)findViewById(R.id.cbAgoM);
        mes8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes8.isChecked()){
                    mesesMuerte += " "+"agosto";
                }
            }
        });
        final CheckBox mes9 = (CheckBox)findViewById(R.id.cbSepM);
        mes9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes9.isChecked()){
                    mesesMuerte += " "+"septiembre";
                }
            }
        });
        final CheckBox mes10 = (CheckBox)findViewById(R.id.cbOctM);
        mes10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes10.isChecked()){
                    mesesMuerte += " "+"octubre";
                }
            }
        });
        final CheckBox mes11 = (CheckBox)findViewById(R.id.cbNovM);
        mes11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes11.isChecked()){
                    mesesMuerte += " "+"noviembre";
                }
            }
        });
        final CheckBox mes12 = (CheckBox)findViewById(R.id.cbDicM);
        mes12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mes12.isChecked()){
                    mesesMuerte += " "+"diciembre";
                }
            }
        });


        noMuert = (EditText)findViewById(R.id.noMuertes);

        fechaCur = (DatePicker)findViewById(R.id.fechaCuracion);

        btnAgregar = (Button) findViewById(R.id.btnAgregarCuracion);

        dbconeccion = new SQLControladorEtnoCuracion(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarCuracion:
                String idEtno = getIntent().getStringExtra("idEtno");
                String enfComun = enferComnes;
                String tipoMedic = usoMed;
                String tipoVac = usoVac;
                String noVac = noVacun.getText().toString();
                String quienVac = quienVacuno;
                String ultimoMesVac = ultimoVacuna;
                String mesMuerte = mesesMuerte;
                String cantMuerte = noMuert.getText().toString();
                String fechaCura = fechaCur.getYear()+"-"+(fechaCur.getMonth()+1)+"-"+fechaCur.getDayOfMonth();

                dbconeccion.insertarDatos(idEtno, enfComun, tipoMedic, tipoVac, noVac, quienVac, ultimoMesVac, mesMuerte, cantMuerte, fechaCura);
                Intent main = new Intent(form_general_curacion.this, formulariosEtno.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("idEtno",idEtno);
                Toast.makeText(getApplicationContext(), "Elementos Guardados Correctamente ", Toast.LENGTH_SHORT).show();
                startActivity(main);
                break;

            default:
                break;
        }
    }
}
