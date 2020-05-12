package com.taotao.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.utils.FastDFSClient;

/**
 * 处理图片操作
 * @author Administrator
 *
 */
@Controller
public class PictureController {

	@Value("${IMAGE_SERVER_URL}")
	private String imageServerUrl;
	
	private FastDFSClient fastDfsClient = new FastDFSClient("/resource/client.conf");
	
	
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public Map<String,Object> uploadFile( MultipartFile uploadFile ) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		
		try {
			
			String fileName = uploadFile.getOriginalFilename();
			// 获取扩展名
			String extName = fileName.substring( fileName.lastIndexOf(".") + 1 );
			String savePath = fastDfsClient.uploadFile( uploadFile.getBytes() , extName );
			
			result.put("error", 0 );
			result.put("url", imageServerUrl + savePath );
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			result.put("error", 1 );
			result.put("message", "图片上传失败" );
			return result;
		}
		
	}
	
	
	
	
	
	
}
