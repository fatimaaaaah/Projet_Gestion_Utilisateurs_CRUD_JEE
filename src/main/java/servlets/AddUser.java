package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import beans.Utilisateurs;
import dao.UtilisateurDao;

@WebServlet("/Add")
public class AddUser extends HttpServlet {

    // Affiche le formulaire AddUser
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
    }

    // Traite l'ajout quand l'utilisateur soumet le formulaire
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Utilisateurs user = new Utilisateurs(nom, prenom, login, password);
        UtilisateurDao.add(user);

        // stocke le message dans la session
        request.getSession().setAttribute("message", "Utilisateur ajouté avec succès !");
        request.getSession().setAttribute("messageType", "success");

        // redirige vers la liste
        response.sendRedirect("List");
    }
}