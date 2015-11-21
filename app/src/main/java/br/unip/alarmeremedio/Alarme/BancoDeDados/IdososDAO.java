package br.unip.alarmeremedio.Alarme.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.unip.alarmeremedio.Alarme.POJO.Idosos;



public class IdososDAO  {
    private DBHelper dbHelper;
    private Context ctx;

    public IdososDAO(Context context){
        dbHelper = new DBHelper(context);
        this.ctx = context;
    }

    public void addIdoso(Idosos idoso){
        ContentValues valores = new ContentValues();
        valores.put("nomeIdoso",idoso.getNome_idoso());
        valores.put("imagem", idoso.getImagem());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert("idosos", null, valores);
        db.close();
    }

    public List<Idosos> listarIdosos(){
        List<Idosos> idosos = new ArrayList<Idosos>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.query("idosos", null, null, null, null, null, "nomeIdoso ASC");
        try {
            while (c.moveToNext()){
                Idosos idoso = new Idosos();
                idoso.setId(c.getLong(c.getColumnIndex("_id")));
                idoso.setNome_idoso(c.getString(c.getColumnIndex("nome_idoso")));
                idoso.setImagem(c.getString(c.getColumnIndex("imagem")));
                idosos.add(idoso);

        }

    }finally {
            c.close();
        }db.close();
        return idosos;
        }



}
