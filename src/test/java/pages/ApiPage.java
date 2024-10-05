package pages;

import helper.EndPoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;
import java.util.Map;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

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
            case "USER_NOT_FOUND":
                setURL = EndPoint.USER_NOT_FOUND;
                break;
            default:
                System.out.println("input right url");
        }
//        System.out.println("endpoint siap pakai adalah: " + setURL);
    }
    public void hitApiGetListUsers(){
        res = getListUsers(setURL);
        System.out.println(res.getBody().asString());
    }
    public void hitApiPostCreateUser(){
        res = postCreateUser(setURL);
        System.out.println(res.getBody().asString());
    }
//    public void hitApiFailCreate(){
//        res = failCreateUser(setURL);
//    }
//    public void hitApiCreateUserInvalidEmail(){
//        res = postInvalidEmailUser(setURL);
//    }
//    public void hitApiCreateInvalidGender(){
//        res = postInvalidGenderUser(setURL);
//    }
    public void validationStatusCodeIsEquals(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
        System.out.println(status_code);
    }
    public void validationResponseBodyGetListUsers(){
        List<Object> data = res.jsonPath().getList("data");
        for (int i=0; i < data.size(); i++) {
        Map<String, Object> user = (Map<String, Object>) data.get(i);
//        List<Object> id = res.jsonPath().getList("id");
//        List<Object> email = res.jsonPath().getList("email");
//        List<Object> nameDepan = res.jsonPath().getList("first_name");
//        List<Object> nameBelakang = res.jsonPath().getList("last_name");
        assertThat(user.get("id")).isInstanceOf(Integer.class);
        assertThat(user.get("email")).toString().contains("@");
        assertThat(user.get("first_name")).isInstanceOf(String.class);
        assertThat(user.get("last_name")).isInstanceOf(String.class);}
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
        res = deleteUser(setURL);
    }
//    public void hitApiGetPreviousUser(){
//        res = getPreviousDeleted(setURL,global_id);
//    }
//    public void hitApiUpdateUser(){
//        res = updateUser(setURL,global_id);
//    }
//    public void validationResponseBodyUpdateUser() {
//        System.out.println(res.getBody().asString());
//        JsonPath jsonPathEvaluator = res.jsonPath();
//        Integer id = jsonPathEvaluator.get("id");
//        String name = jsonPathEvaluator.get("name");
//        String email = jsonPathEvaluator.get("email");
//        String gender = jsonPathEvaluator.get("gender");
//        String status = jsonPathEvaluator.get("status");
//
//        assertThat(id).isNotNull();
//        assertThat(name).isNotNull();
//        assertThat(email).isNotNull();
//        assertThat(gender).isIn("female", "male");
//        assertThat(status).isIn("active", "inactive");
//    }
}
