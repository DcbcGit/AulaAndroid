package br.senac.rn.agendaescolar.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import br.senac.rn.agendaescolar.models.Aluno;
import br.senac.rn.agendaescolar.views.R;

public class AlunoAdapter extends BaseAdapter {

    private List<Aluno> listaAlunos;
    private Context contextoUsado;

    public AlunoAdapter(Context context, List<Aluno> alunos) {
        this.listaAlunos = alunos;
        this.contextoUsado = context;
    }

    @Override
    public int getCount() {
        return this.listaAlunos.size();
    }

    @Override
    public Object getItem(int pos) {
        return this.listaAlunos.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return this.listaAlunos.get(pos).getId();
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        LayoutInflater infla = LayoutInflater.from(contextoUsado);
        View itemLst = infla.inflate(R.layout.item_lista_aluno, null);

        TextView campoNome = (TextView) itemLst.findViewById(R.id.itemNome_ADPItemAluno);
        TextView campoFone = (TextView) itemLst.findViewById(R.id.itemFone_ADPItemAluno);
        ImageView imgAluno = (ImageView) itemLst.findViewById(R.id.itemFoto_ADPItemAluno);

        final Aluno alunoSele = (Aluno) getItem(pos);

        //File picDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        //File imageFile = new File(picDir,"Foto_"+alunoSele.getId().toString()+".jpg" );

        campoNome.setText(alunoSele.getNome());
        campoFone.setText(alunoSele.getFone());

        return itemLst;
    }
}