package model;

import database.DBConnection;
import java.sql.SQLException;

public class Korisnik {
 private  int id;    
 private String username;
 private String password;
 private String ime;
 private String prezime;
 private String mesto;
 private int godine;
 

    public Korisnik(int id, String username, String password, String ime, String prezime, String mesto, int godine) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.mesto = mesto;
        this.godine = godine;
        
    }

    
    
    public Korisnik() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    

    @Override
    public String toString() {
        return "Korisnik{" + "id=" + id + ", username=" + username + ", password=" + password + ", ime=" + ime + ", prezime=" + prezime + ", mesto=" + mesto + ", godine=" + godine + ", pol=" + '}';
    }
    
}
