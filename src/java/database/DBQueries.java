package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Korisnik;
import model.Telefon;
import model.Naruceno;

public class DBQueries {

    public static Korisnik getKorisnikById(int id) throws SQLException {
        Korisnik korisnik = new Korisnik();
        try {
            Connection baza = DBConnection.getConn();
            PreparedStatement pst = baza.prepareStatement("SELECT * FROM `korisnici` WHERE `korisnici`.`id` =?");
            pst.setInt(1, id);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                korisnik.setId(resultSet.getInt("id"));
                korisnik.setUsername(resultSet.getString("username"));
                korisnik.setPassword(resultSet.getString("password"));
                korisnik.setIme(resultSet.getString("ime"));
                korisnik.setPrezime(resultSet.getString("prezime"));
                korisnik.setMesto(resultSet.getString("mesto"));
                korisnik.setGodine(resultSet.getInt("godine"));
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }
        return korisnik;
    }

    public static ArrayList<Korisnik> getAllKorisnik() throws SQLException {
        ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
        Connection baza = DBConnection.getConn();
        Statement st = baza.createStatement();
        String upit = "SELECT * FROM `korisnici`;";
        ResultSet resultSet = st.executeQuery(upit);
        while (resultSet.next()) {
            Korisnik korisnik = new Korisnik();
            korisnik.setId(resultSet.getInt(1));
            korisnik.setUsername(resultSet.getString(2));
            korisnik.setPassword(resultSet.getString(3));
            korisnik.setIme(resultSet.getString(4));
            korisnik.setPrezime(resultSet.getString(5));
            korisnik.setMesto(resultSet.getString(6));
            korisnik.setGodine(resultSet.getInt(7));

            korisnici.add(korisnik);
        }
        return korisnici;
    }

    public static Telefon getTelefonById(int id) throws SQLException {
        Telefon telefon = new Telefon();
        Connection baza = DBConnection.getConn();
        PreparedStatement pst = baza.prepareStatement("SELECT * FROM `telefoni` WHERE `telefoni`.`id` = ?");
        pst.setInt(1, id);
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()) {
            telefon.setId(resultSet.getInt("id"));
            telefon.setNaziv(resultSet.getString("naziv"));
            telefon.setProizvodjac(resultSet.getString("proizvodjac"));
            telefon.setOpis(resultSet.getString("opis"));
            telefon.setCena(resultSet.getInt("cena"));
            telefon.setStanje(resultSet.getInt("stanje"));
            telefon.setSlika(resultSet.getString("slika"));
        }
        return telefon;
    }

    public static void insertKorisnik(Korisnik korisnik) throws SQLException {
        String upit = "INSERT INTO `korisnici`(`id`, `username`, `password`, `ime`, `prezime`, `mesto`, `godine`) VALUES(NULL,?,?,?,?,?,?);";
        Connection baza = DBConnection.getConn();
        PreparedStatement pst = baza.prepareStatement(upit);

        pst.setString(1, korisnik.getUsername());
        pst.setString(2, korisnik.getPassword());
        pst.setString(3, korisnik.getIme());
        pst.setString(4, korisnik.getPrezime());
        pst.setString(5, korisnik.getMesto());
        pst.setInt(6, korisnik.getGodine());

        pst.execute();
    }
    
    
    public static void smanjiStanje(int id) throws SQLException {
        String upit = "UPDATE telefoni SET stanje = stanje - 1 WHERE id = ?;";
        Connection baza = DBConnection.getConn();
        PreparedStatement pst = baza.prepareStatement(upit);

        pst.setInt(1, id);

        pst.execute();
    }


    public static ArrayList<Telefon> getAllTelefon() throws SQLException {
        ArrayList<Telefon> telefoni = new ArrayList<Telefon>();
        Connection baza = DBConnection.getConn();
        Statement st = baza.createStatement();
        String upis = "SELECT * FROM `telefoni`;";
        ResultSet resultSet = st.executeQuery(upis);
        while (resultSet.next()) {
            Telefon telefon = new Telefon();
            telefon.setId(resultSet.getInt(1));
            telefon.setNaziv(resultSet.getString(2));
            telefon.setProizvodjac(resultSet.getString(3));
            telefon.setOpis(resultSet.getString(4));
            telefon.setCena(resultSet.getInt(5));
            telefon.setGodina(resultSet.getInt(6));
            telefon.setStanje(resultSet.getInt(7));
            telefon.setSlika(resultSet.getString(8));
            telefoni.add(telefon);
        }
        return telefoni;
    }

    public static void insertTelefon(Telefon telefon) throws SQLException {
        try {
            String upit = "INSERT INTO `telefoni` (`id`, `naziv`,`proizvodjac`,`opis`,`cena`,`godina`, `stanje`, `slika`) VALUES (NULL,?,?,?,?,?,?,?);";
            Connection baza = DBConnection.getConn();
            PreparedStatement pst = baza.prepareStatement(upit);

            pst.setString(1, telefon.getNaziv());
            pst.setString(2, telefon.getProizvodjac());
            pst.setString(3, telefon.getOpis());
            pst.setInt(4, telefon.getCena());
            pst.setInt(5, telefon.getGodina());
            pst.setInt(6, telefon.getStanje());
            pst.setString(7, telefon.getSlika());
            pst.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Naruceno getNarucenoById(int id) throws SQLException {
        Naruceno naruceno = new Naruceno();
        Connection baza = DBConnection.getConn();
        PreparedStatement pst = baza.prepareStatement("SELECT * FROM `naruceno` WHERE `naruceno`.`id` =?");
        pst.setInt(1, id);
        ResultSet resultSet = pst.executeQuery();
        try {
            naruceno.setId(resultSet.getInt(1));
            naruceno.setKorisnik(getKorisnikById(resultSet.getInt(2)));
            naruceno.setTelefon(getTelefonById(resultSet.getInt(3)));

        } catch (Exception e) {
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        }
        return naruceno;
    }

    public static ArrayList<Naruceno> getAllNaruceno() throws SQLException {
        ArrayList<Naruceno> sve_naruceno = new ArrayList<Naruceno>();
        Connection baza = DBConnection.getConn();
        Statement st = baza.createStatement();
        String upis = "SELECT * FROM `naruceno`;";
        ResultSet resultSet = st.executeQuery(upis);
        while (resultSet.next()) {
            Naruceno naruceno = new Naruceno();
            naruceno.setId(resultSet.getInt(1));
            naruceno.setKorisnik(getKorisnikById(resultSet.getInt("korisnik_id")));
            naruceno.setTelefon(getTelefonById(resultSet.getInt("telefon_id")));
        }
        return sve_naruceno;
    }

    public static void insertNaruceno(Naruceno naruceno) throws SQLException {
        String upit = "INSERT INTO `naruceno`(`id`, `korisnik_id`, `telefon_id`) VALUES (NULL,?,?);";
        Connection baza = DBConnection.getConn();
        PreparedStatement pst = baza.prepareStatement(upit);

        pst.setInt(1, naruceno.getKorisnik().getId());
        pst.setInt(2, naruceno.getTelefon().getId());
        pst.execute();
    }

    
}
