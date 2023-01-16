package ptf.si.rs.zadaca4.controllers;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ptf.si.rs.zadaca4.Config;
import ptf.si.rs.zadaca4.Main;
import ptf.si.rs.zadaca4.models.Ticket;
import ptf.si.rs.zadaca4.repository.CRUDRepository;
import ptf.si.rs.zadaca4.utils.DateValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TicketTableController implements Initializable {

    public TableView<Ticket> ticketTable;
    private final CRUDRepository<Ticket> ticketRepository;
    public TableColumn<Ticket, LocalDateTime> startedTime;
    public TableColumn<Ticket, LocalDate> createdTime;

    public TicketTableController(CRUDRepository<Ticket> ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketTableController() {
        this(Config.tickets);
    }
    public void reloadItems() {
        ticketTable.setItems(FXCollections.observableArrayList(ticketRepository.readAll()));
        createdTime.setSortType(TableColumn.SortType.DESCENDING);
        ticketTable.getSortOrder().add(createdTime);
        ticketTable.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reloadItems();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        createdTime.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (empty) {
                    setText("");
                } else {
                    setText(formatter.format(date));
                }
            }
        });
        startedTime.setCellFactory(new DateValueFactory<>());
        ticketTable.setRowFactory(tableView -> {
            final TableRow<Ticket> row = new TableRow<>();
            final ContextMenu rowMenu = new ContextMenu();
            MenuItem editItem = new MenuItem("Uredi");
            editItem.setOnAction(event -> {
                try {
                    Main.setContent(1);
                    MainController controller = Main.getLoader().getController();
                    controller.getManageTicketController().setCreatedInstance(row.getItem());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            rowMenu.getItems().addAll(editItem);
            row.contextMenuProperty().bind(Bindings.when(row.emptyProperty()).then((ContextMenu)null).otherwise(rowMenu));
            return row;
        });
    }
}
