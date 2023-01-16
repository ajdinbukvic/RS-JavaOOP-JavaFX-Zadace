package ptf.si.zadaca2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Korpa {
    private List<Proizvod> proizvodi;
    public Korpa() {
        this.proizvodi = new ArrayList<>();
    }

    public Korpa(List<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }
    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }
    public void setProizvodi(List<Proizvod> proizvodi) {
        if (proizvodi == null) throw new NullPointerException("Lista proizvoda je null!");
        this.proizvodi = proizvodi;
    }
    public void dodajProizvod(Proizvod proizvod) {
        if (proizvodi.stream().anyMatch(p -> p.equals(proizvod))) throw new IllegalArgumentException("Proizvod s tim nazivom vec postoji!");
        proizvodi.add(proizvod);
    }
    public void ukloniProizvod(String naziv) {
        if (proizvodi.isEmpty()) throw new IllegalStateException("Nema unesenih proizvoda!");
        if (!proizvodi.removeIf(p -> p.getNaziv().equals(naziv))) throw new IllegalArgumentException("Ne postoji proizvod s unesenim nazivom!");
    }
    public Double ukupnaCijena() {
        if (proizvodi.isEmpty()) throw new IllegalStateException("Nema unesenih proizvoda!");
        return proizvodi.stream().mapToDouble(Proizvod::getCijena).sum();
    }
    public void ispisKorpe() {
        if (proizvodi.isEmpty()) throw new IllegalStateException("Nema unesenih proizvoda!");
        proizvodi.forEach(System.out::println);
    }
    public void ispisNazivaProizvodaSortiranih() {
        if (proizvodi.isEmpty()) throw new IllegalStateException("Nema unesenih proizvoda!");
        proizvodi.stream().sorted(Comparator.comparing(Proizvod::getCijena).reversed().thenComparing(Proizvod::getNaziv))
                .forEach(System.out::println);
    }
}
