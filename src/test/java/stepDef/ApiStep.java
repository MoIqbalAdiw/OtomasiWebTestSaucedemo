package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {
    ApiPage apiPage;
    public ApiStep() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @And("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.hitApiGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        apiPage.validationStatusCodeIsEquals(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }

    @And("hit api create new user")
    public void hitApiCreateNewUser() {
        apiPage.hitApiPostCreateUser();
    }

    @Then("validation response create new user")
    public void validationResponseCreateNewUser() {
        apiPage.validationResponseCreateUser();
    }

    @And("hit api delete new user")
    public void hitApiDeleteNewUser() {
        apiPage.hitApiDeleteUser();
    }

//    @And("hit api update data")
//    public void hitApiUpdateData() {
//        apiPage.hitApiUpdateUser();
//    }
//
//    @Then("validation response body update user")
//    public void validationResponseBodyUpdateUser() {
//        apiPage.validationResponseBodyUpdateUser();
//    }

//    @And("hit api create new user fail")
//    public void hitApiCreateNewUserFail() {
//        apiPage.hitApiFailCreate();
//    }

//    @And("hit api create new user with invalid email address")
//    public void hitApiCreateNewUserWithInvalidEmailAddress() {
//        apiPage.hitApiCreateUserInvalidEmail();
//    }

//    @And("hit api create new user with invalid gender")
//    public void hitApiCreateNewUserWithInvalidGender() {
//        apiPage.hitApiCreateInvalidGender();
//    }

//    @And("hit api get previous deleted user")
//    public void hitApiGetPreviousDeletedUser() {
//        apiPage.hitApiGetPreviousUser();
//    }
}
