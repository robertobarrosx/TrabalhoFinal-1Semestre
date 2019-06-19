package GerenciadorDePrateleiras.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class AlbumTb {
    private final SimpleStringProperty nome;
    private final SimpleIntegerProperty anoLancamento;
    private final SimpleIntegerProperty numeroMusicas;
    private final SimpleStringProperty autor;
    private final SimpleStringProperty musicas;
    private final SimpleIntegerProperty posicao;
    private final SimpleIntegerProperty prateleira;
    private final SimpleStringProperty tipo;
    public AlbumTb(String tipo,String nome, int anoLancamento, int numeroMusicas, String autor, ArrayList<Musica> musicas,int prateleira, int posicao) {
        this.nome = new SimpleStringProperty(nome);
        this.anoLancamento = new SimpleIntegerProperty(anoLancamento);
        this.numeroMusicas = new SimpleIntegerProperty(numeroMusicas);
        this.autor = new SimpleStringProperty(autor);
        this.posicao = new SimpleIntegerProperty(posicao);
        this.tipo = new SimpleStringProperty(tipo);
        this.prateleira = new SimpleIntegerProperty(prateleira);
        String pa = "";
        boolean entrou = false;
        for(Musica m:musicas){
            if(entrou)
                pa+= ", ";
            pa+= m.getNome();
            entrou = true;
        }
        this.musicas = new SimpleStringProperty(pa);
    }
    public int getPosicao(){
        return this.posicao.get();
    }
    public int getPrateleira(){
        return this.prateleira.get();
    }
    public String getTipo(){
        return this.tipo.get();
    }
    public String getNome() {
        return nome.get();
    }

    public int getAnoLancamento() {
        return anoLancamento.get();
    }

    public int getNumeroMusicas() {
        return numeroMusicas.get();
    }
    public String getMusicas(){
        return musicas.get();
    }

    public String getAutor() {
        return autor.get();
    }
}
