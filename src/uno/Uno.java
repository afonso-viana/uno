/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rakke
 */
public class Uno extends Application {
    
     private static Scene scene;
/*
    @Override
    public void start(Stage stage) throws IOException {
        // Criação da janela principal do aplicativo
        
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Uno"); // Define o título da janela
        
        // Configuração da cena usando um arquivo FXML chamado "menu.fxml"
        try {
            scene = new Scene(loadFXML("Menu"), 400, 400); // Carrega o arquivo FXML
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        primaryStage.setScene(scene); // Define a cena na janela
        primaryStage.show(); // Mostra a janela
    }

    // Define a raiz da cena para o arquivo FXML especificado
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Carrega o arquivo FXML   
    private static Parent loadFXML(String fxml) throws IOException {
        // Cria um objeto FXMLLoader para carregar o arquivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(Uno.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load(); // Carrega o arquivo FXML
    }

    public static void main(String[] args) {
        launch();
    }
    */
     @Override
    public void start(Stage stage) throws IOException {
        GerirScenes gerirScenes = GerirScenes.getInstance();
        gerirScenes.addScene("menuInicial","Menu.fxml",600,400);
        gerirScenes.addScene("adicionarJogadores","AdicionarJogadores.fxml",600,400);
        

        stage.getIcons().add(new Image(getClass().getResourceAsStream("assets/UNO_Logo.png")));
        stage.setResizable(false);
        stage.setTitle("Uno");
        stage.setScene(gerirScenes.getScene("menuInicial"));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}

