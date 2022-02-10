package DomaciPauza2;

import java.util.*;



    /* Korpa treba da sadrzi:
        -Kupac( kubac moze biti u vidu String samo ime i prezime ili mozete napraviti klasu zasebnu za Kupac
        -proizvode koji su u korpi( bez dupliranih proizvoda)
        -kolicine za svaki proizvod
        napomena najlakse je koristiti mapu za parove proizvoda-kolicina, ali mozete koristiti i ArreyList pa
        imati odvojene nazive za proizvode i za kolicine
        -konstruktor klase korpa prima samo kupca
        -Get i set za kupca
        postoji samo getter za proizvode(set metode ne)
        Ostale metode
        -addProizvod- prima proizvod i dodaje na listu proizvoda iz korpe ( update kolicina ukoliko vec postoji taj proizvod u korpi)
        -ispisatiRacun-ispisuje konacan racun u sledecem formatu:
        Ako su vam potrebne mozete praviti pomocu private metode.
        Naziv kolicina cena
        mleko x1        100
        sporet x3      89250
        za uplatu:  89530
         */
    public class Korpa {

        private String kupac;

        private HashMap<String, Integer> proizvodKolicina = new HashMap<String, Integer>();

        public Korpa(String kupac) {

            this.kupac = kupac;
        }

        public String getKupac() {

            return kupac;
        }

        public void setKupac(String kupac) {

            this.kupac = kupac;
        }

        public HashMap<String,Integer> getProizvodKolicina() {

            return proizvodKolicina;
        }

        public void addProizvod(String proizvod, int kolicina) {
            if (!getProizvodKolicina().containsKey(proizvod)) {
                getProizvodKolicina().put(proizvod, kolicina);
            } else {
                int current = getProizvodKolicina().get(proizvod);
                getProizvodKolicina().put(proizvod, current + kolicina);
            }
        }

        public void ispisiRacun(ArrayList<Double> cena) {
            double suma = 0;

            Set<Map.Entry<String, Integer>> set = getProizvodKolicina().entrySet();
            Iterator<Map.Entry<String, Integer>> i = set.iterator();
            int counter = 0;
            while (i.hasNext()) {
                Map.Entry<String, Integer> me = i.next();
                System.out.print(me.getKey() + ": ");
                System.out.print(me.getValue() + "     ");
                System.out.println(me.getValue() * cena.get(counter));
                suma = suma + me.getValue() * cena.get(counter);
                counter++;
            }

            System.out.println("Vas racun iznosi:     " + suma + " dinara.");

        }
    }

