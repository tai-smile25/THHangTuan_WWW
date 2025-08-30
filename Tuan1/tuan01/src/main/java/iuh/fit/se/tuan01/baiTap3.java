package iuh.fit.se.tuan01;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class baiTap3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public baiTap3() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        User user = new User("Nguyen Van A", 20, "nguyenvana@gmail.com");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
