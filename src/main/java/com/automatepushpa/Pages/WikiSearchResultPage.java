package com.automatepushpa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automatepushpa.Base.TestBase;

public class WikiSearchResultPage extends TestBase {
	@FindBy(xpath = "//td[contains(@class, 'searchResultImage-text')]//div[contains(@class, 'mw-search-result-heading')]//a")
	private List<WebElement> searchResults;

	public WikiSearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	private void search(String searchQuery) {
		driver.get("https://en.wikipedia.org/w/index.php?search=" + searchQuery
				+ "&title=Special:Search&profile=advanced&fulltext=1&ns0=1");
	}

	private WebElement getSearchResultByIndex(Integer i) throws Exception {
		return searchResults.get(i);
	}

	public void navigateToTopSearchResult(String searchQuery) throws Exception {
		search(searchQuery);
		getSearchResultByIndex(0).click();
	}
}