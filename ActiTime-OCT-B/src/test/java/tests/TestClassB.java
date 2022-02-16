package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestClassB {
	
	
//	@BeforeTest
//	public void beforeTest() {
//		System.out.println("before Test TestClassB");
//	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class TestClassB");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method TestClassB");
	}

	@Test
	public void testE() {
		System.out.println("Test E TestClassB");
	}

	@Test
	public void testF() {
		System.out.println("Test F TestClassB");
	}

	@Test
	public void testG() {
		System.out.println("Test G TestClassB");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method TestClassB");
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("After Class TestClassB");
	}

//	@AfterTest
//	public void afterTest() {
//		System.out.println("After Test TestClassB");
//	}

	
}


