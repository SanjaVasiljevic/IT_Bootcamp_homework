package DomaciPauza2;

public class Tehnika extends Proizvod{

    private int garancija, tezina;

    public Tehnika (String barKod, String naziv, double cena, int garancija, int tezina){
        super(barKod, naziv, cena);
        this.garancija = garancija;
        this.tezina = tezina;
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
        if (tezina > 30){
            System.out.println("Dostava do vrata.");
            System.out.println("Vas racun je: " + getCena() * kolicina);
        } else {
            System.out.println("Vas racun je: " + getCena() * kolicina);
        }
    }

}


