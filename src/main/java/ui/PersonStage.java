package ui;

import java.io.IOException;
import repository.Repository;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class PersonStage extends Stage{ 
       
    private Repository repo;

    public PersonStage() {
        repo = new Repository();
    }

    public void init() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PersonStage.fxml"));
        Scene scene = new Scene(root);    
        setTitle("Persons");
        setScene(scene);
        show();   
    }
}