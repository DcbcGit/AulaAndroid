package br.senac.rn.agendaescolar.views;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import br.senac.rn.agendaescolar.models.Aluno;

import java.util.LinkedList;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    Button btnIncluir;
    ListView lstViewAlunos;
    TextView txtNomeAluno;
    List<Aluno> lstAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);

        btnIncluir = (Button) findViewById(R.id.BtnCadastrar_ListaActivity);
        lstViewAlunos = (ListView) findViewById(R.id.listaAluno_ListaActivity);
        txtNomeAluno = (TextView) findViewById(R.id.txtNomeAluno_ListaActivity);
        lstAlunos = new LinkedList<Aluno>();

        lstAlunos.add(new Aluno(
                "Doalcey Carlos",
                "Rua da Diatomida, 357",
                "84991197415",
                "www.facebook.com/DoalceyCarlos",
                10.0));

        ArrayAdapter<Aluno> adap = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, lstAlunos);
        lstViewAlunos.setAdapter(adap);


        btnIncluir.setOnClickListener(onBtnCadastrar);
    }

    protected void Atualizalista(String nomeAluno) {
        ArrayAdapter<Aluno> adap = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, lstAlunos);
        lstViewAlunos.setAdapter(adap);
    }

    protected View.OnClickListener onBtnCadastrar;

    {
        onBtnCadastrar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Atualizalista(txtNomeAluno.getText().toString());
                txtNomeAluno.setText("");
            }
        };
    }

}