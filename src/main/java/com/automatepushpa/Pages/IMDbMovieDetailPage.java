package com.automatepushpa.Pages;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automatepushpa.Base.TestBase;

public class IMDbMovieDetailPage extends TestBase {
	@FindBy(xpath = "//button[@class='ipc-metadata-list-item__label' and text()='Country of origin']/following-sibling::div/ul/li/a")
	private WebElement countryOfOriginValue;

	@FindBy(xpath = "//a[@class='ipc-metadata-list-item__label ipc-metadata-list-item__label--link' and text()='Release date']/following-sibling::div/ul/li/a")
	private WebElement releaseDateValue;

	public IMDbMovieDetailPage() {
		PageFactory.initElements(driver, this);
	}

	public String getCountryOfOrigin() throws Exception {
		Thread.sleep(1000);
		return countryOfOriginValue.getText();
	}

	public Date getReleaseDate() throws Exception {
		Thread.sleep(1000);
		SimpleDateFormat imdbReleaseDateFmt = new SimpleDateFormat("MMMM d, y");
		String delimiter = " \\(";
		String releaseDate = releaseDateValue.getText().split(delimiter)[0];
		return imdbReleaseDateFmt.parse(releaseDate, new ParsePosition(0));
	}
}