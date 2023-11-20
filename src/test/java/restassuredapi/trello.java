package restassuredapi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class trello {
	String id;
	
	@Test(enabled=true)
	public void createboard() {
		RestAssured.baseURI="https://trello.com";
		Response rep=given().queryParam("name", "API PROJECT")
				.queryParam("key", "1e7b7a8730cd0a2a151ab3e174540cae" )
				.queryParam("token", "ATTA6a747becbaeee682718f42d18231db16f14d642ae92b50a87faf1b299a12982dE3004D66")
				.header("Content-type","json/application")
				.when().post("/1/boards/").then().statusCode(200).contentType(ContentType.JSON).extract().response();
		rep.asString();
		JsonPath path=new JsonPath(rep.asString());
		System.out.println(path);
		id=path.get("id");
		System.out.println(id);
	    
	}
	
	@Test(enabled=true)
	public void delboard() {
		RestAssured.baseURI="https://trello.com";
		given().queryParam("name", "new board")
		.queryParam("key", "1e7b7a8730cd0a2a151ab3e174540cae" )
		.queryParam("token", "ATTA6a747becbaeee682718f42d18231db16f14d642ae92b50a87faf1b299a12982dE3004D66")
		.header("Content-type","json/application")
		.when().delete("/1/boards/"+id).then().statusCode(200).log().all();
		
	}

}
