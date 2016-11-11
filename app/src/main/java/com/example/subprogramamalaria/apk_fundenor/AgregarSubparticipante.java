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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AgregarSubparticipante extends Activity implements OnClickListener {
    EditText n1S, n2S, n3S, a1S, a2S, aCS, tallaS, pesoS, cuiS, telS, oficioOS, religionOS, grupoPS, ingresoES;
    LinearLayout LLDes;
    DatePicker fechaNacS, fechaRegS;
    Button btnAgregar;
    String consanSP, generoSP, gradoDesSP, gradoAcaSP, idiomaSP, estaCivSP, cargoComSP, oficioSP, religionSP;

    SQLControladorSubparticipante dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_subparticipante);
        n1S = (EditText)findViewById(R.id.nombreSP1);
        n2S = (EditText)findViewById(R.id.nombreSP2);
        n3S = (EditText)findViewById(R.id.nombreSP3);
        a1S = (EditText)findViewById(R.id.apellidoSP1);
        a2S = (EditText)findViewById(R.id.apellidoSP2);
        aCS = (EditText)findViewById(R.id.apellidoSP3);
        tallaS = (EditText)findViewById(R.id.tallaSP);
        pesoS = (EditText)findViewById(R.id.pesoSP);
        cuiS = (EditText)findViewById(R.id.cuiSP);
        telS = (EditText)findViewById(R.id.telefonoSP);
        oficioOS = (EditText)findViewById(R.id.otroOficioSP);
        religionOS = (EditText)findViewById(R.id.otraReligionSP);
        grupoPS = (EditText)findViewById(R.id.grupoParticipaSP);
        ingresoES = (EditText)findViewById(R.id.ingresoEconomicoSP);
        LLDes = (LinearLayout) findViewById(R.id.LinearDes);
        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        fechaNacS = (DatePicker)findViewById(R.id.fechaNacimientoSP);
        fechaRegS = (DatePicker)findViewById(R.id.fechaRegSP);

        dbconeccion = new SQLControladorSubparticipante(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);

        //Almacena el Grado de Consanguinidad con el Participante
        RadioButton rb_conyugue = (RadioButton)findViewById(R.id.rb_conyugue);
        RadioButton rb_hijo_a = (RadioButton)findViewById(R.id.rb_hijo_a);
        RadioButton rb_otroCon = (RadioButton)findViewById(R.id.rb_otroCons);
        final EditText otroCons = (EditText)findViewById(R.id.otroConsan);
        View.OnClickListener list_consanguinidad = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_conyugue:
                        otroCons.setVisibility(View.GONE);
                        LLDes.setVisibility(View.GONE);
                        consanSP = "conyugue";
                        break;
                    case R.id.rb_hijo_a:
                        otroCons.setVisibility(View.GONE);
                        LLDes.setVisibility(View.VISIBLE);
                        consanSP = "hijo_hija";
                        break;
                    case R.id.rb_otroCons:
                        otroCons.setVisibility(View.VISIBLE);
                        LLDes.setVisibility(View.GONE);
                        consanSP = otroCons.getText().toString();
                        break;
                }
            }
        };
        rb_conyugue.setOnClickListener(list_consanguinidad);
        rb_hijo_a.setOnClickListener(list_consanguinidad);
        rb_otroCon.setOnClickListener(list_consanguinidad);

        //Muestra el apellido de casada si es mujer
        final EditText apellidoP3 = (EditText)findViewById(R.id.apellidoSP3);
        final RadioButton rb_amaCasa = (RadioButton)findViewById(R.id.rb_amaCasaSP);
        RadioButton rb_masculino = (RadioButton)findViewById(R.id.rb_masculinoSP);
        RadioButton rb_femenino = (RadioButton)findViewById(R.id.rb_femeninoSP);
        View.OnClickListener list_apellidoP3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_femeninoSP:
                        apellidoP3.setVisibility(View.VISIBLE);
                        rb_amaCasa.setVisibility(View.VISIBLE);
                        generoSP = "femenino";
                        break;
                    case R.id.rb_masculinoSP:
                        apellidoP3.setVisibility(View.GONE);
                        rb_amaCasa.setVisibility(View.GONE);
                        generoSP = "masculino";
                        break;
                }
            }
        };
        rb_femenino.setOnClickListener(list_apellidoP3);
        rb_masculino.setOnClickListener(list_apellidoP3);

        //Muestra Especifique otro oficio
        final EditText otroOficio = (EditText)findViewById(R.id.otroOficioSP);
        RadioButton rb_otroOficio = (RadioButton)findViewById(R.id.rb_otroOficioSP);
        RadioButton rb_jornalero = (RadioButton)findViewById(R.id.rb_jornaleroSP);
        RadioButton rb_comerciante = (RadioButton)findViewById(R.id.rb_comercianteSP);
        RadioButton rb_agricultor = (RadioButton)findViewById(R.id.rb_agricultorSP);
        View.OnClickListener list_otroOficio = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_otroOficioSP:
                        otroOficio.setVisibility(View.VISIBLE);
                        oficioSP = otroOficio.getText().toString();
                        break;
                    case R.id.rb_jornaleroSP:
                        otroOficio.setVisibility(View.GONE);
                        oficioSP = "jornalero";
                        break;
                    case R.id.rb_comercianteSP:
                        otroOficio.setVisibility(View.GONE);
                        oficioSP = "comerciante";
                        break;
                    case R.id.rb_agricultorSP:
                        otroOficio.setVisibility(View.GONE);
                        oficioSP = "agricultor";
                        break;
                }
            }
        };
        rb_otroOficio.setOnClickListener(list_otroOficio);
        rb_jornalero.setOnClickListener(list_otroOficio);
        rb_comerciante.setOnClickListener(list_otroOficio);
        rb_agricultor.setOnClickListener(list_otroOficio);

        //Almacena el nivel de Desnutrición del nin@
        RadioButton rb_cronicaM = (RadioButton)findViewById(R.id.rb_cronica_moderada);
        RadioButton rb_cronicaS = (RadioButton)findViewById(R.id.rb_cronica_severa);
        RadioButton rb_agudaM = (RadioButton)findViewById(R.id.rb_aguda_moderada);
        RadioButton rb_agudaS = (RadioButton)findViewById(R.id.rb_aguda_severa);
        RadioButton rb_kwuash = (RadioButton)findViewById(R.id.rb_kwuashiorkol);
        RadioButton rb_maras = (RadioButton)findViewById(R.id.rb_marasmo);
        RadioButton rb_edema1 = (RadioButton)findViewById(R.id.rb_edema1);
        RadioButton rb_edema2 = (RadioButton)findViewById(R.id.rb_edema2);
        RadioButton rb_edema3 = (RadioButton)findViewById(R.id.rb_edema3);
        RadioButton rb_ningunoS = (RadioButton)findViewById(R.id.rb_ningunoSP);
        View.OnClickListener list_desnutricion = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_cronica_moderada:
                        gradoDesSP = "cronica_moderada";
                        break;
                    case R.id.rb_cronica_severa:
                        gradoDesSP = "cronica_severa";
                        break;
                    case R.id.rb_aguda_moderada:
                        gradoDesSP = "aguda_moderada";
                        break;
                    case R.id.rb_aguda_severa:
                        gradoDesSP = "aguda_severa";
                        break;
                    case R.id.rb_kwuashiorkol:
                        gradoDesSP = "kwuashiorkol";
                        break;
                    case R.id.rb_marasmo:
                        gradoDesSP = "marasmo";
                        break;
                    case R.id.rb_edema1:
                        gradoDesSP = "edema1";
                        break;
                    case R.id.rb_edema2:
                        gradoDesSP = "edema2";
                        break;
                    case R.id.rb_edema3:
                        gradoDesSP = "edema3";
                        break;
                    case R.id.rb_ningunoSP:
                        gradoDesSP = "ninguno";
                        break;
                }
            }
        };
        rb_cronicaM.setOnClickListener(list_desnutricion);
        rb_cronicaS.setOnClickListener(list_desnutricion);
        rb_agudaM.setOnClickListener(list_desnutricion);
        rb_agudaS.setOnClickListener(list_desnutricion);
        rb_kwuash.setOnClickListener(list_desnutricion);
        rb_maras.setOnClickListener(list_desnutricion);
        rb_edema1.setOnClickListener(list_desnutricion);
        rb_edema2.setOnClickListener(list_desnutricion);
        rb_edema3.setOnClickListener(list_desnutricion);
        rb_ningunoS.setOnClickListener(list_desnutricion);

        //Muestra Especifique otra religión
        final EditText otraReligion = (EditText)findViewById(R.id.otraReligionSP);
        RadioButton rb_catolico = (RadioButton)findViewById(R.id.rb_catolicoSP);
        RadioButton rb_evangelico = (RadioButton)findViewById(R.id.rb_evangelicoSP);
        RadioButton rb_otraReligion = (RadioButton)findViewById(R.id.rb_otraReligionSP);
        View.OnClickListener list_otraReligion = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_otraReligionSP:
                        otraReligion.setVisibility(View.VISIBLE);
                        religionSP = otraReligion.getText().toString();
                        break;
                    case R.id.rb_catolicoSP:
                        otraReligion.setVisibility(View.GONE);
                        religionSP = "catolico";
                        break;
                    case R.id.rb_evangelicoSP:
                        otraReligion.setVisibility(View.GONE);
                        religionSP = "evangelico";
                        break;
                }
            }
        };
        rb_catolico.setOnClickListener(list_otraReligion);
        rb_evangelico.setOnClickListener(list_otraReligion);
        rb_otraReligion.setOnClickListener(list_otraReligion);

        //Almacena el Cargo Comunitario que tiene
        RadioButton rb_cocoSP = (RadioButton)findViewById(R.id.rb_cocodeSP);
        RadioButton rb_comiSP = (RadioButton)findViewById(R.id.rb_comiteSP);
        RadioButton rb_pastSP = (RadioButton)findViewById(R.id.rb_pastorSP);
        RadioButton rb_cateSP = (RadioButton)findViewById(R.id.rb_catequistaSP);
        RadioButton rb_liderSP = (RadioButton)findViewById(R.id.rb_liderComunitarioSP);
        View.OnClickListener list_cargoComSP = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_cocodeSP:
                        cargoComSP = "cocode";
                        break;
                    case R.id.rb_comiteSP:
                        cargoComSP = "comite";
                        break;
                    case R.id.rb_pastorSP:
                        cargoComSP = "passtor";
                        break;
                    case R.id.rb_catequistaSP:
                        cargoComSP = "catequista";
                        break;
                    case R.id.rb_liderComunitarioSP:
                        cargoComSP = "lider_comunitario";
                        break;
                }
            }
        };
        rb_cocoSP.setOnClickListener(list_cargoComSP);
        rb_comiSP.setOnClickListener(list_cargoComSP);
        rb_pastSP.setOnClickListener(list_cargoComSP);
        rb_cateSP.setOnClickListener(list_cargoComSP);
        rb_liderSP.setOnClickListener(list_cargoComSP);

        //Almacena el grado academico del participante
        RadioButton rb_prepri = (RadioButton)findViewById(R.id.rb_preprimariaSP);
        RadioButton rb_prima = (RadioButton)findViewById(R.id.rb_primariaSP);
        RadioButton rb_basico = (RadioButton)findViewById(R.id.rb_basicoSP);
        RadioButton rb_divers = (RadioButton)findViewById(R.id.rb_diversificadoSP);
        RadioButton rb_univer = (RadioButton)findViewById(R.id.rb_universidadSP);
        View.OnClickListener list_gradoAcaSP = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch (view.getId()){
                    case R.id.rb_preprimariaSP:
                        gradoAcaSP = "preprimaria";
                        break;
                    case R.id.rb_primariaSP:
                        gradoAcaSP = "primaria";
                        break;
                    case R.id.rb_basicoSP:
                        gradoAcaSP = "basico";
                        break;
                    case R.id.rb_diversificadoSP:
                        gradoAcaSP = "diversificado";
                        break;
                    case R.id.rb_universidadSP:
                        gradoAcaSP = "universidad";
                        break;
                }
            }
        };
        rb_prepri.setOnClickListener(list_gradoAcaSP);
        rb_prima.setOnClickListener(list_gradoAcaSP);
        rb_basico.setOnClickListener(list_gradoAcaSP);
        rb_divers.setOnClickListener(list_gradoAcaSP);
        rb_univer.setOnClickListener(list_gradoAcaSP);

        //Almacena el estado civil de subparticipante
        RadioButton rb_solteS = (RadioButton)findViewById(R.id.rb_solteroSP);
        RadioButton rb_casadS = (RadioButton)findViewById(R.id.rb_casadoSP);
        RadioButton rb_unidS = (RadioButton)findViewById(R.id.rb_unidoSP);
        RadioButton rb_divorS = (RadioButton)findViewById(R.id.rb_divorsiadoSP);
        RadioButton rb_viudS = (RadioButton)findViewById(R.id.rb_viudoSP);
        View.OnClickListener list_eCivilSP = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch (view.getId()){
                    case R.id.rb_solteroSP:
                        estaCivSP = "soltero";
                        break;
                    case R.id.rb_casadoSP:
                        estaCivSP = "casado";
                        break;
                    case R.id.rb_unidoSP:
                        estaCivSP = "unido";
                        break;
                    case R.id.rb_divorsiadoSP:
                        estaCivSP = "divorsiado";
                        break;
                    case R.id.rb_viudoSP:
                        estaCivSP = "viudo";
                        break;
                }
            }
        };
        rb_solteS.setOnClickListener(list_eCivilSP);
        rb_casadS.setOnClickListener(list_eCivilSP);
        rb_unidS.setOnClickListener(list_eCivilSP);
        rb_divorS.setOnClickListener(list_eCivilSP);
        rb_viudS.setOnClickListener(list_eCivilSP);

        //Almacena el idioma que habla el participante
        RadioButton rb_qeqchS = (RadioButton)findViewById(R.id.rb_qeqchiSP);
        RadioButton rb_pocomS = (RadioButton)findViewById(R.id.rb_pocomchiSP);
        RadioButton rb_casteS = (RadioButton)findViewById(R.id.rb_castellanoSP);
        View.OnClickListener list_idiomaParSP = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_qeqchiSP:
                        idiomaSP = "qeqchi";
                        break;
                    case R.id.rb_pocomchiSP:
                        idiomaSP = "pocomchi";
                        break;
                    case R.id.rb_castellanoSP:
                        idiomaSP = "castellano";
                        break;
                }
            }
        };
        rb_qeqchS.setOnClickListener(list_idiomaParSP);
        rb_pocomS.setOnClickListener(list_idiomaParSP);
        rb_casteS.setOnClickListener(list_idiomaParSP);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnAgregarId:
                String idParticipante = getIntent().getStringExtra("idPart");
                String nombre1SP = n1S.getText().toString();
                String nombre2SP = n2S.getText().toString();
                String nombre3SP = n3S.getText().toString();
                String apellido1SP = a1S.getText().toString();
                String apellido2SP = a2S.getText().toString();
                String apellidoCSP = aCS.getText().toString();
                String generoSub = generoSP;
                String consaSP = consanSP;
                String fechaNacSub = fechaNacS.getYear()+"-"+(fechaNacS.getMonth()+1)+"-"+fechaNacS.getDayOfMonth();
                String tallaSP = tallaS.getText().toString();
                String pesoSP = pesoS.getText().toString();
                String desnuSP = gradoDesSP;
                String cuiSP = cuiS.getText().toString();
                String gradoAcaSub = gradoAcaSP;
                String estadoCivilS = estaCivSP;
                String telefonoSP = telS.getText().toString();
                String cargoComSub = cargoComSP;
                String idiomaSub = idiomaSP;
                String oficioSubP = oficioSP;
                String religionSub = religionSP;
                String grupoSP = grupoPS.getText().toString();
                String ingresoEcoSP = ingresoES.getText().toString();
                String fechaRegSP = fechaRegS.getYear()+"-"+(fechaRegS.getMonth()+1)+"-"+fechaRegS.getDayOfMonth();

                dbconeccion.insertarDatos(idParticipante, nombre1SP, nombre2SP, nombre3SP, apellido1SP, apellido2SP, apellidoCSP, generoSub, consaSP, fechaNacSub, tallaSP, pesoSP, desnuSP, cuiSP, gradoAcaSub, estadoCivilS, telefonoSP, cargoComSub, idiomaSub, oficioSubP, religionSub, grupoSP, ingresoEcoSP, fechaRegSP);

                Intent main = new Intent(AgregarSubparticipante.this, MyActivitySubparticipante.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        main.putExtra("idPart",idParticipante);
                        Toast.makeText(getApplicationContext(), "envia " + idParticipante, Toast.LENGTH_SHORT).show();
                        startActivity(main);
                break;

            default:
                break;
        }
    }
}
