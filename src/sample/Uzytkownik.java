
package sample;

public class Uzytkownik {
    private String haslo;
    private String login;
    private String rola;

    public Uzytkownik(String login, String haslo, String rola) {
        this.login = login;
        this.haslo = haslo;
        this.rola = rola;
    }

    public String getRola() {
        return this.rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return this.haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}