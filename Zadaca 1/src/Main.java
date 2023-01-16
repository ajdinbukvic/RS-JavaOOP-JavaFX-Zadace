import rs.zadaca1.Aviolinija;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<String, Aviolinija> linije = new HashMap<>();

    public static int glavniMeni() {
        System.out.println("1. Dodaj liniju");
        System.out.println("2. Obrisi liniju");
        System.out.println("3. Ispis linija");
        System.out.println("4. Unos broja putnika");
        System.out.println("5. Ispis broja putnika");
        System.out.println("6. Kraj");
        while (true) {
            try {
                System.out.print("Izbor: ");
                int izbor = SCANNER.nextInt();
                SCANNER.nextLine();
                return izbor;
            } catch (Exception ignored) {
                SCANNER.nextLine();
            }
        }
    }

    public static int ispisBrojaPutnikaMeni() {
        System.out.println("1. Po liniji za jedan mjesec");
        System.out.println("2. Po liniji za sve mjesece unutar godine");
        System.out.println("3. Godisnje za sve linije");
        System.out.println("4. Mjesecno za sve linije");
        System.out.println("5. Ukupno po mjesecima");
        System.out.println("6. Ukupno godisnji");
        System.out.println("7. Nazad");
        while (true) {
            try {
                System.out.print("Izbor: ");
                int izbor = SCANNER.nextInt();
                SCANNER.nextLine();
                return izbor;
            } catch (Exception ignored) {
                SCANNER.nextLine();
            }
        }
    }

    public static Aviolinija izaberiLiniju(Map<String, Aviolinija> linije) {
        if (linije.isEmpty()) throw new IllegalStateException("Nema unesenih linija!");
        linije.keySet().forEach(key -> System.out.println("Linija: " + key));
        System.out.print("Unesite naziv linije: ");
        Aviolinija linija = linije.get(SCANNER.nextLine());
        if (linija == null) throw new IllegalStateException("Ne postoji linija s unesenim nazivom!");
        return linija;
    }

    public static int izaberiMjesec() {
        int redniBroj;
        do {
            System.out.print("Unesite redni broj mjeseca: ");
            redniBroj = SCANNER.nextInt();
            SCANNER.nextLine();
            if (redniBroj < 1 || redniBroj > 12) System.out.println("Mjesec moze biti u rasponu 1 - 12");
        } while (redniBroj < 1 || redniBroj > 12);
        return redniBroj;
    }

    public static int unosBrojaPutnika() {
        try {
            System.out.print("Unesite broj putnika: ");
            int brojPutnika = SCANNER.nextInt();
            SCANNER.nextLine();
            return brojPutnika;
        } catch (Exception ignored) {
            throw new IllegalStateException("Pogresan unos...");
        }
    }

    public static void pocetniUnos() {
        try {
            System.out.print("Unesite koliko zelite linija: ");
            int brojLinija = SCANNER.nextInt();
            SCANNER.nextLine();
            System.out.println("Unesite podatke o linijama: ");
            System.out.println("-------------------------------");
            for (int i = 0; i < brojLinija; i++) {
                System.out.println("Linija br: " + (i + 1));
                Aviolinija linija = Aviolinija.dodajLiniju(SCANNER);
                linije.put(linija.generisiPuniNazivLinije(), linija);
                System.out.println("-------------------------------");
            }
        } catch (Exception ignored) {
            throw new IllegalStateException("Pogresan unos...");
        }
    }

    public static void main(String[] args) {
        pocetniUnos();
        boolean meni = true;
        while (meni) {
            switch (glavniMeni()) {
                case 1 -> {
                    try {
                        Aviolinija linija = Aviolinija.dodajLiniju(SCANNER);
                        linije.put(linija.generisiPuniNazivLinije(), linija);
                        System.out.println("Uspjesno dodana nova linija!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        Aviolinija linija = izaberiLiniju(linije);
                        linije.remove(linija.generisiPuniNazivLinije());
                        System.out.println("Linija uspjesno obrisana!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    if (linije.isEmpty()) System.out.println("Nema unesenih linija!");
                    linije.keySet().forEach(key -> System.out.println("Linija: " + key));
                }
                case 4 -> {
                    try {
                        Aviolinija linija = izaberiLiniju(linije);
                        int mjesec = izaberiMjesec();
                        int brPutnika = unosBrojaPutnika();
                        linija.getPutniciPoMjesecu().put(mjesec, brPutnika);
                        linije.put(linija.generisiPuniNazivLinije(), linija);
                        System.out.println("Uspjesno dodan broj putnika za liniju!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    boolean ispisMeni = true;
                    while (ispisMeni) {
                        //globalna provjera za postojanje linija (mora postojati barem jedna linija na pocetku)
                        //zbog unosa prilikom pokretanja programa
                        //moguca situacija kada su linije prazne je kada se tokom programa obrisu "SVE LINIJE" menu opcijom br. 2
                        if (linije.isEmpty()) {
                            System.out.println("Trenutno nema linija, nemoguce prikazati podatke...");
                            ispisMeni = false;
                        }
                        switch (ispisBrojaPutnikaMeni()) {
                            case 1 -> {
                                try {
                                    Aviolinija linija = izaberiLiniju(linije);
                                    int mjesec = izaberiMjesec();
                                    System.out.println("Mjesec: " + mjesec + " | Broj putnika: " + linija.getPutniciPoMjesecu().get(mjesec));
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case 2 -> {
                                try {
                                    Aviolinija linija = izaberiLiniju(linije);
                                    linija.getPutniciPoMjesecu().forEach((key, value) -> System.out.println("Mjesec: " + key + " | Broj putnika: " + value));
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case 3 -> linije.values().forEach(linija -> System.out.println("Linija: " + linija.generisiPuniNazivLinije() + " | Ukupno godisnje putnika za liniju: " + linija.sumirajSveMjesece()));
                            case 4 -> linije.values().forEach(linija -> {
                                System.out.println("Linija: " + linija.generisiPuniNazivLinije());
                                linija.getPutniciPoMjesecu().forEach((key, value) -> System.out.println("Mjesec: " + key + " | Broj putnika: " + value));
                            });
                            case 5 -> {
                                try {
                                    AtomicInteger sumaJednogMjeseca = new AtomicInteger(0);
                                    AtomicInteger mjesec = new AtomicInteger(1);
                                    while (mjesec.get() <= 12) {
                                        linije.values().forEach(linija -> sumaJednogMjeseca.addAndGet(linija.getPutniciPoMjesecu().get(mjesec.get())));
                                        System.out.println("Mjesec: " + mjesec + " | Ukupno putnika po mjesecu: " + sumaJednogMjeseca);
                                        mjesec.addAndGet(1);
                                        sumaJednogMjeseca.set(0);
                                }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case 6 -> {
                                try {
                                    AtomicInteger ukupnoPutnika = new AtomicInteger(0);
                                    linije.values().forEach(linija -> ukupnoPutnika.addAndGet(linija.sumirajSveMjesece()));
                                    System.out.println("Ukupno putnika godisnje: " + ukupnoPutnika);
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            case 7 -> ispisMeni = false;
                            default -> System.out.println("Pogresan izbor!");
                        }
                    }
                }
                case 6 -> meni = false;
                default -> System.out.println("Pogresan izbor!");
            }
        }
    }
}