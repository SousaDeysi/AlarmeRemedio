package br.unip.alarmeremedio.Alarme.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import br.unip.alarmeremedio.Alarme.BancoDeDados.IdososDAO;
import br.unip.alarmeremedio.Alarme.POJO.Idosos;
import br.unip.alarmeremedio.R;

public class Tela_CadastroUsuario extends AppCompatActivity {
    private ImageView addImg;
    public String imagem;
    private EditText edtNome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__cadastro_usuario);
        addImg = (ImageView) findViewById(R.id.btn_ImgUsuario);
    }

    public void comeca(View v) {
     edtNome = (EditText) findViewById(R.id.edt_nomeUsuarios);

        Intent itent = new Intent(this,Tela_AutenticacaoUsuario.class);
        Bundle params = new Bundle();
        params.putString("nome", edtNome.getText().toString());
        params.putString("imagem", imagem);
        itent.putExtras(params);
        startActivity(itent);

        Idosos idosos = new Idosos();
        idosos.setNome_idoso(edtNome.getText().toString());
        idosos.setImagem(imagem);
        IdososDAO dao = new IdososDAO(getApplicationContext());
        dao.addIdoso(idosos);

        Toast.makeText(getApplicationContext(),"Idoso Adcionado",Toast.LENGTH_LONG).show();


    }


    public void addImagem(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(intent, "Selecione uma imagem"), 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {

            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            addImg.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            imagem = picturePath;
        }
    }

    public void salvar(View v) {


    }
}