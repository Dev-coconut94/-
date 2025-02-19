package sec03.brd04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static String ARTICLE_IMAGE_REPO = "E:\\File\\board\\article_image";
	BoardService boardService;
	ArticleVO articleVO;

	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		articleVO = new ArticleVO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nextPage = "";
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String action = req.getPathInfo();
		System.out.println("action : " + action);
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			if (action == null) {
				articlesList = boardService.listArticles();
				req.setAttribute("articlesList", articlesList);
				nextPage = "/board03/listArticles.jsp";
			} else if (action.equals("/listArticles.do")) {
				articlesList = boardService.listArticles();
				req.setAttribute("articlesList", articlesList);
				nextPage = "/board03/listArticles.jsp";
			} else if (action.equals("/articleForm.do")) {
				nextPage = "/board03/articleForm.jsp";
			} else if (action.equals("/addArticle.do")) {
				int articleNO = 0;
				Map<String, String> articleMap = upload(req, resp);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");

				articleVO.setParentNO(0);
				articleVO.setId("hong");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				articleNO = boardService.addArticle(articleVO);

				if (imageFileName != null && imageFileName.length() != 0) {
					File scrFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(scrFile, destDir, true);
				}
				PrintWriter pw = resp.getWriter();
				pw.print("<script>" + " alert('새글을 추가했습니다.');" + "location.href='" + req.getContextPath()
						+ "/board/listArticles.do'; " + "<script>");
				return;

			} else if (action.equals("/viewArticle.do")) {
				String articleNO = req.getParameter("articleNO");
				articleVO= boardService.viewArticle(Integer.parseInt(articleNO));
				req.setAttribute("article", articleVO);
				nextPage = "/board03/viewArticle.jsp";
				
			} else {
				nextPage = "/board03/listArticles.jsp";
			}

			RequestDispatcher dispatch = req.getRequestDispatcher(nextPage);
			dispatch.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	private Map<String, String> upload(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(req);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				} else {
					System.out.println("파라미터이름: " + fileItem.getFieldName());
					System.out.println("파일이름: " + fileItem.getName());
					System.out.println("파일크기: " + fileItem.getSize() + "bytes");

					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}

						String fileName = fileItem.getName().substring(idx + 1);
						articleMap.put(fileItem.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return articleMap;
	}

}
