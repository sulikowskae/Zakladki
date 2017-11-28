package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Zakladki.fxml"));
        Pane root = (Pane)loader.load();
        primaryStage.setTitle("Baza danych");
        primaryStage.setScene(new Scene(root, 750.0D, 600.0D));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
