package pages;

import helper.NumberXpath;
import helper.Utility;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import java.util.List;

import static helper.Utility.driver;

public class WebPage {
    String jumlahItem;
    String totalHarga;
    By input_username = By.id("user-name");
    By input_pwd = By.id("password");
    By btn_login = By.id("login-button");
    By icon_cart = By.xpath("//*[contains(@class, 'cart_container')]");
    By text_err_msg(String msg){
        return By.xpath("//h3[contains(., '" + msg + "')]");
    }
    By addToCart = By.xpath("(//*[.='ADD TO CART'])[1]");
    By removeFromCart = By.xpath("(//*[.='REMOVE'])[1]");
    By icon_cart_badge = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
    By checkout_button = By.xpath("//a[contains(.,'CHECKOUT')]");
    By catch_allname_prod_list = By.xpath("//div[@class='inventory_item_name']");
//    By catch_name_onprodpage = By.xpath("(//div[@class='inventory_item_name'])[position()<4]");
    By input_firstname = By.id("first-name");
    By input_lastname = By.id("last-name");
    By input_postcode = By.id("postal-code");
    By cont_button = By.xpath("//input[@value='CONTINUE']");
    public void openBrowser(){
        driver.get("https://www.saucedemo.com/v1/");
    }
    public void inputUsername(String username){
        driver.findElement(input_username).sendKeys(username);
    }
    public void inputPassword(String pwd){
        driver.findElement(input_pwd).sendKeys(pwd);
    }
    public void clickBtnLogin(){
        driver.findElement(btn_login).click();
    }
    public void assertHomePage(){
        driver.findElement(icon_cart).isDisplayed();
    }
    public void assertErrMsg(String errmsg){
        driver.findElement(text_err_msg(errmsg)).isDisplayed();
    }
    public void clickAddToCart(){
        driver.findElement(addToCart).click();
    }
    public void removeFromCart(){
        driver.findElement(removeFromCart).click();
    }
    public void assertCartItem(String cartItem){
        String itemExpected = cartItem;
        String itemActual = driver.findElement(icon_cart_badge).getText();
        Assertions.assertThat(itemActual).isEqualTo(itemExpected);
    }
    public void clickCartIcon(){
        driver.findElement(icon_cart).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(checkout_button).click();
    }
    public void inputFirstName(String firstname){
        driver.findElement(input_firstname).sendKeys(firstname);
    }
    public void inputLastName(String lastname){
        driver.findElement(input_lastname).sendKeys(lastname);
    }
    public void inputPostCode(String postcode){
        driver.findElement(input_postcode).sendKeys(postcode);
    }
    public void clickContinueButton(){
        driver.findElement(cont_button).click();
    }

    //simpan nama-nama produk ke dalam array/list dahulu untuk diassert
    public void numberItemSelected(String angka){
        switch (angka) {
            case "1":
                jumlahItem = NumberXpath.one;
                break;
            case "2":
                jumlahItem = NumberXpath.two;
                break;
            case "3":
                jumlahItem = NumberXpath.three;
                break;
            case "4":
                jumlahItem = NumberXpath.four;
                break;
            case "5":
                jumlahItem = NumberXpath.five;
                break;
            case "6":
                jumlahItem = NumberXpath.six;
                break;
            default:
                System.out.println("input right item number");
        }
//        System.out.println("item number yang dipakai adalah: "+jumlahItem);
    }

    public List <String> ItemForVerification() {
        List <String> productNames = Utility.productName(By.xpath(jumlahItem));
        System.out.println(productNames);
        return productNames;
    }

    public List <String> ItemListOnCheckout(){
        List <String> namaProduk = Utility.productName(catch_allname_prod_list);
        return namaProduk;
    }
    public boolean assertItemNamesMatch(){
        List <String> nama1 = ItemForVerification();
        List <String> nama2 = ItemListOnCheckout();
        Assertions.assertThat(nama1).isEqualTo(nama2);
//        System.out.println(nama1);
//        System.out.println(nama2);
        return true;
    }
    public String countItemPrice(){
        double hitungHargaManual = Utility.getSumAllItem();
        totalHarga = "$" + Double.toString(hitungHargaManual);
//        System.out.println(totalHarga);
        return totalHarga;
    }
    public void assertTotalPrice(){
        String getTextTotal = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
        String[] arrOfTotal = getTextTotal.split("Item total: ",2);
        String totalActual = arrOfTotal[1];
        String totalExpected = totalHarga;
//        System.out.println(totalActual);
        Assertions.assertThat(totalActual).isEqualTo(totalExpected);
    }
//    public void assertTotalPrice(String totalHarga){
//        String totalExpected = totalHarga;
//        String getTextTotal = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
////        String totalActual = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']" +
////                "[substring-after('total: ',.)]")).getText(); --failed--
//        String[] arrOfTotal = getTextTotal.split("Item total: ",2);
//        String totalActual = arrOfTotal[1];
//        System.out.println(totalActual);
//        Assertions.assertThat(totalActual).isEqualTo(totalExpected);
//    }
}