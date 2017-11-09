package br.senac.rn.agendaescolar.views;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlunoListaActivity extends AppCompatActivity {

    EditText txtNome ;
    Button btnCadastrar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_lista);

        this.inicializarComponentes();
        this.definirEventos();
    }

    protected void inicializarComponentes(){
        txtNome = (EditText) findViewById(R.id.txtNomeAluno);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
    }

    protected void definirEventos(){
        btnCadastrar.setOnClickListener(onClickBtnCadastrar);
    }

    private View.OnClickListener onClickBtnCadastrar;
    {
        onClickBtnCadastrar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context cont = AlunoListaActivity.this;
                Toast.makeText(AlunoListaActivity.this, txtNome.getText(), Toast.LENGTH_LONG).show();
            }
        };
    }
}
