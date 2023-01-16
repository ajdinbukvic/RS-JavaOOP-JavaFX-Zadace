package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ptf.si.zadaca2.Proizvod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProizvodTest {

    private Proizvod proizvod;

    @Before
    public void setUp() { proizvod = new Proizvod("Novi proizvod", 5.2d); }

    @After
    public void tearDown() {}

    @Test
    public void getNazivIspravan() {
        String ocekivaniRezultat = "Novi proizvod";
        assertEquals(ocekivaniRezultat, proizvod.getNaziv());
    }

    @Test
    public void setNazivIspravan() {
        String noviNaziv = "Test proizvod";
        proizvod.setNaziv(noviNaziv);
        assertEquals(noviNaziv, proizvod.getNaziv());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNazivNull() {
        String noviNaziv = null;
        proizvod.setNaziv(noviNaziv);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNazivPrazanString() {
        String noviNaziv = "";
        proizvod.setNaziv(noviNaziv);
    }

    @Test
    public void getCijenaIspravna() {
        double ocekivaniRezultat = 5.2d;
        assertEquals(ocekivaniRezultat, proizvod.getCijena(), 1e-3);
    }

    @Test
    public void setCijenaIspravna() {
        double novaCijena = 8.3d;
        proizvod.setCijena(novaCijena);
        assertEquals(novaCijena, proizvod.getCijena(), 1e-3);
    }

    @Test
    public void setCijenaNula() {
        double novaCijena = 0.0;
        proizvod.setCijena(novaCijena);
        assertEquals(novaCijena, proizvod.getCijena(), 1e-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCijenaNegativna() {
        double novaCijena = -3.6d;
        proizvod.setCijena(novaCijena);
    }

    @Test()
    public void setCijenaPogresanTip() {
        String novaCijena = "5.2d";
        assertNotEquals(novaCijena, proizvod.getCijena(), 1e-3);
    }

    @Test
    public void testEqualsIstiNaziv() {
        Proizvod noviProizvod = new Proizvod("Novi proizvod", 2.7d);
        assertEquals(proizvod, noviProizvod);
    }

    @Test
    public void testEqualsRazlicitNaziv() {
        Proizvod noviProizvod = new Proizvod("Test proizvod", 2.7d);
        assertNotEquals(proizvod, noviProizvod);
    }

    @Test
    public void testToStringTacanIspis() {
        String ispis = "Proizvod: Novi proizvod | Cijena: 5.2";
        assertEquals(ispis, proizvod.toString());
    }

    @Test
    public void testToStringPogresanIspis() {
        String ispis = "Proizvod: Novi proizvod | Cijena: 0.9";
        assertNotEquals(ispis, proizvod.toString());
    }
}