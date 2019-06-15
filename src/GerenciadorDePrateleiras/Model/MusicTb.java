package GerenciadorDePrateleiras.Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class MusicTb {
    private final SimpleStringProperty nome;
    private final SimpleStringProperty compositores;
    private final SimpleDoubleProperty duracao;
    private final SimpleStringProperty album;


    public MusicTb(String nome, ArrayList<String> compositores, String album, double duracao) {
        this.nome = new SimpleStringProperty(nome);
        String pa = "";
        boolean entrou = false;
        for(String comp:compositores){
            if(entrou)
                pa+= ", ";
            pa+= comp;
            entrou = true;
        }
        this.compositores = new SimpleStringProperty(pa);
        this.duracao = new SimpleDoubleProperty(duracao);
        this.album = new SimpleStringProperty(album);
    }

    public String getNome() {
        return nome.get();
    }

    public String getCompositores() {
        return compositores.get();
    }

    public double getDuracao() {
        return duracao.get();
    }

    public String getAlbum() {
        return album.get();
    }
}
