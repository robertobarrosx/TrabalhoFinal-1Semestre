package GerenciadorDePalavras.Model;

public class Item {
    private String tipo;
    private Album album;
    private int prateleira;
    private int posicao;

    public Item(String tipo, Album album, int prateleira, int posicao){
        this.tipo = tipo;
        this.album = album;
        this.prateleira = prateleira;
        this.posicao = posicao;
    }

    public Album getAlbum() {
        return album;
    }

    public int getPosicao() {
        return posicao;
    }

    public int getPrateleira() {
        return prateleira;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return this.tipo+" - "+album.getNome();
    }
}
