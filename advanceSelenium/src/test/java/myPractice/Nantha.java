package myPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Nantha {
	@Test(dataProvider = "dataSender")
	public void sample(String fname,String lname) {
		System.out.println(fname);
		System.out.println(lname);
		
	}
	@DataProvider
	public Object[][] dataSender(){
		Object[][] objArr = new Object[3][2];
		
	objArr[0][0]="iphone";
	objArr[0][1]="Apple iPhone 15 (128 GB) - Green";
	
	objArr[1][0]="iphone";
	objArr[1][1]="iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods";
	
	objArr[2][0]="iphone";
	objArr[2][1]="iPhone 17 Pro 256 GB: 15.93 cm (6.3″) Display with Promotion up to 120Hz, A19 Pro Chip, Breakthrough Battery Life, Pro Fusion Camera System with Center Stage Front Camera; Deep Blue";
	return objArr;
	}
}
