package GerenciadorDePrateleiras.Control;

import GerenciadorDePrateleiras.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class Gerenciador implements Serializable {
    private ObservableList<Prateleira> prateleiras;
    private ObservableList<Item> items;
    private ObservableList<Autor> autores;

    private String ARQUIVO="prateleiras.bin";

    private Gerenciador(){
        prateleiras = FXCollections.observableArrayList();
        criarprateleiras();
    }
    private static Gerenciador instance;
    public static synchronized Gerenciador getInstance(){
        if(instance == null){
            instance = new Gerenciador();
        }
        return instance;
    }
    public ObservableList<Item> getItems(){
        items = FXCollections.observableArrayList();
        for(Prateleira p:prateleiras){
            items.addAll(p.getListItems());
        }
        return FXCollections.unmodifiableObservableList(items);
    }
    public void adicionarAutor(Autor autor){
        if(autores == null)
            autores = FXCollections.observableArrayList();
        autores.add(autor);
    }
    public ObservableList<Autor> getAutores(){
        if(autores == null) {
            autores =FXCollections.observableArrayList();
            for (Item a : items) {
                autores.add(a.getAlbum().getAutor());
            }
        }
        return FXCollections.unmodifiableObservableList(autores);
    }
    public void adicionarPrateleira(Prateleira prateleira){
        this.prateleiras.add(prateleira);
    }
    public void removerPrateleira(Prateleira prateleira){
        this.prateleiras.remove(prateleira);
    }
    private void criarprateleiras(){
        prateleiras = FXCollections.observableArrayList();
        for(int i =0;i<10;i++) {
            Prateleira prateleira = new Prateleira("CD", 2);
            prateleira.setNumero(i+1);
            prateleiras.add(prateleira);

        }
        for(int i =0;i<10;i++) {
            Prateleira prateleira = new Prateleira("K7", 2);
            prateleira.setNumero(i+1);
            prateleiras.add(prateleira);
        }
        for(int i =0;i<10;i++) {
            Prateleira prateleira = new Prateleira("Vinil", 2);
            prateleira.setNumero(i+1);
            prateleiras.add(prateleira);
        }
        ArrayList<Musica> musicas = new ArrayList<>();
        ArrayList<String> compositores = new ArrayList<>();
        compositores.add("Armando");
        compositores.add("Lucio");
        ArrayList<String> compositor2 = new ArrayList<>();
        compositor2.add("Lucio");
        Autor autor = new Autor("Pedro","Paranaguá",1980);
        Autor autor2 = new Autor("Paco","Paranaguá",1980);
        Autor autor3 = new Banda("Panda","Paranaguá",1980);
        Autor autor4 = new Autor("Pietro","Paranaguá",1980);
        Autor autor5 = new Musico("Carlos","Paranaguá",1980);
        musicas.add(new Musica("Amanhã",compositores,"3:02m"));
        musicas.add(new Musica("Hoje",compositor2,"3:04m"));
        Album album = new Album("Carne Unha",2000, new ArrayList<>(musicas),autor2);
        adicionarItem(new Item("Vinil",album));
        album = new Album("Alma Gemea",2005, new ArrayList<>(musicas),autor);
        adicionarItem(new Item("K7",album));
        album = new Album("Alma Gemea",2000,new ArrayList<>(musicas) ,autor);
        adicionarItem(new Item("K7",album));
        album = new Album("Carne Unha",2000, new ArrayList<>(musicas),autor5);
        adicionarItem(new Item("K7",album));
        album = new Album("Alma Perdida",2005, new ArrayList<>(musicas),autor3);
        adicionarItem(new Item("K7",album));
        album = new Album("Alma Gemea",2000, new ArrayList<>(musicas),autor4);
        adicionarItem(new Item("K7",album));
    }



    public boolean adicionarItem(Item i){
        boolean inseriu = false;
        int x=0;
        do{
            if(x == prateleiras.size())
                return false;
            if(this.prateleiras.get(x).getTipoItem().compareTo(i.getTipo()) != 0)
            {
                x++;
                continue;
            }
            this.prateleiras.get(x).adicionarItem(i);
            if(this.prateleiras.get(x).getListItems().size() > this.prateleiras.get(x).getTamanho()){
                i = this.prateleiras.get(x).getListItems().get(this.prateleiras.get(x).getListItems().size()-1);
                this.prateleiras.get(x).removerItem(i);
                x++;
            }else{
                inseriu = true;
            }

        }while(!inseriu);
        return true;
    }
    public void editarItem(Item antigo,Item novo){
        for(Prateleira p:prateleiras){
            if(p.getListItems().contains(antigo)){
                p.removerItem(antigo);
                adicionarItem(novo);
            }
        }
    }
    public void removerItem(Item i){
        for(Prateleira p:prateleiras){
            if(p.getListItems().contains(i)){
                p.removerItem(i);
            }
        }
    }
    public ObservableList<Prateleira> getPrateleiras() {
        return FXCollections.unmodifiableObservableList(prateleiras);
    }


    public ArrayList<Autor> buscarAutor(String autor){
        ArrayList<Autor> autoresL = new ArrayList<>();
        boolean entrou = false;
        for(Prateleira p: this.prateleiras){
            for(Item i: p.getListItems()){
                if(i.getAlbum().getAutor().getNome().toLowerCase().contains(autor.toLowerCase())){
                    if(!autoresL.contains(i.getAlbum().getAutor())) {
                        autoresL.add(i.getAlbum().getAutor());
                        entrou = true;
                    }
                }
            }
        }
        if(!entrou)
            return null;

        return autoresL;
    }

    public ArrayList<Album> buscarAlbum (String nome){
        ArrayList<Album> albumsL = new ArrayList<>();
        boolean entrou = false;
        for(Prateleira p: this.prateleiras){
            for(Item i: p.getListItems()){
                if(i.getAlbum().getAutor().getNome().toLowerCase().contains(nome.toLowerCase()) || i.getAlbum().getNome().toLowerCase().contains(nome.toLowerCase())){
                    albumsL.add(i.getAlbum());
                    entrou = true;
                }
            }
        }
        if(!entrou)
            return null;

        return albumsL;
    }
    public ArrayList<Album> buscarAlbum (){
        ArrayList<Album> albumsL = new ArrayList<>();
        boolean entrou = false;
        for(Prateleira p: this.prateleiras){
            for(Item i: p.getListItems()){
                     albumsL.add(i.getAlbum());
                     entrou = true;
            }
        }
        if(!entrou)
            return null;
        return albumsL;
    }


    public ArrayList<Musica> buscarMusica(String nome) {
        ArrayList<Musica> musicasL = new ArrayList<>();
        boolean entrou = false;
        for (Prateleira p : this.prateleiras) {
            for (Item i : p.getListItems()) {
                for (Musica m : i.getAlbum().getMusicas()) {
                    for (String compositor : m.getCompositores()) {
                        if (compositor.toLowerCase().contains(nome.toLowerCase()) || m.getNome().toLowerCase().contains(nome.toLowerCase())) {
                            musicasL.add(m);
                            entrou = true;
                        }
                    }
                }
            }
        }
        if (!entrou)
            return null;

        return musicasL;
    }
//    Manter (adicionar e remover) autor/banda: (Nome, Cidade de Origem, Ano de Nascimento)
//    Manter (adicionar e remover) de álbum: (Nome, Ano de Lançamento, Número de Músicas, Músicas, Autor/Banda)
//    Manter (adicionar e remover) de música: (Nome, Compositores, Duração)
//    Manter (adicionar,remover e atualizar) item: (Tipo (CD, k7, Vinil), Álbum, Posição nas Prateleiras)
//    Buscar autor/banda por nome
//    Buscar álbum por nome ou por autor/banda
//    Buscar música por nome ou compositores
//    Deve ser possível salvar e recuperar os dados de arquivo binário
//    Deve ser possível importar um conjunto inicial de dados a partir de um arquivo txt. O formato deve ser definido por você.

//    Chico possui 10 prateleira que acomodam 100 vinis cada, 10 prateleira que acomodam 200 cds cada e 10 prateleira que acomodam 150 k7s cada.
//    A posição de cada item deve ser calculada automaticamente, indicando o número da prateleira (1..10) e também
//    a posição dentro da prateleira (1..n). A ordem dos itens deve ser a alfabética por nome do autor/banda, nome do álbum, ano de lançamento.

    public boolean carregaDados() throws IOException,ClassNotFoundException{

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(ARQUIVO)));
        ArrayList<Prateleira> listaLocal = (ArrayList<Prateleira>)ois.readObject();
        prateleiras.clear();
        prateleiras.addAll(listaLocal);
        ois.close();
        return true;
    }
    public void salvaDados() throws IOException{

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(ARQUIVO)));

        ArrayList<Prateleira> listaLocal = new ArrayList<>(this.prateleiras);

        oos.writeObject(listaLocal);

        oos.close();
    }

}
