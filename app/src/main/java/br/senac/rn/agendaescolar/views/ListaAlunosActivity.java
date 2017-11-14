package br.senac.rn.agendaescolar.views;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import org.w3c.dom.TypeInfo;

import br.senac.rn.agendaescolar.models.Aluno;

import java.util.LinkedList;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    Button btnIncluir;
    ListView lstViewAlunos;
    EditText txtNomeAluno;
    List<Aluno> lstAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);

        btnIncluir = (Button) findViewById(R.id.BtnCadastrar_ListaActivity);
        lstViewAlunos = (ListView) findViewById(R.id.listaAluno_ListaActivity);
        txtNomeAluno = (EditText) findViewById(R.id.txtNomeAluno_ListaActivity);
        lstAlunos = new LinkedList<Aluno>();

        lstAlunos.add(new Aluno(
                "Doalcey Carlos",
                "Rua da Diatomida, 357",
                "84991197415",
                "http://www.facebook.com/DoalceyCarlos",
                10.0));

        lstAlunos.add(new Aluno(
                "Gerusa Oliveira",
                "Rua da Diatomida, 357",
                "8491727899",
                "http://www.facebook.com/BandeiraCosta",
                9.0));


        Atualizalista();
        registerForContextMenu(lstViewAlunos);
        registerForContextMenu(btnIncluir);

        btnIncluir.setOnClickListener(onBtnCadastrar);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo escolhaUsu = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Aluno alunoSele = (Aluno) lstViewAlunos.getItemAtPosition(escolhaUsu.position);

        Intent intAV = new Intent(Intent.ACTION_VIEW);
        switch (item.getItemId()) {
            case R.id.item_sms:
                intAV.setData(Uri.parse("sms:" + alunoSele.getFone()));
                item.setIntent(intAV);
                break;
            case R.id.item_site:
                intAV.setData(Uri.parse(alunoSele.getSite()));
                item.setIntent(intAV);
                break;
            case R.id.item_mapa:
                intAV.setData(Uri.parse("geo:0,0?q=" + alunoSele.getEndereco()));
                item.setIntent(intAV);
                break;
            case R.id.item_deletar:
                lstAlunos.remove(escolhaUsu.position);
                Atualizalista();
                break;
            case R.id.item_ligar:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 2);
                } else {
                    intAV = new Intent(Intent.ACTION_CALL);
                    intAV.setData(Uri.parse("tel:" + alunoSele.getFone()));
                    item.setIntent(intAV);
                }
                break;
            case R.id.item_msg_whatsapp:

                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("content://com.android.contacts/data/" + alunoSele.getFone()));
                i.setType("text/plain");
                i.setPackage("com.whatsapp");           // so that only Whatsapp reacts and not the chooser
                i.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                i.putExtra(Intent.EXTRA_TEXT, "I'm the body.");
                startActivity(i);


               // Uri uri = Uri.parse("smsto:" + alunoSele.getFone());
                //Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                //i.putExtra(Intent.EXTRA_TEXT, txtNomeAluno.getText().toString());
                //i.setType("text/plain");
                //i.setPackage("com.whatsapp");
                //startActivity(Intent.createChooser(i, ""));


                //intAV = new Intent(Intent.ACTION_SEND);
                //intAV.putExtra(Intent.EXTRA_TEXT, txtNomeAluno.getText().toString());
                //intAV.setPackage("com.whatsapp");
                //intAV.setType("text/plain");
                //startActivity(intAV);
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();

        switch (v.getId()) {
            case R.id.BtnCadastrar_ListaActivity:
                inflater.inflate(R.menu.menu_single_opcao, menu);
                break;

            case R.id.listaAluno_ListaActivity:
                inflater.inflate(R.menu.menu_lista_opcoes, menu);
                break;
        }
    }

    protected void Atualizalista() {
        ArrayAdapter<Aluno> adap = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, lstAlunos);
        lstViewAlunos.setAdapter(adap);
    }

    protected View.OnClickListener onBtnCadastrar;

    {
        onBtnCadastrar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Atualizalista();
                txtNomeAluno.setText("");
            }
        };
    }
}