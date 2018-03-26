package automation.framework.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListner implements ITestListener {

	AutoUtilities utils = new AutoUtilities();

    public void onTestFailure(ITestResult result) {
        System.out.println("Listener is invoked YAY");
       //utils.takeScreenShot("Screen@_" + utils.timeStamp());
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

}
