package restassuredapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class restassuredc1 {
@Test(enabled = false)
public void tc1() {
	Response a=RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println(a.getBody());          //response of body
	int sc=a.getStatusCode();
	System.out.println(sc);   //status code
	Assert.assertEquals(sc, 200);
	System.out.println(a.time());
	System.out.println(a.asString());
}
@Test(enabled = false)
public void tc2() {
	//given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
	given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]", equalTo(7));
	System.out.println(given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all());
}
@Test(enabled = false)
public void su() {
	given().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
}
@Test(enabled =true)
public void post() {
	JSONObject jo=new JSONObject();
	jo.put("name", "ram");
	jo.put("job", "tester");
	jo.toJSONString();
	System.out.println(jo.toJSONString());
	given().body(jo.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
}
@Test(enabled=true)
public void upd() {
	JSONObject jo=new JSONObject();
	jo.put("name", "raju");
	jo.put("job", "dev");
	System.out.println(jo.toJSONString());
	given().body(jo.toJSONString()).when().post("https://reqres.in/api/users/2").then().statusCode(200).log().all();
}
@Test(enabled =true)
public void del() {
	given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
}
}
