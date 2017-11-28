package sample;

public class Statystyki {
    private Integer liczbaOsob;
    private Double sredniWzrost;
    private Double sredniWiek;

    public Statystyki(Double sredniWzrost, Double sredniWiek, Integer liczbaOsob) {
        this.sredniWiek = sredniWiek;
        this.sredniWzrost = sredniWzrost;
        this.liczbaOsob = liczbaOsob;
    }

    public Double getSredniWzrost() {
        return this.sredniWzrost;
    }

    public void setSredniWzrost(Double sredniWzrost) {
        this.sredniWzrost = sredniWzrost;
    }

    public Double getSredniWiek() {
        return this.sredniWiek;
    }

    public void setSredniWiek(Double sredniWiek) {
        this.sredniWiek = sredniWiek;
    }

    public Integer getLiczbaOsob() {
        return this.liczbaOsob;
    }

    public void setLiczbaOsob(Integer liczbaOsob) {
        this.liczbaOsob = liczbaOsob;
    }
}