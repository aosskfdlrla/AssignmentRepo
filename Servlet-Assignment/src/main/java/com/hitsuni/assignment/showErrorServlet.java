package com.hitsuni.assignment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showError")
public class showErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> attrs = req.getAttributeNames();
        while (attrs.hasMoreElements()) {
            String attr = attrs.nextElement();
            System.out.println(attr + " : " + req.getAttribute(attr));
        }

        String message = (String) req.getAttribute("jakarta.servlet.error.message");

        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<html>")
                .append("<head>")
                .append("<title>에러</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>")
                .append(message)
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.print(errorPage);
        out.flush();
        out.close();
    }
}
