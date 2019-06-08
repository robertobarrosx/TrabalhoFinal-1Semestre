package GerenciadorDePalavras.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Album {
    private String nome;
    private int anoLancamento;
    private int numeroMusicas;
    private ObservableList<Musica> musicas;
    private Autor autor;

    public Album(String nome, int anoLancamento, int numeroMusicas, ArrayList<Musica> musicas, Autor autor){
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.numeroMusicas = numeroMusicas;
        this.musicas = FXCollections.observableArrayList(musicas);
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public int getNumeroMusicas() {
        return numeroMusicas;
    }

    public ObservableList<Musica> getMusicas() {
        return musicas;
    }

    public void adicionarMusica(Musica musica){
        this.musicas.add(musica);
        setNumeroMusicas();
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroMusicas() {
        this.numeroMusicas = musicas.size();
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
