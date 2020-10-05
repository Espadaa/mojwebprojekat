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

                <b/> <a href ="index.jsp" id="registracija">Pocetna </a>
                <a href ="kontakt.jsp" id="kontakt"> Kontakt</a><b/>                
                <a href ="zaposleni.jsp" id="galerija"> Zaposleni</a><b/>
                <a href ="registracija.jsp" id="zaposleni">Registracija</a><b/>
            </div>
        </div>
        
        <div class="pocetna_proizvodi">
            <%
            ArrayList<Telefon> telefoni = DBQueries.getAllTelefon();%>
            <%for(int i = 0; i < telefoni.size(); i++) {%>
            <div class ="pocetna_proizvod">
                <h2><%=telefoni.get(i).getNaziv()%></h2>
                <div class ="prozivod_slika">
                    <img src =<%=telefoni.get(i).getSlika()%>>
                </div>
                <p class ="pocetna_proizvod_info"><%=telefoni.get(i).getOpis()%></p>
                <span clas ="pocetna_proizvod_cena"><%=telefoni.get(i).getCena()%></span>
                <a href = "" class = "dugme-detalji"> Naruci </a>
                <%}%>
                
                
            </div>  
        </div>
        <div class ="footer">
            <div class ="footer-logo">
                <h2>Moja web prodavnica</h2>
            </div>
        </div>
    </body>
</html>
