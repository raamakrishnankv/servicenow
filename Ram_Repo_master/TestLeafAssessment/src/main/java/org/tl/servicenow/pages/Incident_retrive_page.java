package org.tl.servicenow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.tl.servicenow.utils.Common_methods;

public class Incident_retrive_page extends Common_methods {

	public Incident_retrive_page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//input[@class='form-control'])[1]")WebElement eleSeach;
	@FindBy(how = How.XPATH, using = "//a[@class='linked formlink']")WebElement eleRetrivedIncident;

	public Incident_retrive_page searchIncidentNum() throws InterruptedException {
		Thread.sleep(5000);
		eleSeach.sendKeys(genIncidentNum, Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}

	public Incident_retrive_page incidentCrossCheck() {
		String retrivedIncident = eleRetrivedIncident.getText();
		System.out.println("The Retrived Incident Number is: " + retrivedIncident);

		if (retrivedIncident.equals(genIncidentNum)) {
			System.out.println("Incident created successful");
		} else {
			System.out.println("Incident creation failed");
		}
		return this;
	}
}
