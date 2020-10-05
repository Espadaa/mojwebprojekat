<%@page import="database.DBQueries"%>
<%@page import="model.Telefon"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Galerija Proizvoda</title>
    </head>
    <body>
        <div class ="header">
            <div class ="main">


                <b/> <a href ="index.jsp" id ="pocetna">Pocetna</a>
                <a href ="galerija.jsp" id="galerija">Galerija</a><b/>
                <a href ="kontakt.jsp" id="kontakt">Kontakt</a><b/>
                <a href ="zaposleni.jsp" id="zaposleni">Zaposleni</a><b/>
                <a href ="registracija.jsp" id="registracija">Registracija</a><b/>
            </div>
        </div>

        <div class="pocetna_proizvodi">
            <%
                ArrayList<Telefon> telefoni = DBQueries.getAllTelefon();%>
            <%for (int i = 0; i < telefoni.size(); i++) {%>
            <div class ="pocetna_proizvod">
                <h2><%=telefoni.get(i).getNaziv()%></h2>
                <div class ="prozivod_slika">
                    <img src =<%=telefoni.get(i).getSlika()%>>
                </div>
                <p class ="pocetna_proizvod_info"><%=telefoni.get(i).getOpis()%></p>
                <span clas ="pocetna_proizvod_cena">Cena: <%=telefoni.get(i).getCena()%></span><br>
                <span clas ="pocetna_proizvod_cena">Stanje: <%=telefoni.get(i).getStanje()%></span>
                <%if (telefoni.get(i).getStanje() > 0) {%>
                <form ACTION ="NarudzbinaServlet" method ="POST">
                    <input type ="text" hidden="true" name ="telefon_id" value=<%=telefoni.get(i).getId()%>>
                    <input type ="submit" name ="submit" value ="Naruci" class = "dugme-detalji">
                </form>
                <%} else {%>
                <a class = "dugme-detalji"> Nije na stanju </a>
                <%}%>
            </div> 
            <%}%>



        </div>

    </body>
    <div class ="footer">
        <div class ="footer-logo">
            <h2>Moja web prodavnica</h2>
        </div>
    </div>
</html>
