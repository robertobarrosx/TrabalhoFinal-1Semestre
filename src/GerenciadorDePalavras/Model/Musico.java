package GerenciadorDePalavras.Model;

public class Musico extends Autor{

    public Musico(String nome, String cidadeOrigem, int anoNascimento) {
        super(nome, cidadeOrigem, anoNascimento);
    }

    public String tipo(){
        return "Musico";
    }
}
