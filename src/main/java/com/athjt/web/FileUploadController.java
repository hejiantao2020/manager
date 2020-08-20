package com.athjt.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassNameFileUploadController
 * @Description
 * @Author hejiantao
 * @Date2020/8/20 20:35
 * @Version V1.0
 **/
@Controller
@RequestMapping("/admin/fileUpload")
public class FileUploadController {
	
	//上传文件到临时目录
	@PostMapping("/uploadFile")
	public Map<String, Object> uploadFile( @RequestParam(required = true) MultipartFile file){
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		try {
			String originalFilename = file.getOriginalFilename();
			resultmap.put("state", "success");
			resultmap.put("mesg", "操作成功");
			return resultmap;
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("state", "fail");
			resultmap.put("mesg", "操作失败，文件上传失败");
			return resultmap;
		}
	}
}
