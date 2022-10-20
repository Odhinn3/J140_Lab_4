
package main;

import java.util.Iterator;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.User;
import repository.Repository;
import ui.PersonStage;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class AppController implements Initializable {
    private boolean isLogin;
    
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private Button btn;
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws InterruptedException {
        if(login(textField1.getText(), textField2.getText())){
                label.setTextFill(Color.web("006400"));
                label.setText("Login success!");
                try {
                    new PersonStage().init();
                } catch (Exception ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                label.setTextFill(Color.web("F70834"));
                label.setText("Login failed! Try again");    
            }
    }
    
    private boolean login(String name, String password) {
        Iterator iterator = new Repository().getUsers().iterator();
        while(iterator.hasNext()){
            User user = (User) iterator.next();
            if(user.getName().equals(name)&user.getPassword().equals(password)){
                isLogin = true;
                break;
            } else isLogin = false;
        }
        return isLogin;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
}