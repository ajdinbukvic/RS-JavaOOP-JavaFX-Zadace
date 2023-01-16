import ptf.si.zadaca2.Korpa;
import ptf.si.zadaca2.Proizvod;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in).useLocale(Locale.US); //zbog unosa double u formatu sa tackom (4.3), a ne (4,3)
    private static final Korpa korpa = new Korpa();
    public static int meni() {
        System.out.println("1. Dodaj proizvod");
        System.out.println("2. Ukloni proizvod");
        System.out.println("3. Ukupna cijena proizvoda u korpi");
        System.out.println("4. Ispis korpe");
        System.out.println("5. Ispis naziva proizvoda korpe sortiranih po cijeni DESC");
        System.out.println("6. Kraj");
        while (true) {
            try {
                System.out.print("Unesite izbor: ");
                int value = SCANNER.nextInt();
                SCANNER.nextLine();
                return value;
            } catch (Exception ignored) {
                SCANNER.nextLine();
            }
        }
    }
    public static void main(String[] args) {

        boolean ispisMenija = true;
        while (ispisMenija) {
            switch (meni()) {
                case 1 -> {
                    System.out.print("Unesite naziv proizvoda: ");
                    String nazivProizvoda = SCANNER.nextLine();
                    System.out.print("Unesite cijenu proizvoda: ");
                    Double cijenaProizvoda = SCANNER.nextDouble();
                    Proizvod proizvod = new Proizvod(nazivProizvoda, cijenaProizvoda);
                    korpa.dodajProizvod(proizvod);
                    System.out.println("Uspjesno ste dodali novi proizvod!");
                }
                case 2 -> {
                    System.out.print("Unesite naziv proizvoda: ");
                    String nazivProizvoda = SCANNER.nextLine();
                    korpa.ukloniProizvod(nazivProizvoda);
                    System.out.println("Uspjesno ste uklonili proizvod!");
                }
                case 3 -> System.out.println("Ukupna cijena svih proizvoda u korpi je: " + korpa.ukupnaCijena());
                case 4 -> korpa.ispisKorpe();
                case 5 -> korpa.ispisNazivaProizvodaSortiranih();
                case 6 -> ispisMenija = false;
                default -> System.out.println("[GRESKA]: Pogresan izbor!");
            }
        }
    }
}