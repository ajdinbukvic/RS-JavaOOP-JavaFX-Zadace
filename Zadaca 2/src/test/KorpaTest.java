package test;

import org.junit.*;
import ptf.si.zadaca2.Korpa;
import ptf.si.zadaca2.Proizvod;

import static org.junit.Assert.assertEquals;

public class KorpaTest {

    private static Korpa korpa;

    @BeforeClass
    public static void runBeforeAllTests() {
        korpa = new Korpa();
    }

    @AfterClass
    public static void runAfterAllTests() {}

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Test(expected = IllegalArgumentException.class)
    public void dodajProizvodSaPostojecimNazivom() {
        korpa.dodajProizvod(new Proizvod("Isti proizvod", 0.7d));
        korpa.dodajProizvod(new Proizvod("Isti proizvod", 6.5d));
    }

    @Test
    public void dodajProizvodSaNovimNazivom() {
        korpa.dodajProizvod(new Proizvod("Test proizvod", 9.4d));
        korpa.dodajProizvod(new Proizvod("Novi proizvod", 2.4d));
    }

    @Test
    public void dodajProizvodUspjesno() {
        korpa.getProizvodi().clear();
        korpa.dodajProizvod(new Proizvod("Test proizvod", 9.4d));
        korpa.dodajProizvod(new Proizvod("Novi proizvod", 2.4d));
        int ocekivanaVelicina = 2;
        assertEquals(ocekivanaVelicina, korpa.getProizvodi().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ukloniProizvodSaNepostojecimNazivom() {
        korpa.ukloniProizvod("Nepostojeci naziv");
    }

    @Test
    public void ukloniProizvodSaPostojecimNazivom() {
        korpa.dodajProizvod(new Proizvod("Postojeci naziv", 6.3d));
        korpa.ukloniProizvod("Postojeci naziv");
    }

    @Test
    public void ukloniProizvodUspjesno() {
        korpa.getProizvodi().clear();
        korpa.dodajProizvod(new Proizvod("Postojeci naziv 1", 6.3d));
        korpa.dodajProizvod(new Proizvod("Postojeci naziv 2", 6.3d));
        korpa.ukloniProizvod("Postojeci naziv 1");
        int ocekivaniRezultat = 1;
        assertEquals(ocekivaniRezultat, korpa.getProizvodi().size());
    }

    @Test(expected = IllegalStateException.class)
    public void ukloniProizvodSaPraznomListom() {
        korpa.getProizvodi().clear();
        korpa.ukloniProizvod("Novi proizvod");
    }

    @Test
    public void ukupnaCijenaIspravna() {
        korpa.getProizvodi().clear();
        korpa.dodajProizvod(new Proizvod("Proizvod 1", 8.6d));
        korpa.dodajProizvod(new Proizvod("Proizvod 2", 3.4d));
        korpa.dodajProizvod(new Proizvod("Proizvod 3", 1.9d));
        double ocekivaniRezultat = 13.9d;
        assertEquals(ocekivaniRezultat, korpa.ukupnaCijena(), 1e-3);
    }

    @Test(expected = IllegalStateException.class)
    public void ukupnaCijenaSaPraznomListom() {
        korpa.getProizvodi().clear();
        korpa.ukupnaCijena();
    }

    @Test(expected = NullPointerException.class)
    public void ukupnaCijenaSaNullListom() {
        Korpa novaKorpa = new Korpa(null);
        novaKorpa.ukupnaCijena();
    }

    @Test(expected = NullPointerException.class)
    public void setProizvodiSaNullListom() {
        korpa.setProizvodi(null);
    }

    @Test(expected = IllegalStateException.class)
    public void ispisKorpeSaPraznomListom() {
        korpa.getProizvodi().clear();
        korpa.ispisKorpe();
    }

    @Test(expected = IllegalStateException.class)
    public void ispisNazivaProizvodaSortiranihSaPraznomListom() {
        korpa.getProizvodi().clear();
        korpa.ispisNazivaProizvodaSortiranih();
    }
}