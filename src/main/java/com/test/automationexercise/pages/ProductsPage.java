package com.test.automationexercise.pages;

import com.test.automationexercise.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    private By blueTopProduct = By.xpath("//div[@id='cartModal']/following-sibling::div[1]");
    private By addToCartButton = By.xpath("//a[@data-product-id=1]");
    private By productPrice = By.xpath("//div[@id='cartModal']/following-sibling::div[1]//div[contains(@class, 'productinfo')]//h2");
    private By continueShoppingButton = By.xpath("//div[@class='modal-footer']//button");
    private List<Integer> prices = new ArrayList<>();

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToTheCart() {
        scrollToElement(blueTopProduct);
        storeProductPrice(blueTopProduct);
        clickElement(addToCartButton);
        clickElement(continueShoppingButton);
    }

    private int getProductPrice(By locator) {
        String priceText = extractText(locator);
        String numeric = priceText.replaceAll("[^0-9]", "");
        return Integer.parseInt(numeric);
    }

    private void storeProductPrice(By locator) {
        prices.add(getProductPrice(locator));
    }

    public List<Integer> getPrices() {
        return prices;
    }
}
