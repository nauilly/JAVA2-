package lastaccesstime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//��õ�ǰʱ��
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(date);
		
		//1������Cookie ��¼��ǰ�����µķ���ʱ��
		Cookie cookie = new Cookie("lastAccessTime",currentTime);
		cookie.setMaxAge(60*10*500);
		response.addCookie(cookie);
		
		//2����ÿͻ���Я��cookie ---- lastAccessTime
		String lastAccessTime = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie coo : cookies){
				if("lastAccessTime".equals(coo.getName())){
					lastAccessTime = coo.getValue();
				}
			}
		}
		
		response.setContentType("text/html;charset=UTF-8");
		if(lastAccessTime==null){
			response.getWriter().write("���ǵ�һ�η���");
		}else{
			response.getWriter().write("���ϴεķ��ʵ�ʱ���ǣ�"+lastAccessTime);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}