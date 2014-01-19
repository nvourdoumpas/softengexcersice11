package Vourdoumpas_Samios;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Test;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testLogin() {
		Employee testere = new Employee();
		assertEquals(false, testere.sented);
		
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
