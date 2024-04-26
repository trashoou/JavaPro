import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/homework")
public class HomeWorkServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        Integer counter = (Integer) session.getAttribute("counter");
        if(counter == null)
            counter = 1;
        else
            counter++;

        session.setAttribute("counter", counter);

        String customerName = req.getParameter("customerName");
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        if (customerName == null)
            out.write(" Hello, No-name!" + "<br>");
        else
            out.write("Hello, " + customerName + "<br>");

        out.write("The number of page visits is "+ counter);
        out.close();
    }
}
