package chl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.meta.When;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class ApiClass {

	static String p_deviceid;
	static String m_deviceid;
	static String d_deviceid;

	public static void pdevice(String id) {

		p_deviceid = id;
	}

	public static void mdevice(String id) {

		m_deviceid = id;
	}
	public static void ddevice(String id) {

		d_deviceid = id;
	}

	@Test(priority = 8)
	public void panicButoon() {

		
		System.out.println(p_deviceid);
		JSONObject jsonData = new JSONObject();

		jsonData.put("endTimestamp", "0");
		jsonData.put("isLearning", "false");
		jsonData.put("isSimulated", "false");
		jsonData.put("pushed", "1");
		jsonData.put("statusUpdateTimestamp", "0");
		jsonData.put("type", "");
		jsonData.put("timestampStr", "");
		jsonData.put("eventId", "");
		jsonData.put("deviceId", p_deviceid);
		jsonData.put("battery", "72"); 	

		RestAssured.baseURI = "https://liberate-staging.servicebus.windows.net/sensor-events/messages";
		RestAssured.given().header("Content-Type","application/json");
		RestAssured.given().header("Authorization","SharedAccessSignature sr=liberate-staging.servicebus.windows.net&sig=ZpcQn1DG8ruQXcVP0fgqa5kP6j6XR9czXSCBkLlYuic%3d&se=1761807990&skn=Hubitat")
		.contentType(ContentType.JSON).body(jsonData.toJSONString())
		.when().post().then().statusCode(201);


	}

	@Test(priority = 9)
	public void doorAndWindow() {


		JSONObject jsonData = new JSONObject();
		jsonData.put("endTimestamp", "0");
		jsonData.put("isLearning", "false");
		jsonData.put("isSimulated", "false");
		jsonData.put("presenceDetected", "false");
		jsonData.put("contact", "open");
		jsonData.put("statusUpdateTimestamp", "0");
		jsonData.put("type", "");
		jsonData.put("timestampStr", "");
		jsonData.put("eventId", "");
		jsonData.put("deviceId", d_deviceid);
		jsonData.put("battery", "72"); 

		RestAssured.baseURI ="https://liberate-staging.servicebus.windows.net/sensor-events/messages";
		RestAssured.given().header("Content-Type","application/json");
		RestAssured.given().header("Authorization","SharedAccessSignature sr=liberate-staging.servicebus.windows.net&sig=ZpcQn1DG8ruQXcVP0fgqa5kP6j6XR9czXSCBkLlYuic%3d&se=1761807990&skn=Hubitat")
		.contentType(ContentType.JSON).body(jsonData.toJSONString()).when().post().then().statusCode(201);

	}

	@Test(priority = 10)
	public void motion() {

		JSONObject jsonData = new JSONObject();
		jsonData.put("endTimestamp", "0");
		jsonData.put("isLearning", "false");
		jsonData.put("isSimulated", "false");
		jsonData.put("motion", "inactive");
		jsonData.put("statusUpdateTimestamp", "0");
		jsonData.put("type", "");
		jsonData.put("timestampStr", "");
		jsonData.put("eventId", "");
		jsonData.put("deviceId", m_deviceid);
		jsonData.put("battery", "72"); 

		RestAssured.baseURI ="https://liberate-staging.servicebus.windows.net/sensor-events/messages";
		RestAssured.given().header("Content-Type","application/json");
		RestAssured.given().header("Authorization","SharedAccessSignature sr=liberate-staging.servicebus.windows.net&sig=ZpcQn1DG8ruQXcVP0fgqa5kP6j6XR9czXSCBkLlYuic%3d&se=1761807990&skn=Hubitat")
		.contentType(ContentType.JSON).body(jsonData.toJSONString()).when().post().then().statusCode(201);


	}



}
