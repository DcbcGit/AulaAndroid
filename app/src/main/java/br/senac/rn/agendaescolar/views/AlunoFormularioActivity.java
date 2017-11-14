package br.senac.rn.agendaescolar.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class AlunoFormularioActivity extends AppCompatActivity {

    EditText txtNome;
    EditText txtEndereco;
    EditText txtFone;
    EditText txtSite;
    RatingBar txtNota;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_formulario);
        GeraComponentes();
    }

    protected void GeraComponentes() {
        txtNome = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtEndereco = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtFone = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtSite = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtNota = (RatingBar) findViewById(R.id.rtbNota_FormAluno);
        btnSalvar = (Button) findViewById(R.id.btnSalvar_FormAluno);
    }
}