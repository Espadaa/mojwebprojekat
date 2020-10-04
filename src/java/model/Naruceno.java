package model;

public class Naruceno {
private int id;
private int korisnik_id;
private int telefon_id;

    public Naruceno(int id, int korisnik_id, int mobilni_id) {
        this.id = id;
        this.korisnik_id = korisnik_id;
        this.telefon_id = telefon_id;
    }

    public Naruceno(int korisnik_id, int telefon_id) {
        this.korisnik_id = korisnik_id;
        this.telefon_id = telefon_id;
    }
    

    public Naruceno() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(int korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    public int getTelefon_id() {
        return telefon_id;
    }

    public void setTelefon_id(int telefon_id) {
        this.telefon_id = telefon_id;
    }

    @Override
    public String toString() {
        return "Naruceno{" + "id=" + id + ", korisnik_id=" + korisnik_id + ", telefon_id=" + telefon_id + '}';
    }
    
    
}
