package br.unip.alarmeremedio.Alarme.BancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.unip.alarmeremedio.Alarme.POJO.Medicamentos;

/**
 * Created by Casa on 04/11/2015.
 */
public class MedicamentoDAO {

    private DBHelper dbHelper;
    private Context context;

    public MedicamentoDAO(Context context){
        dbHelper = new DBHelper(context);
        this.context = context;
    }

    public void addMedicamento(Medicamentos medicamentos){
        ContentValues valores = new ContentValues();
        valores.put("nomeMedicamento",medicamentos.getNomeMedicamento());
        valores.put("formaFarma",medicamentos.getFormaFarma());
        valores.put("quatMedic",medicamentos.getQtdMedi());
        valores.put("horaInicio",medicamentos.getHoraInicio());
        valores.put("periodo",medicamentos.getPeriodo());
        valores.put("qtdDias_mes",medicamentos.getQuatDias_Mes());
        valores.put("mes",medicamentos.isMes());
        valores.put("dia",medicamentos.isDias());
        valores.put("usoContinuo",medicamentos.isUsoContinuo());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert("medicamentos", null, valores);
        db.close();
    }

    public List<Medicamentos> listarMedicamentos(){
        List<Medicamentos> medicamentos = new ArrayList<Medicamentos>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor c = db.query("medicamentos", null, null, null, null, null, "nomeMedicamento ASC");
        try {
            while (c.moveToNext()){
                Medicamentos med = new Medicamentos();
                med.setId(c.getLong(c.getColumnIndex("_id")));
                med.setNomeMedicamento(c.getString(c.getColumnIndex("nomeMedicamento")));
                med.setFormaFarma(c.getString(c.getColumnIndex("formaFarma")));
                med.setQtdMedi(c.getInt(c.getColumnIndex("quatMedic")));
                med.setHoraInicio(c.getInt(c.getColumnIndex("horaInicio")));
                med.setPeriodo(c.getString(c.getColumnIndex("periodo")));
                med.setQuatDias_Mes(c.getInt(c.getColumnIndex("qtdDias_mes")));
                boolean mes = c.getInt(c.getColumnIndex("mes"))==1? true:false;
                med.setMes(mes);
                boolean dias = c.getInt(c.getColumnIndex("dia"))==1? true:false;
                med.setDias(dias);
                boolean usoContinuo = c.getInt(c.getColumnIndex("usoContinuo"))==1? true:false;
                med.setUsoContinuo(usoContinuo);
                medicamentos.add(med);

            }

        }finally {
            c.close();
        }db.close();
        return medicamentos;
    }
}
