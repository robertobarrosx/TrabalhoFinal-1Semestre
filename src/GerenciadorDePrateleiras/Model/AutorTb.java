package GerenciadorDePrateleiras.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AutorTb {
    private final SimpleStringProperty nome;
    private final SimpleStringProperty tipo;
    private final SimpleStringProperty cidadeOrigem;
    private final SimpleIntegerProperty anoNascimento;

    public AutorTb(String nome, String tipo, String cidade, int ano) {
        this.nome = new SimpleStringProperty(nome);
        this.tipo = new SimpleStringProperty(tipo);
        this.cidadeOrigem = new SimpleStringProperty(cidade);
        this.anoNascimento = new SimpleIntegerProperty(ano);
    }

    public String getTipo(){
        return tipo.get();
    }
    public String getNome() {
        return nome.get();
    }

    public String getCidadeOrigem() {
        return cidadeOrigem.get();
    }

    public int getAnoNascimento() {
        return anoNascimento.get();
    }
}
