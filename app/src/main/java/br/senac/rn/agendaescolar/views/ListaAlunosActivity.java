package br.senac.rn.agendaescolar.views;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ListaAlunosActivity extends AppCompatActivity {

    Button btnIncluir;
    ListView lstAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);

        btnIncluir = (Button) findViewById(R.id.BtnCadastrar_ListaActivity);
        lstAlunos = (ListView)findViewById(R.id.listaAluno_ListaActivity);
    }

}
