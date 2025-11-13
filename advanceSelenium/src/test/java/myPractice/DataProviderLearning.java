package myPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLearning {
	
	@Test(dataProvider ="dataSender" )
	public void login(String name,String lastname) {
		System.out.println(name);
		System.out.println(lastname);
		
		
		
	}
	
	@DataProvider
	public String[][] dataSender() {
		String[][] data={{"Nantha","Mani"},{"ravi","vasanth"},{"naveen","vijay"}};
		
		return data;
		
	}

}
