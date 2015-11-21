package br.unip.alarmeremedio.Alarme.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.unip.alarmeremedio.Alarme.Adapter.AdapterMedicamentos;
import br.unip.alarmeremedio.Alarme.BancoDeDados.MedicamentoDAO;
import br.unip.alarmeremedio.Alarme.POJO.Medicamentos;
import br.unip.alarmeremedio.R;

public class LitarMedicamentos extends AppCompatActivity {
    private ListView listMedicamento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litar_medicamentos);
        listMedicamento= (ListView)findViewById(R.id.listaMedic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_litar_medicamentos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    protected void onResume(){
        super.onResume();

        MedicamentoDAO dao = new MedicamentoDAO(getApplicationContext());
        final List<Medicamentos> medicamento = dao.listarMedicamentos();
        ArrayAdapter<Medicamentos> adapter = new AdapterMedicamentos(this,android.R.layout.simple_list_item_1,medicamento);
        listMedicamento.setAdapter(adapter);
    }
}
