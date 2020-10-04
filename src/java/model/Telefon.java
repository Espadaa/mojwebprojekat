package model;

public class Telefon {
private int id;
private String naziv;
private String proizvodjac;
private String opis;
private int cena;
private int godina;

    public Telefon(int id, String naziv, String proizvodjac, String opis, int cena, int godina) {
        this.id = id;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.opis = opis;
        this.cena = cena;
        this.godina = godina;
    }

    public Telefon(String naziv, String proizvodjac, String opis, int cena, int godina) {
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.opis = opis;
        this.cena = cena;
        this.godina = godina;
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

    @Override
    public String toString() {
        return "Telefon{" + "id=" + id + ", naziv=" + naziv + ", proizvodjac=" + proizvodjac + ", opis=" + opis + ", cena=" + cena + ", godina=" + godina + '}';
    }

    
}
