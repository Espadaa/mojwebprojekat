package servleti;

import database.DBQueries;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Telefon;
@WebServlet(name = "TelefonServlet", urlPatterns = {"/TelefonServlet/:id"})

public class TelefonServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             String naziv = request.getParameter("naziv");
             String proizvodjac = request.getParameter("proizvodjac");
             String opis = request.getParameter("opis");
             int cena = Integer.parseInt(request.getParameter("cena"));
             int godina = Integer.parseInt(request.getParameter("godina"));
             int stanje = Integer.parseInt(request.getParameter("stanje"));
             String slika = request.getParameter("slika");
            
            Telefon telefon = new Telefon(naziv, proizvodjac, opis, cena, godina, stanje, slika);
            DBQueries.insertTelefon(telefon);
            
        }
        catch(SQLException ex){
            ex.getStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
