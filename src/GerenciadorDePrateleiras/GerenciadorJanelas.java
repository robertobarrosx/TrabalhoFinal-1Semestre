package GerenciadorDePrateleiras;

import GerenciadorDePrateleiras.Control.JanelaBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class GerenciadorJanelas {

    public static final String BASE    = "view/node.fxml";
    public static final String PRINCIPAL    = "view/buscar.fxml";
    public static final String JANELA_GERENCIAR = "view/gerenciador.fxml";
    public static final String ADD_MUSICA= "view/gerenciarAddMusica.fxml";
    public static final String ADD_ALBUM= "view/gerenciador.fxml";
    public static final String EDITAR_ALBUM = "view/gerenciarEditarAlbum.fxml";
    public static final String EDITAR_MUSICA ="view/gerenciarEditarMusica.fxml";

    private static JanelaBase controlador;

    public static void setControlador(JanelaBase controlador) {
        GerenciadorJanelas.controlador = controlador;
    }


    public static void loadJanela(String fxml) {
        try {
            controlador.setJanela(
                    (Node) FXMLLoader.load(
                            GerenciadorJanelas.class.getResource(
                                    fxml
                            )
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}