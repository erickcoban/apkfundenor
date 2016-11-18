package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

public class AgregarParticipante extends Activity implements OnClickListener {
    EditText n1P, n2P, n3P, a1P, a2P, aCP, cuiP, otroO, otraRP, grupoP, extTP, ingresoP, telP, otraReligion, otroOficio;
    Button btnAgregar;
    DatePicker fechaNac, fechaRegPar;
    String generoPar, gradoPar, eCivilPar, cargoPar, idiomaPar, oficioPar, religionPar,
           terrenoPar, cJuridcaPar;

    SQLControladorParticipante dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_participante);

        //Obtiene los valores de los campos selecciónados para almacenar en la tabla
        n1P = (EditText)findViewById(R.id.nombreP1);
        n2P = (EditText)findViewById(R.id.nombreP2);
        n3P = (EditText)findViewById(R.id.nombreP3);
        a1P = (EditText)findViewById(R.id.apellidoP1);
        a2P = (EditText)findViewById(R.id.apellidoP2);
        aCP = (EditText)findViewById(R.id.apellidoP3);
        cuiP = (EditText)findViewById(R.id.cui);
        telP = (EditText)findViewById(R.id.telefonoP);
        otroO = (EditText)findViewById(R.id.otroOficio);
        otraRP = (EditText)findViewById(R.id.otraReligion);
        grupoP = (EditText)findViewById(R.id.grupoParticipa);
        extTP = (EditText)findViewById(R.id.extensionTierra);
        ingresoP = (EditText)findViewById(R.id.ingresoEconomico);

        fechaNac = (DatePicker)findViewById(R.id.fechaNacimiento);
        fechaRegPar = (DatePicker)findViewById(R.id.fechaRegPar);

        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        //Inicializa la base de datos
        dbconeccion = new SQLControladorParticipante(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);

        //Muestra el apellido de casada si es mujer
        final EditText apellidoP3 = (EditText)findViewById(R.id.apellidoP3);
        final RadioButton rb_amaCasa = (RadioButton)findViewById(R.id.rb_amaCasa);
        RadioButton rb_masculino = (RadioButton)findViewById(R.id.rb_masculino);
        RadioButton rb_femenino = (RadioButton)findViewById(R.id.rb_femenino);
        View.OnClickListener list_apellidoP3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_femenino:
                        apellidoP3.setVisibility(View.VISIBLE);
                        rb_amaCasa.setVisibility(View.VISIBLE);
                        generoPar = "femenino";
                        break;
                    case R.id.rb_masculino:
                        apellidoP3.setVisibility(View.GONE);
                        rb_amaCasa.setVisibility(View.GONE);
                        generoPar = "masculino";
                        break;
                }
            }
        };
        rb_femenino.setOnClickListener(list_apellidoP3);
        rb_masculino.setOnClickListener(list_apellidoP3);

        //Almacena el grado academico del participante
        RadioButton rb_ninguAC = (RadioButton)findViewById(R.id.rb_ningunoGAP);
        RadioButton rb_prepri = (RadioButton)findViewById(R.id.rb_preprimaria);
        RadioButton rb_prima = (RadioButton)findViewById(R.id.rb_primaria);
        RadioButton rb_basico = (RadioButton)findViewById(R.id.rb_basico);
        RadioButton rb_divers = (RadioButton)findViewById(R.id.rb_diversificado);
        RadioButton rb_univer = (RadioButton)findViewById(R.id.rb_universidad);
        View.OnClickListener list_gradoAca = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch (view.getId()){
                    case R.id.rb_ningunoGAP:
                        gradoPar = "ninguno";
                        break;
                    case R.id.rb_preprimaria:
                        gradoPar = "preprimaria";
                        break;
                    case R.id.rb_primaria:
                        gradoPar = "primaria";
                        break;
                    case R.id.rb_basico:
                        gradoPar = "basico";
                        break;
                    case R.id.rb_diversificado:
                        gradoPar = "diversificado";
                        break;
                    case R.id.rb_universidad:
                        gradoPar = "universidad";
                        break;
                }
            }
        };
        rb_ninguAC.setOnClickListener(list_gradoAca);
        rb_prepri.setOnClickListener(list_gradoAca);
        rb_prima.setOnClickListener(list_gradoAca);
        rb_basico.setOnClickListener(list_gradoAca);
        rb_divers.setOnClickListener(list_gradoAca);
        rb_univer.setOnClickListener(list_gradoAca);

        //Almacena el grado academico del participante
        RadioButton rb_solte = (RadioButton)findViewById(R.id.rb_soltero);
        RadioButton rb_casad = (RadioButton)findViewById(R.id.rb_casado);
        RadioButton rb_unid = (RadioButton)findViewById(R.id.rb_unido);
        RadioButton rb_divor = (RadioButton)findViewById(R.id.rb_divorsiado);
        RadioButton rb_viud = (RadioButton)findViewById(R.id.rb_viudo);
        View.OnClickListener list_eCivilPar = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch (view.getId()){
                    case R.id.rb_soltero:
                        eCivilPar = "soltero";
                        break;
                    case R.id.rb_casado:
                        eCivilPar = "casado";
                        break;
                    case R.id.rb_unido:
                        eCivilPar = "unido";
                        break;
                    case R.id.rb_divorsiado:
                        eCivilPar = "divorsiado";
                        break;
                    case R.id.rb_viudo:
                        eCivilPar = "viudo";
                        break;
                }
            }
        };
        rb_solte.setOnClickListener(list_eCivilPar);
        rb_casad.setOnClickListener(list_eCivilPar);
        rb_unid.setOnClickListener(list_eCivilPar);
        rb_divor.setOnClickListener(list_eCivilPar);
        rb_viud.setOnClickListener(list_eCivilPar);

        //Almacena el Cargo Comunitario que tiene
        RadioButton rb_ning = (RadioButton)findViewById(R.id.rb_ningunoCCP);
        RadioButton rb_coco = (RadioButton)findViewById(R.id.rb_cocode);
        RadioButton rb_comi = (RadioButton)findViewById(R.id.rb_comite);
        RadioButton rb_past = (RadioButton)findViewById(R.id.rb_pastor);
        RadioButton rb_cate = (RadioButton)findViewById(R.id.rb_catequista);
        RadioButton rb_lider = (RadioButton)findViewById(R.id.rb_liderComunitario);
        View.OnClickListener list_cargoCom = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_ningunoCCP:
                        cargoPar = "ninguno";
                        break;
                    case R.id.rb_cocode:
                        cargoPar = "cocode";
                        break;
                    case R.id.rb_comite:
                        cargoPar = "comite";
                        break;
                    case R.id.rb_pastor:
                        cargoPar = "passtor";
                        break;
                    case R.id.rb_catequista:
                        cargoPar = "catequista";
                        break;
                    case R.id.rb_liderComunitario:
                        cargoPar = "lider_comunitario";
                        break;
                }
            }
        };
        rb_ning.setOnClickListener(list_cargoCom);
        rb_coco.setOnClickListener(list_cargoCom);
        rb_comi.setOnClickListener(list_cargoCom);
        rb_past.setOnClickListener(list_cargoCom);
        rb_cate.setOnClickListener(list_cargoCom);
        rb_lider.setOnClickListener(list_cargoCom);

        //Almacena el idioma que habla el participante
        RadioButton rb_qeqch = (RadioButton)findViewById(R.id.rb_qeqchi);
        RadioButton rb_pocom = (RadioButton)findViewById(R.id.rb_pocomchi);
        RadioButton rb_caste = (RadioButton)findViewById(R.id.rb_castellano);
        View.OnClickListener list_idiomaPar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_qeqchi:
                        idiomaPar = "qeqchi";
                        break;
                    case R.id.rb_pocomchi:
                        idiomaPar = "pocomchi";
                        break;
                    case R.id.rb_castellano:
                        idiomaPar = "castellano";
                        break;
                }
            }
        };
        rb_qeqch.setOnClickListener(list_idiomaPar);
        rb_pocom.setOnClickListener(list_idiomaPar);
        rb_caste.setOnClickListener(list_idiomaPar);

        //Muestra Especifique otro oficio
        otroOficio = (EditText)findViewById(R.id.otroOficio);
        RadioButton rb_otroOficio = (RadioButton)findViewById(R.id.rb_otroOficioP);
        RadioButton rb_ama_casa = (RadioButton)findViewById(R.id.rb_amaCasa);
        RadioButton rb_jornalero = (RadioButton)findViewById(R.id.rb_jornalero);
        RadioButton rb_comerciante = (RadioButton)findViewById(R.id.rb_comerciante);
        RadioButton rb_agricultor = (RadioButton)findViewById(R.id.rb_agricultor);
        View.OnClickListener list_otroOficio = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_otroOficioP:
                        //otroOficio.setVisibility(View.VISIBLE);
                        oficioPar = otroOficio.getText().toString();
                        break;
                    case R.id.rb_amaCasa:
                        oficioPar = "ama_de_casa";
                        break;
                    case R.id.rb_jornalero:
                        otroOficio.setVisibility(View.GONE);
                        oficioPar = "jornalero";
                        break;
                    case R.id.rb_comerciante:
                        otroOficio.setVisibility(View.GONE);
                        oficioPar = "comerciante";
                        break;
                    case R.id.rb_agricultor:
                        otroOficio.setVisibility(View.GONE);
                        oficioPar = "agricultor";
                        break;
                }
            }
        };
        rb_otroOficio.setOnClickListener(list_otroOficio);
        rb_ama_casa.setOnClickListener(list_otroOficio);
        rb_jornalero.setOnClickListener(list_otroOficio);
        rb_comerciante.setOnClickListener(list_otroOficio);
        rb_agricultor.setOnClickListener(list_otroOficio);

        //Muestra Especifique otra religión
        otraReligion = (EditText)findViewById(R.id.otraReligion);
        RadioButton rb_catolico = (RadioButton)findViewById(R.id.rb_catolico);
        RadioButton rb_evangelico = (RadioButton)findViewById(R.id.rb_evangelico);
        RadioButton rb_otraReligion = (RadioButton)findViewById(R.id.rb_otraReligion);
        View.OnClickListener list_otraReligion = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_otraReligion:
                        //otraReligion.setVisibility(View.VISIBLE);
                        religionPar = "otro";
                        break;
                    case R.id.rb_catolico:
                        otraReligion.setVisibility(View.GONE);
                        religionPar = "catolico";
                        break;
                    case R.id.rb_evangelico:
                        otraReligion.setVisibility(View.GONE);
                        religionPar = "evangelico";
                        break;
                }
            }
        };
        rb_catolico.setOnClickListener(list_otraReligion);
        rb_evangelico.setOnClickListener(list_otraReligion);
        rb_otraReligion.setOnClickListener(list_otraReligion);

        //Almacena la tenencia de la tierra
        RadioButton rb_prop = (RadioButton)findViewById(R.id.rb_propia);
        RadioButton rb_pres = (RadioButton)findViewById(R.id.rb_prestada);
        RadioButton rb_algu = (RadioButton)findViewById(R.id.rb_alquilada);
        RadioButton rb_ning2 = (RadioButton)findViewById(R.id.rb_ninguna);
        View.OnClickListener list_tenenciaTP = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_propia:
                        terrenoPar = "propia";
                        break;
                    case R.id.rb_prestada:
                        terrenoPar = "prestada";
                        break;
                    case R.id.rb_alquilada:
                        terrenoPar = "alquilada";
                        break;
                    case R.id.rb_ninguna:
                        terrenoPar = "ninguna";
                        break;
                }
            }
        };
        rb_prop.setOnClickListener(list_tenenciaTP);
        rb_pres.setOnClickListener(list_tenenciaTP);
        rb_algu.setOnClickListener(list_tenenciaTP);
        rb_ning2.setOnClickListener(list_tenenciaTP);

        //Almacena si tiene certeza juridica
        RadioButton rb_no = (RadioButton)findViewById(R.id.rb_no);
        RadioButton rb_si = (RadioButton)findViewById(R.id.rb_si);
        View.OnClickListener list_certezaPart = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.rb_no:
                        cJuridcaPar = "no";
                        break;
                    case R.id.rb_si:
                        cJuridcaPar = "si";
                        break;
                }
            }
        };
        rb_no.setOnClickListener(list_certezaPart);
        rb_si.setOnClickListener(list_certezaPart);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            //Guarda los datos en la tabla
            case R.id.btnAgregarId:
                String idFamilia = getIntent().getStringExtra("idFam");
                String nombre1P = n1P.getText().toString();
                String nombre2P = n2P.getText().toString();
                String nombre3P = n3P.getText().toString();
                String apellido1P = a1P.getText().toString();
                String apellido2P = a2P.getText().toString();
                String apellidoCP = aCP.getText().toString();
                String generoP = generoPar;
                String fechaNaci = fechaNac.getYear()+"-"+(fechaNac.getMonth()+1)+"-"+fechaNac.getDayOfMonth();
                String dpiP = cuiP.getText().toString();
                String gradoAcade = gradoPar;
                String estadoCivil = eCivilPar;
                String telefonoP = telP.getText().toString();
                String cargoComu = cargoPar;
                String idiomPart =idiomaPar;
                String oficioPart = oficioPar;
                String religionPart = religionPar;
                String grupoPart = grupoP.getText().toString();
                String terrenoPart = terrenoPar;
                String certezaJPart = cJuridcaPar;
                String extensionTPart = extTP.getText().toString();
                String ingresoEcono = ingresoP.getText().toString();
                String fechaRegPart = fechaRegPar.getYear()+"-"+(fechaRegPar.getMonth()+1)+"-"+fechaRegPar.getDayOfMonth();

                dbconeccion.insertarDatos(idFamilia, nombre1P, nombre2P, nombre3P, apellido1P, apellido2P, apellidoCP, generoP, fechaNaci,
                                          dpiP, gradoAcade, estadoCivil, telefonoP, cargoComu, idiomPart, oficioPart, religionPart, grupoPart,
                                          terrenoPart, certezaJPart, extensionTPart, ingresoEcono, fechaRegPart);
                Intent main = new Intent(AgregarParticipante.this, MyActivityParticipante.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("idFam", idFamilia);
                startActivity(main);
                break;

            default:
                break;
        }
    }
}
