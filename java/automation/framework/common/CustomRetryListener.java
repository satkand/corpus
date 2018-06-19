package automation.framework.common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryListener implements IRetryAnalyzer {

	private int retryCount = 0;

	private int retryCountMax = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < retryCountMax) {
			retryCount++;
			return true;
		}
		return false;
	}

}
