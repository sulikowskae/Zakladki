
package sample;

import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Zakladka1Wylogowany {
    public TextField loginfield;
    public TextField passwordfield;
    public Label error_label;
    private Zakladki parentController;

    public Zakladka1Wylogowany() {
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

    public void logIn(ActionEvent actionEvent) {
        String login = this.loginfield.getText();
        String haslo = this.passwordfield.getText();
        if (!login.equals("") && !haslo.equals("")) {
            Iterator var4 = this.getParentController().getUzytkownicy().iterator();

            while(var4.hasNext()) {
                Uzytkownik przybysz = (Uzytkownik)var4.next();
                if (login.equals(przybysz.getLogin()) && haslo.equals(przybysz.getHaslo())) {
                    this.getParentController().zaloguj(przybysz);
                    this.getParentController().logowanie(new ActionEvent());
                    break;
                }
            }

            this.error_label.setText("Zły login lub hasło.");
        } else {
            this.error_label.setText("Wpisz login i/lub hasło.");
        }

    }
}
