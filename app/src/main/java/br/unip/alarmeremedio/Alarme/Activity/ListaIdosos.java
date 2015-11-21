package br.unip.alarmeremedio.Alarme.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.unip.alarmeremedio.Alarme.Adapter.AdapterIdoso;
import br.unip.alarmeremedio.Alarme.BancoDeDados.IdososDAO;
import br.unip.alarmeremedio.Alarme.POJO.Idosos;
import br.unip.alarmeremedio.R;

public class ListaIdosos extends AppCompatActivity {
    private ListView listaIdosos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_idosos);

        listaIdosos = (ListView)findViewById(R.id.listView);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IdososDAO dao = new IdososDAO(getApplicationContext());
        final List<Idosos> idoso = dao.listarIdosos();
        ArrayAdapter<Idosos> adapter = new AdapterIdoso(this,android.R.layout.simple_list_item_activated_1,idoso);

        listaIdosos.setAdapter(adapter);

    }

}
