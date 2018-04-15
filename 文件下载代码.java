package Demo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得文件下载的名称 
		 String filename=request.getParameter("filename");//a.flv
		 //获得下载文件的类型----客户端通过文件的MIME类型去区分文件类型
		  response.setContentType(this.getServletContext().getMimeType(filename));
		  //告诉客户端要下载的形式是以附件形式下载，而不是直接解析
		  response.setHeader("Content-Disposition","attachment;filename="+filename);
		  
		 //获得文件下载的绝对路径
		 String path=this.getServletContext().getRealPath("download/"+filename);
		 //获得文件的输入流
		 InputStream in=new  FileInputStream(path);
		 //获得文件的输出流
		 ServletOutputStream out=response.getOutputStream();
		 //文件拷贝代码
		 int len=0;
		 byte[] buffer=new byte[1024];
		
		while((len=in.read(buffer))>0) {
			 out.write(buffer,0,len);
		 }
		 
		in.close();
         out.close();
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}