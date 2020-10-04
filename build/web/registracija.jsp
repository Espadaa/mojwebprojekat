
<%@page import ="database.DBQueries"%>
<%@page import ="java.util.ArrayList"%>
<%@page import="model.Korisnik" %>
<%@page import ="model.Telefon" %>
<%@page import ="model.Naruceno" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%ArrayList<Korisnik> korisnici = DBQueries.getAllKorisnik();%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registracija korisnika</title>
    </head>
    <body>


        <div class ="header">
            <div class ="main">

                <b/> <a href ="index.jsp" id="registracija">Pocetna </a>
                <a href ="kontakt.jsp" id="kontakt"> Kontakt</a><b/>                
                <a href ="galerija.jsp" id="galerija"> Galerija</a><b/>
                <a href ="zaposleni.jsp" id="zaposleni">Zaposleni</a><b/>
            </div>
        </div>
        <div class ="registracija_header">
            <h2>Dobro dosli u registrovanje</h2>
        </div>
        <div class ="registracija_form">

            <form ACTION ="RegistracijaServlet" method ="POST">
                Vas korisnicko ime: <input type ="text" name ="username" id="registracija_username"><br/>
                Vasa lozinka: <input type="password" name ="password" id="registracija_password"><br/>
                Vase ime: <input type ="text" name ="ime" id="registracija_ime"><br/>
                Vase prezime: <input type ="text" name ="prezime" id="registracija_prezime"><br/>
                Mesto rodjenja: <input type ="text" name ="mesto" id="registracija_mesto"><br/>
                Vase godine: <input type ="text" name ="godine" id="registracija_godine"><br/>
                <input type ="submit" name ="submit" value ="Prihvati" id ="submit" id="registracija_submit">
            </form>
        </div>



    </body>
</html>
