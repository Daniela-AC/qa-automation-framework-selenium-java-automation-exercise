package com.test.automationexercise.utils;

import com.test.automationexercise.pages.ProductsPage;

public class PurchaseService {

    private ProductsPage productsPage;

    public PurchaseService(ProductsPage productsPage) {
        this.productsPage = productsPage;
    }

    public int getExpectedTotal() {
        int sum = 0;

        for (int price : productsPage.getPrices()) {
            sum += price;
        }
        return sum;
    }
}
