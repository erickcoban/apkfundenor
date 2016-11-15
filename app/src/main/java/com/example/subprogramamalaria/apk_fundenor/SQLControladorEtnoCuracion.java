package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorEtnoCuracion {

    private DBhelperEtnoCuracion dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorEtnoCuracion(Context c) {
        ourcontext = c;
    }

    public SQLControladorEtnoCuracion abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperEtnoCuracion(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idEtno, String enfermedadComun, String tipoMedicamento, String tipoVacuna,
                              String noVacuna, String quienVacuna, String ultimaVacunaMes,String mesesMuerte,
                              String promedioMuerte, String fechaReg) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperEtnoCuracion.CURACION_ETNO, idEtno);
        cv.put(DBhelperEtnoCuracion.CURACION_ENFECOMUN, enfermedadComun);
        cv.put(DBhelperEtnoCuracion.CURACION_TIPOMED, tipoMedicamento);
        cv.put(DBhelperEtnoCuracion.CURACION_TIPOVAC, tipoVacuna);
        cv.put(DBhelperEtnoCuracion.CURACION_NOVACUNA, noVacuna);
        cv.put(DBhelperEtnoCuracion.CURACION_QUIENVAC, quienVacuna);
        cv.put(DBhelperEtnoCuracion.CURACION_ULTIMOMES, ultimaVacunaMes);
        cv.put(DBhelperEtnoCuracion.CURACION_MUERTE, mesesMuerte);
        cv.put(DBhelperEtnoCuracion.CURACION_PROMMUERTE, promedioMuerte);
        cv.put(DBhelperEtnoCuracion.CURACION_FECHA, fechaReg);
        database.insert(DBhelperEtnoCuracion.TABLE_CURACION, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperEtnoCuracion.CURACION_ID,
                DBhelperEtnoCuracion.CURACION_ETNO,
                DBhelperEtnoCuracion.CURACION_ENFECOMUN,
                DBhelperEtnoCuracion.CURACION_TIPOMED,
                DBhelperEtnoCuracion.CURACION_TIPOVAC,
                DBhelperEtnoCuracion.CURACION_NOVACUNA,
                DBhelperEtnoCuracion.CURACION_QUIENVAC,
                DBhelperEtnoCuracion.CURACION_ULTIMOMES,
                DBhelperEtnoCuracion.CURACION_MUERTE,
                DBhelperEtnoCuracion.CURACION_PROMMUERTE,
                DBhelperEtnoCuracion.CURACION_FECHA
        };
        Cursor c = database.query(DBhelperEtnoOtrosAnimales.TABLE_ANIMALES, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long idEtno, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperEtnoOtrosAnimales.ANIMALES_NOMBRE, memberName);
        int i = database.update(DBhelperEtnoOtrosAnimales.TABLE_ANIMALES, cvActualizar,
                DBhelperEtnoOtrosAnimales.ANIMALES_ID + " = " + idEtno, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperEtnoOtrosAnimales.TABLE_ANIMALES, DBhelperEtnoOtrosAnimales.ANIMALES_ID + "="
                + memberID, null);
    }
}