import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/plus/clever")
public class OurCleverAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // получаем значение sum
        HttpSession session = request.getSession();
        Integer sum = (Integer) session.getAttribute("sum");

        if(sum == null) {
            sum = 0;
        }

        String number = request.getParameter("number");
        sum += Integer.parseInt(number);

        session.setAttribute("sum", sum);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Our Plus Service</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>sum = " + sum + "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
