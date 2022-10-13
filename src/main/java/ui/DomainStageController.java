
package ui;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Domain;
import model.Person;
import repository.Repository;
import static ui.PersonStageController.person;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class DomainStageController implements Initializable{

    @FXML
    private TableView<DomainTable> table;
    @FXML
    private TableColumn<DomainTable, Integer> idColumn;
    @FXML
    private TableColumn<DomainTable, String> webnameColumn;
    @FXML
    private TableColumn<DomainTable, String> ipColumn;
    @FXML
    private TableColumn<DomainTable, LocalDate> dateregColumn;
    @FXML
    private TableColumn<DomainTable, String> countryregColumn;

    private Repository repo;
 
    public DomainStageController() {
        repo = new Repository();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, Integer>("id"));
        webnameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("webname"));
        ipColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("domainname"));
        dateregColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, LocalDate>("datereg"));
        countryregColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("countryreg"));       
    }
    
    public void fillTable(Person person){
        ObservableList<DomainTable> observableList = FXCollections.observableArrayList();
        List<Domain> domainList = repo.getDomainByPersonId(person.getId());
        for(Domain domain : domainList){
            observableList.add(new DomainTable(domain.getId(),
                    domain.getWebname(),
                    domain.getDomainname(),
                    domain.getIp(),
                    domain.getDatereg(),
                    domain.getCountryreg()));
        }
        table.setItems(observableList);
    }
    
}
