package ptf.si.rs.zadaca5.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class Utilities {
    public static void displayErrorAlert(String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public static Optional<String> displayInputDialog(String contentText) {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.getEditor().setPromptText(contentText);
        inputDialog.setContentText(contentText + ":");
        inputDialog.setHeaderText("Unesite korisnikov " + contentText);
        Optional<String> result = inputDialog.showAndWait();
        return result;
    }
}