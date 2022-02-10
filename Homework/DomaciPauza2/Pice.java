package DomaciPauza2;

public class Pice extends Proizvod {

    private String ambalaza;

    public Pice(String barKod, String naziv, String ambalaza, double cena){
        super(barKod, naziv, cena);
        this.ambalaza = ambalaza;
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

    public String getAmbalaza() {
        return ambalaza;
    }

    @Override
    public void poruci(int kolicina) {
        double cenaAmbalaze;
        switch (ambalaza) {
            case "kartonska":
                cenaAmbalaze = getCena() * 10 / 100.0;
                System.out.println("Vas racun je: " + (getCena() + cenaAmbalaze) * kolicina);
                break;
            case "plasticna":
                cenaAmbalaze = getCena() * 20 / 100.0;
                System.out.println("Vas racun je: " + (getCena() + cenaAmbalaze) * kolicina);
                break;
            case "staklena":
            case "limenka":
                cenaAmbalaze = getCena() * 30 / 100.0;
                System.out.println("Vas racun je: " + (getCena() + cenaAmbalaze) * kolicina);
                break;
            default:
                System.out.println("Nepostojeca ambalaza.");
                break;
        }
    }
}
