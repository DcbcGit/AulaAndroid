package br.senac.rn.agendaescolar.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.senac.rn.agendaescolar.models.Aluno;

public class AcessoWS {

    private Aluno aluno;

    public AcessoWS(Aluno aluno) {
        this.aluno = aluno;
    }


    public String httpGet(String endereco) {

        try {

            URL url = new URL(endereco);
            HttpURLConnection conHttp = (HttpURLConnection) url.openConnection();

            conHttp.setRequestMethod("GET");
            conHttp.connect();

            InputStreamReader strReader = new InputStreamReader(url.openStream());
            BufferedReader bufReader = new BufferedReader(strReader);

            StringBuilder strBuilder = new StringBuilder();

            String linha = null;
            while ((linha = bufReader.readLine()) != null) {
                strBuilder.append(linha + "\n");
            }

            bufReader.close();

            return  strBuilder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}