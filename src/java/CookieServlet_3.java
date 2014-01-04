
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Použití cookies pro počítání přístupů daného klienta na webový server.
 *
 * @author Jaroslav Srp
 */
public class CookieServlet_3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException,
        IOException {

        Locale cestina = new Locale("cs", "CZ");
        Locale usa = Locale.US;

        String hello = "";

        //System.out.println("volba:" + hello);
        HttpSession sessionB = request.getSession();
        String jazyk = (String) sessionB.getAttribute("jazyk");

		//session.setAttribute("pocet", pocet);
        if (jazyk.equals("cz")) {
            ResourceBundle csTexty
                = ResourceBundle.getBundle("Texty", cestina);

            hello = "" + csTexty.getString("hello_world");

        } else if (jazyk.equals("en")) {
            ResourceBundle usaTexty
                = ResourceBundle.getBundle("Texty", usa);

            hello = "" + usaTexty.getString("hello_world");
        }

        // příprava odpovědi pro klienta
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //tvorba těla odpovědi
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body bgcolor=\"" + "YELLOW" + "\">");
        out.println("<font size=\"" + "5" + "\" color=\"" + "BLUE" + "\">");

        out.println("<p><br/>");
        out.println("ID: " + sessionB.getId() + "<br/>");
        out.println("JAZ: *" + sessionB.getAttribute("jazyk") + "*<br/>");
        out.println("TextB: " + hello + "</p><br/>");

        //odakz na stranku zpet:
        out.println("</font>");
        out.println("<a href=\"http://localhost:8080/DU6/druhy\">ZPĚT</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
