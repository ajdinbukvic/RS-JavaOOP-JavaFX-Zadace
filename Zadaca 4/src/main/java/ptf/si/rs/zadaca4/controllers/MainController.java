package ptf.si.rs.zadaca4.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import ptf.si.rs.zadaca4.models.Ticket;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public TicketTableController ticketTableController;
    public ManageTicketController manageTicketController;
    public Tab ticketsTableTab;
    public Tab manageTicketTab;

    public TabPane tabPane;

    public TicketTableController getTicketTableController() {
        return ticketTableController;
    }

    public ManageTicketController getManageTicketController() {
        return manageTicketController;
    }

    public TabPane getTabPane() {
        return tabPane;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ticketsTableTab.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) ticketTableController.reloadItems();
        });
        manageTicketTab.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) manageTicketController.setCreatedInstance(new Ticket());
        });
    }
}
