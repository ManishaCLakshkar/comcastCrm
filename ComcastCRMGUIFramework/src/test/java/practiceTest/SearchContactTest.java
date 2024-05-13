package practiceTest;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.objectRepoditojutility.LoginPage;

/**
 * test clas for contact module
 * 
 */
public class SearchContactTest extends BaseClass
 {
	/**
	 * Scenario :Login()==> navigate to contact
	 */
	public void searchContactTest() {
		/*Login to app*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("url", "username", "password");
	}

}
