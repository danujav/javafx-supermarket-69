package lk.ijse.supermarket.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.supermarket.model.Customer;
import lk.ijse.supermarket.model.tm.CustomerTm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerFormController {
    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableView<CustomerTm> tblCustomer;

    public void initialize() throws IOException {
        loadAllCustomers();
        setCellValueFactory();
    }

    private void setCellValueFactory() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
    }

    private void loadAllCustomers() {
        // fetch all customers from the MYSQL Database
        List<Customer> customerList = getCustomers();


        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        for(Customer c : customerList) {
            CustomerTm tm = new CustomerTm(c.getName(), c.getAddress(), c.getTel());

            obList.add(tm);
        }

        tblCustomer.setItems(obList);
    }

    private List<Customer> getCustomers() {
        List<Customer> customerList = new ArrayList<>();

        customerList.add(new Customer("S001", "Supun", "Galle", "0756555678"));
        customerList.add(new Customer("S002", "Nilantha", "Panadura", "0786345643"));
        customerList.add(new Customer("S003", "Kaushi", "Jaffna", "0716865667"));

        return customerList;
    }
}
