package Request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestLine extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�������ķ�ʽ
	 String method=	request.getMethod();
	 System.out.println("method:"+method);
	 //���������ص�����
	  String uri=  request.getRequestURI();
	  StringBuffer  url=   request.getRequestURL();
	  System.out.println("uri:"+uri);
		System.out.println("url:"+url);
	  //���WEBӦ�õ�����
	  String path=  request.getContextPath();
		System.out.println("path:"+path);
		//��õ�ַ��Ĳ������ַ���
       String query=		request.getQueryString();
       System.out.println("qurey:"+query);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}