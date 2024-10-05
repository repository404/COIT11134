/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coit11134.staffphonebook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author kenzlerb
 */
public class AddPhoneSceneController implements Initializable {


    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhone;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnCancel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void submitAction(ActionEvent event) {
        System.out.println("You clicked on Add!");
        if (!txtName.getText().equals("") && !txtPhone.getText().equals("")) {
            PhoneNumber ph = new PhoneNumber(txtName.getText(), txtPhone.getText());
            // Adding the employee phone number to the PhoneNo ArrayList
            App.getDataHandler().addPhoneNo(ph);
            //Return to the Main scene
            App.changeScene(0);
        } else {
            System.out.println("All fields must be completed");
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        System.out.println("You clicked on Cancel!");
        //Returns to the Main scene
        App.changeScene(0);
    }

}
