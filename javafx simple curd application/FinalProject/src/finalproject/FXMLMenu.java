/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MD.ARAFATH ISLAM
 */
public class FXMLMenu implements Initializable {

    @FXML
    private Button addbtn;
    @FXML
    private Button delectbtn;
    @FXML
    private Button updatebtn;
    @FXML
    private Button showbtn;

   Stage dialogStage = new Stage();
   Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==addbtn){
            Node source = (Node) event.getSource();
            dialogStage = (Stage) source.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Add.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        }
        if(event.getSource()==delectbtn){
             Node source = (Node) event.getSource();
            dialogStage = (Stage) source.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Delete.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        } 
        if(event.getSource()==updatebtn){
             Node source = (Node) event.getSource();
            dialogStage = (Stage) source.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("Update.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        } 
        if(event.getSource()==showbtn){
            Node source = (Node) event.getSource();
            dialogStage = (Stage) source.getScene().getWindow();
            dialogStage.close();
            scene = new Scene(FXMLLoader.load(getClass().getResource("ShowAll.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
        }
    }
    
}
