package br.unip.alarmeremedio.Alarme.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.unip.alarmeremedio.Alarme.Adapter.AdapterMedicamentos;
import br.unip.alarmeremedio.Alarme.BancoDeDados.MedicamentoDAO;
import br.unip.alarmeremedio.Alarme.POJO.Medicamentos;
import br.unip.alarmeremedio.R;

public class Tela_logado extends AppCompatActivity {
    //private String[] Medicamento = new String[]{"AMOXILINA","RIVOTRIL","TROPINAL","INSULINA","METIFORMINA","OMEOPRAZOL"};
    private ListView listMedicamento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_logado);
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Medicamento);
         //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        listMedicamento= (ListView)findViewById(R.id.listaMedicamentos);

     //ListView listMed= (ListView)findViewById(R.id.listaMedicamentos);
       //  listMed.setAdapter(adapter);


    }


    public void novoMed(View v) {

        Intent it = new Intent(this, Tela_CadastroMedicamentos.class);
        startActivity(it);

    }

    public void ediPerfil(View v) {
        Intent it = new Intent(this, Tela_editarUsuario.class);
        startActivity(it);
    }



    protected void onResume(){
        super.onResume();

        MedicamentoDAO dao = new MedicamentoDAO(getApplicationContext());
        final List<Medicamentos> medicamento = dao.listarMedicamentos();
        ArrayAdapter<Medicamentos> adapter = new AdapterMedicamentos(this,android.R.layout.simple_list_item_1,medicamento);
        listMedicamento.setAdapter(adapter);
    }

}


