package GerenciadorDePrateleiras.Control;

import GerenciadorDePrateleiras.GerenciadorJanelas;
import GerenciadorDePrateleiras.Model.Item;
import GerenciadorDePrateleiras.Model.Musica;
import GerenciadorDePrateleiras.Model.Prateleira;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import javax.swing.text.html.ImageView;

public class GerenciarController {

    ImageView icone;
    private ObservableList<Prateleira> prateleiras;
    private ObservableList<Item> items;
    @FXML
    private TextField tfTitulo_hb_editarMusica,tfDuracao_hb_editarMusica;
    @FXML
    private ListView<Item> ltv_albums;
    @FXML
    private ListView<Musica> ltv_musicas;
    @FXML
    private HBox hb_editarIco,hb_addIco,hb_editarAlbum,hb_AddAlbum,hb_editarMusica,hb_adicionarMusica;

    @FXML
    public void initialize(){
        prateleiras = Gerenciador.getInstance().getPrateleiras();

        items = Gerenciador.getInstance().getItems();
        //adiciona um monitor, para verificar qualquer mudança na lista.
        //quando uma mudança ocorre (inclusão, remoção) o método onChange é executado
        //utilizamos aqui para atualizar o text com a quantidade de tarefas cadastradas
        items.addListener(new ListChangeListener<Item>() {
            @Override
            public void onChanged(Change<? extends Item> change) {
                // txtQtdeTarefas.setText("Total de Tarefas:"+Agenda.getInstance().getLista().size());
            }
        });

        //passamos a referência da lista para o listView.
        //Como a lista é observável, cada mudança na lista irá atualizar automaticamente o listView.
        ltv_albums.setItems(items);


        //podemos colocar um monitor para verificar quando um item da lista é selecionado.
        //quando isso ocorre, podemos atualizar partes da tela
        ltv_albums.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Item>() {
            @Override
            public void changed(ObservableValue<? extends Item> observableValue, Item antiga, Item nova) {

                //se um item for selecionado, mostramos os detalhes
                if(nova != null) {
                    ltv_musicas.getItems().clear();
                    ltv_musicas.getItems().setAll(nova.getAlbum().getMusicas());
                }
            }
        });


        //para ajustar como um item do listview é mostrado, podemos colocar ações para a
        //fábrica de células do listView. Assim, ao renderizar cada um dos items,
        //as ações serão executadas
        ltv_albums.setCellFactory(new Callback<ListView<Item>, ListCell<Item>>() {

            @Override
            public ListCell<Item> call(ListView<Item> tarefaListView) {

                ListCell<Item> celula = new ListCell<Item>(){

                    @Override
                    protected void updateItem(Item item, boolean vazio) {
                        super.updateItem(item, vazio);
                        if(vazio){
                            setText(null);
                        }else{

                            //icone.getImageURL().
                            setText(item.getTipo()+" - "+item.getAlbum().getAutor().getNome()+" - "+item.getAlbum().getNome());
                        }

                    }
                };
                return celula;
            }
        });






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
    private void mudarInterface(){

    }
    @FXML
    private void editarMusica(){
        //hbox editarmusica
        hb_addIco.setVisible(false);
        hb_editarIco.setVisible(true);
        hb_editarAlbum.setVisible(false);
        hb_AddAlbum.setVisible(false);
        hb_adicionarMusica.setVisible(false);
        Musica musica = ltv_musicas.getSelectionModel().getSelectedItem();
        tfTitulo_hb_editarMusica.setText(musica.getNome());

        for(String p:musica.getCompositores()){

        }
        tfDuracao_hb_editarMusica.setText(musica.getDuracao()+"");
        hb_editarMusica.setVisible(true);
    }
    @FXML
    private void editarMusicaConfirmar(){

    }
    @FXML
    private void apagarTela(){
        hb_addIco.setVisible(false);
        hb_editarIco.setVisible(false);
        hb_editarAlbum.setVisible(false);
        hb_AddAlbum.setVisible(false);
        hb_adicionarMusica.setVisible(false);
        hb_editarMusica.setVisible(false);
        hb_addIco.setVisible(false);
    }
    @FXML
    private void addMusica(){
        //hbox add musica
        hb_addIco.setVisible(true);
        hb_editarIco.setVisible(false);
        hb_editarAlbum.setVisible(false);
        hb_AddAlbum.setVisible(false);
        hb_editarMusica.setVisible(false);
        hb_adicionarMusica.setVisible(true);
    }
    @FXML
    private void addAlbum(){
        //hbox add Album
        hb_addIco.setVisible(true);
        hb_editarIco.setVisible(false);
        hb_AddAlbum.setVisible(true);
        hb_editarAlbum.setVisible(false);
        hb_editarMusica.setVisible(false);
        hb_adicionarMusica.setVisible(false);
    }
    @FXML
    private void editarAlbum(){
        //hbox edit Album
        hb_addIco.setVisible(false);
        hb_editarIco.setVisible(true);
        hb_editarAlbum.setVisible(true);
        hb_AddAlbum.setVisible(false);
        hb_editarMusica.setVisible(false);
        hb_adicionarMusica.setVisible(false);
    }
    @FXML
    private void removerAlbum(){
        Item item = ltv_albums.getSelectionModel().getSelectedItem();
        Gerenciador.getInstance().removerItem(item);
        ltv_albums.setItems(Gerenciador.getInstance().getItems());

    }
    @FXML
    private void removerMusica(){
        Musica musica = ltv_musicas.getSelectionModel().getSelectedItem();
        Item item = ltv_albums.getSelectionModel().getSelectedItem();
        item.getAlbum().getMusicas().remove(musica);
        ltv_musicas.getItems().clear();
        ltv_musicas.getItems().setAll(item.getAlbum().getMusicas());
    }

}
