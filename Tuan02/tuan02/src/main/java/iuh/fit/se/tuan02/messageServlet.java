package iuh.fit.se.tuan02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/MessageServlet")
public class messageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public messageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // Đặt kiểu nội dung của phản hồi là HTML
        response.setContentType("text/html;charset=UTF-8");

        // Nhận thông báo từ request (được gửi từ Servlet trước)
        String message = (String) request.getAttribute("Message");

        // In thông báo ra giao diện người dùng
        response.getWriter().append("<html><body>");
        response.getWriter().append("<h2>Upload Result</h2>");

        if (message != null) {
            response.getWriter().append("<p>" + message + "</p>");
        } else {
            response.getWriter().append("<p>No message received!</p>");
        }

        response.getWriter().append("</body></html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
