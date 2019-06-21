package GerenciadorDePrateleiras.Control;

import GerenciadorDePrateleiras.Model.Autor;
import GerenciadorDePrateleiras.Model.Banda;
import GerenciadorDePrateleiras.Model.Musico;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.Optional;

public class ControllerAutor {
    @FXML
    private TextField tf_nome,tf_cidade,tf_ano;
    @FXML
    private JFXToggleButton tb_autor;
    public Autor pegaResultado(){
        Autor autor;

            String nome = tf_nome.getText();
            String cidade = tf_cidade.getText();
            String ano = tf_ano.getText();

            if (nome.compareTo("") == 0 || cidade.compareTo("") == 0 || ano.compareTo("") == 0) {


                mensagem("Preencha todos os campos por favor!");
                return null;
            }

        try {
            if(tb_autor.isSelected()) {
                autor = new Banda(nome, cidade, Integer.parseInt(ano));
            }else{
                autor = new Musico(nome, cidade, Integer.parseInt(ano));
            }
            return autor;
        }catch (Exception e){
            mensagem("Preencha o ano apenas com numeros!");
        }
        return null;
    }
    private void mensagem(String msg){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(msg);


        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("../Resources/css/dark.css").toExternalForm());
        dialogPane.getStyleClass().add("root");
        Optional<ButtonType> resultado = alert.showAndWait();
    }
}
