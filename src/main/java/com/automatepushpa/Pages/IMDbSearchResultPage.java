package com.automatepushpa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automatepushpa.Base.TestBase;

public class IMDbSearchResultPage extends TestBase {
	@FindBy(xpath = "//li[contains(@class, 'ipc-metadata-list-summary-item')]")
	private List<WebElement> searchResults;

	public IMDbSearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	private void search(String searchQuery) {
		driver.get("https://www.imdb.com/find/?q=" + searchQuery);
	}

	private WebElement getSearchResultByIndex(Integer i) throws Exception {
		return searchResults.get(i);
	}

	public void navigateToTopSearchResult(String searchQuery) throws Exception {
		search(searchQuery);
		getSearchResultByIndex(0).click();
	}
}