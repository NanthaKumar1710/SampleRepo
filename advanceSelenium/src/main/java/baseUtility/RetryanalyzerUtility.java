package baseUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class RetryanalyzerUtility implements IRetryAnalyzer {

	int maxRetryCount= 3;
	int retryCount=0;
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<maxRetryCount) {
			retryCount++;
			System.out.println("Retrying test : "+result.getName()+" | Attempt "+(retryCount));
			UtilityClassObject.getTest().log(Status.FAIL,"Retrying test : "+result.getName()+" | Attempt "+(retryCount));
			return true;
		}
		return false;
	}
	
	

}
