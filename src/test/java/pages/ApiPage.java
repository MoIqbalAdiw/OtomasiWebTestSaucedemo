package pages;

import helper.EndPoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.*;

public class ApiPage {
    String setURL, global_id;
    Response res;
    public void prepareUrlFor(String url){
        switch (url) {
            case "GET_LIST_USERS":
                setURL = EndPoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USER":
                setURL = EndPoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USER":
                setURL = EndPoint.DELETE_USERS;
                break;
            default:
                System.out.println("input right url");
        }
//        System.out.println("endpoint siap pakai adalah: " + setURL);
    }
    public void hitApiGetListUsers(){
        res = getListUsers(setURL);
//        System.out.println(res.getBody().asString());
    }
    public void hitApiPostCreateUser(){
        res = postCreateUser(setURL);
//        System.out.println(res.getBody().asString());
    }
    public void hitApiFailCreate(){
        res = failCreateUser(setURL);
    }
    public void hitApiCreateUserInvalidEmail(){
        res = postInvalidEmailUser(setURL);
    }
    public void hitApiCreateInvalidGender(){
        res = postInvalidGenderUser(setURL);
    }
    public void validationStatusCodeIsEquals(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
        System.out.println(status_code);
    }
    public void validationResponseBodyGetListUsers(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isInstanceOf(Integer.class);
        assertThat(name.get(0)).isInstanceOf(String.class);
        assertThat(email.get(0)).toString().contains("@");
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
//        System.out.println(email);
    }
    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void validationResponseCreateUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);
    }
    public void hitApiDeleteUser(){
        res = deleteUser(setURL,global_id);
    }
    public void hitApiGetPreviousUser(){
        res = getPreviousDeleted(setURL,global_id);
    }
    public void hitApiUpdateUser(){
        res = updateUser(setURL,global_id);
    }
    public void validationResponseBodyUpdateUser() {
        System.out.println(res.getBody().asString());
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");
    }
}
