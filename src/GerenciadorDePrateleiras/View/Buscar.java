package GerenciadorDePrateleiras.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Buscar extends Application {

    public static void main(String[] args)
    {
        Application.launch();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("buscar.fxml"));
        /*Gerenciador Palavra*/
//        primaryStage.setTitle("Gerenciar Palavras");
//        primaryStage.setScene(new Scene(root, 600, 630));
        /*Jogo*/
        primaryStage.setTitle("GRIP");
        //prefHeight="927.0" prefWidth="1477.0"
        primaryStage.setScene(new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().width-100, Toolkit.getDefaultToolkit().getScreenSize().height-100));
        //Tamanho Gerenciador //
        primaryStage.setResizable(false);
        //

        //root.getStylesheets().add("Jogo/view/dark.css");
        primaryStage.show();
    }


}
