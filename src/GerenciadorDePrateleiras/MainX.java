package GerenciadorDePrateleiras;

import GerenciadorDePrateleiras.Model.Grip;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import GerenciadorDePrateleiras.Control.JanelaBase;

import java.awt.*;
import java.io.IOException;

public class MainX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Pane root = loadMainPane();
        Scene cena = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().width-100, Toolkit.getDefaultToolkit().getScreenSize().height-100);
        cena.getStylesheets().add("GerenciadorDePrateleiras/Resources/css/dark.css");
        stage.setScene(cena);
        stage.setResizable(false);


        stage.setTitle("GRIP");
        stage.show();

    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        GerenciadorJanelas.BASE

                )
        );

        JanelaBase controller = loader.getController();

        GerenciadorJanelas.setControlador(controller);

        GerenciadorJanelas.loadJanela(GerenciadorJanelas.PRINCIPAL);

        return mainPane;
    }


    @Override
    public void init() throws Exception {
        super.init();
        try{

            Grip.getInstance().carregaDados();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        try{

            Grip.getInstance().salvaDados();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

