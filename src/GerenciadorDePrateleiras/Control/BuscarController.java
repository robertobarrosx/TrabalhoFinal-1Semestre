package GerenciadorDePrateleiras.Control;

import GerenciadorDePrateleiras.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.util.*;

public class BuscarController {


    @FXML
    TextField tf_string;

    @FXML
    HBox hb_musica,hb_autor,hb_album,hb_autorB,hb_albumB;

    @FXML
    TableColumn<MusicTb,String> tb_musicaColNome, tb_musicaColNomeAlbum, tb_musicaColCompositores;
    @FXML
    TableColumn<MusicTb, ?> tb_musicaColDuracao;

    @FXML
    TableColumn<AutorTb,String> tb_autorColTipo, tb_autorColNome, tb_autorColCidade;
    @FXML
    TableColumn<AutorTb,Integer> tb_autorColAno;
    @FXML
    TableColumn<AlbumTb,String> tb_albumColNome,cl_AutorNome;
    @FXML
    TableColumn<AlbumTb,Integer> tb_albumColAno, tb_albumColQtdMusicas;

    @FXML
    TableView<AlbumTb> tb_album;
    @FXML
    RadioButton rb_musica,rb_autor,rb_album;

    @FXML
    TableView<MusicTb> tb_musica;//,tb_album,tb_autor;
    @FXML
    TableView<AutorTb> tb_autor;

    @FXML
    ToggleGroup tipoBusca;

    private ObservableList<Autor> autores;
    private ObservableList<Musica> musicas;
    private ObservableList<Album> albums;
    private ArrayList<MusicTb> list;
    private ObservableList<MusicTb> listaDeClientes(List<MusicTb> lista) {

        return FXCollections.observableArrayList( lista);
    }
    @FXML
    public void initialize(){
        list = new ArrayList<>();
        autores = FXCollections.observableArrayList();
        musicas = FXCollections.observableArrayList();
        albums = FXCollections.observableArrayList();
        tb_musicaColNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        tb_musicaColDuracao.setCellValueFactory(
                new PropertyValueFactory<>("duracao"));
        tb_musicaColNomeAlbum.setCellValueFactory(
                new PropertyValueFactory<>("album"));
        tb_musicaColCompositores.setCellValueFactory(
                new PropertyValueFactory<>("compositores"));
        tb_musica.setItems(listaDeClientes(list));
    }

    @FXML
    private void mudarInterface(){
        hb_autor.setVisible(false);
        hb_musica.setVisible(false);
        hb_album.setVisible(false);
        hb_albumB.setVisible(false);
        hb_autorB.setVisible(false);
        if(rb_musica.isSelected()) {
            hb_musica.setVisible(true);
            tf_string.setPromptText("Digite o nome da musica ou o nome de um dos compositores");
        }
        else if(rb_autor.isSelected()) {
            hb_autor.setVisible(true);
            hb_autorB.setVisible(true);
            tf_string.setPromptText("Digite o nome do cantor ou o nome da banda");
        }else{
            hb_album.setVisible(true);
            hb_albumB.setVisible(true);
            tf_string.setPromptText("Digite o nome do album ou o nome do autor");
        }
    }

    @FXML
    private void listarAlbums(){

    }
    @FXML
    private void listarMusicas(){

    }
    @FXML
    private void buscar(){
        ArrayList<Album> albums = Gerenciador.getInstance().buscarAlbum();
        list.clear();
        for(Album al: albums){
            for(Musica msc:al.getMusicas()){
                String comp = "";
                for(String st:msc.getCompositores()){
                    comp += st;
                }
                if(msc.getNome().toLowerCase().contains(tf_string.getText().toLowerCase()) || comp.toLowerCase().contains(tf_string.getText().toLowerCase()))
                    list.add(new MusicTb(msc.getNome(),msc.getCompositores(),al.getNome(),msc.getDuracao()));
            }
        }
        for(MusicTb a:list)
            System.out.println(a.getNome());
        tb_musica.setItems(listaDeClientes(list));

    }
}
