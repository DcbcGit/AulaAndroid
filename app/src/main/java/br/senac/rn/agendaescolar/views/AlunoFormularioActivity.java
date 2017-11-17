package br.senac.rn.agendaescolar.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import br.senac.rn.agendaescolar.daos.AlunoDao;
import br.senac.rn.agendaescolar.models.Aluno;

public class AlunoFormularioActivity extends AppCompatActivity {

    private EditText txtNome, txtEndereco, txtFone, txtSite;
    private RatingBar txtNota;
    private Button btnSalvar;
    private Aluno alunoEdicao;

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
            txtNota.setRating((float) alunoEdicao.getNota());
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
    }

    protected Aluno pegaDadosTela() {
        Aluno aluno = new Aluno();
        aluno.setNome(txtNome.getText().toString());
        aluno.setEndereco(txtEndereco.getText().toString());
        aluno.setSite(txtSite.getText().toString());
        aluno.setFone(txtFone.getText().toString());
        aluno.setNota(txtNota.getRating());

        return aluno;
    }

    protected void salvarTela() {
        AlunoDao aluDao = new AlunoDao(this);
        aluDao.inserir(pegaDadosTela());
    }

    protected void carregaTela() {
        Intent intAbraLista = new Intent(this, ListaAlunosActivity.class);
        startActivity(intAbraLista);
    }

    protected void gerarComponentes() {
        txtNome = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtEndereco = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtFone = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtSite = (EditText) findViewById(R.id.txtNomeAluno_FormAluno);
        txtNota = (RatingBar) findViewById(R.id.rtbNota_FormAluno);
        btnSalvar = (Button) findViewById(R.id.btnSalvar_FormAluno);
    }
}