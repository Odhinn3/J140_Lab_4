package ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Domain;
import model.Person;
import repository.Repository;
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
    @FXML
    private Button styleswitch;

    private Repository repo;
    private boolean switchcss = true;

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
    
    @FXML
    private void styleChangeAction(ActionEvent event) throws InterruptedException, IOException {
        
        if(switchcss){   
            table.getStylesheets().clear();
            table.getStylesheets().add("/style3.css");
        } else {
            table.getStylesheets().clear();
            table.getStylesheets().add("/style2.css");
        }
        setSwitchcss(!switchcss);
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
    
    public boolean isSwitchcss() {
        return switchcss;
    }

    public void setSwitchcss(boolean switchcss) {
        this.switchcss = switchcss;
    }
}