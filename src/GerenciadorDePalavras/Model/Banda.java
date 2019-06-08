package GerenciadorDePalavras.Model;

public class Banda extends Autor {

    public Banda(String nome, String cidadeOrigem, int anoNascimento) {
        super(nome, cidadeOrigem, anoNascimento);
    }

    private String tipo(){
        return "Banda";
    }
}
