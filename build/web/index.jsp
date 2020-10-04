
<%@page import="database.DBQueries"%>
<%@page import="model.Telefon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prodavnica telefona</title>
    </head>
    <body>
        <div class ="header">
            <div class ="main">

                <b/> <a href ="registracija.jsp" id="registracija">Registracija </a>
                <a href ="kontakt.jsp" id="kontakt"> Kontakt</a><b/>                
                <a href ="galerija.jsp" id="galerija"> Galerija</a><b/>
                <a href ="zaposleni.jsp" id="zaposleni">Zaposleni</a><b/>
            </div>
        </div>
        <div class = "pocetna">
            <div class ="pocetna_hero">
                <div class ="tekst_hero">
                    <h1> Dobro dosli u web <span>prodavnicu</span></h1>
                </div>
            </div>
        </div>
        <div class="pocetna_proizvodi">
        <%
        ArrayList<Telefon> telefoni = DBQueries.getAllTelefon();
        for(int i = 0; i < telefoni.size(); i++) {%>
            <div class ="pocetna_proizvod">
                <h2><%=telefoni.get(i).getNaziv()%></h2>
                <div class ="prozivod_slika">
                    <img src =<%=telefoni.get(i).getSlika()%>>
                </div>
                <p class ="pocetna_proizvod_info"><%=telefoni.get(i).getOpis()%></p>
                <span clas ="pocetna_proizvod_cena"><%=telefoni.get(i).getCena()%></span>
                <a href = "" class = "dugme-detalji"> Detalji </a>
            </div>  
        </div>
    </body>
</html>
