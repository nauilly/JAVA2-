package Request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestLine extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得请求的方式
	 String method=	request.getMethod();
	 System.out.println("method:"+method);
	 //获得请求相关的内容
	  String uri=  request.getRequestURI();
	  StringBuffer  url=   request.getRequestURL();
	  System.out.println("uri:"+uri);
		System.out.println("url:"+url);
	  //获得WEB应用的名称
	  String path=  request.getContextPath();
		System.out.println("path:"+path);
		//获得地址后的参数的字符串
       String query=		request.getQueryString();
       System.out.println("qurey:"+query);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}