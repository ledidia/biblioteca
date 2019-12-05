package biblioteca;

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
import java.util.List;

/**
 * Created by student on 12/5/2016.
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
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
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println("----------------------------------------------------------------");
        System.out.println(id);
        System.out.println("----------------------------------------------------------------");
        Carte carte=entityManager.find(Carte.class,id);
        if(carte!=null) {
                            entityManager.remove(carte);
                        }
        Query oaspete=entityManager.createQuery("Select c from Carte c");
        List<Carte> carte1 =oaspete.getResultList();
        request.setAttribute("carte",carte1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
