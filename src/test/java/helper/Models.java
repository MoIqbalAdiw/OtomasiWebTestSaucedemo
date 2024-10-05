package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {
    private static RequestSpecification request;

    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type","application/json")
                .header("Accept","application/json");
    }
    public static Response getListUsers(String endpoint) {
//        System.out.println("endpoint yang di lempar: " + endpoint);
        setupHeaders();
        return request.when().get(endpoint);
    }
    public static Response postCreateUser(String endpoint){
        String email = generateRandomEmail();
        String nameDepan = "Moh";
        String namaBelakang = "Iqbal";
        JSONObject payLoad = new JSONObject();
        payLoad.put("first_name", nameDepan);
        payLoad.put("last_name", namaBelakang);
        payLoad.put("email", email);

        setupHeaders();
        return request.body(payLoad.toString()).when().post(endpoint);
    }
//    public static void setFailHeaders() {
//        request = RestAssured.given()
//                .header("Content-Type","application/json")
//                .header("Accept", "application/json");
//    }
//    public static Response failCreateUser(String endpoint){
//        String name = "Moh Iqbal";
//        String gender = "male";
//        String email = generateRandomEmail();
//        String status = "active";
//        JSONObject payLoad = new JSONObject();
//        payLoad.put("name", name);
//        payLoad.put("gender", gender);
//        payLoad.put("email", email);
//        payLoad.put("status", status);
//
//        setFailHeaders();
//        return request.body(payLoad.toString()).when().post(endpoint);
//    }
//    public static Response postInvalidEmailUser(String endpoint){
//        String name = "Adip Sudip";
//        String gender = "male";
//        String email = "";
//        String status = "active";
//        JSONObject payLoad = new JSONObject();
//        payLoad.put("name", name);
//        payLoad.put("gender", gender);
//        payLoad.put("email", email);
//        payLoad.put("status", status);
//        setupHeaders();
//        return request.body(payLoad.toString()).when().post(endpoint);
//    }
//    public static Response postInvalidGenderUser(String endpoint){
//        String name = "Adip Sudip";
//        String gender = "cowok";
//        String email = "macantutul@makanayam.com";
//        String status = "active";
//        JSONObject payLoad = new JSONObject();
//        payLoad.put("name", name);
//        payLoad.put("gender", gender);
//        payLoad.put("email", email);
//        payLoad.put("status", status);
//        setupHeaders();
//        return request.body(payLoad.toString()).when().post(endpoint);
//    }
    public static Response deleteUser(String endpoint) {
        setupHeaders();
//        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(endpoint);
    }
//    public static Response getPreviousDeleted(String endpoint, String user_id){
//        setupHeaders();
//        String finalEndpoint = endpoint+"/"+user_id;
//        return request.when().get(finalEndpoint);
//    }
//    public static Response updateUser(String endpoint, String user_id) {
//        setupHeaders();
//        String name = "Iqbal Edit";
//        String gender = "male";
//        String email = generateRandomEmail();
//        String status = "active";
//        JSONObject payLoad = new JSONObject();
//        payLoad.put("name", name);
//        payLoad.put("gender", gender);
//        payLoad.put("email", email);
//        payLoad.put("status", status);
//
//        String finalEndpoint = endpoint + "/" + user_id;
//        return request.body(payLoad.toString()).when().patch(finalEndpoint);
//    }
}
