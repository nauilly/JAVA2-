package Demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dx1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//û����Ӧ����֪�ͻ���ȥ��Servlet2Ҫ��Դ
				//1.����״̬��302
				response.setStatus(302);
				//������ӦͷLocation
				response.setHeader("Location", "/WEB01/dx2");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}