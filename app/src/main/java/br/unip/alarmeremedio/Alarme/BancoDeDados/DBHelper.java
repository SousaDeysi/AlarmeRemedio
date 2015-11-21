package br.unip.alarmeremedio.Alarme.BancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Deysiane on 25/10/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "DBIdosos";
    private static int VERSAO = 1;
    public DBHelper(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlIdoso = "CREATE TABLE idosos("+
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT"+
                ",nomeIdoso TEXT NOT NULL"+
                ",imagem TEXT NOT NULL"+
                ");";
        db.execSQL(sqlIdoso);

       String sqlMedicamento = "CREATE TABLE medicamentos("+
                "_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT"+
                ",nomeMedicamento TEXT NOT NULL"+
                ",quatMedic INTEGER"+
                ",formaFarma TEXT"+
                ",horaInicio TEXT"+
                ",periodo TEXT"+
                ",qtdDias_mes INTEGER"+
                ",mes INTEGER"+
                ",dia INTEGER"+
                ",usoContinuo INTEGER"+
                ",idoso_id INTEGER REFERENCES idosos (_id)"+
                ");";
        db.execSQL(sqlMedicamento);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sqlIdoso = "DROP TABLE IF EXISTS idosos";
        db.execSQL(sqlIdoso);
        onCreate(db);

        String sqlMedicamento = "DROP TABLE IF EXISTS medicamentos";
        db.execSQL(sqlMedicamento);
        onCreate(db);
    }
}
