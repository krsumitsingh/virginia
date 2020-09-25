package com.guru99demo.helper.assertions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.guru99demo.helper.logger.LoggerHelper;

public class AssertionHelper {
	
	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);

	public static void verifyText(String s1, String s2){
		log.info("verify text with "+s1+" and "+s2);
		Assert.assertEquals(s1, s2);		
	}
	
	public static void makeTrue(){
		log.info("making script pass....");
		Assert.assertTrue(true);	
	}

	public static void makeTrue(String message ){
		log.info("making script pass....");
		Assert.assertTrue(true, message);
	}
	
	public static void makeFalse(){
		log.info("making script fail....");
		Assert.assertFalse(false);
	}
	
	public static void makeFalse(String message){
		log.info("making script pass....");
		Assert.assertFalse(false, message);
	}
	
	public static void verifyTrue(boolean status){
		Assert.assertTrue(true);	
	}
	
	public static void verifyFalse(boolean status){
		Assert.assertTrue(false);	
	}
	
	public static void verifyNull(String s1){
		log.info("verify object is null....");
		Assert.assertNull(s1);
	}
	
	public static void verifyNotNull(String s1){
		log.info("verify object is not null....");
		Assert.assertNotNull(s1);
	}
	
	public static void fail(){
		Assert.assertTrue(false);
	}
	
	public static void pass(){
		Assert.assertTrue(true);
	}
	
	public static void updateTestStatus(boolean status){
		if(status){
			pass();
		}
		else{
			fail();
		}
	}
}
