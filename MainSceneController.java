/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coit11134.staffphonebook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author kenzlerb
 */
public class MainSceneController implements Initializable {

    @FXML
    private TextArea txtOutput;
    @FXML
    private Button btnDisplay;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnSave;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clearAction(ActionEvent event) {

        System.out.println("You clicked on Clear!");
        // Clears the text area
        txtOutput.setText("");
    }

    @FXML
    private void saveAction(ActionEvent event) {
        System.out.println("You clicked on Save!");
        //All data saved to the text file
        App.getDataHandler().saveData();
    }

    @FXML
    private void displayAction(ActionEvent event) throws FileNotFoundException {
        //readDataFileAndDisplay();  // Part I
        System.out.println("You clicked on display");
        txtOutput.setText(App.getDataHandler().getDisplayOutput());
    }

    @FXML
    private void addAction(ActionEvent event) {
        System.out.println("You clicked on Add!");
        //Switch to the AddNumber scene
        App.changeScene(1);
    }

    @FXML
    private void exitAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to Close?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Platform.exit();
            }
        });
    }



    public void readDataFileAndDisplay() throws FileNotFoundException {
        int count = 0;            // number of entries
        String allPhone = "";     // to store all names and phones as a single value

        try {
            Scanner in = new Scanner(new FileReader("staffphone.txt"));//open file
            String myEntry = "";
            String name = "";
            String phone = "";

            while (in.hasNextLine()) {
                myEntry = in.nextLine();
                StringTokenizer st = new StringTokenizer(myEntry, ",");
                while (st.hasMoreTokens()) {
                    name = st.nextToken();
                    phone = st.nextToken();
                }
                allPhone = allPhone + name + "  " + phone + "\n";
                count++;
            }// end of while loop
            in.close();//close file
        } catch (ArrayIndexOutOfBoundsException ex) {
            //…
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "File reading exception");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    Platform.exit();
                }
            });
        }
        //to display the values in the text area having the fx:id txtDisplay
        txtOutput.setText(allPhone + "\n" + "Total number of phone entry is: " + count);
    }
}//end of readDataFileAndDisplay method
