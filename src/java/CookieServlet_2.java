
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Použití cookies pro počítání přístupů daného klienta na webový server.
 *
 * @author Jaroslav Srp
 */
public class CookieServlet_2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException,
        IOException {

        Locale cestina = new Locale("cs", "CZ");
        Locale usa = Locale.US;

        
        
        String hello = "";
        
        String volba = request.getParameter("bc");
        
        HttpSession sessionA = request.getSession();
		String jazyk = (String) sessionA.getAttribute("jazyk");
        
        if(volba == null || volba.equals("")){
            volba = jazyk;
        }
        
        if (volba.equals("cz")) {
 		    sessionA.setAttribute("jazyk", volba);
            ResourceBundle csTexty
                = ResourceBundle.getBundle("Texty", cestina);

            hello = "" + csTexty.getString("hello_world");
            
        } else if (volba.equals("en")) {
            sessionA.setAttribute("jazyk", volba);
            
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
        out.println("ID: " + sessionA.getId()+"<br/>");
        out.println("JAZ: *" + sessionA.getAttribute("jazyk")+"*<br/>");
        out.println("TextA: " + hello + "</p><br/>");
        
        
        //odakz na stranku zpet:
        out.println("</font>");
        out.println("<a href=\"http://localhost:8080/DU6/\">ZPĚT</a>");
        out.println("<a href=\"http://localhost:8080/DU6/treti\">NEXT</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
