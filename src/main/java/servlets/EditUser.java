package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import beans.Utilisateurs;
import dao.UtilisateurDao;

@WebServlet("/Edit")
public class EditUser extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Utilisateurs u = UtilisateurDao.findById(id);

        if(u == null) {
            request.getSession().setAttribute("message", "Utilisateur introuvable !");
            request.getSession().setAttribute("messageType", "error");
            response.sendRedirect("List");
        } else {
            request.setAttribute("user", u);
            getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Utilisateurs u = new Utilisateurs(id, nom, prenom, login, password);
        UtilisateurDao.update(u);

        request.getSession().setAttribute("message", "Utilisateur modifié avec succès !");
        request.getSession().setAttribute("messageType", "success");

        response.sendRedirect("List");
    }
}
