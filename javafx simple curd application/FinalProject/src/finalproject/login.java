
package finalproject;
import utils.ConnectionUtil;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
/**
*
* @author Bushan Sirgur
*/
public class login implements Initializable {
 
@FXML
private TextField txtusername;
 
@FXML
private PasswordField txtpassword;
 
Stage dialogStage = new Stage();
Scene scene;
 
Connection connection = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;
    @FXML
    private Button login;
 
public login() {
connection = ConnectionUtil.connectdb();
}
 
@FXML
private void handleButtonAction(ActionEvent event) {
String user = txtusername.getText().toString();
String pass = txtpassword.getText().toString();
 
String sql = "SELECT * FROM admins WHERE username = ? and password = ?";
 
try{
preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1,user );
preparedStatement.setString(2, pass);
resultSet = preparedStatement.executeQuery();
if(!resultSet.next()){
infoBox("Enter Correct Email and Password", "Failed", null);
}else{
infoBox("Login Successfull", "Success", null);
Node source = (Node) event.getSource();
dialogStage = (Stage) source.getScene().getWindow();
dialogStage.close();
scene = new Scene(FXMLLoader.load(getClass().getResource("FXMLMenu.fxml")));
dialogStage.setScene(scene);
dialogStage.show();
}
 
}catch(Exception e){
e.printStackTrace();
}
}
 
public static void infoBox(String infoMessage, String titleBar, String headerMessage)
{
Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle(titleBar);
alert.setHeaderText(headerMessage);
alert.setContentText(infoMessage);
alert.showAndWait();
}
 
@Override
public void initialize(URL url, ResourceBundle rb) {
 
}
}