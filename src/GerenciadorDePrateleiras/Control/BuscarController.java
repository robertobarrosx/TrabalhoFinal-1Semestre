package GerenciadorDePrateleiras.Control;

import GerenciadorDePrateleiras.GerenciadorJanelas;
import GerenciadorDePrateleiras.Model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.*;

public class BuscarController {


    private Image iconeImportar,iconeExportar;
    @FXML
    private TextField tf_string;

    @FXML
    private HBox hb_musica,hb_autor,hb_album,hb_autorB,hb_albumB;

    @FXML
    private TableColumn<MusicTb,String> tb_musicaColNome, tb_musicaColNomeAlbum, tb_musicaColCompositores;
    @FXML
    private TableColumn<MusicTb, String> tb_musicaColDuracao;

    @FXML
    private TableColumn<AutorTb,String> tb_autorColTipo, tb_autorColNome, tb_autorColCidade,tb_autorColAlbum;
    @FXML
    private TableColumn<AutorTb,Integer> tb_autorColAno;
    @FXML
    private TableColumn<AlbumTb,String> tb_albumColNome, tb_albumColAutor,tb_albumColMusicas;
    @FXML
    private TableColumn<AlbumTb,Integer> tb_albumColAno, tb_albumColQtdMusicas,tb_albumColTipo,tb_albumColPrateleira,tb_albumColPosicao;

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

    public BuscarController(){
        iconeImportar = new Image(getClass().getResource("../Resources/img/import.png").toExternalForm(),true);
        iconeExportar = new Image(getClass().getResource("../Resources/img/export.png").toExternalForm(),true);
    }
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

        tb_albumColTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));
        tb_albumColNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        tb_albumColAno.setCellValueFactory(
                new PropertyValueFactory<>("anoLancamento"));
        tb_albumColQtdMusicas.setCellValueFactory(
                new PropertyValueFactory<>("numeroMusicas"));
        tb_albumColAutor.setCellValueFactory(
                new PropertyValueFactory<>("autor"));
        tb_albumColMusicas.setCellValueFactory(
                new PropertyValueFactory<>("musicas"));
        tb_albumColPrateleira.setCellValueFactory(
                new PropertyValueFactory<>("prateleira"));
        tb_albumColPosicao.setCellValueFactory(
                new PropertyValueFactory<>("posicao"));
        tb_album.setItems(listaDeAlbums(albumList));


        tb_autorColNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        tb_autorColCidade.setCellValueFactory(
                new PropertyValueFactory<>("cidadeOrigem"));
        tb_autorColTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));
        tb_autorColAno.setCellValueFactory(
                new PropertyValueFactory<>("anoNascimento"));
        tb_autorColAlbum.setCellValueFactory(
                new PropertyValueFactory<>("albums"));
        tb_album.setItems(listaDeAlbums(albumList));
    }

    @FXML
    private void mudarInterface(){
        hb_autor.setVisible(false);
        hb_musica.setVisible(false);
        hb_album.setVisible(false);
        tf_string.clear();
        if(rb_musica.isSelected()) {
            musicList.clear();
            tb_musica.setItems(listaDeMusicas(musicList));
            hb_musica.setVisible(true);
            tf_string.setPromptText("Digite o nome da musica ou o nome de um dos compositores");
        }
        else if(rb_autor.isSelected()) {
            autorList.clear();
            tb_autor.setItems(listaDeAutor(autorList));
            hb_autor.setVisible(true);
            tf_string.setPromptText("Digite o nome do cantor ou o nome da banda");
        }else{
            albumList.clear();
            tb_album.setItems(listaDeAlbums(albumList));
            hb_album.setVisible(true);
            tf_string.setPromptText("Digite o nome do album ou o nome do autor");
        }
    }
    @FXML
    private void janelaBuscar(){
        GerenciadorJanelas.loadJanela(GerenciadorJanelas.PRINCIPAL);
    }
    @FXML
    private void janelaGerenciar(){
        GerenciadorJanelas.loadJanela(GerenciadorJanelas.JANELA_GERENCIAR);
    }
    @FXML
    private void janelaAjuda(){
        GerenciadorJanelas.loadJanela(GerenciadorJanelas.ADD_ALBUM);
    }

    @FXML
    private void importarDados(){
        Grip.getInstance().importarDados();
    }

    @FXML
    private void exportarDados(){
        Grip.getInstance().exportarDados();
    }
    @FXML
    private void listarAlbums(){

    }
    @FXML
    private void listarMusicas(){

    }
    private void messagemAviso(String titulo, String erro,String msg){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(erro);
        alert.setContentText(msg);
        ImageView image = new ImageView();
        image.setFitHeight(50);
        image.setFitWidth(50);
        if(titulo.compareTo("Importação de items") == 0){
            image.setImage(iconeImportar);
            alert.setGraphic(image);
        }
        else if(titulo.compareTo("Exportação de items") == 0) {
            image.setImage(iconeExportar);
            alert.setGraphic(image);
        }

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("../Resources/css/dark.css").toExternalForm());
        dialogPane.getStyleClass().add("root");
        Optional<ButtonType> resultado = alert.showAndWait();
    }
    @FXML
    private void buscar(){
        if(rb_musica.isSelected()) {
            ArrayList<Album> albums = Grip.getInstance().buscarAlbum();
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
            /*for (MusicTb a : musicList)
                System.out.println(a.getNome());*/
            tb_musica.setItems(listaDeMusicas(musicList));
        }else if(rb_autor.isSelected()){
            autorList.clear();
            ArrayList<Autor> autores = Grip.getInstance().buscarAutor(tf_string.getText());
            if(autores != null)
            for(Autor a:autores){
                ArrayList<String> pa = new ArrayList<>();
                for(Album albs: Grip.getInstance().buscarAlbum()){
                    if(albs.getAutor().equals(a))
                        pa.add(albs.getNome());
                }

                autorList.add(new AutorTb(a.getNome(),a.tipo(),a.getCidadeOrigem(),a.getAnoNascimento(),pa));
            }
            tb_autor.setItems(listaDeAutor(autorList));
        }else{
            albumList.clear();
            ArrayList<Prateleira> prateleiras  = new ArrayList<>(Grip.getInstance().getPrateleiras());

            for(Prateleira p:prateleiras) {
                for(Item i:p.getItems()){
                    if(i.getAlbum().getAutor().getNome().toLowerCase().contains(tf_string.getText().toLowerCase()) || i.getAlbum().getNome().toLowerCase().contains(tf_string.getText().toLowerCase())){
                        albumList.add(new AlbumTb(i.getTipo(),i.getAlbum().getNome(), i.getAlbum().getAnoLancamento(), i.getAlbum().getNumeroMusicas(), i.getAlbum().getAutor().getNome(), i.getAlbum().getMusicas(),p.getNumero(),i.getPosicao()));
                    }

                }
            }
            tb_album.setItems(listaDeAlbums(albumList));
        }
    }
}
