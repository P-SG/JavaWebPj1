package p201223;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownloadController extends HttpServlet{
	private static String ARTICLE_IMAGE_REPO ="C:\\board\\article_image";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//이미지 파일 이름과 글 번호를 가져온다
		String imageFileName = (String) request.getParameter("imageFileName");
		String articleNO = request.getParameter("articleNO");
		System.out.println("imageFileName="+ imageFileName);
		OutputStream out = response.getOutputStream();
		// 글 번호에 대한 파일 경로를 설정한다
		String path = ARTICLE_IMAGE_REPO + "\\" + articleNO+"\\"+imageFileName;
		File imageFile = new File(path);
		System.out.println(imageFile);
		
		response.setHeader("Cache-Control",  "no-cache");
		// 이미지 파일을 내려 받는 데 필요한 response에 헤더 정보를 설정한다
		response.addHeader("Content-disposition",  "attachment;fileName=" + imageFileName);
		FileInputStream in = new FileInputStream(imageFile);
		// 버퍼를 이용해 한 번에 8kb씩 전송한다
		byte[] buffer = new byte[1024 * 8];
		while(true) {
			int count = in.read(buffer);
			if(count == -1)
				break;
			out.write(buffer, 0 , count);
		}
		in.close();
		out.close();
	}
}