package iuh.fit.se.tuan02;

import com.google.gson.Gson;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user")
public class baiTap4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public baiTap4() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        User user = new User("Nguyen", "Van B", 25);

        // Chuyển đối tượng User sang chuỗi JSON
        String json = new Gson().toJson(user);

        // Thiết lập kiểu phản hồi là application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Gửi JSON về client
        response.getWriter().write(json);
    }

}
