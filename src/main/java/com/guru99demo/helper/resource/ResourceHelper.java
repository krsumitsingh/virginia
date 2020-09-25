package com.guru99demo.helper.resource;

public class ResourceHelper {
	
	public static String getResourcePath(String Path){
		
		String basePath = System.getProperty("user.dir");
		return basePath+"/"+Path;
		
	}

/************************************************************************************************	
/**
 * Testing getResourcepath method
 * @param args
 */
   /*  public static void main(String[] args) {
		
		String path = ResourceHelper.getResourcePath("\\resources\\configFile\\log4j.properties");
		System.out.println(path);
		
	}*/
	
}
