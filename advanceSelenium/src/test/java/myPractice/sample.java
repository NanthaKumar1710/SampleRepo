package myPractice;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class sample{
	
	@BeforeMethod
	public void n() {
		System.out.println("method1 sucessfully");
		
	}
	
	@BeforeSuite
	public void z() {
		System.out.println("z created sucessfully");
		
	}
	
	@BeforeSuite
	public void c() {
		System.out.println("c created sucessfully");
	}
	
	@Test
	public void t() {
		System.out.println("@test1 runned");
	}
	
	@BeforeSuite
	public void x() {
		System.out.println("x created sucessfully");
	}
	
	@Test
	public void m() {
		System.out.println(" @test2 runned");
	}
}