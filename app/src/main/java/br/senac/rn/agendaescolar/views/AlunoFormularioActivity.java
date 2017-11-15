package br.senac.rn.agendaescolar.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class AlunoFormularioActivity extends AppCompatActivity {

    private EditText txtNome, txtEndereco, txtFone, txtSite;
    private RatingBar txtNota;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_formulario);

        GerarComponentes();
        GerarEventos();
    }

    private  void Cadastrar(){
        Intent intAbraLista = new Intent(this,ListaAlunosActivity.class);
        startActivity(intAbraLista);
    }

    private void GerarEventos() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cadastrar();
            }
        });
    }

    protected void GerarComponentes() {
        txtNome = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtEndereco = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtFone = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtSite = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtNota = (RatingBar) findViewById(R.id.rtbNota_FormAluno);
        btnSalvar = (Button) findViewById(R.id.btnSalvar_FormAluno);
    }
}