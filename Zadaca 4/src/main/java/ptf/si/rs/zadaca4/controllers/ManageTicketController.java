package ptf.si.rs.zadaca4.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ptf.si.rs.zadaca4.Config;
import ptf.si.rs.zadaca4.Main;
import ptf.si.rs.zadaca4.models.*;
import ptf.si.rs.zadaca4.repository.CRUDRepository;
import ptf.si.rs.zadaca4.utils.Utilities;

import java.net.URL;
import java.util.*;

import static ptf.si.rs.zadaca4.utils.Utilities.displayInputDialog;
import static ptf.si.rs.zadaca4.utils.Validators.*;

public class ManageTicketController implements Initializable {

    private final CRUDRepository<Ticket> ticketRepository;
    public ComboBox<Service> serviceBox;
    public TextField titleField;
    public TextField userField;
    public DatePicker createdAtPicker;
    public ComboBox<Method> methodBox;
    public ComboBox<Priority> priorityBox;
    public TextArea descriptionArea;
    public ComboBox<String> agentBox;
    public ComboBox<Status> statusBox;
    public TextField emailField;
    public TextField phoneField;
    public Label pageTitle;
    public Label emailText;
    public Label phoneText;
    public Label statusText;
    private Ticket createdInstance;

    public ManageTicketController(CRUDRepository<Ticket> ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public ManageTicketController() { this(Config.tickets); }

    public void setCreatedInstance(Ticket createdInstance) {
        this.createdInstance = createdInstance;
        if (this.createdInstance.getId() != null) {
            pageTitle.setText("Uređivanje tiketa");
            statusBox.setVisible(true);
            statusText.setVisible(true);
            statusBox.getSelectionModel().select(createdInstance.getStatus());
            serviceBox.getSelectionModel().select(createdInstance.getService());
            priorityBox.getSelectionModel().select(createdInstance.getPriority());
            methodBox.getSelectionModel().select(createdInstance.getMethod());
            agentBox.getSelectionModel().select(createdInstance.getAgent());
            if (!createdInstance.getEmail().equals("")) {
                emailText.setVisible(true);
                emailField.setVisible(true);
                emailField.setText(createdInstance.getEmail());
            }
            else if (!createdInstance.getPhone().equals("")) {
                phoneText.setVisible(true);
                phoneField.setVisible(true);
                phoneField.setText(createdInstance.getPhone());
            }
        }
        else {
            emailField.setVisible(false);
            phoneField.setVisible(false);
            phoneText.setVisible(false);
            emailText.setVisible(false);
            statusBox.setVisible(false);
            statusText.setVisible(false);
            pageTitle.setText("Dodavanje novog tiketa");
            serviceBox.getSelectionModel().selectFirst();
            methodBox.getSelectionModel().selectFirst();
            priorityBox.getSelectionModel().selectFirst();
            agentBox.getSelectionModel().selectFirst();
        }
        titleField.setText(createdInstance.getTitle());
        userField.setText(createdInstance.getUser());
        descriptionArea.setText(createdInstance.getDescription());
        createdAtPicker.setValue(createdInstance.getCreatedAt());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        serviceBox.getItems().addAll(Service.values());
        methodBox.getItems().addAll(Method.values());
        priorityBox.getItems().addAll(Priority.values());
        statusBox.getItems().addAll(Status.values());
        List<String> agents = Arrays.asList("Agent 1", "Agent 2", "Agent 3", "Agent 4");
        agentBox.getItems().addAll(agents);
        setCreatedInstance(new Ticket());
    }
    public void saveTicket(ActionEvent actionEvent) {
        try {
            checkRequiredField(titleField.getText(), "Naslov");
            checkMaxLength(titleField.getText(), 500, "Naslov");

            checkRequiredField(userField.getText(), "Korisnik");
            checkMaxLength(userField.getText(), 100, "Korisnik");

            checkNotNull(createdAtPicker.getValue(), "Datum prijave");

            checkRequiredField(descriptionArea.getText(), "Opis");
            checkMaxLength(descriptionArea.getText(), 5000, "Opis");

            createdInstance.setTitle(titleField.getText());
            createdInstance.setDescription(descriptionArea.getText());
            createdInstance.setService(serviceBox.getSelectionModel().getSelectedItem());
            createdInstance.setPriority(priorityBox.getSelectionModel().getSelectedItem());
            createdInstance.setCreatedAt(createdAtPicker.getValue());
            createdInstance.setAgent(agentBox.getSelectionModel().getSelectedItem());
            createdInstance.setUser(userField.getText());
            createdInstance.setMethod(methodBox.getSelectionModel().getSelectedItem());
            if (statusBox.isVisible()) createdInstance.setStatus(statusBox.getSelectionModel().getSelectedItem());
            boolean isValid = inputMethodValue();
            if(!isValid) return;
            ticketRepository.save(createdInstance);
            Main.setContent(0);
        } catch (Exception e) {
            Utilities.displayErrorAlert(e.getMessage());
        }
    }

    private boolean inputMethodValue() {
        switch(createdInstance.getMethod()) {
            case WEB_PAGE -> {
                createdInstance.setEmail("");
                createdInstance.setPhone("");
            }
            case EMAIL -> {
                if (createdInstance.getEmail().equals("")) {
                    Optional<String> input = displayInputDialog("Email");
                    if (input.isPresent()) createdInstance.setEmail(input.get());
                    else return false;
                }
                else createdInstance.setEmail(emailField.getText());
                createdInstance.setPhone("");
            }
            case PHONE -> {
                if (createdInstance.getPhone().equals("")) {
                    Optional<String> input = displayInputDialog("Telefon");
                    if (input.isPresent()) createdInstance.setPhone(input.get());
                    else return false;
                }
                else createdInstance.setPhone(phoneField.getText());
                createdInstance.setEmail("");
            }
        }
        return true;
    }
}
