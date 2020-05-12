package dockerValidation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest1 {

	@BeforeTest
	public void startDocker() throws IOException, InterruptedException {
		startDocker s = new startDocker();
		s.startFile();
	}
	
	@AfterTest
	public void stopDocker() throws IOException, InterruptedException {
		stopDocker s = new stopDocker();
		s.stopFile();;
	}
	
	@Test
	public void test1() throws MalformedURLException {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		URL url = new URL("http://192.168.99.100:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
	}
}
