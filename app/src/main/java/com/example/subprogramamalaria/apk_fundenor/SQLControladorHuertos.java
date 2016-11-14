package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorHuertos {

    private DBhelperHuertos dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorHuertos(Context c) {
        ourcontext = c;
    }

    public SQLControladorHuertos abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperHuertos(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idFam, String tamano, String fechaImp, String buenaPrac, String ingresoSem, String manttoTie,
                              String produccionOrg, String practicaAgua, String fechaHue) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperHuertos.HUERTO_IDFAM, idFam);
        cv.put(DBhelperHuertos.HUERTO_NOMBRE, tamano);
        cv.put(DBhelperHuertos.HUERTO_FECHA, fechaImp);
        cv.put(DBhelperHuertos.HUERTO_BUENAP, buenaPrac);
        cv.put(DBhelperHuertos.HUERTO_INGRESOS, ingresoSem);
        cv.put(DBhelperHuertos.HUERTO_MANTTOT, manttoTie);
        cv.put(DBhelperHuertos.HUERTO_PRODUCCIONORG, produccionOrg);
        cv.put(DBhelperHuertos.HUERTO_PRACTICAAGUA, practicaAgua);
        cv.put(DBhelperHuertos.HUERTO_FECHAHUERTO, fechaHue);
        database.insert(DBhelperHuertos.TABLE_HUERTOS, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperHuertos.HUERTO_ID,
                DBhelperHuertos.HUERTO_IDFAM,
                DBhelperHuertos.HUERTO_NOMBRE,
                DBhelperHuertos.HUERTO_FECHA,
                DBhelperHuertos.HUERTO_BUENAP,
                DBhelperHuertos.HUERTO_INGRESOS,
                DBhelperHuertos.HUERTO_MANTTOT,
                DBhelperHuertos.HUERTO_PRODUCCIONORG,
                DBhelperHuertos.HUERTO_PRACTICAAGUA,
                DBhelperHuertos.HUERTO_FECHAHUERTO
        };
        Cursor c = database.query(DBhelperHuertos.TABLE_HUERTOS, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long memberID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperHuertos.HUERTO_NOMBRE, memberName);
        int i = database.update(DBhelperHuertos.TABLE_HUERTOS, cvActualizar,
                DBhelperHuertos.HUERTO_ID + " = " + memberID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperHuertos.TABLE_HUERTOS, DBhelperHuertos.HUERTO_ID + "="
                + memberID, null);
    }
}