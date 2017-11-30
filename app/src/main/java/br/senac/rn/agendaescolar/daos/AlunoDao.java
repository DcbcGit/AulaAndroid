package br.senac.rn.agendaescolar.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.senac.rn.agendaescolar.models.Aluno;

public class AlunoDao extends SQLiteOpenHelper {

    SQLiteDatabase db;
    static final int versao = 2;

    public AlunoDao(Context context) {
        super(context, "AgendaDB", null, 2);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "";
        sql += "CREATE TABLE IF NOT EXISTS ALUNOS( ";
        sql += "id INTEGER PRIMARY KEY,";
        sql += "nome TEXT,";
        sql += "endereco TEXT,";
        sql += "fone TEXT,";
        sql += "site TEXT,";
        sql += "nota REAL );";

        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int verAnt, int verNova) {

        switch (verNova)
        {
            case 2:
                db.execSQL("ALTER TABLE ALUNOS ADD COLUMN foto TEXT");
                break;
        }


    }

    public List<Aluno> buscaTodos() {
        db = getReadableDatabase();

        String cmdSQL = "SELECT * FROM ALUNOS";
        Cursor cursor = db.rawQuery(cmdSQL, null);

        List<Aluno> lstAlunos = new ArrayList<Aluno>();

        while (cursor.moveToNext()) {
            lstAlunos.add(new Aluno(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("endereco")),
                    cursor.getString(cursor.getColumnIndex("fone")),
                    cursor.getString(cursor.getColumnIndex("site")),
                    cursor.getDouble(cursor.getColumnIndex("nota")),
                    cursor.getString(cursor.getColumnIndex("foto"))
            ));
        }

        return lstAlunos;
    }

    private ContentValues AtribuiValoresAlunos(Aluno aluno){
        ContentValues values = new ContentValues();

        values.put("nome", aluno.getNome());
        values.put("endereco", aluno.getEndereco());
        values.put("fone", aluno.getFone());
        values.put("site", aluno.getSite());
        values.put("nota", aluno.getNota());
        values.put("foto", aluno.getFoto());

        return  values;
    }

    public void inserir(Aluno aluno) {
        //MEtodo que indica ao banco escrever no banco de dados.
        db = getWritableDatabase();

        db.insert("ALUNOS", null, AtribuiValoresAlunos(aluno));
    }

    public void atualiza(Aluno aluno) {
        //MEtodo que indica ao banco escrever no banco de dados.
        db = getWritableDatabase();

        String where = " id = ?";
        String[] parametros = {aluno.getId().toString()};

        db.update("ALUNOS", AtribuiValoresAlunos(aluno), where, parametros);
    }

    public void deletar(int id) {
        //MEtodo que indica ao banco escrever no banco de dados.
        db = getWritableDatabase();
        String where = " id = ?";
        String[] parametros = {String.valueOf(id)};
        db.delete("ALUNOS", where, parametros);
    }
}