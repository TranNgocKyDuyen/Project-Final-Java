package contronller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Sanpham;

import java.io.IOException;
import java.util.List;

import dao.Sanphams;


/**
 * Servlet implementation class BookController
 */
public class SanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showSanphams(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String button = request.getParameter("button");
		
		switch (button) {
			case "add":
				addSanpham(request, response);
				break;
			case "edit":
				editSanpham(request, response);
				break;
			case "delete":
				break;
			case "save":
				saveSanpham(request, response);
				showSanphams(request, response);
				break;
			case "closeSanpham":
				showSanphams(request, response);
				break;
			case "close":
				System.out.print(button);
				response.sendRedirect("home");
				break;
			default:
				showSanphams(request, response);
				break;
		}
	}
	
	private void showSanphams(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Sanpham> Sanpham = Sanphams.getAll();
		request.setAttribute("Sanphams", Sanpham);
		RequestDispatcher rd=request.getRequestDispatcher("/view/Sanphams.jsp");  
        rd.forward(request, response);
	}
	private void addSanpham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd=request.getRequestDispatcher("/view/Sanpham.jsp");  
        rd.forward(request, response);
	}
	private void editSanpham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currID = request.getParameter("currSanphamID");
		
		request.setAttribute("currSanphamID", currID);
		
		RequestDispatcher rd=request.getRequestDispatcher("/view/Sanpham.jsp");  
        rd.forward(request, response);
	}
	private void saveSanpham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id").toString();
		String tensp = request.getParameter("tensp").toString();
		double Gia = Double.parseDouble(request.getParameter("Gia").toString());
		String mota = request.getParameter("mota").toString();
		Sanpham Sanpham = new Sanpham(id,tensp,Gia,mota);
		
		Sanphams.save(Sanpham);
	}
}