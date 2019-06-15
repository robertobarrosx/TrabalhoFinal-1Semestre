package GerenciadorDePrateleiras.Model;

public class Banda extends Autor {

    public Banda(String nome, String cidadeOrigem, int anoNascimento) {
        super(nome, cidadeOrigem, anoNascimento);
    }

    public String tipo(){
        return "Banda";
    }

    @Override
    public String toString() {
        return "Banda: "+getNome()+" Cidade Natal: "+getCidadeOrigem()+" em "+getAnoNascimento();
    }
}
