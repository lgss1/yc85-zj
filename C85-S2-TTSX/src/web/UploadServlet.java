package web;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import dao.UserDao;
import util.Result;

@MultipartConfig()
@WebServlet("/UploadServlet.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao u = new UserDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;utf-8");
		Part part = request.getPart("file");
		// String webpath = "/productimg";

		// 获取工程根目录 tomcat服务/webapps/工程名
		String webpath = "/";
		
		String diskpath = request.getServletContext().getRealPath(webpath);

		// 将路径转成 File 对象
		File proDir = new File(diskpath);
		System.out.println(proDir);
		// 获取上级的上级目录 tomcat
		File tomcatDir = proDir.getParentFile().getParentFile();
		// 获取上级目录 webapps/ROOT/upload
		File uploadDir = new File(tomcatDir, "/webapps/ROOT/upload");
		System.out.println(uploadDir);
		// 重新赋值磁盘路径
		diskpath = uploadDir.getAbsolutePath();

		System.out.println(diskpath);
		diskpath = diskpath + "/" + part.getSubmittedFileName();
		webpath += "/" + part.getSubmittedFileName();
		// 去掉首部的 /
		webpath = webpath.substring(1);
		part.write(diskpath);

		Gson gson = new Gson();
		//Result res = new Result(1, "文件上传成功!", webpath);
		Result res = new Result( 1, "文件上传成功!", "/upload/" + part.getSubmittedFileName());
		String json = gson.toJson(res);
		response.getWriter().append(json);

	}

}
