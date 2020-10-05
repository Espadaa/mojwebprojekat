
<%@page import ="database.DBQueries"%>
<%@page import ="java.util.ArrayList"%>
<%@page import="model.Korisnik" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<Korisnik> korisnici = DBQueries.getAllKorisnik();%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class ="header">
            <div class ="main">
                <a href ="index.jsp" id ="logovanje">Pocetna </a>
                <b/> <a href ="registracija.jsp" id="registracija">Registracija </a>
                <a href ="kontakt.jsp" id="kontakt"> Kontakt</a><b/>                
                <a href ="galerija.jsp" id="galerija"> Galerija</a><b/>
                <a href ="zaposleni.jsp" id="zaposleni">Zaposleni</a><b/>
            </div>
        </div>
        <div class ="logovanje_korisnika">
            <form ACTION="KorisnikServlet" method ="GET">
                Korisnicko ime: <input type ="text" name ="username_logovanje" id="username_logovanje" ><br/>
                Korisnicka lozinka <input type ="password" name ="password_logovanje" id ="password_logovanje"><br/>
                <input type ="submit" name ="submit" value="Uloguj se">
            <%    boolean validno = false;
        int index = -1;

        for (int i = 0; i < korisnici.size(); i++) {
            if (korisnici.get(i).getUsername().equals() && korisnici.get(i).getPassword().equals()) {
                validno = true;
                index = i;
                break;

            }

        }
        if (validno) { %>
        <a href ="logovanje_strana.jsp">Pozdrav</a>
        <%
        } else {
            System.out.println("Neuspesna prijava, pokusajte ponovo");
            Korisnik.prijava();

        } %>
            </form>
            
           
           <div class ="footer">
            <div class ="footer-logo">
                <h2>Moja web prodavnica</h2>
            </div>
        </div>
        </div>
    </body>
</html>
