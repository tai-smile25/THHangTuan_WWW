package controllers;

import dao.DienThoaiDAO;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import dao.DienThoaiDAO;
import daoImpl.DienThoaiDAOImple;
import models.DienThoai;

/**
 * Servlet implementation class DanhSachDienThoaiNCCServlet
 */
@WebServlet(urlPatterns = { "/list", "/searchDienThoai"})
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/QUANLYDIENTHOAI")
	private DataSource dataSource;
	private DienThoaiDAO dienThoaiDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachDienThoaiNCCServlet() {
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
		 String action = request.getServletPath();
	        if ("/searchDienThoai".equals(action)) {
	            searchDienThoai(request, response);
	        } else {
	            request.setAttribute("dienThoai", dienThoaiDAO.findAll());
	            request.getRequestDispatcher("views/DanhSachDienThoaiNCC.jsp").forward(request, response);
	        }		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void searchDienThoai(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String tenDT = request.getParameter("tenDT");

	    List<DienThoai> searchResults = dienThoaiDAO.findByName(tenDT);

	    request.setAttribute("dienThoai", searchResults);

	    RequestDispatcher dispatcher = request.getRequestDispatcher("views/DanhSachDienThoaiNCC.jsp");
	    dispatcher.forward(request, response);
	}


}
