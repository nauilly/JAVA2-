package Request;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestContent extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    //1.获得单个表单值
		String username= request.getParameter("username");
		System.out.println(username);
		 String password=request.getParameter("password");
		 System.out.println(password);
		//2.获得多个表单的值
		 String[]  hobbys= request.getParameterValues("hobby");
		for(String hobby:hobbys) {
			System.out.print(hobby);
		}
		//3.获得所有参数的名称
	    Enumeration<String> pEnumeration=	   request.getParameterNames();
		while(pEnumeration.hasMoreElements()) {
		System.out.println(pEnumeration.nextElement());
	}
		System.out.println("-------------");
	     //4.获得所有的参数封装到一个Map <String,String[]>
		 Map<String, String[]> Pmap= request.getParameterMap();
		for(Map.Entry<String, String[]> entry:Pmap.entrySet()) {
			System.out.println(entry.getKey());
			for(String str:entry.getValue()) {
				System.out.println(str);
			}
			System.out.println("------------");
		}
			
			
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}