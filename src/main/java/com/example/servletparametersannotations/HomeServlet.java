package com.example.servletparametersannotations;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    private static String siteName;

    @Override
    public void init() {
        siteName = getServletContext().getInitParameter("site-name");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>" + siteName + "</title></head>");
        out.println("<body><h1>Welcome to " + siteName + "!</h1>");
        out.println("</body></html>");
    }
}