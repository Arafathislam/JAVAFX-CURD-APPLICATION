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
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.ConnectionUtil;

/**
 * FXML Controller class
 *
 * @author MD.ARAFATH ISLAM
 */
public class showall implements Initializable {
     @FXML
    private TableView<Modelshow> table;
    @FXML
    private TableColumn<Modelshow, String> tvid;
    @FXML
    private TableColumn<Modelshow, String> tvname;
    @FXML
    private TableColumn<Modelshow, String> tvdept;
    @FXML
    private TableColumn<Modelshow, String> tvbatch;
    @FXML
    private TableColumn<Modelshow, String> tvphn;
    Connection connection = null;
    ResultSet rst=null;
    ObservableList<Modelshow> obl= FXCollections.observableArrayList();
      public showall() {
    connection = ConnectionUtil.connectdb();
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
           rst=connection.createStatement().executeQuery("Select * from studentinfo"); 
           while(rst.next()){
               obl.add(new Modelshow(rst.getString("id"),rst.getString("name"),rst.getString("dept"),rst.getString("batch"),rst.getString("phone")));
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
       tvid.setCellValueFactory(new PropertyValueFactory<>("id"));
       tvname.setCellValueFactory(new PropertyValueFactory<>("name"));
       tvdept.setCellValueFactory(new PropertyValueFactory<>("dept"));
       tvbatch.setCellValueFactory(new PropertyValueFactory<>("batch"));
       tvphn.setCellValueFactory(new PropertyValueFactory<>("phone"));
       table.setItems(obl);
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
         infoBox("OK", "Success", null);
             Node source = (Node) event.getSource();
           Stage dialogStage = (Stage) source.getScene().getWindow();
            dialogStage.close();
           Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FXMLMenu.fxml")));
            dialogStage.setScene(scene);
            dialogStage.show();
    }
    
}
