package Vourdoumpas_Samios;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Test;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testLogin() {
		Customer tester = new Customer();
		assertEquals(false, tester.sented);
		
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
