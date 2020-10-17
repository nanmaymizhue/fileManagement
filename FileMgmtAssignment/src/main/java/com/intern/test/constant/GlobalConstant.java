package com.intern.test.constant;

public class GlobalConstant {

	public static final int SUCCESS = 0;
	public static final int FAIL = 1 ;
	
	
	public interface Message{
		String SUCCESS_MESSAGE="Successful !!!";
		String FAIL_MESSAGE = "Fail !!!";
	}
	
	public interface FolderLocation {
        Integer LOCATION_NRC = 1;
        Integer LOCATION_PROFILE = 2;     

    }

    public interface FolderName {
        String FOLDER_ROOT = "upload";
        String  NRC = "NRC";
        String  PROFILE = "PROFILE";
        String FOLDER_OTHER = "other";

    }

}
