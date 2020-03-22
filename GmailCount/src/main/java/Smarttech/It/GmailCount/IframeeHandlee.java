package Smarttech.It.GmailCount;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeeHandlee {
	
public static void main(String[] args) throws InterruptedException  {
		
		System.setProperty("webdriver.chrome.driver", "/Users/habib/Desktop/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		
		
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		
	
				
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[2]/ul/li[1]/a" )).click();
		
		
		String k = driver.getTitle();
		  System.out.println("Your parent window  page title Is : "+k);
		
		
		
		driver.findElement(By.xpath("//*[contains(text(),'New Browser Tab')]" )).click();
		String j = driver.getTitle();
		  System.out.println("Your child window  page title Is : "+j);
		  
		
		
		
		//Get the address of main window 
	           String parent = driver.getWindowHandle();
	           
	           

	    //get address of all windows
	      Set<String> allWindow = driver.getWindowHandles();
	      
	      

	    //get address of all windows and store it in ArrayList
	      ArrayList<String> allWindowCopy = new ArrayList<String>(allWindow);
	      
	      

	      //close the 2nd window
	      
	      for(int i=0;i<allWindowCopy.size();i++)
	      {
	          if(i==2)
	          {
	              driver.switchTo().window(allWindowCopy.get(i));
	              driver.close();
	          }
	      }
	      
	      

	      //To switch to main window
	      driver.switchTo().window(parent);
	      
	      
	      
	      
	      driver.findElement(By.xpath("//*[contains(text(),'IFrame practice page')]" )).click();
	      
	      
	      driver.switchTo().frame("iframe1");
	      
	      Thread.sleep(5000);
	      
	     String mainframe1= driver.findElement(By.xpath("//*[@id=\"page\"]/div[1]/header" )).getText();
	      
	      
	      System.out.println("I am from i frame 1 ================================  " +mainframe1); 
	      
	      
	      driver.switchTo().defaultContent();
	      driver.switchTo().frame("iframe2");
	      
	      String subframe1= driver.findElement(By.xpath(" //*[@id=\"sidebar\"]" )).getText();
	      System.out.println("I am from i frame 2 ===============================  " +subframe1); 

	      //perform action in main window
	      
	 
	      driver.close();
	  }

		
		
}	  
		  
		  
		  
		  
		  
		  
		  
		  
		  