package GerenciadorDePrateleiras.Model;

import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable {
    private String tipo;
    private Album album;
    private int posicao;

    public Item(String tipo, Album album){
        this.tipo = tipo;
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }

    public int getPosicao() {
        return posicao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public int compareTo(Item item) {
        if(this.album.getAutor().getNome().compareTo(item.album.getAutor().getNome()) == 0)
        {
            if(this.album.getNome().compareTo(item.album.getNome())>0){
                return 1;
            }else if(this.album.getNome().compareTo(item.album.getNome())<0){
                return -1;
            }else if(this.album.getNome().compareTo(item.album.getNome())==0){
                if(this.album.getAnoLancamento() < item.album.getAnoLancamento()){
                    return -1;
                }else if(this.album.getAnoLancamento() > item.album.getAnoLancamento()){
                    return 1;
                }else{
                    return 0;
                }
            }
        }else if(this.album.getAutor().getNome().compareTo(item.album.getAutor().getNome()) < 0){
            return -1;
        }else{
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.album.getAutor().getNome()+" - "+this.album.getNome();
    }


    //    A ordem dos itens deve ser a alfabética por nome do autor/banda, nome do álbum, ano de lançamento.

}
