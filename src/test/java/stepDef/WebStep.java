package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.WebPage;

public class WebStep {
    WebPage webPage;
    public WebStep() {
        this.webPage = new WebPage();
    }
    @Given("open web login page")
    public void openWebLoginPage() {
        webPage.openBrowser();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        webPage.inputUsername(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String pwd) {
        webPage.inputPassword(pwd);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        webPage.clickBtnLogin();
    }

    @And("user will see icon cart in homepage")
    public void userWillSeeIconCartInHomepage() {
        webPage.assertHomePage();
    }

    @And("user will see error message {string}")
    public void userWillSeeErrorMessage(String errMessge) {
        webPage.assertErrMsg(errMessge);
    }

    @And("user add item to cart")
    public void userAddItemToCart() {
        webPage.clickAddToCart();
    }

    @Then("verify cart item is match {string}")
    public void verifyCartItemIsMatch(String cartItem) {
        webPage.assertCartItem(cartItem);
    }

    @And("user remove item from cart")
    public void userRemoveItemFromCart() {
        webPage.removeFromCart();
    }

    @And("user click cart icon")
    public void userClickCartIcon() {
        webPage.clickCartIcon();
    }

    @And("user click checkout")
    public void userClickCheckout() {
        webPage.clickCheckoutButton();
    }

    @And("user input first name {string}")
    public void userInputFirstName(String firstname) {
        webPage.inputFirstName(firstname);
    }

    @And("user input last name {string}")
    public void userInputLastName(String lastname) {
        webPage.inputLastName(lastname);
    }

    @And("user input postal code {string}")
    public void userInputPostalCode(String code) {
        webPage.inputPostCode(code);
    }

    @And("user click continue")
    public void userClickContinue() {
        webPage.clickContinueButton();
    }

    @And("number of item selected is {string}")
    public void numberOfItemSelectedIs(String jumlah) {
        webPage.numberItemSelected(jumlah);
    }

    @And("collect item list checkout")
    public void collectItemListCheckout() {
        webPage.ItemListOnCheckout();
    }

    @And("collect item names")
    public void collectItemNames() {
        webPage.ItemForVerification();
    }

//    @And("collect item names of total {string}")
//    public void collectItemNamesOfTotal(String arg0) {
//    }

    @Then("verify cart list same as selected item on previous page")
    public void verifyCartListSameAsSelectedItemOnPreviousPage() {
        webPage.assertItemNamesMatch();
    }

    @And("get sum total price item list")
    public void getSumTotalPriceItemList() {
        webPage.countItemPrice();
    }
    
    @Then("verify item total price matches total price product selected")
    public void verifyItemTotalPriceMatchesTotalPriceProductSelected() {
        webPage.assertTotalPrice();
    }

//    @Then("verify item total price matches total price product selected {string}")
//    public void verifyItemTotalPriceMatchesTotalPriceProductSelected(String totalHarga) {
//        webPage.assertTotalPrice(totalHarga);
//    }
}
