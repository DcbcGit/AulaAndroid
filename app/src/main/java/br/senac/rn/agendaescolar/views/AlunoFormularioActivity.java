package br.senac.rn.agendaescolar.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import br.senac.rn.agendaescolar.daos.AlunoDao;
import br.senac.rn.agendaescolar.models.Aluno;

public class AlunoFormularioActivity extends AppCompatActivity {

    private EditText txtNome, txtEndereco, txtFone, txtSite;
    private ImageView imgAluno;
    private RatingBar txtNota;
    private Button btnSalvar;
    private Aluno alunoEdicao;

    static final int REQUEST_IMAGE_CAPTURE = 1337;
    private Uri uriImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_formulario);

        gerarComponentes();
        geraEventos();
        setAlunoTela();
    }

    protected void setAlunoTela() {
        Intent itent = getIntent();
        alunoEdicao = (Aluno) itent.getSerializableExtra("aluno");
        if (alunoEdicao != null) {
            txtNome.setText(alunoEdicao.getNome());
            txtEndereco.setText(alunoEdicao.getEndereco());
            txtFone.setText(alunoEdicao.getFone());
            txtSite.setText(alunoEdicao.getSite());
            txtNota.setProgress((int) alunoEdicao.getNota());

            this.setTitle("Editar Aluno: " + alunoEdicao.getNome());
        }
    }

    protected void geraEventos() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarTela();
                carregaTela();
            }
        });

        imgAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (ActivityCompat.checkSelfPermission(AlunoFormularioActivity.this, MediaStore.ACTION_IMAGE_CAPTURE) != PackageManager.PERMISSION_GRANTED) {
                //  ActivityCompat.requestPermissions(AlunoFormularioActivity.this, new String[]{MediaStore.ACTION_IMAGE_CAPTURE}, 2);
                //} else {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriImagem);
                // if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                //  }
                //}
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            imgAluno.setImageBitmap(imageBitmap);

            escreveImagens(imageBitmap);
        }
    }

    public void escreveImagens(Bitmap bmp){
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);

            byte[] bytes = stream.toByteArray();
            String nomeArquivo = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/Camera/image.png";

            Toast.makeText(this,nomeArquivo,Toast.LENGTH_LONG).show();

            FileOutputStream fos = new FileOutputStream(nomeArquivo);
            fos.write(bytes);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Aluno pegaDadosTela() {
        Aluno aluno = alunoEdicao == null ? new Aluno() : alunoEdicao;

        aluno.setNome(txtNome.getText().toString());
        aluno.setEndereco(txtEndereco.getText().toString());
        aluno.setSite(txtSite.getText().toString());
        aluno.setFone(txtFone.getText().toString());
        aluno.setNota(txtNota.getProgress());

        return aluno;
    }

    protected void salvarTela() {
        AlunoDao aluDao = new AlunoDao(this);

        Aluno aluRet = pegaDadosTela();
        if (aluRet.getId() == 0)
            aluDao.inserir(aluRet);
        else
            aluDao.atualiza(aluRet);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //finish();
    }

    protected void carregaTela() {
        finish();
        //Intent intAbraLista = new Intent(this, ListaAlunosActivity.class);
        //startActivity(intAbraLista);
    }

    protected void gerarComponentes() {
        txtNome = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtEndereco = (EditText) findViewById(R.id.txtEndereco_FormAluno);
        txtFone = (EditText) findViewById(R.id.txtFone_FormAluno);
        txtSite = (EditText) findViewById(R.id.txtSite_FormAluno);
        txtNota = (RatingBar) findViewById(R.id.rtbNota_FormAluno);
        btnSalvar = (Button) findViewById(R.id.btnSalvar_FormAluno);
        imgAluno = (ImageView) findViewById(R.id.imgAluno_FormAluno);
    }
}