package p201218;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doHandle(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doHandle(request, response);
	    }

	    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8"); 
	        response.setContentType("text/html; charset=utf-8");
	        String file_repo = "C:\\file_repo"; //폴더 경로지정
	        String fileName = (String) request.getParameter("fileName"); //fileName의 파라미터 값을 불러온다
	        System.out.println("fileName="+fileName); //파일이름 출력
	        OutputStream out = response.getOutputStream(); //출력스트림 객체 생성
	        String downFile = file_repo + "\\" + fileName; //폴더이름과 파일이름으로 경로를 만들어 저장
	        File f = new File(downFile); //위의 다운파일로 새로운 파일객체 생성
	        response.setHeader("Chche-Control", "no-cache");
	        //헤더가 이미 존재한다면, 새로운 값으로 대체하고 없다면 새로운 헤더와 값 추가
	        response.addHeader("Content-disposition",
	        		"attachment; fileName="+fileName);
	        //새로운 헤더와 값을 추가하고 이미 존재한다면 값을 하나 더 추가
	        FileInputStream in = new FileInputStream(f); //입력스트림 객체 생성
	        byte[] buffer = new byte[1024 * 8];
	        while(true) {
	        	int count = in.read(buffer);
	        	if(count==-1)
	        		break;
	        	out.write(buffer, 0, count);
	        }
	       in.close();
	       out.close();
	    }
}
