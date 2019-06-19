package GerenciadorDePrateleiras.Control;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;


public class JanelaBase {

    @FXML
    private StackPane painelBase;

    public void setJanela(Node node){
        painelBase.getChildren().setAll(node);
    }

}
