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

@WebServlet(name = "SearchControl", urlPatterns = { "/SearchControl" })
public class SearchControl extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		try {
			String search = req.getParameter("txtSearch");
			String pageIndex = req.getParameter("index");
			if (pageIndex == null) {
				pageIndex = "1";
			}
			int index = Integer.parseInt(pageIndex);
			int count = new DigitalDao().count(search);
			int pageSize = 3;
			int maxPage = count / pageSize;
			if (count % pageSize != 0) {
				maxPage++;
			}
			List<Digital> listSearch = new DigitalDao().search(search, index);
			List<Digital> top5 = new DigitalDao().getTop5();
			req.setAttribute("listSearch", listSearch);
			req.setAttribute("maxPage", maxPage);
			req.setAttribute("index", index);
			req.setAttribute("txtSearch", search);
			req.setAttribute("top5", top5);
			req.getRequestDispatcher("SearchResultPage.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
