package br.unip.alarmeremedio.Alarme.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.unip.alarmeremedio.Alarme.POJO.Medicamentos;
import br.unip.alarmeremedio.R;

/**
 * Created by Casa on 09/11/2015.
 */
public class AdapterMedicamentos extends ArrayAdapter<Medicamentos> {

    private final List<Medicamentos> medicamentos;
    private final Activity activity;


    public AdapterMedicamentos(Activity activity, int textViewResouceId, List<Medicamentos> medicamentos){
        super(activity,textViewResouceId,medicamentos);

        /*List de Medicamentos do Pojo Medicamentos que é recebida como parametro pelo construtor da classe*/
        this.medicamentos = medicamentos;
        this.activity = activity;
    }
    /*Esse método é usado para consultar os dados no banco*/
    @Override
    public View getView (int posicao, View covertView, ViewGroup parent){

        /*Recebe cada medicamento da classe POJO medicamento  e pega a sua posição*/

        Medicamentos medicamento = medicamentos.get(posicao);

        View view = activity.getLayoutInflater().inflate(R.layout.item_medicamentos, null);

        TextView nm_med = (TextView)view.findViewById(R.id.txtNMmedicamento);
        nm_med.setText(medicamento.getNomeMedicamento());

        ImageView imgStatus = (ImageView)view.findViewById(R.id.statusMedicamento);
        imgStatus.setImageResource(R.drawable.botaocor1);

        return view;
    }
    @Override
    public long getItemId(int posicao){
        return medicamentos.get(posicao).getId();
    }

    @Override
    public int getCount(){
        return super.getCount();
    }
    @Override
    public Medicamentos getItem(int posicao){
        return medicamentos.get(posicao);
    }
}
