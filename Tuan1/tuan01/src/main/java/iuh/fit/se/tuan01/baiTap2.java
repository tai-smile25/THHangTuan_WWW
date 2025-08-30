package iuh.fit.se.tuan01;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class baiTap2 extends HttpServlet {
    public baiTap2() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().write(
                "<!DOCTYPE html>" +
                        "<html lang='en'>" +
                        "<head>" +
                        "<meta charset='UTF-8'>" +
                        "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
	                    "<title>Login Form</title>" +
                        "</head>" +
                        "<body>" +
                        "<h2>Login Form</h2>" +
                        "<form action='login' method='post'>" +
                        "<label for='username'>Username:</label><br>" +
                        "<input type='text' id='username' name='username' required><br><br>" +
                        "<label for='password'>Password:</label><br>" +
                        "<input type='password' id='password' name='password' required><br><br>" +
                        "<input type='submit' value='Login'>" +
                        "</form>" +
                        "</body>" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}