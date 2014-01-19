package Vourdoumpas_Samios;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Test;

import org.junit.Test;

public class AdministratorTest {

	@Test
	public void testLogin() {
		Administrator tester = new Administrator();
		assertEquals(false, tester.checked);
		
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
