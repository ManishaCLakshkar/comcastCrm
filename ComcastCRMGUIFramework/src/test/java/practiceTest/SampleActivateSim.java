package practiceTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;

public class SampleActivateSim extends BaseClass{
	@Test(retryAnalyzer = com.comcast.crm.ListenerUtility.RetryListenerImplementation.class)
	public void ActivateSimTest() {
		System.out.println("execute create Invoice");
		String actTitle= driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
