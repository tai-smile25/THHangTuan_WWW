package controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import dao.DienThoaiDAO;
import daoImpl.DienThoaiDAOImple;
import models.DienThoai;

/**
 * Servlet implementation class QuanLyFormServlet
 */
@WebServlet(urlPatterns = { "/managelist" })
public class QuanLyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name = "jdbc/QUANLYDIENTHOAI")
	private DataSource dataSource;
	private DienThoaiDAO dienThoaiDAO;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void init(ServletConfig config) throws ServletException {
   		// TODO Auto-generated method stub
   		super.init(config);
   		dienThoaiDAO = new DienThoaiDAOImple(this.dataSource);
   	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dienThoai", dienThoaiDAO.findAll());
		request.getRequestDispatcher("views/QuanLyForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "remove":
			remove(request, response);
			break;
		default:
			doGet(request, response);
			break;
		}
	}
	
	private void remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maDT = request.getParameter("maDT");
		if (maDT != null && !maDT.isEmpty()) {
			int id = Integer.parseInt(maDT);
			DienThoai dienThoai = dienThoaiDAO.getById(id);
			if (dienThoai != null) {
				dienThoaiDAO.remove(dienThoai);
			}
		}
		response.sendRedirect(request.getContextPath() + "/managelist");
	}

}
