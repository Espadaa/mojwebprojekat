package model;

import database.DBQueries;
import java.sql.SQLException;

public class Naruceno {
private int id;
private Korisnik korisnik;
private Telefon telefon;

    public Naruceno(int id, Korisnik korisnik, Telefon telefon) {
        this.id = id;
        this.korisnik = korisnik;
        this.telefon = telefon;
    }

    public Naruceno(Korisnik korisnik, Telefon telefon) {
        this.korisnik = korisnik;
        this.telefon = telefon;
    }
    

    public Naruceno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Telefon getTelefon() {
        return telefon;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Naruceno{" + "id=" + id + ", korisnik=" + korisnik + ", telefon=" + telefon + '}';
    }

     public  Naruceno getById(int id) throws SQLException {
        return DBQueries.getNarucenoById(id);
        

    }
    
}
