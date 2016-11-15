package com.example.subprogramamalaria.apk_fundenor;

/**
 * Created by Subprograma Malaria on 05/11/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControladorEntoProduccion {

    private DBhelperEtnoProduccion dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControladorEntoProduccion(Context c) {
        ourcontext = c;
    }

    public SQLControladorEntoProduccion abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelperEtnoProduccion(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String idEnto, String produc, String cantGalli, String prodGalli, String vendeGalli, String consuGalli, String cantGallo, String prodGallo,
                              String vendeGallo, String consuGallo, String cantPolli, String prodPolli, String vendePolli, String consuPolli, String  cantPatos,
                              String prodPatos, String vendePatos, String consuPatos, String cantPatas, String prodPatas, String vendePatas, String consuPatas,
                              String cantChuntas, String prodChuntas, String vendeChuntas, String consuChuntas, String cantChuntos, String prodChuntos, String vendeChuntos,
                              String consuChuntos, String cantChuntios, String prodChuntios, String vendeChuntios, String consuChuntios, String aveEncerrada, String fechaRegProd) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelperEtnoProduccion.PRODUCCION_IDETNO, idEnto);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_PRODUCCION, produc);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CANTGALLINA, cantGalli);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_PRODGALLINA, prodGalli);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_VENDEGALLINA, vendeGalli);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CONSUGALLINA, consuGalli);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CANTGALLOS, cantGallo);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_PRODGALLOS, prodGallo);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_VENDEGALLOS, vendeGallo);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CONSUGALLOS, consuGallo);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CANTPOLLITOS, cantPolli);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_PRODPOLLITOS, prodPolli);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_VENDEPOLLITOS, vendePolli);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CONSUPOLLITOS, consuPolli);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CANTPATOS, cantPatos);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_PRODPATOS, prodPatos);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_VENDEPATOS, vendePatos);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CONSUPATOS, consuPatos);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CANTPATAS, cantPatas);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_PRODPATAS, prodPatas);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_VENDEPATAS, vendePatas);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CONSUPATAS, consuPatas);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CANTCHUNTAS, cantChuntas);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_PRODCHUNTAS, prodChuntas);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_VENDECHUNTAS, vendeChuntas);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CONSUCHUNTAS, consuChuntas);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CANTCHUNTOS, cantChuntos);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_PRODCHUNTOS, prodChuntos);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_VENDECHUNTOS, vendeChuntos);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CONSUCHUNTOS, consuChuntos);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CANTCHUNTIOS, cantChuntios);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_PRODCHUNTIOS, prodChuntios);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_VENDECHUNTIOS, vendeChuntios);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_CONSUCHUNTIOS, consuChuntios);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_AVEENCERRADA, aveEncerrada);
        cv.put(DBhelperEtnoProduccion.PRODUCCION_FECHAREG, fechaRegProd);
        database.insert(DBhelperEtnoProduccion.TABLE_PRODUCCION, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelperEtnoProduccion.PRODUCCION_ID,
                DBhelperEtnoProduccion.PRODUCCION_IDETNO,
                DBhelperEtnoProduccion.PRODUCCION_PRODUCCION,
                DBhelperEtnoProduccion.PRODUCCION_CANTGALLINA,
                DBhelperEtnoProduccion.PRODUCCION_PRODGALLINA,
                DBhelperEtnoProduccion.PRODUCCION_VENDEGALLINA,
                DBhelperEtnoProduccion.PRODUCCION_CONSUGALLINA,
                DBhelperEtnoProduccion.PRODUCCION_CANTGALLOS,
                DBhelperEtnoProduccion.PRODUCCION_PRODGALLOS,
                DBhelperEtnoProduccion.PRODUCCION_VENDEGALLOS,
                DBhelperEtnoProduccion.PRODUCCION_CONSUGALLOS,
                DBhelperEtnoProduccion.PRODUCCION_CANTPOLLITOS,
                DBhelperEtnoProduccion.PRODUCCION_PRODPOLLITOS,
                DBhelperEtnoProduccion.PRODUCCION_VENDEPOLLITOS,
                DBhelperEtnoProduccion.PRODUCCION_CONSUPOLLITOS,
                DBhelperEtnoProduccion.PRODUCCION_CANTPATOS,
                DBhelperEtnoProduccion.PRODUCCION_PRODPATOS,
                DBhelperEtnoProduccion.PRODUCCION_VENDEPATOS,
                DBhelperEtnoProduccion.PRODUCCION_CONSUPATOS,
                DBhelperEtnoProduccion.PRODUCCION_CANTPATAS,
                DBhelperEtnoProduccion.PRODUCCION_PRODPATAS,
                DBhelperEtnoProduccion.PRODUCCION_VENDEPATAS,
                DBhelperEtnoProduccion.PRODUCCION_CONSUPATAS,
                DBhelperEtnoProduccion.PRODUCCION_CANTCHUNTAS,
                DBhelperEtnoProduccion.PRODUCCION_PRODCHUNTAS,
                DBhelperEtnoProduccion.PRODUCCION_VENDECHUNTAS,
                DBhelperEtnoProduccion.PRODUCCION_CONSUCHUNTAS,
                DBhelperEtnoProduccion.PRODUCCION_CANTCHUNTOS,
                DBhelperEtnoProduccion.PRODUCCION_PRODCHUNTOS,
                DBhelperEtnoProduccion.PRODUCCION_VENDECHUNTOS,
                DBhelperEtnoProduccion.PRODUCCION_CONSUCHUNTOS,
                DBhelperEtnoProduccion.PRODUCCION_CANTCHUNTIOS,
                DBhelperEtnoProduccion.PRODUCCION_PRODCHUNTIOS,
                DBhelperEtnoProduccion.PRODUCCION_VENDECHUNTIOS,
                DBhelperEtnoProduccion.PRODUCCION_CONSUCHUNTIOS,
                DBhelperEtnoProduccion.PRODUCCION_AVEENCERRADA,
                DBhelperEtnoProduccion.PRODUCCION_FECHAREG
        };
        Cursor c = database.query(DBhelperEtnoProduccion.TABLE_PRODUCCION, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long idProd, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelperEtnoProduccion.PRODUCCION_PRODUCCION, memberName);
        int i = database.update(DBhelperEtnoProduccion.TABLE_PRODUCCION, cvActualizar,
                DBhelperEtnoProduccion.PRODUCCION_ID + " = " + idProd, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelperEtnoProduccion.TABLE_PRODUCCION, DBhelperEtnoProduccion.PRODUCCION_ID + "="
                + memberID, null);
    }
}