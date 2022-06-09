package Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SetServlet", urlPatterns = "/set")
public class SetServlet extends jakarta.servlet.http.HttpServlet {


    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("str", "Test");
    }
}
