package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorParticipante {

    private DBhelperParticipante dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorParticipante(Context c) {
        ourcontext = c;
    }

    public SQLControladorParticipante abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperParticipante(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String nombre1P, String nombre2P, String nombre3P, String apellido1P,
                              String apellido2P, String apellidoCP, String generoP, String fechaNacP,
                              String cuiP, String gradoAP, String estadoCP, String cargoCP, String idiomaP,
                              String oficioP, String religion, String grupoP, String tenenciaTP, String certezaP,
                              String medidaTP, String ingresoEP, String fechaRegP) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperParticipante.PARTICIPANTE_NOMBRE1, nombre1P);
        cv.put(DBhelperParticipante.PARTICIPANTE_NOMBRE2, nombre2P);
        cv.put(DBhelperParticipante.PARTICIPANTE_NOMBRE3, nombre3P);
        cv.put(DBhelperParticipante.PARTICIPANTE_APELLIDO1, apellido1P);
        cv.put(DBhelperParticipante.PARTICIPANTE_APELLIDO2, apellido2P);
        cv.put(DBhelperParticipante.PARTICIPANTE_APELLIDOC, apellidoCP);
        cv.put(DBhelperParticipante.PARTICIPANTE_GENERO, generoP);
        cv.put(DBhelperParticipante.PARTICIPANTE_FECHANAC, fechaNacP);
        cv.put(DBhelperParticipante.PARTICIPANTE_CUI, cuiP);
        cv.put(DBhelperParticipante.PARTICIPANTE_GRADOACA, gradoAP);
        cv.put(DBhelperParticipante.PARTICIPANTE_ESTADOCIV, estadoCP);
        cv.put(DBhelperParticipante.PARTICIPANTE_CARGOCOM, cargoCP);
        cv.put(DBhelperParticipante.PARTICIPANTE_IDIOMA, idiomaP);
        cv.put(DBhelperParticipante.PARTICIPANTE_OFICIO, oficioP);
        cv.put(DBhelperParticipante.PARTICIPANTE_RELIGION, religion);
        cv.put(DBhelperParticipante.PARTICIPANTE_GRUPO, grupoP);
        cv.put(DBhelperParticipante.PARTICIPANTE_TENECIAT, tenenciaTP);
        cv.put(DBhelperParticipante.PARTICIPANTE_CERTEZA, certezaP);
        cv.put(DBhelperParticipante.PARTICIPANTE_MEDIDAT, medidaTP);
        cv.put(DBhelperParticipante.PARTICIPANTE_INGRESOE, ingresoEP);
        cv.put(DBhelperParticipante.PARTICIPANTE_FECHAREG, fechaRegP);
        database.insert(DBhelperParticipante.TABLE_PARTICIPANTE, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperParticipante.PARTICIPANTE_ID,
                DBhelperParticipante.PARTICIPANTE_NOMBRE1,
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
        Cursor c = database.query(DBhelperParticipante.TABLE_PARTICIPANTE, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long memberID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperParticipante.PARTICIPANTE_NOMBRE1, memberName);
        int i = database.update(DBhelperParticipante.TABLE_PARTICIPANTE, cvActualizar,
                DBhelperParticipante.PARTICIPANTE_ID + " = " + memberID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperParticipante.TABLE_PARTICIPANTE, DBhelperParticipante.PARTICIPANTE_ID + "="
                + memberID, null);
    }
}