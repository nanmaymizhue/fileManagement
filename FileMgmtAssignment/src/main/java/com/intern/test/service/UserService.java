package com.intern.test.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.intern.test.constant.GlobalConstant;
import com.intern.test.entity.User;
import com.intern.test.repository.UserRepository;

@Service
public class UserService {
	Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}
	

	
	   public String getFolderPath(Integer lo,String name) {

	        StringBuilder path = new StringBuilder();
	        
	        path.append(GlobalConstant.FolderName.FOLDER_ROOT).append("/");
	
	        String nextFolder;
	      
	        if (lo.equals(GlobalConstant.FolderLocation.LOCATION_NRC)) {
	            nextFolder = GlobalConstant.FolderName.NRC;
	        } else if (lo.equals(GlobalConstant.FolderLocation.LOCATION_PROFILE)) {
	            nextFolder = GlobalConstant.FolderName.PROFILE;
	        }
	       else {
	            nextFolder = GlobalConstant.FolderName.FOLDER_OTHER;
	        }
	      
	        path.append(nextFolder).append("/").append(name).append("/");
	       
	        Double ra = Math.random();
	        Long random=(long) (ra*10000);
	   
	        path.append(random);
	        path.append(System.currentTimeMillis());
	       
	       
	        return path.toString();
	    }
	   
	   
	   public Long saveFile(MultipartFile file, String path) throws IOException {
	       
			 if (file.isEmpty()) {
		            throw new RuntimeException("File is empty");
		        }
		        
		        Path location = Paths.get(path);
		        
		        if (Files.notExists(location)) {
		            new File(location.toString()).mkdirs();
		        }
		        return Files.copy(file.getInputStream(),
		                location.resolve(file.getOriginalFilename()),
		                StandardCopyOption.REPLACE_EXISTING);
		    }
	
	
	

}
