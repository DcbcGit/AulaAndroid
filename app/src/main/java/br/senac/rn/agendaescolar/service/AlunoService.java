package br.senac.rn.agendaescolar.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.senac.rn.agendaescolar.models.Aluno;

public class AlunoService {


    public List<Aluno> buscaTodos() {
        List<Aluno> alunos = new ArrayList<Aluno>();


        String endereco = "http://10.2.2.68:8080/agendaweb/resources/aluno/todos";

        AcessoWS aws = new AcessoWS(new Aluno());

        Type tipo = new TypeToken<List<Aluno>>() {
        }.getType();

        Gson gson = new Gson();

        alunos = gson.fromJson(aws.httpGet(endereco), tipo);

        return alunos;
    }

}
