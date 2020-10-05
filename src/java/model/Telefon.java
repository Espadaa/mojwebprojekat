package model;

import database.DBQueries;
import java.sql.SQLException;

public class Telefon {

    private int id;
    private String naziv;
    private String proizvodjac;
    private String opis;
    private int cena;
    private int godina;
    private int stanje;
    private String slika;

    public Telefon(int id, String naziv, String proizvodjac, String opis, int cena, int godina, int stanje, String slika) {
        this.id = id;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.opis = opis;
        this.cena = cena;
        this.godina = godina;
        this.stanje = stanje;
        this.slika = slika;
    }

    public Telefon(String naziv, String proizvodjac, String opis, int cena, int godina, int stanje, String slika) {
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.opis = opis;
        this.cena = cena;
        this.godina = godina;
        this.stanje = stanje;
        this.slika = slika;
    }

    public Telefon() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public int getStanje() {
        return stanje;
    }

    public void setStanje(int stanje) {
        this.stanje = stanje;
    }

    public void smanjiStanje() throws SQLException {
        DBQueries.smanjiStanje(id);
    }
    
    @Override
    public String toString() {
        return "Telefon{" + "id=" + id + ", naziv=" + naziv + ", proizvodjac=" + proizvodjac + ", opis=" + opis + ", cena=" + cena + ", godina=" + godina + ", stanje=" + stanje + ", slika=" + slika + '}';
    }

    public static Telefon getById(int id) throws SQLException {
        return DBQueries.getTelefonById(id);
    }
    

}
