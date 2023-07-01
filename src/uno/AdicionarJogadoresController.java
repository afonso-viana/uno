package uno;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author rakke
 */
public class AdicionarJogadoresController implements Initializable {

    @FXML
    private Label jogardor1;
    @FXML
    private Label jogador2;
    @FXML
    private Label jogador3;
    @FXML
    private Label jogador4;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void botaoGuardarClick(ActionEvent event) {
    }

    @FXML
    private void butaoSairClick(ActionEvent event) {
    }
    
}
