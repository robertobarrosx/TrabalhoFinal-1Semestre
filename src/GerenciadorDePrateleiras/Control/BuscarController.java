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
    private TextField tf_string;

    @FXML
    private HBox hb_musica,hb_autor,hb_album,hb_autorB,hb_albumB;

    @FXML
    private TableColumn<MusicTb,String> tb_musicaColNome, tb_musicaColNomeAlbum, tb_musicaColCompositores;
    @FXML
    private TableColumn<MusicTb, ?> tb_musicaColDuracao;

    @FXML
    private TableColumn<AutorTb,String> tb_autorColTipo, tb_autorColNome, tb_autorColCidade;
    @FXML
    private TableColumn<AutorTb,Integer> tb_autorColAno;
    @FXML
    private TableColumn<AlbumTb,String> tb_albumColNome, tb_albumColAutor;
    @FXML
    private TableColumn<AlbumTb,Integer> tb_albumColAno, tb_albumColQtdMusicas;

    @FXML
    private TableView<AlbumTb> tb_album;
    @FXML
    private RadioButton rb_musica,rb_autor,rb_album;

    @FXML
    private TableView<MusicTb> tb_musica;//,tb_album,tb_autor;
    @FXML
    private TableView<AutorTb> tb_autor;

    @FXML
    private ToggleGroup tipoBusca;

    private ObservableList<Autor> autores;
    private ObservableList<Musica> musicas;
    private ObservableList<Album> albums;
    private ArrayList<MusicTb> musicList;
    private ArrayList<AlbumTb> albumList;
    private ArrayList<AutorTb> autorList;
    private ObservableList<MusicTb> listaDeMusicas(List<MusicTb> lista) {

        return FXCollections.observableArrayList( lista);
    }
    private ObservableList<AutorTb> listaDeAutor(List<AutorTb> lista) {

        return FXCollections.observableArrayList( lista);
    }
    private ObservableList<AlbumTb> listaDeAlbums(List<AlbumTb> lista) {

        return FXCollections.observableArrayList( lista);
    }
    @FXML
    public void initialize(){
        musicList = new ArrayList<>();
        albumList = new ArrayList<>();
        autorList = new ArrayList<>();
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
        tb_musica.setItems(listaDeMusicas(musicList));

        tb_albumColNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        tb_albumColAno.setCellValueFactory(
                new PropertyValueFactory<>("anoLancamento"));
        tb_albumColQtdMusicas.setCellValueFactory(
                new PropertyValueFactory<>("numeroMusicas"));
        tb_albumColAutor.setCellValueFactory(
                new PropertyValueFactory<>("autor"));
        tb_album.setItems(listaDeAlbums(albumList));

        tb_autorColNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        tb_autorColCidade.setCellValueFactory(
                new PropertyValueFactory<>("cidadeOrigem"));
        tb_autorColTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));
        tb_autorColAno.setCellValueFactory(
                new PropertyValueFactory<>("anoNascimento"));
        tb_album.setItems(listaDeAlbums(albumList));
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
        if(rb_musica.isSelected()) {
            ArrayList<Album> albums = Gerenciador.getInstance().buscarAlbum();
            musicList.clear();
            for (Album al : albums) {
                for (Musica msc : al.getMusicas()) {
                    String comp = "";
                    for (String st : msc.getCompositores()) {
                        comp += st;
                    }
                    if (msc.getNome().toLowerCase().contains(tf_string.getText().toLowerCase()) || comp.toLowerCase().contains(tf_string.getText().toLowerCase()))
                        musicList.add(new MusicTb(msc.getNome(), msc.getCompositores(), al.getNome(), msc.getDuracao()));
                }
            }
            for (MusicTb a : musicList)
                System.out.println(a.getNome());
            tb_musica.setItems(listaDeMusicas(musicList));
        }else if(rb_autor.isSelected()){
            autorList.clear();
            ArrayList<Autor> autores = Gerenciador.getInstance().buscarAutor(tf_string.getText());
            if(autores != null)
            for(Autor a:autores){
                autorList.add(new AutorTb(a.getNome(),a.tipo(),a.getCidadeOrigem(),a.getAnoNascimento()));
            }
            tb_autor.setItems(listaDeAutor(autorList));
        }else{
            albumList.clear();
            ArrayList<Album> albums = Gerenciador.getInstance().buscarAlbum(tf_string.getText());
            if(albums !=null)
            for(Album a:albums){
                albumList.add(new AlbumTb(a.getNome(),a.getAnoLancamento(),a.getNumeroMusicas(),a.getAutor().getNome()));
            }
            tb_album.setItems(listaDeAlbums(albumList));
        }
    }
}
