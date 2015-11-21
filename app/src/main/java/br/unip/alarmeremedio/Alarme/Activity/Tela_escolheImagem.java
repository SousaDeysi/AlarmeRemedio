package br.unip.alarmeremedio.Alarme.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.unip.alarmeremedio.R;

public class Tela_escolheImagem extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_escolhe_imagem);


    }

    public void img1(View v){
        Intent it  = new Intent(this,Tela_CadastroUsuario.class);



        startActivity(it);

    }

    }
