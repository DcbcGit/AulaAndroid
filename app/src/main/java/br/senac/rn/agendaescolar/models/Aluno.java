package br.senac.rn.agendaescolar.models;

import java.io.Serializable;

public class Aluno implements Serializable {

    private Integer id;
    private String nome;
    private String Endereco;
    private String fone;
    private String site;
    private double nota;

    public Aluno() {
    }

    public Aluno(String nome, String endereco, String fone, String site, double nota) {
        this.nome = nome;
        Endereco = endereco;
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

    public void ToString(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
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
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public String getFone() {
        return fone;
    }

    public String getSite() {
        return site;
    }

    public double getNota() {
        return nota;
    }
}
