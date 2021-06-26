package onthiclient3.config;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadFile {
	
	public void upload(MultipartFile multipartFile,HttpSession session) throws IOException {
		ServletContext context=session.getServletContext();
		String fileName=multipartFile.getOriginalFilename();
		String path=context.getRealPath("/images");
		String filePath=path+File.separator+fileName;
		System.out.println(path);
		byte[] bytes= multipartFile.getBytes();
		BufferedOutputStream stream;
		stream=new BufferedOutputStream(new FileOutputStream(new File(filePath)));
		stream.write(bytes);
		stream.flush();
		stream.close();
	}
	

	
}
