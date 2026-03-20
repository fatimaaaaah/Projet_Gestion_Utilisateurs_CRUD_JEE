package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.UtilisateurDao;

@WebServlet("/Delete")
public class DeleteUser extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean success = UtilisateurDao.delete(id);

        if(success) {
            request.getSession().setAttribute("message", "Utilisateur supprimé avec succès !");
            request.getSession().setAttribute("messageType", "success");
        } else {
            request.getSession().setAttribute("message", "Erreur lors de la suppression !");
            request.getSession().setAttribute("messageType", "error");
        }

        response.sendRedirect("List");
    }
}