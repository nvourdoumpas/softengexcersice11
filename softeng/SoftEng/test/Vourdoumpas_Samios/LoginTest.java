package Vourdoumpas_Samios;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.awt.Event;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Test;

public class LoginTest {

	


	@Test
	public void testLogin() {
		Login testerl = new Login();
		assertEquals(false, testerl.login);
		
	}
	
	@BeforeClass
	public static void testSetup(){
		System.out.println("Starting...");
	}
	
	@AfterClass
	public static void testCleanup(){
		System.out.println("Done!");
	}

}
