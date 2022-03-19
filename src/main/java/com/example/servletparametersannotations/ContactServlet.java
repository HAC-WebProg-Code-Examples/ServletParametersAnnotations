package com.example.servletparametersannotations;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContactServlet", value = "/contact", initParams = {
        @WebInitParam(name = "contactEmail", value = "support@example.com"),
        @WebInitParam(name = "contactPhone", value = "(+972) 052-341-5134"),
})
public class ContactServlet extends HttpServlet {

    private static String siteName;
    private static String contactEmail;
    private static String contactPhone;

    @Override
    public void init() {
        siteName = getServletContext().getInitParameter("site-name");
        contactEmail = getInitParameter("contactEmail");
        contactPhone = getInitParameter("contactPhone");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>" + siteName + "</title></head>");
        out.println("<body><h1>Contact us:</h1>");
        out.println("<address>");
        out.println("<div>Email: <a href=\"mailto:" + contactEmail + "\">" + contactEmail + "</a></div>");
        out.println("<div>Phone: <a href=\"tel:" + contactPhone + "\">" + contactPhone + "</a></div>");
        out.println("</address>");
        out.println("</body></html>");
    }
}
