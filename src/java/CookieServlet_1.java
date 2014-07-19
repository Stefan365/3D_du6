
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Použití cookies pro počítání přístupů daného klienta na webový server.
 *
 * @author Stefan Veres
 */
public class CookieServlet_1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException,
        IOException {

        
        
        // příprava odpovědi pro klienta
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

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
