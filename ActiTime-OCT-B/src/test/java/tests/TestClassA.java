package tests;
	

	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
    import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;

    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Parameters;
    import org.testng.annotations.Test;



	public class TestClassA {
	

//	@BeforeTest
//	@Parameters("testData")
//	public void beforeTest(String data) {
//		System.out.println(data);
//		System.out.println("before Test TestClassA");
//	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class TestClassA");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method TestClassA");
	}

	@Test
	public void testA() {
		System.out.println("Test A TestClassA");
	}

	@Test
	public void testB() {
		System.out.println("Test B TestClassA");
	}

	@Test
	public void testC() {
		System.out.println("Test C TestClassA");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method TestClassA");
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("After Class TestClassA");
	}

//	@AfterTest
//	public void afterTest() {
//		System.out.println("After Test TestClassA");
//	}



	}



