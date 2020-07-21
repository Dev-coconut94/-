package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem.do")
public class MemberController extends HttpServlet{
	
	MemberDAO memberDAO;
	
	@Override
	public void init() throws ServletException {
		memberDAO = new MemberDAO();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
	}
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		List<MemberVO> membersList = memberDAO.listMembers();
		req.setAttribute("membersList", membersList);
		RequestDispatcher dispatch = req.getRequestDispatcher("/test01/listMembers.jsp");
		dispatch.forward(req, resp);
	}
	
	

}
