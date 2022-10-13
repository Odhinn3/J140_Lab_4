package main;

import com.sun.javafx.scene.control.skin.Utils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.*;
import javafx.scene.Parent;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        
        Parent root = loader.load();

        Scene scene = new Scene(root);
        String style = getClass().getResource("mainstyle.css").toExternalForm();
        scene.getStylesheets().add(style);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}