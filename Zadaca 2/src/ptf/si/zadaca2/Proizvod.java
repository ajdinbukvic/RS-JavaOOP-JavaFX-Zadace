package ptf.si.zadaca2;

import java.util.Objects;

public class Proizvod {
    private String naziv;
    private Double cijena;

    public Proizvod(String naziv, Double cijena) {
        this.naziv = naziv;
        this.cijena = cijena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if (naziv == null || naziv.equals("")) throw new IllegalArgumentException("Naziv ne moze biti null niti prazan string!");
        this.naziv = naziv;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        if (cijena < 0) throw new IllegalArgumentException("Cijena ne moze biti negativna!");
        this.cijena = cijena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proizvod proizvod)) return false;
        return getNaziv().equals(proizvod.getNaziv());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNaziv());
    }

    @Override
    public String toString() {
        return "Proizvod: " + naziv + " | Cijena: " + cijena;
    }
}
