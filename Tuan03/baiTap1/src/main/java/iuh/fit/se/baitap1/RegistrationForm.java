package iuh.fit.se.baitap1;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.Qualification;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/registrationForm")
public class RegistrationForm extends HttpServlet {
    public RegistrationForm(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());

        // Lay du lieu tu form
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        // Lấy dữ liệu từ form
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String pinCode = req.getParameter("pinCode");
        String state = req.getParameter("state");
        String country = req.getParameter("country");

        // Hobbies (checkbox)
        String[] hobbiesArr = req.getParameterValues("hobbies");
        List<String> hobbies = hobbiesArr != null ? Arrays.asList(hobbiesArr) : new ArrayList<>();

        // Qualification
        List<Qualification> qualifications = new ArrayList<>();
        String[] exams = {"Class X", "Class XII", "Graduation", "Masters"};
        for (int i = 0; i < exams.length; i++) {
            String board = req.getParameter("board" + (i + 1));
            String percentage = req.getParameter("percentage" + (i + 1));
            String year = req.getParameter("year" + (i + 1));
            qualifications.add(new Qualification(exams[i], board, percentage, year));
        }

        // Course
        String course = req.getParameter("course");

        // Tạo đối tượng Student
        Student student = new Student(firstName, lastName, dob, email, mobile, gender,
                address, city, pinCode, state, country, hobbies, qualifications, course);

        // Xuất kết quả ra trình duyệt
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Student Info</title></head><body>");
        out.println("<h2>Student Registration Details</h2>");
        out.println("<p><b>Name:</b> " + student.getFirstName() + " " + student.getLastName() + "</p>");
        out.println("<p><b>Date of Birth:</b> " + student.getDob() + "</p>");
        out.println("<p><b>Email:</b> " + student.getEmail() + "</p>");
        out.println("<p><b>Mobile:</b> " + student.getMobile() + "</p>");
        out.println("<p><b>Gender:</b> " + student.getGender() + "</p>");
        out.println("<p><b>Address:</b> " + student.getAddress() + ", " + student.getCity() +
                " - " + student.getState() + " (" + student.getPinCode() + "), " + student.getCountry() + "</p>");

        out.println("<p><b>Hobbies:</b> " + String.join(", ", student.getHobbies()) + "</p>");

        out.println("<h3>Qualifications</h3>");
        out.println("<table border='1' cellpadding='5'>");
        out.println("<tr><th>Examination</th><th>Board</th><th>Percentage</th><th>Year</th></tr>");
        for (Qualification q : student.getQualifications()) {
            out.println("<tr>");
            out.println("<td>" + q.getExamination() + "</td>");
            out.println("<td>" + q.getBoard() + "</td>");
            out.println("<td>" + q.getPercentage() + "</td>");
            out.println("<td>" + q.getYearOfPassing() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("<p><b>Course Applied For:</b> " + student.getCourse() + "</p>");
        out.println("</body></html>");
    }

}