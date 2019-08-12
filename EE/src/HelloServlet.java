import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/Hello")

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String one = req.getParameter(" one ");
        String two = req.getParameter(" two ");
        one = one == null ? "" :one.replaceAll("<","&lt;").replaceAll(">","&gt;");
        two = two == null ? "" :two.replaceAll("<","&lt;").replaceAll(">","&gt;");
        resp.getWriter().write("<html>" +
                "<head></head>" +
                "<body>" +
                "one = " + one +
                "two = " + two +
                "<form action='Hello' method='post'>" +
                        "<input type='text' name ='one'/>" +
                        "<input type='text' name ='two'/>" +
                        "<input type='submit' name ='submit'/>" +
                "</form>" +
                "</body>" +
                "</html>" );

        Enumeration<String> parametrName = req.getParameterNames();
        while (parametrName.hasMoreElements()){
            String elementName = parametrName.nextElement();
            System.out.println(elementName + " hello " + req.getParameter(elementName));
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
