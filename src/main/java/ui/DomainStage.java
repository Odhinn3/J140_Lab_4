package ui;

import java.io.IOException;
import model.Person;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class DomainStage extends Stage{
    private Person person;

    public DomainStage(Person person){       
        this.person = person;
    }
    
    public void init() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DomainStage.fxml"));
        Parent root = loader.load();
        DomainStageController controller = loader.getController();
        controller.fillTable(person);
        Scene scene = new Scene(root);
        setTitle("User domains");
        setScene(scene);
        show();
    }
}