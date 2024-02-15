package lk.ijse.supermarket.controller;

import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javax.management.Notification;
import java.io.IOException;

public class MainFormController {
    @FXML
    private AnchorPane centerNode;

    public void initialize() throws IOException {
        loadDashboardForm();
        showNotification();
    }

    private void showNotification() {
        String title = "Huree!";
        String message = "You've successfully login to the system";

        Notifications notification = Notifications.SUCCESS;
        TrayNotification tray = new TrayNotification(title, message, notification);
        tray.showAndWait();
    }

    private void loadDashboardForm() throws IOException {
        AnchorPane dashboardPane = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));


        centerNode.getChildren().clear();
        centerNode.getChildren().add(dashboardPane);
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {

    }
}
