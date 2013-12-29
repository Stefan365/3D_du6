
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
public class CookieServlet1 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException,
        IOException {

        String font_col = "BLACK", back_col = "WHITE", font_size = "8";
        
		
        //nacitanie vlastnosti z cookies:
        Cookie[] mySiteCookies = request.getCookies();
		for (int i=0; i<mySiteCookies.length; i++) {
			Cookie c = mySiteCookies[i];
			if (c.getName().equals("font_color")) {
				font_col = c.getValue();
                response.addCookie(c);
				//break;
			} else if (c.getName().equals("background_color")) {
				back_col = c.getValue();
                response.addCookie(c);
				//break;
			} else if (c.getName().equals("font_size")) {
				font_size = c.getValue();
                response.addCookie(c);				
                //break;
			} 
		}
        
        // příprava odpovědi pro klienta
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        
        //tvorba těla odpovědi
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<body bgcolor=\"" + back_col + "\">");
        out.println("<font size=\"" + font_size + "\" color=\"" + font_col + "\">");      
        
        out.printf("<p>Toto je prva stranka.<br/>" +      
        " Farba písma: " + font_col + ", Farba pozadia: " + back_col + ", Velkost písma: " + font_size
            + "</p><br/>");
                    
        //odakz na stranku zpet:
        out.println("</font>");
        out.println("<a href=\"http://localhost:8080/DU5/\">ZPĚT</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
