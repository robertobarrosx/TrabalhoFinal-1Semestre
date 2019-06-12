package GerenciadorDePalavras.Model;

public class Autor {
    private String nome;
    private String cidadeOrigem;
    private int anoNascimento;

    public Autor(String nome,String cidadeOrigem,int anoNascimento){
        this.nome = nome;
        this.cidadeOrigem = cidadeOrigem;
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    private String tipo(){
        return "Autor";
    }

    @Override
    public String toString() {
        return "Autor: "+nome+" Nascido: "+cidadeOrigem+" em "+anoNascimento;
    }
}
