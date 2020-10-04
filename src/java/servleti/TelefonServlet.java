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

@WebServlet(name = "TelefonServlet", urlPatterns = {"/TelefonServlet"})

public class TelefonServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             int id =Integer.parseInt(request.getParameter("id")) ;
             String naziv = request.getParameter("naziv");
             String proizvodjac = request.getParameter("proizvodjac");
             String opis = request.getParameter("opis");
             int cena = Integer.parseInt(request.getParameter("cena"));
             int godina = Integer.parseInt(request.getParameter("godina"));
             String slika = request.getParameter("slika");
            
            Telefon telefon = new Telefon(id, naziv, proizvodjac, opis, cena, godina, slika);
            DBQueries.insertTelefon(telefon);
            
        }
        catch(SQLException ex){
            ex.getStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
