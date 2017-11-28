package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Zakladka3 {
    private Zakladki parentController;
    public GridPane panel;
    @FXML
    private Label lbl_avWzrost;
    @FXML
    private Label lbl_avWiek;
    @FXML
    private Label lbl_liczba;
    public Pane brak;

    public Zakladka3() {
    }

    public void drukujStatystyki() {
        if (this.parentController.getStatystyki() != null) {
            this.lbl_avWiek.setText(this.parentController.getStatystyki().getSredniWiek().toString());
            this.lbl_avWzrost.setText(this.parentController.getStatystyki().getSredniWzrost().toString());
            this.lbl_liczba.setText(this.parentController.getStatystyki().getLiczbaOsob().toString());
            this.panel.setVisible(true);
            this.brak.setVisible(false);
        } else {
            this.panel.setVisible(false);
            this.brak.setVisible(true);
        }

    }

    public void zmienPlansze(ActionEvent actionEvent) {
        this.drukujStatystyki();
        this.parentController.statystyki(actionEvent);
    }

    public void setParentController(Zakladki parentController) {
        this.parentController = parentController;
    }

    public Zakladki getParentController() {
        return this.parentController;
    }
}

