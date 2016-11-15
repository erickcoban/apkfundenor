package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorEtnoAlimentacion {

    private DBhelperEtnoAlimentacion dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorEtnoAlimentacion(Context c) {
        ourcontext = c;
    }

    public SQLControladorEtnoAlimentacion abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperEtnoAlimentacion(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idEtno, String concentrado, String tipoConcentrado, String otroAlimento, String fechaReg) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperEtnoAlimentacion.ALIMENTACION_ETNO, idEtno);
        cv.put(DBhelperEtnoAlimentacion.ALIMENTACION_CONCENTRADO, concentrado);
        cv.put(DBhelperEtnoAlimentacion.ALIMENTACION_TIPOCONCENTRADO, tipoConcentrado);
        cv.put(DBhelperEtnoAlimentacion.ALIMENTACION_OTRO, otroAlimento);
        cv.put(DBhelperEtnoAlimentacion.ALIMENTACION_FECHA, fechaReg);
        database.insert(DBhelperEtnoAlimentacion.TABLE_ALIMENTACION, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperEtnoAlimentacion.ALIMENTACION_ID,
                DBhelperEtnoAlimentacion.ALIMENTACION_ETNO,
                DBhelperEtnoAlimentacion.ALIMENTACION_CONCENTRADO,
                DBhelperEtnoAlimentacion.ALIMENTACION_TIPOCONCENTRADO,
                DBhelperEtnoAlimentacion.ALIMENTACION_OTRO,
                DBhelperEtnoAlimentacion.ALIMENTACION_FECHA
        };
        Cursor c = database.query(DBhelperEtnoAlimentacion.TABLE_ALIMENTACION, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long idEtno, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperEtnoAlimentacion.ALIMENTACION_ETNO, memberName);
        int i = database.update(DBhelperEtnoAlimentacion.TABLE_ALIMENTACION, cvActualizar,
                DBhelperEtnoAlimentacion.ALIMENTACION_ID + " = " + idEtno, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperEtnoAlimentacion.TABLE_ALIMENTACION, DBhelperEtnoAlimentacion.ALIMENTACION_ID + "="
                + memberID, null);
    }
}