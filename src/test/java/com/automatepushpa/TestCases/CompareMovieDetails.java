package com.automatepushpa.TestCases;

import java.util.Date;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automatepushpa.Base.TestBase;
import com.automatepushpa.Pages.IMDbMovieDetailPage;
import com.automatepushpa.Pages.IMDbSearchResultPage;
import com.automatepushpa.Pages.WikiDetailsPage;
import com.automatepushpa.Pages.WikiSearchResultPage;

public class CompareMovieDetails extends TestBase {
	String movieName = System.getProperty("movieName");
	IMDbMovieDetailPage imdbMovieDetailsPage;
	WikiDetailsPage wikiDetailsPage;
	IMDbSearchResultPage imdbSearchResultsPage;
	WikiSearchResultPage wikiSearchResultPage;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws Exception {
		initalization();
		imdbSearchResultsPage = new IMDbSearchResultPage();
		imdbMovieDetailsPage = new IMDbMovieDetailPage();
		wikiSearchResultPage = new WikiSearchResultPage();
		wikiDetailsPage = new WikiDetailsPage();
	}

	@Test
	public void verifyCountryTest() throws Exception {
		imdbSearchResultsPage.navigateToTopSearchResult(movieName);
		String imdbCountryOfOrigin = imdbMovieDetailsPage.getCountryOfOrigin();
		wikiSearchResultPage.navigateToTopSearchResult(movieName);
		String wikiCountry = wikiDetailsPage.getCountry();
		Assert.assertEquals(imdbCountryOfOrigin, wikiCountry);
	}

	@Test
	public void verifyReleaseDate() throws Exception {
		imdbSearchResultsPage.navigateToTopSearchResult(movieName);
		Date imdbReleaseDate = imdbMovieDetailsPage.getReleaseDate();
		wikiSearchResultPage.navigateToTopSearchResult(movieName);
		Date wikiReleaseDate = wikiDetailsPage.getReleaseDate();
		Assert.assertEquals(imdbReleaseDate, wikiReleaseDate);
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
}
