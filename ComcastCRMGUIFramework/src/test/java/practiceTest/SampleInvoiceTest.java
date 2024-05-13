package practiceTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
//@Listeners(com.comcast.crm.ListenerUtility.ListenerImplementation.class)
public class SampleInvoiceTest extends BaseClass {
	@Test
	public void createInvoiceTest() {
		System.out.println("execute create Invoice");
		String actTitle= driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}

	
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute create Invoice");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
