package GerenciadorDePrateleiras.Control;

import GerenciadorDePrateleiras.GerenciadorJanelas;
import GerenciadorDePrateleiras.Model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class GerenciarController {

    private Image iconeVinils,iconeK7s,iconeCds,miniIconeVinils,miniIconeK7s,miniIconeCds,iconeAutor;
    private ObservableList<Prateleira> prateleiras;
    private ObservableList<Item> items;
    @FXML
    private ImageView icoAddAlbum,icoEditarAlbum,iconesLVT;
    @FXML
    private ComboBox<Autor> cbAutor_hb_addAlbum,cbAutor_hb_editarAlbum;
    //textfields musicas
    @FXML
    private TextField tfTitulo_hb_editarMusica,tfDuracao_hb_editarMusica, tfAutor_hb_addMusica,tfTitulo_hb_addMusica,tfDuracao_hb_addMusica,tfCompositor_hb_editarMusica;
    //textfields Albuns

    @FXML
    private RadioButton rbVinil_hb_addAlbum,rbK7_hb_addAlbum,rbCD_hb_addAlbum,rbVinil_hb_editarAlbum,rbCD_hb_editarAlbum,rbK7_hb_editarAlbum;
    @FXML
    private TextField tfTitulo_hb_addAlbum,tfAno_hb_addAlbum,tfAno_hb_editarAlbum,tfTitulo_hb_editarAlbum;
    @FXML
    private ListView<Item> ltv_albums;
    @FXML
    private ListView<Musica> ltv_musicas;
    @FXML
    private HBox hb_editarIco,hb_addIco,hb_editarAlbum,hb_AddAlbum,hb_editarMusica,hb_adicionarMusica;

    public GerenciarController() {
        iconeVinils = new Image(getClass().getResource("../Resources/img/vinyl-record.png").toExternalForm(), true);
        iconeK7s = new Image(getClass().getResource("../Resources/img/icons8-unidade-de-fita-filled-100.png").toExternalForm(), true);
        iconeCds = new Image(getClass().getResource("../Resources/img/icons8-gravar-música-64.png").toExternalForm(), true);
        miniIconeK7s = new Image(getClass().getResource("../Resources/img/minicassete.png").toExternalForm(),true);
        miniIconeCds = new Image(getClass().getResource("../Resources/img/minicd.png").toExternalForm(),true);
        miniIconeVinils = new Image(getClass().getResource("../Resources/img/minivinil.png").toExternalForm(),true);
        iconeAutor = new Image(getClass().getResource("../Resources/img/autorAdd.png").toExternalForm(),true);
    }

    @FXML
    public void initialize(){
        prateleiras = Grip.getInstance().getPrateleiras();

        items = Grip.getInstance().getItems();
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


        ltv_albums.setCellFactory(param -> new ListCell<Item>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(Item item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if(item.getTipo().toUpperCase().equals("CD"))
                        imageView.setImage(miniIconeCds);
                    else if(item.getTipo().toUpperCase().equals("K7"))
                        imageView.setImage(miniIconeK7s);
                    else
                        imageView.setImage(miniIconeVinils);

                    setText(item.toString());
                    setGraphic(imageView);
                }
            }
        });
        /*ltv_albums.setCellFactory(new Callback<ListView<Item>, ListCell<Item>>() {
            private ImageView imageView = new ImageView();
            @Override

            public ListCell<Item> call(ListView<Item> tarefaListView) {
                ListCell<Item> celula = new ListCell<Item>(){

                    @Override
                    protected void updateItem(Item item, boolean vazio) {
                        super.updateItem(item, vazio);
                        if(vazio){
                            setText(null);
                            setGraphic(null);
                        }else{
                            if(item.getTipo().toLowerCase().contains("cd"))
                                imageView.setImage(iconeCds);
                            else if(item.getTipo().toLowerCase().contains("k7"))
                                imageView.setImage(iconeK7s);
                            else
                                imageView.setImage(iconeVinils);
                            //icone.getImageURL().
                            setText(item.getTipo()+" - "+item.getAlbum().getAutor().getNome()+" - "+item.getAlbum().getNome());
                            setGraphic(imageView);
                        }

                    }
                };
                return celula;
            }
        });
*/





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

        if(rbVinil_hb_addAlbum.isSelected()){
            icoAddAlbum.setImage(iconeVinils);
        }else if(rbK7_hb_addAlbum.isSelected()){
            icoAddAlbum.setImage(iconeK7s);
        }else if(rbCD_hb_addAlbum.isSelected()){
            icoAddAlbum.setImage(iconeCds);
        }

        if(rbCD_hb_editarAlbum.isSelected()){
            icoEditarAlbum.setImage(iconeCds);
        }else if(rbK7_hb_editarAlbum.isSelected()){
            icoEditarAlbum.setImage(iconeK7s);
        }else if(rbVinil_hb_editarAlbum.isSelected()){
            icoEditarAlbum.setImage(iconeVinils);
        }

    }
    @FXML
    private void addAutor(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Adicionar Autor");
        DialogPane dialog = alert.getDialogPane();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass()
                    .getResource("../view/addAutor.fxml"));
            Parent content = loader.load();
            ImageView image = new ImageView();
            image.setImage(iconeAutor);
            dialog.setHeaderText("Preencha os campos");
            dialog.setGraphic(image);
            dialog.setContent(content);
            dialog.getStyleClass().add("root");
            dialog.getStylesheets().add(
                    getClass().getResource("../Resources/css/dark.css").toExternalForm());
            Optional<ButtonType> resultado = alert.showAndWait();
            if (resultado.isPresent() &&
                    resultado.get() == ButtonType.OK) {
                ControllerAutor controle = loader.getController();

                Autor autor = controle.pegaResultado();
                if (autor != null) {
                    Grip.getInstance().adicionarAutor(autor);
                }
            }
        } catch (IOException e) {
            messagemERRO("Presta Ateção!","Ocorreu um erro inesperado ao add Autor","não sei o que houve");
        }
    }
    @FXML
    private void editarMusica(){
        try {
            //hbox editarmusica
            Musica musica = ltv_musicas.getSelectionModel().getSelectedItem();
            tfTitulo_hb_editarMusica.setText(musica.getNome());
            hb_addIco.setVisible(false);
            hb_editarIco.setVisible(true);
            hb_editarAlbum.setVisible(false);
            hb_AddAlbum.setVisible(false);
            hb_adicionarMusica.setVisible(false);

            String compositores = "";
            boolean entrou = false;
            for (String p : musica.getCompositores()) {
                if (entrou)
                    compositores += ", ";
                compositores += p;
                entrou = true;
            }

            tfCompositor_hb_editarMusica.setText(compositores);
            tfDuracao_hb_editarMusica.setText(musica.getDuracao() + "");
            hb_editarMusica.setVisible(true);
        }catch (NullPointerException e){

            messagemERRO("Presta atenção!","Ocorreu um erro","Selecione uma musica antes de tentar editar");

        }
    }
    @FXML
    private void onCofirmarEditarAlbum(){
        try {
            if(tfTitulo_hb_editarAlbum.getText().trim().compareTo("") == 0 || tfAno_hb_editarAlbum.getText().trim().compareTo("")==0) {
                Musica musica = null;
                musica.getNome();
            }
            int ano = Integer.parseInt(tfAno_hb_editarAlbum.getText());
            String titulo = tfTitulo_hb_editarAlbum.getText();
            Autor autor = cbAutor_hb_editarAlbum.getValue();
            String tipo;
            if (rbK7_hb_editarAlbum.isSelected()) {
                tipo = "K7";
            } else if (rbCD_hb_editarAlbum.isSelected()) {
                tipo = "CD";
            } else {
                tipo = "Vinil";
            }
            Album album = new Album(titulo, ano, autor);
            Grip.getInstance().editarItem(ltv_albums.getSelectionModel().getSelectedItem(),new Item(tipo, album));
            ltv_albums.setItems(Grip.getInstance().getItems());
            apagarTela();
        }catch (NullPointerException e){
            messagemERRO("Presta Ateção!","Ocorreu um erro","Preencha todos os campos antes de cadastrar album");
        }catch (NumberFormatException e) {
            messagemERRO("Presta Ateção!","Ocorreu um erro","Digite apenas numeros");
        }catch(Exception e){
            messagemERRO("Presta Ateção!","Ocorreu um erro inesperado","não sei o que houve");
        }
    }
    @FXML
    private void onCofirmarAddAlbum(){
        try {
            if(tfTitulo_hb_addAlbum.getText().trim().compareTo("") == 0 || tfAno_hb_addAlbum.getText().trim().compareTo("")==0) {
                Musica musica = null;
                musica.getNome();
            }

            int ano = Integer.parseInt(tfAno_hb_addAlbum.getText());
            String titulo = tfTitulo_hb_addAlbum.getText();
            Autor autor = cbAutor_hb_addAlbum.getValue();
            String tipo;
            if (rbK7_hb_addAlbum.isSelected()) {
                tipo = "K7";
            } else if (rbCD_hb_addAlbum.isSelected()) {
                tipo = "CD";
            } else {
                tipo = "Vinil";
            }
            Album album = new Album(titulo, ano, autor);
            Grip.getInstance().adicionarItem(new Item(tipo, album));
            ltv_albums.setItems(Grip.getInstance().getItems());
            apagarTela();
        }catch (NullPointerException e){
            messagemERRO("Presta Ateção!","Ocorreu um erro","Preencha todos os campos antes de cadastrar o album");
        }catch (NumberFormatException e) {
            messagemERRO("Presta Ateção!","Ocorreu um erro","Digite apenas numeros");
        }catch(Exception e){
            messagemERRO("Presta Ateção!","Ocorreu um erro inesperado","não sei o que houve");
        }
    }
    @FXML
    private void confirmarAddMusica(){
        String nome = tfTitulo_hb_addMusica.getText();
        String duracao = tfDuracao_hb_addMusica.getText();
        ArrayList<String> autor = new ArrayList<>();
        String compositores[];
        if(tfAutor_hb_addMusica.getText().contains(",") || tfAutor_hb_addMusica.getText().contains("/")) {
            if(tfAutor_hb_addMusica.getText().contains("/"))
                compositores = tfAutor_hb_addMusica.getText().split("/");
            else
            compositores = tfAutor_hb_addMusica.getText().split(",");
            ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(compositores));
            autor.addAll(stringList);
        }else{
            autor.add(tfAutor_hb_addMusica.getText());
        }

        Musica musica = new Musica(nome,autor,duracao);
        Item item = ltv_albums.getSelectionModel().getSelectedItem();
        item.getAlbum().adicionarMusica(musica);
        ltv_musicas.getItems().clear();
        ltv_musicas.getItems().setAll(item.getAlbum().getMusicas());
    }
    @FXML
    private void editarMusicaConfirmar(){
        String nome = tfTitulo_hb_editarMusica.getText();
        String duracao = tfDuracao_hb_editarMusica.getText();
        ArrayList<String> autor = new ArrayList<>();
        String compositores[];
        if(tfCompositor_hb_editarMusica.getText().contains(",") || tfCompositor_hb_editarMusica.getText().contains("/")) {
            if(tfCompositor_hb_editarMusica.getText().contains("/"))
                compositores = tfCompositor_hb_editarMusica.getText().split("/");
            else
                compositores = tfCompositor_hb_editarMusica.getText().split(",");
            ArrayList<String> stringList = new ArrayList<>(Arrays.asList(compositores));
            autor.addAll(stringList);
        }else{
            autor.add(tfCompositor_hb_editarMusica.getText());
        }
        Musica antiga = ltv_musicas.getSelectionModel().getSelectedItem();
        Musica nova = new Musica(nome,autor,duracao);
        Item item = ltv_albums.getSelectionModel().getSelectedItem();
        item.getAlbum().editarMusica(antiga,nova);
        ltv_musicas.getItems().clear();
        ltv_musicas.getItems().setAll(item.getAlbum().getMusicas());
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
        try {
            if(ltv_albums.getSelectionModel().getSelectedItem().getAlbum().getNome().compareTo("") !=0) {
                hb_addIco.setVisible(true);
                hb_editarIco.setVisible(false);
                hb_editarAlbum.setVisible(false);
                hb_AddAlbum.setVisible(false);
                hb_editarMusica.setVisible(false);
                hb_adicionarMusica.setVisible(true);
                tfAutor_hb_addMusica.clear();
                tfDuracao_hb_addMusica.clear();
                tfTitulo_hb_addMusica.clear();
            }
        }catch (NullPointerException e){
            messagemERRO("Presta Atenção!","Ocorreu um erro","Selecione um album antes de tentar adicionar uma nova musica");
        }
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
        cbAutor_hb_addAlbum.setItems(Grip.getInstance().getAutores());

    }
    @FXML
    private void editarAlbum(){
        try {
            Item item = ltv_albums.getSelectionModel().getSelectedItem();
            item.getAlbum().getNome();
            hb_addIco.setVisible(false);
            hb_editarIco.setVisible(true);
            hb_editarAlbum.setVisible(true);
            hb_AddAlbum.setVisible(false);
            hb_editarMusica.setVisible(false);
            hb_adicionarMusica.setVisible(false);

            cbAutor_hb_editarAlbum.setItems(Grip.getInstance().getAutores());
            cbAutor_hb_editarAlbum.getSelectionModel().select(item.getAlbum().getAutor());
            tfTitulo_hb_editarAlbum.setText(item.getAlbum().getNome());
            if (item.getTipo().compareTo("K7") == 0) {
                rbK7_hb_editarAlbum.setSelected(true);
                icoEditarAlbum.setImage(iconeK7s);
            } else if (item.getTipo().compareTo("CD") == 0) {
                rbCD_hb_editarAlbum.setSelected(true);
                icoEditarAlbum.setImage(iconeCds);
            } else {
                rbVinil_hb_editarAlbum.setSelected(true);
                icoEditarAlbum.setImage(iconeVinils);
            }
            tfAno_hb_editarAlbum.setText(item.getAlbum().getAnoLancamento() + "");
        }catch (NullPointerException e){
            messagemERRO("Presta Atenção!","Ocorreu um erro","Selecione um album antes de tentar editar");
        }
    }



    @FXML
    private void removerAlbum(){
        try {
            Item item = ltv_albums.getSelectionModel().getSelectedItem();
            item.getAlbum().getNome();
            Grip.getInstance().removerItem(item);
            ltv_albums.setItems(Grip.getInstance().getItems());
            ltv_musicas.getItems().clear();
            apagarTela();
        }catch (NullPointerException e){
            messagemERRO("Presta Atenção!","Ocorreu um erro","Selecione um album antes de tentar remover");
        }
    }
    @FXML
    private void removerMusica(){
       try {
           Musica musica = ltv_musicas.getSelectionModel().getSelectedItem();
           musica.getNome();
           Item item = ltv_albums.getSelectionModel().getSelectedItem();
           item.getAlbum().getMusicas().remove(musica);
           ltv_musicas.getItems().clear();
           ltv_musicas.getItems().setAll(item.getAlbum().getMusicas());
           apagarTela();
       }catch(NullPointerException e){
           messagemERRO("Presta Atenção!","Ocorreu um erro","Selecione uma musica antes de tentar remover.");
       }

    }
    private void messagemERRO(String titulo, String erro,String msg){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(erro);
        alert.setContentText(msg);


        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("../Resources/css/dark.css").toExternalForm());
        dialogPane.getStyleClass().add("root");
        Optional<ButtonType> resultado = alert.showAndWait();
    }
}
