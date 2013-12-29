
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
 * @author Jaroslav Srp
 */
public class CookieServletHL extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException,
        IOException {

        //přečtení parametru od klienta. zakladne nastavenie, pokial nebude ine z cookies, resp. formulara
        String font_col = "BLACK", back_col = "WHITE", font_size = "8";

        if (request.getParameter("fc") == null //pokial formular nebol vyplneny: ...
            & request.getParameter("fc") == null
            & request.getParameter("fc") == null) {
            
            //...je tu stale este moznost, ze su k dispozicii cookies:
            Cookie[] mySiteCookies = request.getCookies();

            if (mySiteCookies != null) {
                for (int i = 0; i < mySiteCookies.length; i++) {
                    Cookie c = mySiteCookies[i];
                    if (c.getName().equals("font_color")) {
                        font_col = c.getValue().equals("") ? font_col : c.getValue();
                        response.addCookie(c);
                        //break;
                    } else if (c.getName().equals("background_color")) {
                        back_col = c.getValue().equals("") ? back_col : c.getValue();
                        response.addCookie(c);
                        //break;
                    } else if (c.getName().equals("font_size")) {
                        font_size = c.getValue().equals("") ? font_size : c.getValue();                                              response.addCookie(c);
                        //break;
                    }
                }
            }
        } else {
            //dopln hodnoty z formulara:
            font_col = request.getParameter("fc");
            back_col = request.getParameter("bc");
            font_size = request.getParameter("fs");

            //Cookie[] cookies = request.getCookies();
            Cookie c = new Cookie("font_color", font_col);
            response.addCookie(c);
            c = new Cookie("background_color", back_col);
            response.addCookie(c);
            c = new Cookie("font_size", font_size);
            response.addCookie(c);
        }

        // příprava odpovědi pro klienta
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //tvorba těla odpovědi
        PrintWriter out = response.getWriter();

        out.println("<?xml version = \"1.0\" encoding=\"windows-1250\"?>\n"
            + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\n"
            + "    \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n"
            + "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"cs\">");

        out.println("<head>");
        out.println("<meta http-equiv=\"content-type\"\n"
            + "              content=\"text/html; charset=windows-1250\"/>\n"
            + "        <title>Zpracování HTTP žádosti GET</title>");
        out.println("</head>");

        out.println(" <body bgcolor=\"" + back_col + "\">\n");
        out.println(""
            + "        <!-- Formulář pro odeslání dat do servletu metodou get.\n"
            + "        Servlet se vyvolá při přístupu na URL\n"
            + "        http://localhost:8084/2A_DU4/post -->\n"
            + "\n"
            + "        <form action = \"/DU5/cookie\" method = \"get\">\n"
            + "            <p>\n"
            + "                <label>\n"
            + "                    <!--\n"
            + "                    <input type=\"text\" name=\"meno\"/><br/>\n"
            + "                    PRIEZVISKO:\n"
            + "                    <input type=\"text\" name=\"priezvisko\"/><br/>\n"
            + "                    ROK NARODENIA:\n"
            + "                    <input type=\"number\" name=\"rok\"/><br/>\n"
            + "                    -->\n"
            + "                    FONT COLOR      :      \n"
            + "                    <input type=\"radio\" name=\"fc\" value=\"BLACK\" checked=\"true\"/>black\n"
            + "                    <input type=\"radio\" name=\"fc\" value=\"BLUE\"/>blue\n"
            + "                    <input type=\"radio\" name=\"fc\" value=\"WHITE\"/>white<br/><br/>\n"
            + "\n"
            + "                    BACKGROUND COLOR:\n"
            + "                    <input type=\"radio\" name=\"bc\" value=\"WHITE\" checked=\"true\"/>white\n"
            + "                    <input type=\"radio\" name=\"bc\" value=\"BLACK\"/>black\n"
            + "                    <input type=\"radio\" name=\"bc\" value=\"YELLOW\"/>yellow<br/><br/>\n"
            + "\n"
            + "                    FONT SIZE       :     \n"
            + "                    <input type=\"radio\" name=\"fs\" value=\"8\" checked=\"true\"/>8\n"
            + "                    <input type=\"radio\" name=\"fs\" value=\"5\"/>5\n"
            + "                    <input type=\"radio\" name=\"fs\" value=\"3\"/>3<br/><br/>\n"
            + "\n"
            + "                    <!--odoslanie formularu: -->\n"
            + "                    <input type=\"submit\" value=\"Odeslat Formular\"/>\n"
            + "\n"
            + "                </label>\n"
            + "\n"
            + "\n"
            + "            </p>\n"
            + "        </form>\n"
            + "        <p>\n"
            + "            <a href=\"http://localhost:8080/DU5/cookie1\">str1</a>\n"
            + "            <a href=\"http://localhost:8080/DU5/cookie2\">str2</a>\n"
            + "        </p>\n"
            + "        <font size=\"" + font_size + "\" color=\"" + font_col + "\">"
            + "        <p>\n"
            + "        Skusobny text. <br/>\n"
            + " Farba písma: " + font_col + ", Farba pozadia: " + back_col + ", Velkost písma: " + font_size
            + "        </p>\n"
            + "        </font>\n"
            + "    </body>\n"
            + "");
        out.println("</html>");
    }
}
