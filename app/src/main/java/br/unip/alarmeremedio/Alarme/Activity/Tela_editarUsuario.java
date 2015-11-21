package br.unip.alarmeremedio.Alarme.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.unip.alarmeremedio.R;

public class Tela_editarUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_editar_usuario);
    }

   public void escolher (View v){
       Intent it  = new Intent(this,Tela_escolheImagem.class);
       startActivity(it);

   }
    public void comecar (View v){
        Intent it  = new Intent(this,Tela_logado.class);
        startActivity(it);

    }

}
