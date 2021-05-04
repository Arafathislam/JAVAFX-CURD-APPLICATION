/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import static finalproject.login.infoBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.ConnectionUtil;


public class delete implements Initializable {

    @FXML
    private TextField txtid;
    Connection connection = null;
    PreparedStatement pst = null;
       public delete() {
    connection = ConnectionUtil.connectdb();
}
   
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        String query="delete from studentinfo where id= ?";
       try{
           pst = connection.prepareStatement(query);
           pst.setString(1, txtid.getText());
           pst.execute();
           infoBox("Delete", "Success", null);
           Node source = (Node) event.getSource();
           Stage dialogStage = (Stage) source.getScene().getWindow();
           dialogStage.close();
           Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FXMLMenu.fxml")));
           dialogStage.setScene(scene);
           dialogStage.show();
       }catch (Exception ex){
           ex.printStackTrace();
       }
        
    }
    
}
