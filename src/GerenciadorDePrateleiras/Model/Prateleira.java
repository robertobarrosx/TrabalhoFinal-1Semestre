package GerenciadorDePrateleiras.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Prateleira implements Serializable {
    private ArrayList<Item> items;
    private int tamanho;
    private String tipoItem;
    private int numero;
    public Prateleira(String tipoItem,int tamanho){
        this.items = new ArrayList<>();
        this.tamanho = tamanho;
        this.tipoItem = tipoItem;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void adicionarItem(Item i){
        this.items.add(i);
        Collections.sort(this.items);
        for(Item a:items){
            a.setPosicao(items.indexOf(a)+1);
        }
    }
    public void removerItem(Item i){
        this.items.remove(i);
        Collections.sort(this.items);
        for(Item a:items){
            a.setPosicao(items.indexOf(a)+1);
        }
    }
    public ArrayList<Item> getListItems(){
        return items;
    }
    public void imprimirLista(){
        boolean vazia = true;
        for(Item i:items){
            System.out.println("Cantor/Banda:" + i.getAlbum().getAutor().getNome()+" Album: "+i.getAlbum().getNome()+" Ano de lançamento: "+i.getAlbum().getAnoLancamento()+" Prateleira: "+this.numero+" Posição: "+i.getPosicao() +" Tipo: "+tipoItem);
            vazia = false;
        }
        if(vazia)
            System.out.println("Vazia\n");
        else
        System.out.println("\n");
    }

}
