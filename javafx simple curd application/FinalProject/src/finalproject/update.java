/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import static finalproject.login.infoBox;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.ConnectionUtil;


public class update implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtdept;
    @FXML
    private TextField txtbatch;
    @FXML
    private TextField txtphn;
    @FXML
    private Button addbtn;
     Connection connection = null;
    Statement statement = null;
    ResultSet rst=null;
    PreparedStatement pst=null;
     public update() {
    connection = ConnectionUtil.connectdb();
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
       
        try{
            String query="update studentinfo set id=?,name=?,dept=?,batch=?,phone=? where id='"+txtid.getText()+"'";
            pst = connection.prepareStatement(query);
            pst.setString(1, txtid.getText());
            pst.setString(2, txtname.getText());
            pst.setString(3, txtdept.getText());
            pst.setString(4, txtbatch.getText());
            pst.setString(5, txtphn.getText());
            pst.execute();
             
            infoBox("Updated", "Success", null);
             Node source = (Node) event.getSource();
           Stage dialogStage = (Stage) source.getScene().getWindow();
            dialogStage.close();
           Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FXMLMenu.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
    } catch (Exception ex){
           ex.printStackTrace();
       }
    
    
    }}
