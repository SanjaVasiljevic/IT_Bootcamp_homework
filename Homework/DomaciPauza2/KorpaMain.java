package DomaciPauza2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class KorpaMain {
    /* Kreirati:
    -Korisnik unosi ime i prezime
    -Kreira korpu za njega
    -Ispisuje mu se poruka : Unesite barKod proizvoda koji zelite da dodate u korpu
    -Pokupi se unos korisnika i proizbvoda sa tim bar kodom (ako postoji) se dodaje u njegovu korpu
    -Korisnik unosi proizvode u korpu sve dok ne unese "Zavrsi kupovinu"
    -Nakon sto je zavrsio kupovinu ispisuje se racu iz korpe.
    Napomena : Niz prozvoda koristite iz prethodnog domaceg zadatka.
    to su ponudjeni proizvodi iz prodavnice koje korisnik moze da doda u korpu njihovod bar kod.
     */

    public static void main(String[] args) {

        Proizvod p1 = new Prehrambeni("457sdi7", "mleko", 100, LocalDate.of(2021, 12, 30));
        Proizvod p2 = new Tehnika("345kh3", "sporet", 35000, 5, 40);
        Proizvod p3 = new AlkoholnaPica("654k33", "pivo", 120, "staklena", 10);
        Proizvod p4 = new Pice("774gg", "sok breskva", "kartonska", 200);

        Proizvod[] proizvodi = {p1, p2, p3, p4};

        System.out.println("Cene pre popusta: \n");
        for (Proizvod p : proizvodi) {
            System.out.println(p);
        }

        for (Proizvod p : proizvodi) {
            if (p.getCena() >= 200) {
                p.setPopust(15);
            }
        }

        for (Proizvod p : proizvodi) {
            if (p instanceof AlkoholnaPica) {
                p.setPopust(50);
            }
        }

        System.out.println("Cene nakon popusta: \n");
        for (Proizvod p : proizvodi) {
            System.out.println(p);
        }
        p1.poruci(3);
        System.out.println("-------------------------");
        p2.poruci(1);
        System.out.println("-------------------------");
        p3.poruci(1);
        System.out.println("-------------------------");
        p4.poruci(1);
        System.out.println("-------------------------");


        Scanner s = new Scanner(System.in);
        System.out.println("Unesite vase ime i prezime: ");
        String kupac = s.nextLine();
        Korpa userKorpa = new Korpa(kupac);

        System.out.println("Unesite bar kod proizvoda koji zelite da dodate u korpu");
        String barKod = s.nextLine();

        HashMap<String, String> nazivProizvoda = new HashMap<String, String>();
        for (Proizvod p : proizvodi) {
            nazivProizvoda.put(p.getBarKod(), p.getNaziv());
        }

        HashMap<String, Double> cenaProizvoda = new HashMap<>();
        ArrayList<Double> cena = new ArrayList<>();

        while (!barKod.equals("zavrsi kupovinu")) {
            if (nazivProizvoda.containsKey(barKod)) {
                userKorpa.addProizvod(nazivProizvoda.get(barKod), 5);
                for (Proizvod p : proizvodi) {
                    cenaProizvoda.put(p.getBarKod(), p.getCena());
                }
                if (!cena.contains(cenaProizvoda.get(barKod))) {
                    cena.add(cenaProizvoda.get(barKod));
                }
            } else {
                System.out.println("Uneli ste nepostojeci bar kod!");
            }
            System.out.println("Unesite bar kod proizvoda koji zelite da dodate u korpu: ");
            barKod = s.nextLine();
        }
        userKorpa.ispisiRacun(cena);
    }


}
