import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


import java.util.List;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertTrue;



public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "inventory_list")

    private WebElement inventoryList;


//    public void inventoryListIsDisplayed(){

//        assertTrue(inventoryList.isDisplayed());

    //    }
    @FindBy(className = "inventory_list")
    private WebElement invetoryList;
    @FindBy(className = "inventory_item")
    private List<WebElement> items;


    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCartButton;



    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement tShirtAddToCartButton;
    //add 4 prockt
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private  WebElement sauceLabsOnesie;



    public boolean inventoryListIsDisplayed() {

        return inventoryList.isDisplayed();

    }
    public int getInventoryItemSize(){
        return items.size();
    }

    public boolean allInventoryItemsAreDisplayed() {
        boolean allVisible = true;
        for (WebElement item : items) {
            if (!item.isDisplayed()) {
                allVisible = false;
                break;
            }
        }
        return allVisible;
    }

    public boolean allItemsNameAreNotEmpty() {
        boolean allItemsNameAreNotEmpty = true;
        for (WebElement itemName : itemNames) {
            String text = itemName.getText();
            if (text.isEmpty()) {
                allItemsNameAreNotEmpty = false;
                break;
            }
        }
            return allItemsNameAreNotEmpty;
        }

        public  boolean allNamesStartWithSauceLab(){
        boolean allNamesStartWithSauceLab = true;
        String expectedText = "Sauce Labs";
        int i =0;
        for (WebElement item : itemNames){
            String text = item.getText();
            if (!text.startsWith(expectedText)){
                allNamesStartWithSauceLab = false;
                System.out.println("Element without Sauce Labs"+i);
                break;

            }
            i++;

        }

        return  allNamesStartWithSauceLab;
        }
    public void backPackAddToCart(){
        backpackAddToCartButton.click();
    }

    public void bikeLightAddToCart(){
        bikeLightAddToCartButton.click();
    }

    public void tShirtAddToCart(){
        tShirtAddToCartButton.click();
    }
    //add 4 prockt
    public  void sauceLabsOnesie(){
        sauceLabsOnesie.click();
    }
    }

