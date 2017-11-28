package sample;

import java.util.Iterator;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;


public class Zakladka2 {
    public Label pesel_error;
    public TextField imie_txt;
    public TextField nazwisko_txt;
    public TextField wzrost_txt;
    public TextField pesel_txt;
    public TableView<Zakladka2.Czlowieczek> table;
    public Label imie_error;
    public Label nazwisko_error;
    public Label wzrost_error;
    public Label lbl_imie;
    public Label lbl_nazwisko;
    public Label lbl_pesel;
    public Label lbl_wzrost;
    public Button button;

    private Zakladki parentController;


    public Zakladka2() {
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

    public void liczStatystyki(ActionEvent actionEvent) {
        Integer n = Integer.valueOf(0);
        Double avWiek = 0.0D;
        Double avWzrost = 0.0D;

        for(Iterator var5 = this.table.getItems().iterator(); var5.hasNext(); n = n.intValue() + 1) {
            Czlowieczek czlowieczek = (Czlowieczek)var5.next();
            avWiek = avWiek.doubleValue() + (double)czlowieczek.getWiek().intValue();
            avWzrost = avWzrost.doubleValue() + (double)czlowieczek.getWzrost().intValue();
        }

        avWiek = avWiek.doubleValue() / (double)n.intValue();
        avWzrost = avWzrost.doubleValue() / (double)n.intValue();
        this.parentController.setStatystyki(new Statystyki(avWzrost, avWiek, n));
        this.parentController.statystyki(actionEvent);
    }

    public static boolean sprawdzPesel(String s) {
        return s != null && s.matches("(\\d*\\.?\\d+)") && s.length() == 11;
    }

    public void handleClick(ActionEvent actionEvent) {
        Czlowieczek nowy = new Czlowieczek();
        if (this.imie_txt.getText().equals("")) {
            this.imie_error.setText("Brak imienia!");
        } else {
            this.imie_error.setText("");
            nowy.setImie(this.imie_txt.getText());
        }

        if (this.nazwisko_txt.getText().equals("")) {
            this.nazwisko_error.setText("Brak nazwiska!");
        } else {
            this.nazwisko_error.setText("");
            nowy.setNazwisko(this.nazwisko_txt.getText());
        }

        if (this.wzrost_txt.getText().equals("")) {
            this.wzrost_error.setText("Brak wzrostu!");
        } else {
            this.wzrost_error.setText("");
            nowy.setWzrost(Integer.parseInt(this.wzrost_txt.getText()));
        }

        if (this.pesel_txt.getText().equals("")) {
            this.pesel_error.setText("Brak peselu!");
        } else if (!sprawdzPesel(this.pesel_txt.getText())) {
            this.pesel_error.setText("Błędny pesel!");
        } else {
            this.pesel_error.setText("");
            nowy.setPesel(this.pesel_txt.getText());
        }

        if (nowy.sprawdz()) {
            this.table.getItems().add(nowy);
        }

        System.out.println(this.table.getItems());
    }

    public void initialize() {
        this.pesel_txt.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (Zakladka2.this.pesel_txt.getLength() < 11) {
                    Zakladka2.this.pesel_txt.setStyle("-fx-text-fill: black;");
                    if (!newValue.matches("\\d*")) {
                        Zakladka2.this.pesel_txt.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                } else if (Zakladka2.this.pesel_txt.getLength() == 11) {
                    Zakladka2.this.pesel_txt.setStyle("-fx-text-fill: green;");
                    Zakladka2.this.pesel_error.setText("");
                } else {
                    Zakladka2.this.pesel_txt.setText(newValue.substring(0, 11));
                }

            }
        });
        this.wzrost_txt.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    Zakladka2.this.wzrost_txt.setText(newValue.replaceAll("[^\\d]", ""));
                }

            }
        });
        Iterator var1 = this.table.getColumns().iterator();

        while(var1.hasNext()) {
            TableColumn<Czlowieczek, ?> column = (TableColumn)var1.next();
            if ("imie".equals(column.getId())) {
                column.setCellValueFactory(new PropertyValueFactory("imie"));
            } else if ("nazwisko".equals(column.getId())) {
                column.setCellValueFactory(new PropertyValueFactory("nazwisko"));
            } else if ("wiek".equals(column.getId())) {
                column.setCellValueFactory(new PropertyValueFactory("wiek"));
            } else if ("pesel".equals(column.getId())) {
                column.setCellValueFactory(new PropertyValueFactory("pesel"));
            } else if ("wzrost".equals(column.getId())) {
                column.setCellValueFactory(new PropertyValueFactory("wzrost"));
            } else if ("plec".equals(column.getId())) {
                column.setCellValueFactory(new PropertyValueFactory("plec"));
            } else if ("data".equals(column.getId())) {
                column.setCellValueFactory(new PropertyValueFactory("data"));
            } else if ("usun".equals(column.getId())) {
                column.setCellValueFactory((param) -> {
                    return new ReadOnlyObjectWrapper((Czlowieczek)param.getValue());
                });
                column.setCellFactory((param) -> {
                    return new TableCell<Czlowieczek, Czlowieczek>() {
                        private final Button deleteButton = new Button("Usuń");

                        protected void updateItem(Czlowieczek person, boolean empty) {
                            super.updateItem(person, empty);
                            if (person == null) {
                                this.setGraphic((Node)null);
                            } else {
                                this.setGraphic(this.deleteButton);
                                this.deleteButton.setOnAction((event) -> {
                                    this.getTableView().getItems().remove(person);
                                });
                            }
                        }
                    };
                });
            }
        }

    }
}
