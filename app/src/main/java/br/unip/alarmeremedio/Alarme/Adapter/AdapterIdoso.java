package br.unip.alarmeremedio.Alarme.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.unip.alarmeremedio.Alarme.POJO.Idosos;
import br.unip.alarmeremedio.R;

/**
 * Created by Casa on 06/11/2015.
 */
public class AdapterIdoso extends ArrayAdapter<Idosos> {

    private final List<Idosos> idoso;
    private final Activity activity;

    public AdapterIdoso(Activity activity, int textViewResouceId, List<Idosos> idosos){
        super(activity,textViewResouceId,idosos);
        this.activity = activity;
        this.idoso = idosos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Idosos idosos = idoso.get(position);
        View view = activity.getLayoutInflater().inflate(R.layout.layout_adapter_idoso, null);
        TextView nome = (TextView)view.findViewById(R.id.nomeBD);
        nome.setText(idosos.getNome_idoso());

     return null;
    }

    @Override
    public long getItemId(int position) {
        return idoso.get(position).getId();
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public Idosos getItem(int position) {
        return idoso.get(position);
    }
}
