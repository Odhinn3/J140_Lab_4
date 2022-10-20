package ui;

import java.io.IOException;
import model.Person;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class DomainStage extends Stage{
    protected static Person person;

    public DomainStage(Person person){       
        this.person = person;
    }
    
    public void init() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DomainStage.fxml"));
        Parent root = loader.load();
        DomainStageController controller = loader.getController();
        controller.fillTable(person);
        Scene scene = new Scene(root);
        String style = getClass().getResource("/style2.css").toExternalForm();
        scene.getStylesheets().add(style);
        initModality(Modality.APPLICATION_MODAL);
        setTitle("User domains");
        setScene(scene);
        show();
    }  
}