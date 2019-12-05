package biblioteca;

import biblioteca.informatie.*;

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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 12/2/2016.
 */
@WebServlet("/s")
public class Home extends HttpServlet {
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
        Query oaspete=entityManager.createQuery("Select c from Carte c");
        List<Carte> carte =oaspete.getResultList();
        Query oaspete1=entityManager.createQuery("Select a from Articol a");
        List<Carte> articol =oaspete1.getResultList();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        if (request.getParameter("oaspete") != null) {
            dispatcher = request.getRequestDispatcher("/oaspete.jsp");
            request.setAttribute("carte",carte);
            request.setAttribute("articol",articol);
        }
        if (request.getParameter("administrator") != null) {
            dispatcher = request.getRequestDispatcher("/logare.jsp");
        }
        /*if (request.getParameter("delete") != null) {
           String s1=request.getParameter("idd");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println(s1);
            System.out.println("-------------------------------------------------------------------------------");
        }*/
        if (request.getParameter("login") != null) {
            String  user="admin";
            String parola="1234";
            if( (user.equals(request.getParameter("login")))&&(parola.equals(request.getParameter("parola"))))
            {
                request.setAttribute("carte",carte);
                dispatcher = request.getRequestDispatcher("/admin.jsp");
            }else
            {
                dispatcher = request.getRequestDispatcher("/logare.jsp");
            }
        }
        if (request.getParameter("addCarte") != null) {

            dispatcher = request.getRequestDispatcher("/addCarte.jsp");
        }
        if (request.getParameter("adauga") != null) {
            Carte c=new Carte();
            c.setDenumire(request.getParameter("denumirea"));
            String dat = request.getParameter("data");
            DateFormat formatter = null;
            Date convertedDate = null;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                convertedDate = (Date) formatter.parse(dat);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            c.setData(convertedDate);
           Autor a=new Autor();
            a.setNume(request.getParameter("autor"));
            entityManager.persist(a);
            List<Autor> al=new ArrayList<Autor>();
            al.add(a);
            c.setAutor(al);
            Editura ed=new Editura();
            ed.setNume(request.getParameter("denumirea2"));
            ed.setDirector(request.getParameter("director"));
            ed.setAdresa(request.getParameter("adresa"));
            entityManager.persist(ed);
            c.setEditura(ed);
            Locatie loc=new Locatie();
            loc.setDenumirea(request.getParameter("denumirea1"));
            loc.setAdresa(request.getParameter("adresa1"));
            entityManager.persist(loc);
            c.setLocatie(loc);
            CuvinteCheie cuv=new CuvinteCheie();
            cuv.setCuvint(request.getParameter("cuvint"));
            entityManager.persist(cuv);
            c.setCuvint(cuv);
            entityManager.persist(c);
            request.setAttribute("carte",carte);
            dispatcher = request.getRequestDispatcher("/admin.jsp");
        }
        dispatcher.forward(request, response);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
