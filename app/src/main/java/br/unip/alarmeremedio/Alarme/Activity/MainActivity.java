package br.unip.alarmeremedio.Alarme.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import br.unip.alarmeremedio.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void logar1(View v){
        Intent it  = new Intent(this,Tela_CadastroMedicamentos.class);
        startActivity(it);

    }
    public void addUsua2(View v){
        Intent it  = new Intent(this,Tela_CadastroMedicamentos.class);
        startActivity(it);

    }
    public void editaUsuario(View v){
        Intent it  = new Intent(this,Tela_editarUsuario.class);
        startActivity(it);

    }}
