package DomaciPauza2;
abstract class Proizvod {

    private String barKod;
    private String naziv;
    private double cena;

    public Proizvod() {

    }

    public Proizvod (String barKod, String naziv, double cena){
        this.barKod = barKod;
        this.naziv = naziv;
        this.cena = cena;
    }

    public String getBarKod() {
        return barKod;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCena() {
        return this.cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setPopust (double procenatPopusta){
        double novaCena = getCena() - (getCena() * procenatPopusta / 100.0);
        setCena(novaCena);
    }

    public abstract void poruci (int kolicina);

    @Override
    public String toString() {
        return "Proizvod {" + "naziv = '" + naziv + '\'' + ", cena = " + cena + "}";
    }

}