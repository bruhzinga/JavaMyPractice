import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

    @WebServlet( name = "CandidatsServlet",  value = "/getCandidats")
public class CandidatsServlet extends HttpServlet {

    private static String url = "jdbc:mysql://localhost:3306/presidents?useSSL=false";
    private static String username = "root";
    private static String password = "root";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<String> candidates = new ArrayList<String>();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from presidents");
            while (rs.next()) {
                candidates.add(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("Candidates", candidates);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
