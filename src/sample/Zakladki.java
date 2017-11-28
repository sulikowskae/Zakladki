
package sample;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class Zakladki {
    public TextField imie_txt;
    public TextField nazwisko_txt;
    public TextField pesel_txt;
    public TextField wzrost_txt;
    public Label lbl_imie;
    public Label lbl_nazwisko;
    public Label lbl_wzrost;
    public Label lbl_pesel;
    public Button button;

    @FXML
    private Pane glowna;
    @FXML
    private Uzytkownik zalogowany;
    @FXML
    private Label lbl_rola;
    @FXML
    private Label lbl_zalogowany;
    private ArrayList<Uzytkownik> uzytkownicy = new ArrayList();
    private Statystyki stats;


    public Zakladki() {
    }

    public Uzytkownik getZalogowany() {
        return this.zalogowany;
    }

    public ArrayList<Uzytkownik> getUzytkownicy() {
        return this.uzytkownicy;
    }

    public void zaloguj(Uzytkownik uzytkownik) {
        this.zalogowany = uzytkownik;
        this.lbl_zalogowany.setText(uzytkownik.getLogin());
        this.lbl_rola.setText(uzytkownik.getRola());
    }

    public void wyloguj() {
        this.zalogowany = null;
        this.lbl_zalogowany.setText("");
        this.lbl_rola.setText("");
    }

    public void logowanie(ActionEvent actionEvent) {
        FXMLLoader loader;
        Parent pane;
        if (this.zalogowany == null) {
            loader = new FXMLLoader(this.getClass().getResource("logowanie.fxml"));

            try {
                pane = (Parent)loader.load();
                Zakladka1Wylogowany cntr = (Zakladka1Wylogowany)loader.getController();
                cntr.setParentController(this);
                this.glowna.getChildren().clear();
                this.glowna.getChildren().add(pane);
            } catch (IOException var6) {
                var6.printStackTrace();
            }
        } else {
            loader = new FXMLLoader(this.getClass().getResource("wylogowywanie.fxml"));

            try {
                pane = (Parent)loader.load();
                Zakladka1Zalogowany cntr = (Zakladka1Zalogowany)loader.getController();
                cntr.setParentController(this);
                this.glowna.getChildren().clear();
                this.glowna.getChildren().add(pane);
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }

    }

    public void dane(ActionEvent actionEvent) {

        if (this.zalogowany.getRola() != "admin") {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("dane.fxml"));

            try {
                Parent pane = (Parent)loader.load();
                Zakladka2 cntr = (Zakladka2)loader.getController();
                cntr.setParentController(this);

                this.imie_txt.setVisible(false);
                this.nazwisko_txt.setVisible(false);
                this.pesel_txt.setVisible(false);
                this.wzrost_txt.setVisible(false);
                this.lbl_imie.setVisible(false);
                this.lbl_nazwisko.setVisible(false);
                this.lbl_pesel.setVisible(false);
                this.lbl_wzrost.setVisible(false);
                this.button.setVisible(false);

                this.glowna.getChildren().clear();
                this.glowna.getChildren().add(pane);
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        } else{
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("dane.fxml"));
            try {
                Parent pane = (Parent)loader.load();
                Zakladka2 cntr = (Zakladka2)loader.getController();
                cntr.setParentController(this);
                this.glowna.getChildren().clear();
                this.glowna.getChildren().add(pane);
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }

    }


    public void statystyki(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("statystyki.fxml"));

        try {
            Parent pane = (Parent)loader.load();
            Zakladka3 cntr = (Zakladka3)loader.getController();
            cntr.setParentController(this);
            cntr.drukujStatystyki();
            this.glowna.getChildren().clear();
            this.glowna.getChildren().add(pane);
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void initialize() {
        Uzytkownik stefan = new Uzytkownik("Stefan", "admin1", "admin");
        Uzytkownik krzysio = new Uzytkownik("Krzysio", "haslo123", "uzytkownik");
        this.uzytkownicy.add(stefan);
        this.uzytkownicy.add(krzysio);
        this.zaloguj(stefan);
    }

    public void setStatystyki(Statystyki stats) {
        this.stats = stats;
    }

    public Statystyki getStatystyki() {
        return this.stats;
    }
}
