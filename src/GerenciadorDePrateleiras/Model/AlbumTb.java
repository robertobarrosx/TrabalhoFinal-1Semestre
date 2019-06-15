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

    public AlbumTb(String nome, int anoLancamento, int numeroMusicas, String autor, ArrayList<Musica> musicas) {
        this.nome = new SimpleStringProperty(nome);
        this.anoLancamento = new SimpleIntegerProperty(anoLancamento);
        this.numeroMusicas = new SimpleIntegerProperty(numeroMusicas);
        this.autor = new SimpleStringProperty(autor);
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
