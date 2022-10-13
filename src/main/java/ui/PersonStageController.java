
package ui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Person;
import repository.Repository;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class PersonStageController implements Initializable{

    @FXML
    private TableView<PersonTable> table;
    @FXML
    private TableColumn<PersonTable, Integer> idColumn;
    @FXML
    private TableColumn<PersonTable, String> jobtitleColumn;
    @FXML
    private TableColumn<PersonTable, String> nameColumn;
    @FXML
    private TableColumn<PersonTable, String> phoneColumn;
    @FXML
    private TableColumn<PersonTable, String> emailColumn;
    @FXML
    private TableColumn<PersonTable, Integer> domColumn;
    
    public static Person person;
    private Repository repo;

    public PersonStageController() {
        repo = new Repository();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PersonTable> observableList = FXCollections.observableArrayList();
        List<Person> personList = repo.getPersons();
        for(Person person : personList){
            int domainnumber = repo.getDomainByPersonId(person.getId()).size(); 
                observableList.add(new PersonTable(
                    person.getId(), 
                    person.getJobtitle(), 
                    person.getName(), 
                    person.getPhone(), 
                    person.getEmail(),
                    domainnumber));        
        }
        idColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("id"));
        jobtitleColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("jobtitle"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("email"));
        domColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("d"));
        table.setItems(observableList);
        
        table.setOnMouseClicked((MouseEvent e)->{
            if(e.getClickCount()==2){
                PersonTable personTable = table.getSelectionModel().getSelectedItem();
                person = repo.getPersonById(personTable.getId());
                DomainStage domainStage = new DomainStage(person);
                try {
                    
                    domainStage.init();
                } catch (IOException ex) {
                    Logger.getLogger(PersonStageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
