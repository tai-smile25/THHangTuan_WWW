package iuh.fit.se.tuan01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class baiTap5 extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public baiTap5() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher dispatcher = request.getRequestDispatcher("/registrationForm.html");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Lấy dữ liệu từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String facebook = request.getParameter("facebook");
        String shortBio = request.getParameter("bio");

        // Tạo nội dung HTML để hiển thị thông tin nhập vào
        PrintWriter out = response.getWriter();
        String html = "<html>" +
                "<head><title>Result Page</title></head>" +
                "<body>" +
                "<h2>Registration Details</h2>" +
                "<p><strong>First Name:</strong> " + firstName + "</p>" +
                "<p><strong>Last Name:</strong> " + lastName + "</p>" +
                "<p><strong>Username:</strong> " + username + "</p>" +
                "<p><strong>Password:</strong> " + password + "</p>" +
                "<p><strong>Email:</strong> " + email + "</p>" +
                "<p><strong>Facebook:</strong> <a href=\"" + facebook + "\">" + facebook + "</a></p>" +
                "<p><strong>Short Bio:</strong> " + shortBio + "</p>" +
                "</body>" +
                "</html>";

        out.println(html);
    }
}
