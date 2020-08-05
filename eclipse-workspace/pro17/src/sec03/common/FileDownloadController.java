package sec03.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sec03.brd04.ArticleVO;
import sec03.brd04.BoardService;

@WebServlet("/download.do")
public class FileDownloadController extends HttpServlet{

	private static String ARTICLE_IMAGE_REPO = "E:\\File\\board\\article_image";
	BoardService boardService;
	ArticleVO articleVO;
	
	
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
		resp.setContentType("text/html; charset=utf-8");
		String imageFileName = (String)req.getParameter("imageFileName");
		String articleNO = req.getParameter("articeNO");
		System.out.println("imageFileName=" + imageFileName);
		OutputStream out = resp.getOutputStream();
		
		String path = ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + imageFileName;
		File imageFile = new File(path);
		
		resp.setHeader("Cache-Control", "no-cache");
		resp.addHeader("Content-dispostion", "attachment;fileName="+imageFileName);
		
		FileInputStream in = new FileInputStream(imageFile);
		byte[] buffer = new byte[1024*8];
		while (true) {
			int count = in.read(buffer);
			if (count == -1)
				break;
			out.write(buffer, 0, count) ;
			
		}
		in.close();
		out.close();
	}

}
