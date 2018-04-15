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
		
		//����ļ����ص����� 
		 String filename=request.getParameter("filename");//a.flv
		 //��������ļ�������----�ͻ���ͨ���ļ���MIME����ȥ�����ļ�����
		  response.setContentType(this.getServletContext().getMimeType(filename));
		  //���߿ͻ���Ҫ���ص���ʽ���Ը�����ʽ���أ�������ֱ�ӽ���
		  response.setHeader("Content-Disposition","attachment;filename="+filename);
		  
		 //����ļ����صľ���·��
		 String path=this.getServletContext().getRealPath("download/"+filename);
		 //����ļ���������
		 InputStream in=new  FileInputStream(path);
		 //����ļ��������
		 ServletOutputStream out=response.getOutputStream();
		 //�ļ���������
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