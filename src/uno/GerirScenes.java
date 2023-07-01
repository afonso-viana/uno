/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import com.sun.javaws.Main;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author neon
 */
public class GerirScenes {
    private static GerirScenes uniqueInstance = null;
    private final HashMap<String, Scene> map = new HashMap<>();
    private GerirScenes () {};

    public static GerirScenes getInstance(){
        if (uniqueInstance == null)
            uniqueInstance = new GerirScenes();
        return uniqueInstance;
    }
    
    public Scene getScene(String key){
        return map.get(key);
    }
    
    public void addScene(String key, String viewPath, int x, int y) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(Uno.class.getResource(viewPath))), x, y);
        map.put(key,scene);
    }
    
    public void switchScene(MouseEvent event, String sceneKey){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(getScene(sceneKey));
    }

    public void switchScene(ActionEvent event, String sceneKey){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(getScene(sceneKey));
    }

    public void switchScene(Stage stage, String sceneKey){
        stage.setScene(getScene(sceneKey));
    }
}
