package DomaciPauza2;

public class AlkoholnaPica extends Pice{

    private double procenatAlkohola;

    public AlkoholnaPica(String barKod, String naziv, double cena, String ambalaza, double procenatAlkohola){
        super(barKod, naziv, ambalaza, cena);
        this.procenatAlkohola = procenatAlkohola;
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
    public void setPopust(double procenatPopusta) {
        double novaCena = getCena() - (getCena() * procenatPopusta / 100.0);
        setCena(novaCena);
    }

    @Override
    public void poruci(int kolicina) {
        double cenaAmbalaze;

        switch (getAmbalaza()) {
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

