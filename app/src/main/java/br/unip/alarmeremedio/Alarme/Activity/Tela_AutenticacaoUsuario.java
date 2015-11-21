package br.unip.alarmeremedio.Alarme.Activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.unip.alarmeremedio.R;

public class Tela_AutenticacaoUsuario extends AppCompatActivity{

    private ImageView imgIdoso1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__autenticacao_usuario);


        Intent it = getIntent();
        if(it !=null){
            Bundle params = it.getExtras();
            if (params != null){
                String nomeIdoso = params.getString("nome");
                String imagem = params.getString("imagem");
                TextView tvNome = (TextView)findViewById(R.id.txt_nomeUsuario1);
                tvNome.setText(nomeIdoso);
                ImageView img1 =(ImageView)findViewById(R.id.btn_usuario1);
                img1.setImageBitmap(BitmapFactory.decodeFile(imagem));
            }
        }

    }


    public void addUsua2(View v){
        Intent it  = new Intent(this,Tela_CadastroUsuario.class);
        startActivity(it);

    }
    public void editaUsuario(View v){
        Intent it  = new Intent(this,Tela_logado.class);

        startActivity(it);

    }



}
