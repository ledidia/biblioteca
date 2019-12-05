package biblioteca;

import biblioteca.informatie.Autor;
import biblioteca.informatie.Carte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by student on 12/5/2016.
 */
@WebServlet("/Edit1")
public class Edit1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        String[] ida = request.getParameterValues("ida");
        Carte carte1 = entityManager.find(Carte.class, id);
        carte1.setDenumire(request.getParameter("denumirea"));
        for (Autor a : carte1.getAutor()) {
            for (int i = 0; i < ida.length; i++) {
                int ia = Integer.parseInt(ida[i]);
                if (a.getId() == ia) {
                    a.setNume(request.getParameter("autor"));
                }
            }
        }
        String dat = request.getParameter("data");
        DateFormat formatter = null;
        Date convertedDate = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            convertedDate = (Date) formatter.parse(dat);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        carte1.setData(convertedDate);
        carte1.getEditura().setNume(request.getParameter("denumirea2"));
        carte1.getEditura().setDirector(request.getParameter("director"));
        carte1.getEditura().setAdresa(request.getParameter("adresa"));
        carte1.getLocatie().setAdresa(request.getParameter("adresa1"));
        carte1.getLocatie().setDenumirea(request.getParameter("denumirea1"));
        entityManager.persist(carte1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Edit.jsp");
        dispatcher.forward(request, response);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}