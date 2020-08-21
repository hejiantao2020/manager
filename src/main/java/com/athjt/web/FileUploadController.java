package com.athjt.web;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

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
	@Value("${web.upload-path}")
	private String uploadPath;
	//上传文件到临时目录
	@ResponseBody
	@RequestMapping("/uploadFile")
	@RequiresPermissions(value = {"基础信息"})
	public Map<String, Object> uploadFile(@RequestParam MultipartFile file, HttpServletRequest request){
		LinkedHashMap<String, Object> resultmap = new LinkedHashMap<String, Object>();
		try {
			//获取上传文件名,包含后缀
			String originalFilename = file.getOriginalFilename();
			//获取后缀
			String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
			//保存的文件名
			String dFileName = UUID.randomUUID()+substring;
			//保存路径
			//springboot 默认情况下只能加载 resource文件夹下静态资源文件
			//String path = "D:/workspace/demo2/src/main/resources/static/image/";
			//生成保存文件
			File uploadFile = new File(uploadPath + dFileName);
			System.out.println(uploadFile);
			//将上传文件保存到路径
			try {
				file.transferTo(uploadFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			resultmap.put("state", "success");
			resultmap.put("mesg", "上传成功");
			resultmap.put("fileName",dFileName);
			resultmap.put("filePath",uploadPath+dFileName);
			return resultmap;
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("state", "fail");
			resultmap.put("mesg", "操作失败，文件上传失败");
			return resultmap;
		}
	}
}
