package br.unip.alarmeremedio.Alarme.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TimePicker;
import android.widget.Toast;

import br.unip.alarmeremedio.Alarme.BancoDeDados.MedicamentoDAO;
import br.unip.alarmeremedio.Alarme.POJO.Medicamentos;
import br.unip.alarmeremedio.R;

public class Tela_CadastroMedicamentos extends AppCompatActivity {


    private String[] formaFarmaceutica = new String[]{"Comprimido", "gotas", "injeção", "capsulas"};
    private String[] tipoMedicamento = new String[]{"Comprimido", "gotas", "injeção", "capsulas"};
    private String[] periodo = new String[]{"De 4 em 4 horas", "De 6 em 6 horas", "De 8 em 8 horas", "De 12 em 12 horas", "A cada 24 horas", "Uma vez por semana"};
    private Spinner spTipoMed;
    private Spinner spPeriodo;
    private TabHost tb;
    private EditText edtNome_med;
    private EditText qtd_med;
    private EditText qtd_tempoUso;
    private CheckBox checkMes;
    private CheckBox checkDias;
    private RadioButton radioUsoContinuo;
    private String farmaForma;
    private String perido;
    private CheckBox checkLembreMe;
    private Spinner farmaFormaLembre;
    private EditText etdQtdTotal;
    private TimePicker hora_inicio;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
       requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__cadastro_medicamentos);


        etdQtdTotal = (EditText) findViewById(R.id.etdQtdTotal);
        checkLembreMe = (CheckBox)findViewById(R.id.checkBox);
        edtNome_med = (EditText)findViewById(R.id.edt_nomeMedicamento);
        qtd_med = (EditText) findViewById(R.id.edt_qtdMedicamento);
        qtd_tempoUso = (EditText) findViewById(R.id.edt_qtdtempo);
        checkMes = (CheckBox)findViewById(R.id.ckMes);
        checkDias = (CheckBox)findViewById(R.id.ckDias);
        radioUsoContinuo = (RadioButton)findViewById(R.id.rdUsoContinuo);
        hora_inicio = (TimePicker) findViewById(R.id.timePicker);


        checkLembreMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                habilitaLembrete(isChecked);
            }
        });




           ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tipoMedicamento);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spTipoMed = (Spinner) findViewById(R.id.tipoMedicamento);
        spTipoMed.setAdapter(adapter);
        spTipoMed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    farmaForma = "Comprimido";

                }
                if (position == 1) {

                    farmaForma = "Gotas";

                }
                if (position == 2) {

                    farmaForma = "Injeção";

                }
                if (position == 3) {

                    farmaForma = "Cápsulas";

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, formaFarmaceutica);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        farmaFormaLembre = (Spinner) findViewById(R.id.spformaFarma);
        farmaFormaLembre.setAdapter(adapter2);
        farmaFormaLembre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    farmaForma = "Comprimido";

                }
                if (position == 1) {

                    farmaForma = "Gotas";

                }
                if (position == 2) {

                    farmaForma = "Injeção";

                }
                if (position == 3) {

                    farmaForma = "Cápsulas";

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, periodo);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spPeriodo = (Spinner) findViewById(R.id.spinner_periodo);
        spPeriodo.setAdapter(adapter1);

        spPeriodo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    perido = "De 4 em 4 horas";

                }
                if (position == 1) {

                    perido = "De 6 em 6 horas";

                }
                if (position == 2) {

                    perido = "De 8 em 8 horas";

                }
                if (position == 3) {

                    perido = "De 12 em 12 horas";

                }
                if (position == 4) {

                    perido = "A cada 24 horas";

                }
                if (position == 5) {

                    perido = "1 vez por semana";

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
    public void salvaMedicamento(View v){
      Medicamentos medicamentos = new Medicamentos();
        medicamentos.setNomeMedicamento(edtNome_med.getText().toString());
        medicamentos.setFormaFarma(farmaForma);
        medicamentos.setQtdMedi(qtd_med.getText().length());
        medicamentos.setPeriodo(perido);
        medicamentos.setQuatDias_Mes(qtd_tempoUso.getText().length());



        MedicamentoDAO dao = new MedicamentoDAO(getApplicationContext());
        dao.addMedicamento(medicamentos);



        Toast.makeText(getApplicationContext(),"Medicamento Adcionado",Toast.LENGTH_LONG).show();
        finish();




    }

    public void habilitaLembrete(boolean lembrete){
        if (lembrete){

            farmaFormaLembre.setVisibility(View.VISIBLE);
            etdQtdTotal.setVisibility(View.VISIBLE);
        }

        else {

            farmaFormaLembre.setVisibility(View.GONE);
            etdQtdTotal.setVisibility(View.GONE);
        }

    }





}