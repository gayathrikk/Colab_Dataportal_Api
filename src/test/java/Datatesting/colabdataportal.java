package Datatesting;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class colabdataportal {

    @Test
    void brainData() {
        // Request 1: Get Login User
    	System.out.println("Sending POST request to Get Login User ");
    	
		 String jsonBody ="{\"user_name\":\"software team\",\"user_hash\":\"106900966448254245591\",\"email\":\"teamsoftware457@gmail.com\","
		 		+ "\"image\":\"https://lh3.googleusercontent.com/a/AAcHTte--G1vkdrm_ojhRzgIsEpuDHA-4loc7lX1bl-XensG=s96-c\"}";
				 given()
	            .auth()
	            .preemptive()
	            .basic("admin", "admin")
	            .contentType(ContentType.JSON) 
	            .body(jsonBody) 
	        .when()
	            .post("https://dataportal.colab.humanbrain.in/CC/getLoginUser")
	        .then()
	            .statusCode(200)
	            .log().all();
				 
        // Request 2: Get Details of Series Stats All Restricted
		System.out.println("Sending GET request to Get Details of Series Stats All Restricted API...");
        given()
            .auth()
            .preemptive()
            .basic("admin", "admin")
        .when()
            .get("https://dataportal.colab.humanbrain.in/CC/getDetailsOfSeriesStatsAllRestricted/106900966448254245591")
        .then()
            .statusCode(200)
            .log().all();
    }
}
