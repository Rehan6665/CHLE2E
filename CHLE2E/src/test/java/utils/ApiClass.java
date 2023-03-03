package utils;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class ApiClass {

	@Test
	public  void panicButoon() {

		JSONObject jsonData = new JSONObject();

		jsonData.put("endTimestamp", "0");
		jsonData.put("isLearning", "false");
		jsonData.put("isSimulated", "false");
		jsonData.put("pushed", "1");
		jsonData.put("statusUpdateTimestamp", "0");
		jsonData.put("type", "");
		jsonData.put("timestampStr", "");
		jsonData.put("eventId", "");
		jsonData.put("deviceId", "NDagency11P2");
		jsonData.put("battery", "72");
		
		RestAssured.baseURI = "https://liberate-staging.servicebus.windows.net/sensor-events/messages";
		RestAssured.given().header("Content-Type","application/json");
		RestAssured.given().header("Authorization","SharedAccessSignature sr=liberate-staging.servicebus.windows.net&sig=ZpcQn1DG8ruQXcVP0fgqa5kP6j6XR9czXSCBkLlYuic%3d&se=1761807990&skn=Hubitat")
		.contentType(ContentType.JSON).body(jsonData.toJSONString())
		.when().post().then().statusCode(201);
		
		
	}
}
