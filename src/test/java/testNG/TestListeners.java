package testNG;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// not implemented
	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
	}

	public void onTestFailure(ITestResult result) {
		String s = result.getName().toString().trim();
		try {
			MyUtil.captureScreenShot(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		MyUtil.zip(System.getProperty("user.dir") + "\\Screenshot\\");
		MonitoringMail mail = new MonitoringMail();
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
