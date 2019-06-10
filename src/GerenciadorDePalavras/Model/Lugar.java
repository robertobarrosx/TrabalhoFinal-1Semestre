package GerenciadorDePalavras.Model;
import java.util.ArrayList;
import java.util.Collections;

public class Lugar {
    private ArrayList<Item> items;
    private int tamanho;
    private String tipoItem;

    public Lugar(){
        this.items = new ArrayList<>();
        ArrayList<Musica> musicas = new ArrayList<>();
        ArrayList<String> compositores = new ArrayList<>();
        compositores.add("Armando");
        compositores.add("Lucio");
        Autor autor = new Autor("Pedro","Paranaguá",1980);
        Autor autor2 = new Autor("Paco","Paranaguá",1980);
        Autor autor3 = new Autor("Panda","Paranaguá",1980);
        Autor autor4 = new Autor("Pietro","Paranaguá",1980);
        Autor autor5 = new Autor("Carlos","Paranaguá",1980);
        musicas.add(new Musica("Amanhã",compositores,3.2));

        Album album = new Album("Carne Unha",2000, musicas,autor2);
        this.items.add(new Item("K7",album));
        album = new Album("Alma Gemea",2005, musicas,autor);
        this.items.add(new Item("K7",album));
        album = new Album("Alma Gemea",2000, musicas,autor);
        this.items.add(new Item("K7",album));
        album = new Album("Carne Unha",2000, musicas,autor5);
        this.items.add(new Item("K7",album));
        album = new Album("Alma Perdida",2005, musicas,autor3);
        this.items.add(new Item("K7",album));
        album = new Album("Alma Gemea",2000, musicas,autor4);
        this.items.add(new Item("K7",album));
        Collections.sort(this.items);
    }
    public void imprimirLista(){
        for(Item i:items){
            System.out.println("Cantor/Banda:" + i.getAlbum().getAutor().getNome()+" Album: "+i.getAlbum().getNome()+" Ano de lançamento: "+i.getAlbum().getAnoLancamento());
        }
    }

}
