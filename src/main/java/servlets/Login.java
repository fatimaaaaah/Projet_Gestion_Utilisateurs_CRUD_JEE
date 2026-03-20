package servlets;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(login.equals("admin") && password.equals("admin")){

            HttpSession session = request.getSession();
            session.setAttribute("user", login);

            response.sendRedirect("List");

        }else{

            request.setAttribute("erreur","Login ou mot de passe incorrect");

            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("login.jsp");

            dispatcher.forward(request,response);
        }
    }
}