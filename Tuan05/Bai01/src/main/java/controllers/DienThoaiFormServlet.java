package controllers;

import jakarta.annotation.Resource;
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
import dao.NhaCungCapDAO;
import daoImpl.DienThoaiDAOImple;
import daoImpl.NhaCungCapDAOImple;
import models.DienThoai;
import models.NhaCungCap;

/**
 * Servlet implementation class DienThoaiFormServlet
 */
@WebServlet(urlPatterns = { "/dienthoaiform", "/dienthoaiform*" })
public class DienThoaiFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/QUANLYDIENTHOAI")
	private DataSource dataSource;
	private DienThoaiDAO dienThoaiDAO;
	private NhaCungCapDAO nhaCungCapDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DienThoaiFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dienThoaiDAO = new DienThoaiDAOImple(this.dataSource);
		nhaCungCapDAO = new NhaCungCapDAOImple(this.dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<NhaCungCap> nhaCungCapList = nhaCungCapDAO.findAll();
        request.setAttribute("nhaCungCapList", nhaCungCapList);
        request.getRequestDispatcher("views/DienThoaiForm.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		themDienThoai(request, response);
	}

	private void themDienThoai(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tenDT = request.getParameter("tenDT");
		String namSanXuat = request.getParameter("namSanXuat");
		String cauHinh = request.getParameter("cauHinh");
		String maNCC = request.getParameter("maNCC");
		String hinhAnh = request.getParameter("hinhAnh");

		DienThoai dienThoai = new DienThoai();
		dienThoai.setTenDT(tenDT);
		dienThoai.setNamSanXuat(Integer.parseInt(namSanXuat));
		dienThoai.setCauHinh(cauHinh);
		dienThoai.setMaNCC(Integer.parseInt(maNCC));
		dienThoai.setHinhAnh(hinhAnh);

		dienThoaiDAO.addDienThoai(dienThoai);

		response.sendRedirect(request.getContextPath() + "/list");
	}

}
