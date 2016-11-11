package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorSubparticipante {

    private DBhelperSubparticipante dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorSubparticipante(Context c) {
        ourcontext = c;
    }

    public SQLControladorSubparticipante abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperSubparticipante(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idPart, String nombre1, String nombre2, String nombre3, String apellido1, String apellido2, String apellidoC, String generoSP,
                              String consanguinidad, String fechaNac, String talla, String peso, String desnutricion, String cuiSP, String gradoAcademico, String estadoCivil,
                              String telefonoSP, String cargoComunitario, String idomaSP, String oficioSP, String religionSP, String grupoSP, String ingresoESP, String fechaRegSP) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_IDPART, idPart);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_NOMBRE1, nombre1);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_NOMBRE2, nombre2);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_NOMBRE3, nombre3);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_APELLIDO1, apellido1);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_APELLIDO2, apellido2);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_APELLIDOC, apellidoC);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_GENERO, generoSP);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_CONSANGUINIDAD, consanguinidad);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_FECHANAC, fechaNac);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_TALLA, talla);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_PESO, peso);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_DESNUTICION, desnutricion);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_CUI, cuiSP);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_GRADOACA, gradoAcademico);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_ESTADOCIV, estadoCivil);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_TELEFONO, telefonoSP);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_CARGOCOM, cargoComunitario);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_IDIOMA, idomaSP);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_OFICIO, oficioSP);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_RELIGION, religionSP);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_GRUPO, grupoSP);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_INGRESOE, ingresoESP);
        cv.put(DBhelperSubparticipante.SUBPARTICIPANTE_FECHAREG, fechaRegSP);
        database.insert(DBhelperSubparticipante.TABLE_SUBPARTICIPANTE, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
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
        Cursor c = database.query(DBhelperSubparticipante.TABLE_SUBPARTICIPANTE, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long memberID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperSubparticipante.SUBPARTICIPANTE_NOMBRE1, memberName);
        int i = database.update(DBhelperSubparticipante.TABLE_SUBPARTICIPANTE, cvActualizar,
                DBhelperSubparticipante.SUBPARTICIPANTE_ID + " = " + memberID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperSubparticipante.TABLE_SUBPARTICIPANTE, DBhelperSubparticipante.SUBPARTICIPANTE_ID + "="
                + memberID, null);
    }
}