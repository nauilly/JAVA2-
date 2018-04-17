package Request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.���ָ��ͷ��Ϣ
		 String Header= request.getHeader("User-Agent");
		 //2.�������ͷ������
		Enumeration<String> headernames=  request.getHeaderNames();
		while (headernames.hasMoreElements()) {
			String  headerName = (String) headernames.nextElement();
			String headerValue= request.getHeader(headerName);
			System.out.println(headerName+":"+headerValue);
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}