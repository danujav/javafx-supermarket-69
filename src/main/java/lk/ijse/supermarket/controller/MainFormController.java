package lk.ijse.supermarket.controller;

import com.github.plushaze.traynotification.notification.Notifications;
import com.github.plushaze.traynotification.notification.TrayNotification;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.supermarket.model.Customer;
import lk.ijse.supermarket.model.tm.CustomerTm;

public class MainFormController {
    @FXML
    private AnchorPane centerNode;
    @FXML
    private AnchorPane root;

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
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        AnchorPane customerPane = FXMLLoader.load(this.getClass().getResource("/view/customer_form.fxml"));

        centerNode.getChildren().clear();
        centerNode.getChildren().add(customerPane);
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
        AnchorPane dashboardPane = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));

        centerNode.getChildren().clear();
        centerNode.getChildren().add(dashboardPane);
    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        AnchorPane itemPane = FXMLLoader.load(this.getClass().getResource("/view/item_form.fxml"));

        centerNode.getChildren().clear();
        centerNode.getChildren().add(itemPane);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Pane loginPane = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));

        Scene scene = new Scene(loginPane);

        Stage stage = (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
