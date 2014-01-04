
import java.io.IOException;
import java.io.PrintWriter;
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
public class CookieServlet_1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException,
        IOException {

        //přečtení parametru od klienta. zakladne nastavenie, pokial nebude ine z cookies, resp. formulara
        
        
        // příprava odpovědi pro klienta
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
		Integer pocet = (Integer) session.getAttribute("pocet");
		if (pocet == null) {
			pocet = new Integer(1);
		} else {
			pocet = new Integer(pocet.intValue() + 1);
		}
		session.setAttribute("pocet", pocet);
        
        
        
        //tvorba těla odpovědi
        PrintWriter out = response.getWriter();

        out.println("<?xml version = \"1.0\" encoding=\"windows-1250\"?>\n" +
"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n" +
"    \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"cs\">\n" +
"    <head>\n" +
"        <meta http-equiv=\"content-type\" content=\"text/html; charset=windows-1250\"/>\n" +
"        <title>Zpracování HTTP žádosti GET</title>\n" +
"    </head>\n" +
"    <body bgcolor=\"YELLOW\">\n" +
"        <form action = \"/DU6/druhy\" method = \"get\">\n" +
"            <font size=\"5\" color=\"BLUE\">\n" +
"                <p>\n" +
"                    <label>\n" +
"                        VYBER       :     \n" +
"                        <input type=\"radio\" name=\"bc\" value=\"cz\" checked=\"true\"/>CZ \n" +
"                        <input type=\"radio\" name=\"bc\" value=\"en\"/>EN <br/><br/>\n" +
"                        \n" +
"                        <input type=\"submit\" value=\"Odeslat\"/>\n" +
"                    </label>\n" +
"\n" +
"                    <a href=\"http://localhost:8080/DU6/druhy\">CZ</a>\n" +
"                    <a href=\"http://localhost:8080/DU6/druhy\">EN</a>\n" +
"                </p>\n" +
"            </font>\n" +
"\n" +
"        </form>\n" +
"\n" +
"    </body>\n" +
"\n" +
"</html>");
        
    }
}
