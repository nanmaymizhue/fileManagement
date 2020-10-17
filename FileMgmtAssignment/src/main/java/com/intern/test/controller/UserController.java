package com.intern.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intern.test.constant.GlobalConstant;
import com.intern.test.entity.User;
import com.intern.test.response.BaseResponse;
import com.intern.test.response.UploadResponse;
import com.intern.test.service.UserService;

@RestController
public class UserController {
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping(value="/user")
	public BaseResponse addUser(@RequestBody User user) {
		try { 
			user = userService.addUser(user);
		}catch(Exception e) {
			System.out.println("Error occur "+e.getMessage());
			return new BaseResponse(GlobalConstant.FAIL, null,GlobalConstant.Message.FAIL_MESSAGE);
		}
		return new BaseResponse(GlobalConstant.SUCCESS, user,GlobalConstant.Message.SUCCESS_MESSAGE);
		
	}
	
	@GetMapping(value="/user")
	public BaseResponse getUsers() {
		List<User> user = userService.getUsers();
		return new BaseResponse(GlobalConstant.SUCCESS, user, GlobalConstant.Message.SUCCESS_MESSAGE);
	}
		
	
	 @PostMapping("file/upload")
		public BaseResponse uploadFile(@RequestParam MultipartFile file, @RequestParam Integer location,@RequestParam String name) {
	        logger.debug("REST request to upload file {} to location {}", location);
	        UploadResponse response = null;

	
	        String pathFile = userService.getFolderPath(location,name);
	        
	        try {
	            userService.saveFile(file, pathFile);
	            response = new UploadResponse();
	            response.setUrl(pathFile + "/" + file.getOriginalFilename());
	            response.setFileName(file.getOriginalFilename());
	            response.setStatus(true);
	            response.setFileContentType(file.getContentType());

	            logger.debug("Upload file {} success", file.getOriginalFilename());
	        } catch (IOException e) {

	            logger.warn("Upload file {} error", file.getOriginalFilename(), e);
	            e.printStackTrace();
	        }
	        return new BaseResponse(GlobalConstant.SUCCESS, response, GlobalConstant.Message.SUCCESS_MESSAGE);
	    }
	 
	 @GetMapping("file/download")
	 //upload/PROFILE/Htet Lwin Aun/55991602399446006/200x200bb.jpg"
	    public void downloadFile(@RequestParam String path, HttpServletResponse response) {
	        logger.info("Info to download file path {} ",path);

	        File file = new File(path);
	        try (FileInputStream fos = new FileInputStream(file)) {
	            StringTokenizer token = new StringTokenizer(path, "/");
	            String fileName = null;
	            while (token.hasMoreTokens()) {
	                fileName = token.nextToken();
	            }
	            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
	            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
	            IOUtils.copy(fos, response.getOutputStream());
	            response.flushBuffer();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	


}
