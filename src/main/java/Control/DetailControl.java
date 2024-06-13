package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DigitalDao;
import entity.Digital;

@WebServlet(name = "DetailControl", urlPatterns = { "/detail" })
public class DetailControl extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DigitalDao dao = new DigitalDao();
		int id = Integer.parseInt(req.getParameter("id"));
		Digital d = dao.getOne(id);
		req.setAttribute("one", d);
		List<Digital> top5 = dao.getTop5();
		req.setAttribute("top5", top5);
		req.getRequestDispatcher("Detail.jsp").forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(req, resp);
	}

}
