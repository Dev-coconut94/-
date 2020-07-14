package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem")
public class MemberServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req,resp);
	}

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		String id = (String)req.getParameter("id");
		System.out.println("id = " + id);
		MemberDAO memberDAO = new MemberDAO();
		boolean overlappedID = memberDAO.overlappedID(id);
		
		if(overlappedID == true) {
			writer.print("not_usable");
		
		} else {
			writer.print("usable"); //여기 오타
		}
	}
	
	
}


/*
package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*//**
 * Servlet implementation class MemberServlet
 *//*
@WebServlet("/mem")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandler(request, response);
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}

	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		String id = (String) request.getParameter("id");
		System.out.println("id = " + id);
		MemberDAO memberDAO = new MemberDAO();
		boolean overlappedID = memberDAO.overlappedID(id);

		if (overlappedID == true) {
			writer.print("not_usable");
		} else {
			writer.print("usable");
		}
	}

}*/