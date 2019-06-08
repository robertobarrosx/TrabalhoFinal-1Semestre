package GerenciadorDePalavras.Model;

import java.util.ArrayList;

public class Musica {
    private String nome;
    private ArrayList<String> compositores;
    private double duracao;

    public Musica(String nome,ArrayList<String> compositores,double duracao){
        this.nome = nome;
        this.compositores = compositores;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getCompositores() {
        return compositores;
    }

    public double getDuracao() {
        return duracao;
    }
}
