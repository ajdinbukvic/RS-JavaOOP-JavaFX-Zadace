package rs.zadaca1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Aviolinija {
    private String lokacijaOd;
    private String lokacijaDo;
    private Map<Integer, Integer> putniciPoMjesecu; // <mjesec, brPutnika>

    public Aviolinija(String lokacijaOd, String lokacijaDo) {
        this.lokacijaOd = lokacijaOd;
        this.lokacijaDo = lokacijaDo;
        putniciPoMjesecu = new HashMap<>();
        //radi formatiranja ispisa svih mjeseci i broja putnika
        for (int i = 1; i <= 12; i++) putniciPoMjesecu.put(i, 0); //postavljanje default vrijednosti
        //za svih 12 mjeseci <1, 0> , <2, 0> , <3, 0> ...
    }

    public String getLokacijaOd() {
        return lokacijaOd;
    }

    public void setLokacijaOd(String lokacijaOd) {
        this.lokacijaOd = lokacijaOd;
    }

    public String getLokacijaDo() {
        return lokacijaDo;
    }

    public void setLokacijaDo(String lokacijaDo) {
        this.lokacijaDo = lokacijaDo;
    }

    public Map<Integer, Integer> getPutniciPoMjesecu() {
        return putniciPoMjesecu;
    }

    public void setPutniciPoMjesecu(Map<Integer, Integer> putniciPoMjesecu) {
        if (putniciPoMjesecu == null) throw new IllegalArgumentException("Nema unesenih putnika!");
        this.putniciPoMjesecu = putniciPoMjesecu;
    }

    public static Aviolinija dodajLiniju(Scanner scanner) {
        System.out.print("Unesite pocetnu lokaciju: ");
        String poc = scanner.nextLine();
        System.out.print("Unesite krajnju lokaciju: ");
        String kraj = scanner.nextLine();
        return new Aviolinija(poc, kraj);
    }

    public String generisiPuniNazivLinije() {
        return this.lokacijaOd + "-" + this.lokacijaDo;
    }

    public int sumirajSveMjesece() {
        return putniciPoMjesecu.values().stream().mapToInt(Integer::valueOf).sum();
    }

    @Override
    public String toString() {
        return "Aviolinija{" +
                "lokacijaOd='" + lokacijaOd + '\'' +
                ", lokacijaDo='" + lokacijaDo + '\'' +
                ", putniciPoMjesecu=" + putniciPoMjesecu +
                '}';
    }
}
