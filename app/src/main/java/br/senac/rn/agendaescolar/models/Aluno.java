package br.senac.rn.agendaescolar.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Aluno implements Serializable {

    private Integer id;
    private String nome;
    private String endereco;
    private String fone;
    private String site;
    private double nota;

    public Aluno() {
    }

    public Aluno(String nome, String endereco, String fone, String site, double nota) {
        this.nome = nome;
        this.endereco = endereco;
        this.fone = fone;
        this.site = site;
        this.nota = nota;
    }

    public Aluno(Integer id, String nome, String endereco, String fone, String site, double nota) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.fone = fone;
        this.site = site;
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aluno aluno = (Aluno) o;

        return id.equals(aluno.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // @Override
    //public String toString() {
    //  return String.format("%03d - %s \nTel: %s\nEnd: %s ", this.id, this.nome, this.fone, endereco);
    //}


    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", fone='" + fone + '\'' +
                ", site='" + site + '\'' +
                ", nota=" + nota +
                '}';

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getFone() {
        return this.fone;
    }

    public String getSite() {
        return this.site;
    }

    public double getNota() {
        return this.nota;
    }

}
