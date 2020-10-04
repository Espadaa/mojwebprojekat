
package servleti;

import database.DBQueries;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Korisnik;

@WebServlet(name = "KorisnikServlet", urlPatterns = {"/KorisnikServlet"})

public class KorisnikServlet extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        register(request, response);
    }
    
    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String ime = request.getParameter("ime");
            String prezime = request.getParameter("prezime");
            String mesto = request.getParameter("mesto");
            int godine = Integer.parseInt(request.getParameter("godine")) ;
            
            Korisnik korisnik = new Korisnik(username, password, ime, prezime, mesto, godine);
            DBQueries.insertKorisnik(korisnik);
        } catch (SQLException ex) {
            Logger.getLogger(KorisnikServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
