package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout {

    public WebElement productNameAddedToCart(String productName, WebDriver driver){
        return   driver.findElement(By.xpath("//tr[@class='first last odd'] //h2[@class = 'product-name'] // a [text()='"+productName+"']"));
    }

}
