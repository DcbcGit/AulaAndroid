package br.senac.rn.agendaescolar.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.List;

import br.senac.rn.agendaescolar.adapter.AlunoAdapter;
import br.senac.rn.agendaescolar.daos.AlunoDao;
import br.senac.rn.agendaescolar.models.Aluno;
import br.senac.rn.agendaescolar.views.ListaAlunosActivity;

public class AcessoAssync extends AsyncTask {

    private ProgressDialog dialog;
    private Context thisContexto;
    private  List<Aluno> listaAlunos;
    private ListView thisLstAdapter;

    public AcessoAssync(Context contexto, List<Aluno> lstAlunos, ListView lstAdapter){
        this.thisContexto = contexto;
        this.listaAlunos = lstAlunos;
        this.thisLstAdapter = lstAdapter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(thisContexto,"Aguarde","Carregando Dados...");

    }

    @Override
    protected void onPostExecute(Object o) {
        dialog.dismiss();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        listaAlunos = new AlunoDao(thisContexto).buscaTodos();
        AlunoAdapter adap = new AlunoAdapter(thisContexto,listaAlunos);
        thisLstAdapter.setAdapter(adap);
        return null;
    }
}