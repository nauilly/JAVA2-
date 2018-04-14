package Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ByteStream extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得输出字节流对象
	     ServletOutputStream out= 	response.getOutputStream();
		
		//使用Context获得图片的绝对路劲
	       String  Realpath= this.getServletContext().getRealPath("4.jpg");
	       
	       InputStream in=new  FileInputStream(Realpath);
	       
	      int len=0;
	      byte[]  buffer=new byte[1024];
	     while((len=in.read(buffer))>0){
	    	out.write(buffer, 0, len);
	     }
	       
		
		in.close();
		out.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}