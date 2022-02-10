package DomaciPauza2;

import java.time.LocalDate;

public class Prehrambeni extends Proizvod{

    private LocalDate datumIsteka;
    private final LocalDate sadasnjiDatum;

    public Prehrambeni (String barKod, String naziv, double cena, LocalDate datumIsteka){
        super(barKod, naziv, cena);
        this.datumIsteka = datumIsteka;
        this.sadasnjiDatum = LocalDate.now();
    }

    @Override
    public void setPopust(double procenatPopusta) {
        double novaCena = getCena() - (getCena() * procenatPopusta / 100.0);
        setCena(novaCena);
    }

    @Override
    public void setCena(double cena) {
        super.setCena(cena);
    }

    @Override
    public double getCena() {
        return super.getCena();
    }

    @Override
    public void poruci(int kolicina) {
        if (sadasnjiDatum.compareTo(datumIsteka) > 0){
            System.out.println("Datum je istekao!");
        } else {
            System.out.println("Vas racun je: " + getCena() * kolicina);
        }
    }

}

