package test.rest;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestUsers {
	private String url;
	private Response resp;
	@Parameters({"baseUrl","endpoint","schema"})
	@BeforeClass
	public void setUp(String baseUrl, String endPoint, String schema) {
		resp = get(String.format("%s%s", baseUrl,endPoint));
		//Given
			resp
			.then().assertThat().statusCode(HttpStatus.SC_OK)
				.and()
					.body(matchesJsonSchemaInClasspath(schema));		
	}
	
	@Parameters({"node_path","node_value"})
	@Test
	public void testIfNodeExists(String path, String value) {
		//Given
		resp
			.then()
				.assertThat().body(path, hasKey(value));
	}
	
	@Parameters({"node_name","value"})
	@Test
	public void testNodeValue(String node, String value) {
		//Given
		resp
			.then()
				.assertThat().body(node, equalTo(value));
	}
	
	@Test
	public void testIfCompleted() {
		Boolean completed = resp
			.then()
				.extract()
					.path("completed");
		assertFalse(completed);
	}

}
