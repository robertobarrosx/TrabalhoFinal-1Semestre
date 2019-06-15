package GerenciadorDePrateleiras.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class AutorTb {
    private final SimpleStringProperty nome;
    private final SimpleStringProperty tipo;
    private final SimpleStringProperty cidadeOrigem;
    private final SimpleIntegerProperty anoNascimento;
    private final SimpleStringProperty albums;

    public AutorTb(String nome, String tipo, String cidade, int ano, ArrayList<String> albums) {
        this.nome = new SimpleStringProperty(nome);
        this.tipo = new SimpleStringProperty(tipo);
        this.cidadeOrigem = new SimpleStringProperty(cidade);
        this.anoNascimento = new SimpleIntegerProperty(ano);
        String pa = "";
        boolean entrou = false;
        for(String comp:albums){
            if(entrou)
                pa+= ", ";
            pa+= comp;
            entrou = true;
        }
        this.albums = new SimpleStringProperty(pa);
    }

    public String getTipo(){
        return tipo.get();
    }
    public String getNome() {
        return nome.get();
    }
    public String getAlbums(){
        return albums.get();
    }
    public String getCidadeOrigem() {
        return cidadeOrigem.get();
    }

    public int getAnoNascimento() {
        return anoNascimento.get();
    }
}
