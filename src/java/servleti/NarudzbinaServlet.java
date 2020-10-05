package servleti;

import database.DBQueries;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Naruceno;
import model.Korisnik;
import model.Telefon;

@WebServlet(name = "NarudzbinaServlet", urlPatterns = {"/NarudzbinaServlet"})

public class NarudzbinaServlet extends HttpServlet {

    protected void novoNaruceno(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int korisnik_id = 1;
            int telefon_id = Integer.parseInt(request.getParameter("telefon_id"));
            Korisnik korisnik = Korisnik.getById(korisnik_id);

            Telefon telefon = Telefon.getById(telefon_id);
            telefon.smanjiStanje();

            Naruceno novo_naruceno = new Naruceno(korisnik, telefon);
            DBQueries.insertNaruceno(novo_naruceno);
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/galerija.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        try {
//            System.out.println("neki string");
////            processRequest(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(NarudzbinaServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            novoNaruceno(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(NarudzbinaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
