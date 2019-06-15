package GerenciadorDePrateleiras.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AlbumTb {
    private final SimpleStringProperty nome;
    private final SimpleIntegerProperty anoLancamento;
    private final SimpleIntegerProperty numeroMusicas;
    private final SimpleStringProperty autor;


    public AlbumTb(String nome, int anoLancamento, int numeroMusicas, String autor) {
        this.nome = new SimpleStringProperty(nome);
        this.anoLancamento = new SimpleIntegerProperty(anoLancamento);
        this.numeroMusicas = new SimpleIntegerProperty(numeroMusicas);
        this.autor = new SimpleStringProperty(autor);
    }
}
