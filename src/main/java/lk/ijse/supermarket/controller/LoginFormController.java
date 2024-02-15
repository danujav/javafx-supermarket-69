package lk.ijse.supermarket.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.supermarket.db.Db;

import java.io.IOException;

public class LoginFormController {
    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        String userName = txtUserName.getText();
        String pw = txtPassword.getText();

        if(userName.equals(Db.USER_NAME) && pw.equals(Db.PW)) {
            AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/main_form.fxml"));

            Scene scene = new Scene(rootNode);
            Stage stage = (Stage) this.rootNode.getScene().getWindow();
            stage.setScene(scene);

            stage.setTitle("Dashboard Form");
            stage.centerOnScreen();
        } else {
            new Alert(Alert.AlertType.ERROR, "Login Failed").show();
        }
    }
}
