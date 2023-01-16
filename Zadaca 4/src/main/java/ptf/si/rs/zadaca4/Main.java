package ptf.si.rs.zadaca4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import ptf.si.rs.zadaca4.controllers.MainController;

import java.io.IOException;

public class Main extends Application {
    private static Scene scene;
    private static FXMLLoader loader;
    private static TabPane tabPane;
    @Override
    public void start(Stage stage) throws IOException {
        loader = new FXMLLoader(Main.class.getResource("main.fxml"));
        scene = new Scene(loader.load());
        stage.setTitle("Tiket za podršku");
        stage.setScene(scene);
        stage.show();
        MainController mainController = (MainController)loader.getController();
        tabPane = mainController.getTabPane();
    }

    public static FXMLLoader getLoader() {
        return loader;
    }

    public static void setContent(int index) throws IOException {
        tabPane.getSelectionModel().select(index);
    }
    public static void main(String[] args) {
        launch();
    }
}