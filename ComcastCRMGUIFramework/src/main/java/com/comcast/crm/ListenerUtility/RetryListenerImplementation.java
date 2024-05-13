package com.comcast.crm.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImplementation  implements IRetryAnalyzer{
	
	int count = 0;
	int limitCount=5;
	public boolean retry(ITestResult result)
	{
		if(count < limitCount) {
			count++;
			return true;
		}
		return false;
	}
//	@Override
//	public boolean retry(ITestResult result) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	
}
