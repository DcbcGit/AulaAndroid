package br.senac.rn.agendaescolar.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicial extends AppCompatActivity {

    Button btnNovoAluno, btnNovaMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        this.criaComponentes();
        this.criaEventos();
    }

    protected void criaComponentes() {
        btnNovoAluno = (Button) findViewById(R.id.btnNovoAluno_ACTInicial);

    }

    protected void criaEventos() {
        btnNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intActNovoAluno = new Intent(TelaInicial.this,ListaAlunosActivity.class);
            }
        });
    }

}
