package cc.magickiat.j2ee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.CreateException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.magickiat.j2ee.ejb.hello.HelloLocal;
import cc.magickiat.j2ee.ejb.hello.HelloUtil;

/**
 * @web.servlet name="HelloServlet"
 * @web.servlet-mapping url-pattern="/hello"
 * 
 * @web.ejb-local-ref name="ejb/HelloLocal" type="Session"
 *                    home="cc.magickiat.j2ee.ejb.hello.HelloLocalHome"
 *                    local="cc.magickiat.j2ee.ejb.hello.HelloLocal"
 * @jboss.ejb-local-ref ref-name="HelloLocal" jndi-name="HelloLocal"
 */
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String name = req.getParameter("name");

        PrintWriter writer = resp.getWriter();
        try {
            HelloLocal local = HelloUtil.getLocalHome().create();
            String sayHello = local.sayHello(name);
            writer.println("<h1>" + sayHello + "</h1>");

        } catch (NamingException e) {
            writer.println("NamingException: " + e.getMessage());
        } catch (CreateException e) {
            writer.println("CreateException: " + e.getMessage());
        } finally {
            writer.close();
        }

    }

}
