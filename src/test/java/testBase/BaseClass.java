package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {

	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");
		
		logger=LogManager.getLogger(this.getClass());
		
		//WebDriverManager.chromedriver().setup();
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void teardown()
	{
		driver.quit();
	}
	
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return (generatedstring);
	}
	
	public String randomnumber()
	{
		String generatedstring1=RandomStringUtils.randomNumeric(10);
		return(generatedstring1);
	}
	
	public String randomalphanumeric()
	{
		String st=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		return (st+"@"+num);
	}

	public String captureScreen(String name) throws IOException {
		
		new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takescreenshots=(TakesScreenshot) driver;
		File source= takescreenshots.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"//screenshots"+name+"_"+"timestamp"+".png";
		try
		{
		FileUtils.copyDirectory(source, new File(destination));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return destination;
	}

	
	
	
	
	
}
