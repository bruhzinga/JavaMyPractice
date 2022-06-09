import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet( name ="GoServlet", value = "/go")
public class GoServlet extends HttpServlet {

    private static String url = "jdbc:mysql://localhost:3306/presidents?useSSL=false";
    private static String username = "root";
    private static String password = "root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<String> resultArr = new ArrayList<String>();
        Integer countUsersAll = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from presidents");
            while (rs.next()) {
                resultArr.add(rs.getString(2));
            }

            List<String> candidats = new ArrayList<String>();
            for (String result : resultArr) {
                if ( req.getParameterValues("checkbox") !=null) {
                    for (int i = 0; i < req.getParameterValues("checkboxes").length; i++) {
                        if (req.getParameterValues("checkboxes")[i].equals(result)) {
                            candidats.add(result);
                        }
                    }
                }
            }
            for (String candidat : candidats) {
                stmt.execute("UPDATE presidents SET countUsers = countUsers + 1 WHERE last_name = '" + candidat + "'");
            }

            rs = stmt.executeQuery("select * from presidents");
            List<Integer> countPerCand = new ArrayList<Integer>();
            while (rs.next()) {
                countUsersAll += (rs.getInt(3));
                countPerCand.add(rs.getInt(3));
            }
            List<String> persents = new ArrayList<String>();
            for (int i = 0; i < resultArr.size(); i++) {
                persents.add( ((float)countPerCand.get(i) / (float)countUsersAll) * 100 + " % - " + resultArr.get(i));
            }
            req.setAttribute("resultArr", persents);
            req.getRequestDispatcher("persent.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
