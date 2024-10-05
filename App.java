package coit11134.staffphonebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

public class App extends Application {
    private static Scene sceneMain;
    private static Scene sceneAddNumber;
    private static Stage stage;
    private static DataHandler data;      

    public void start(Stage stage) throws IOException {        
        //Instatiates the DataHandler object
        data = new DataHandler("staffphone.txt");         
        
        //Creates the Main and AddNumber scene 
        Parent rootMain = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        Parent rootAddNum = FXMLLoader.load(getClass().getResource("addPhoneScene.fxml"));
        
        sceneMain = new Scene(rootMain);
        sceneAddNumber = new Scene(rootAddNum);
        
        this.stage = stage;
        //set the current scene to the main scene
        stage.setScene(sceneMain);
        stage.show();
    }
 //Method for passing a reference to the data object
    public static DataHandler getDataHandler() {
        return data;
    }  
    
    //Method for switching scenes
    public static void changeScene(int sc)  {
        switch(sc) { 
            case 0: stage.setScene(sceneMain); break;
            case 1: stage.setScene(sceneAddNumber); break;
            default:
        } 
    }
    
   //Method for exiting the application
    public static void exit()    { 
        stage.close();
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}
