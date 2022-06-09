package Servlet;

//Это вне задания - просто балуюсь

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import java.io.IOException;

@WebServlet(name = "SetAttribute", urlPatterns = "/setAttribute")
public class SetAttribute extends jakarta.servlet.http.HttpServlet  {


    protected void doGet(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        ServletContext servletContext = getServletContext();
        request.setAttribute("str", "request");
        servletContext.setAttribute("str", "ServletContext");
        session.setAttribute("str","SessionContext");

        request.getRequestDispatcher("/index.jsp").forward(request, response);



    }
}