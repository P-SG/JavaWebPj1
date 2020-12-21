package p201218;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doHandle(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doHandle(request, response);
	    }

	    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8"); 
	        String encoding = "utf-8"; //인코딩변수 생성
	        File currentDirPath = new File("C:\\file_repo"); //파일을 생성할 디렉터리
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        
//	        DiskFileItemFactory 클래스가 제공하는 메서드
//	        setRepository() 파일을 저장할 디렉터리를 설정합니다.
//	        setSizeThreadhold() 최대 업로드 가능한 파일 크기를 설정합니다.
	        factory.setRepository(currentDirPath);
	        //지정한 버퍼최대값을 넘었을 경우 버퍼내의 데이터를 보존하는 일시영역을 지정
	        factory.setSizeThreshold(1024 * 1024); 
	        //업로드시 사용할 임시메모리,1024kb 설정
	        
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        //setSizeMax(long sizeMax) : 전체 파일의 업로드 최대 크기
	        //setFileSizeMax(long fileSizeMax) : 개별 파일별 업로드 최대 크기
	        try {
	        	List items = upload.parseRequest(request);
	        	//업로드 요청을 파싱해서 items에 넣는다
	        	for(int i=0;i<items.size();i++) {
	        		FileItem fileItem = (FileItem) items.get(i); 
	        		//아이템값을 얻는데 반복문을 이용해 items의 값들을 나열해 fileItem에 저장
	        		if(fileItem.isFormField()) { //파일이 아닌경우 
	        			//FileItem오브젝트에 저장되어 있는 값이 파일데이터인지 그외의  폼데이터인지 확인
	        			System.out.println(fileItem.getFieldName() + "=" + 
	        		fileItem.getString(encoding));	
	        		}else { //파일이 맞을경우
	        			System.out.println("파라미터명: "+fileItem.getFieldName());
	        			System.out.println("파일명: "+fileItem.getName());
	        			System.out.println("파일크기: "+fileItem.getSize()+"bytes");
	        			
	        				if(fileItem.getSize() > 0) { //파일의 크기가 0보다 클경우
	        					int idx = fileItem.getName().lastIndexOf("\\");
	        					//마지막에 나오는 "\\"의 값을 반환한다
	        						if(idx == 1) { //idx가 1일 경우
	        							idx = fileItem.getName().lastIndexOf("/");
	        							//마지막에 나오는 "/"의 값을 반환한다
	        						}
	        				String fileName = fileItem.getName().substring(idx + 1);
	        				//파일의 이름: 위의 인덱스 값+1부터 문자열을 자른다
	        				File uploadFile = new File(currentDirPath + "\\" +fileName);
	        				//파일을 업로드: 위에 지정한 주소에 파일명을 더해 변수에 저장
	        									fileItem.write(uploadFile);
	        									//위 변수의 정보를 로컬 디스크 경로에 업로드한다
	        				} // end if
	        		} // end if
	        	} //end for
	        }catch (Exception e) { //예외처리
	        	e.printStackTrace();
	        }
	    }
}
//ServletFileUpload 클래스가 제공하는 메서드
//parseRequest() 전송된 매개변수를 List 객체로 얻습니다.
//getItemIterator() 전송된 매개변수를 Iterator 타입으로 얻습니다.
