package sample;

import javafx.event.ActionEvent;

public class Zakladka1Zalogowany {
    private Zakladki parentController;

    public Zakladka1Zalogowany() {
    }

    public void zmienPlansze(ActionEvent actionEvent) {
        this.parentController.logowanie(actionEvent);
    }

    public void setParentController(Zakladki parentController) {
        this.parentController = parentController;
    }

    public Zakladki getParentController() {
        return this.parentController;
    }

    public void logOut(ActionEvent actionEvent) {
        this.getParentController().wyloguj();
        this.getParentController().logowanie(new ActionEvent());
    }
}
