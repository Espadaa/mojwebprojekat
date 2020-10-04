
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
import model.Korisnik;



public class RegistracijaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int id =Integer.parseInt(request.getParameter("id")) ;
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String ime = request.getParameter("ime");
            String prezime = request.getParameter("prezime");
            String mesto = request.getParameter("mesto");
            int godine =Integer.parseInt(request.getParameter("godine")) ;
            
            
            Korisnik korisnik = new Korisnik(id,username, password, ime, prezime, mesto, godine);
            DBQueries.insertKorisnik(korisnik);
            
            
            
        } catch (SQLException ex) {
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
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
