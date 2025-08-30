package iuh.fit.se.tuan01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class baiTap4 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String message;

    public baiTap4() {
        super();
        // TODO Auto-generated constructor stub
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        super.init(config);
        message = config.getInitParameter("message");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
        String appName	= request.getServletContext().getInitParameter("appName");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<h1>App Name: " + appName + "</h1>");
        response.getWriter().write("<p>Init Message: " + message + "</p>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
        String appName	= request.getServletContext().getInitParameter("appName");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("<p>App Name: " + appName +"withMessage" + message + "</p>");
    }
}
