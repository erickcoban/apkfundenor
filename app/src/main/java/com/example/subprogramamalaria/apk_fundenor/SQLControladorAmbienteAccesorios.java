package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorAmbienteAccesorios {

    private DBhelperAmbienteAccesorios dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorAmbienteAccesorios(Context c) {
        ourcontext = c;
    }

    public SQLControladorAmbienteAccesorios abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperAmbienteAccesorios(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idAmbiente, String ambiente, String accesoHabitacion, String accesoCocina, String accesoLetrina,
                              String accesoDucha, String accesoLavadero,String fechaRegAcceso) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperAmbienteAccesorios.ACCESORIO_IDAMBIENTE, idAmbiente);
        cv.put(DBhelperAmbienteAccesorios.ACCESORIO_AMBIENTE, ambiente);
        cv.put(DBhelperAmbienteAccesorios.ACCESORIO_HABITACION , accesoHabitacion);
        cv.put(DBhelperAmbienteAccesorios.ACCESORIO_COCINA, accesoCocina);
        cv.put(DBhelperAmbienteAccesorios.ACCESORIO_LETRINA, accesoLetrina);
        cv.put(DBhelperAmbienteAccesorios.ACCESORIO_DUCHA, accesoDucha);
        cv.put(DBhelperAmbienteAccesorios.ACCESORIO_LAVA, accesoLavadero);
        cv.put(DBhelperAmbienteAccesorios.ACCESORIO_FECHA, fechaRegAcceso);
        database.insert(DBhelperAmbienteAccesorios.TABLE_ACCESORIOS, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperAmbienteAccesorios.ACCESORIO_ID,
                DBhelperAmbienteAccesorios.ACCESORIO_IDAMBIENTE,
                DBhelperAmbienteAccesorios.ACCESORIO_AMBIENTE,
                DBhelperAmbienteAccesorios.ACCESORIO_HABITACION,
                DBhelperAmbienteAccesorios.ACCESORIO_COCINA,
                DBhelperAmbienteAccesorios.ACCESORIO_LETRINA,
                DBhelperAmbienteAccesorios.ACCESORIO_DUCHA,
                DBhelperAmbienteAccesorios.ACCESORIO_LAVA,
                DBhelperAmbienteAccesorios.ACCESORIO_FECHA

        };
        Cursor c = database.query(DBhelperAmbienteAccesorios.TABLE_ACCESORIOS, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long viviendaID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperAmbienteAccesorios.ACCESORIO_IDAMBIENTE, memberName);
        int i = database.update(DBhelperAmbienteAccesorios.TABLE_ACCESORIOS, cvActualizar,
                DBhelperAmbienteAccesorios.ACCESORIO_ID + " = " + viviendaID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperAmbienteAccesorios.TABLE_ACCESORIOS, DBhelperAmbienteAccesorios.ACCESORIO_ID + "="
                + memberID, null);
    }
}