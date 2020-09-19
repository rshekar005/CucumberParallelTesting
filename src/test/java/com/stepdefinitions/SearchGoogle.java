package com.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.listeners.ExtentManager;
import com.listeners.ExtentTestManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class SearchGoogle extends BaseTest
{
	protected Scenario scenario;
	static String scenarioName;
	@Before()
	public void before(Scenario scenario)
	{
		this.scenario=scenario;
		scenarioName= scenario.getName();
		ExtentTestManager.startTest(scenarioName);
		ExtentTestManager.getTest().log(Status.INFO, "Scenario Started :"+scenario.getName());
	}
	
	@After()
	public void after(Scenario scenario){
		if(scenario.isFailed())
		{
			ExtentTestManager.logFail("Scenario Failed");
			ExtentTestManager.addScreenShotsOnFailure();
		}
		else
		{
			ExtentTestManager.logPass("Scenario Passed");
			ExtentTestManager.scenarioPass();
			ExtentTestManager.addScreenShots();
		}
		ExtentManager.getReporter().flush();
		getDriver().close();
	}
	@Given("launch browser {string}")
	public void launch_browser(String browser) {
		ExtentTestManager.logInfo("Launching the browser :"+browser);
	   startWebdriver(browser);
	}

	@When("user navigates to {string}")
	public void user_navigates_to(String url) {
		ExtentTestManager.logInfo("Launching the browser :"+url);
		enterUrl(url); 
	}

	@Then("user enters search terms {string}")
	public void user_enters_search_terms(String search) {
		ExtentTestManager.logInfo("user entering search terms :"+search);
	   getDriver().findElement(By.name("q")).sendKeys(search);
	}

	@Then("clicks on search button")
	public void clicks_on_search_button() {
		ExtentTestManager.logInfo("clicks on search ");
	   WebElement button=getDriver().findElement(By.name("btnK"));
	   JavascriptExecutor js= (JavascriptExecutor)getDriver();
	   js.executeScript("arguments[0].click();", button);
	}

}
