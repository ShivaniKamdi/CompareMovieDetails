package com.automatepushpa.Pages;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automatepushpa.Base.TestBase;

public class WikiDetailsPage extends TestBase {
	@FindBy(xpath = "//tr//th[@class='infobox-label' and text()='Country']/following-sibling::td")
	private WebElement countryValue;

	@FindBy(xpath = "//tr//th[@class='infobox-label']//div[text()='Release date']/parent::th/following-sibling::td//div//ul//li")
	private WebElement releaseDateValue;

	public WikiDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getCountry() throws Exception {
		Thread.sleep(1000);
		return countryValue.getText();
	}

	public Date getReleaseDate() throws Exception {
		Thread.sleep(1000);
		SimpleDateFormat wikiReleaseDateFmt = new SimpleDateFormat("d MMMM y");
		String releaseDate = releaseDateValue.getText();
		return wikiReleaseDateFmt.parse(releaseDate, new ParsePosition(0));
	}
}
