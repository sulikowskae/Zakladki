
package sample;

import java.time.LocalDate;
import java.time.Period;

public class Czlowieczek {
    protected String imie;
    protected String nazwisko;
    protected Integer wiek;
    protected String pesel;
    protected Integer wzrost;
    protected String data;
    protected String plec;

    public Czlowieczek() {
    }

    public boolean sprawdz() {
        return this.pesel != null && this.imie != null && this.nazwisko != null && this.wzrost != null;
    }

    public String getImie() {
        return this.imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPlec() {
        return this.plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNazwisko() {
        return this.nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Integer getWiek() {
        return this.wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    public Integer getWzrost() {
        return this.wzrost;
    }

    public void setWzrost(Integer wzrost) {
        this.wzrost = wzrost;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
        if (pesel.charAt(9) % 2 == 0) {
            this.plec = "K";
        } else {
            this.plec = "M";
        }

        Integer rok = Integer.parseInt(pesel.substring(0, 2));
        Integer miesiac = Integer.parseInt(pesel.substring(2, 4));
        if (miesiac.intValue() <= 20) {
            rok = rok.intValue() + 1900;
        } else {
            rok = rok.intValue() + 2000;
            miesiac = miesiac.intValue() - 20;
        }

        Integer dzien = Integer.parseInt(pesel.substring(4, 6));
        String var10001 = String.valueOf(dzien);
        this.data = var10001 + "." + String.valueOf(miesiac) + "." + String.valueOf(rok);
        this.wiek = Period.between(LocalDate.of(rok.intValue(), miesiac.intValue(), dzien.intValue()), LocalDate.now()).getYears();
    }

    public String getPesel() {
        return this.pesel;
    }

    public String toString() {
        return this.imie + ", " + this.wiek + ", " + this.pesel;
    }
}