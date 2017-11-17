package br.senac.rn.agendaescolar.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.senac.rn.agendaescolar.models.Aluno;

/**
 * Created by A9236541 on 14/11/2017.
 */

public class AlunoDao extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public AlunoDao(Context context) {
        super(context, "AgendaDB", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE ALUNOS( ";
        sql += "id INTEGER PRIMARY KEY,";
        sql += "nome TEXT,";
        sql += "endereco TEXT,";
        sql += "fone TEXT,";
        sql += "site TEXT,";
        sql += "nota REAL);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<Aluno> buscaTodos() {
        db = getReadableDatabase();

        String cmdSQL = "SELECT * FROM ALUNOS";
        Cursor cursor = db.rawQuery(cmdSQL, null);

        List<Aluno> lstAlunos = new ArrayList<Aluno>();

        while (cursor.moveToNext()) {
            lstAlunos.add(new Aluno(
                    cursor.getInt(cursor.getColumnIndex("nota")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("endereco")),
                    cursor.getString(cursor.getColumnIndex("fone")),
                    cursor.getString(cursor.getColumnIndex("site")),
                    cursor.getDouble(cursor.getColumnIndex("nota"))
            ));
        }

        return lstAlunos;
    }

    public void inserir(Aluno aluno) {
        //MEtodo que indica ao banco escrever no banco de dados.
        db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("nome", aluno.getNome());
        values.put("endereco", aluno.getEndereco());
        values.put("fone", aluno.getFone());
        values.put("site", aluno.getSite());
        values.put("nota", aluno.getNota());

        db.insert("ALUNOS", null, values);
    }

    public void atualiza(Aluno aluno) {
        //MEtodo que indica ao banco escrever no banco de dados.
        db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("nome", aluno.getNome());
        values.put("endereco", aluno.getEndereco());
        values.put("fone", aluno.getFone());
        values.put("site", aluno.getSite());
        values.put("nota", aluno.getNota());

        db.update("ALUNOS", values, " id = " + aluno.getId().toString(), null);
    }

    public void deletar(int id) {
        //MEtodo que indica ao banco escrever no banco de dados.
        db = getReadableDatabase();
        db.delete("ALUNOS", "id = " + id, null);
    }
}