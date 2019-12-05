package biblioteca;

import biblioteca.informatie.Autor;
import biblioteca.informatie.Carte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
import java.util.List;

/**
 * Created by student on 12/5/2016.
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
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
        Carte carte = entityManager.find(Carte.class, id);
        if (carte != null) {
            request.setAttribute("carte", carte);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Edit.jsp");
        dispatcher.forward(request, response);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

