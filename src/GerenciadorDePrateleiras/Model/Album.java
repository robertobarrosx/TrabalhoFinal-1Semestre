package GerenciadorDePrateleiras.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Album implements Serializable {
    private String nome;
    private int anoLancamento;
    private int numeroMusicas;
    private ArrayList<Musica> musicas;
    private Autor autor;

    public Album(String nome, int anoLancamento, ArrayList<Musica> musicas, Autor autor){
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.numeroMusicas = musicas.size();
        this.musicas = musicas;
        this.autor = autor;
    }

    public Album(String nome, int anoLancamento, Autor autor){
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.numeroMusicas = 0;
        this.musicas = new ArrayList<>();
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
        this.numeroMusicas = musicas.size();
        return numeroMusicas;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void adicionarMusica(Musica musica){
        this.musicas.add(musica);
    }
    public void editarMusica(Musica antiga,Musica nova){
        ArrayList<Musica> listaLocal = new ArrayList<>();
        for(Musica m:this.musicas){
            if(m.equals(antiga)){
                listaLocal.add(nova);
            }else{
                listaLocal.add(m);
            }
        }
        this.musicas = listaLocal;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
