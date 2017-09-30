package org.andrews.demos.cocktails.drinky_drinky;


import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertNotEquals;

import org.andrews.demos.cocktails.drinky_drinky.entities.Beverage;
import org.andrews.demos.cocktails.drinky_drinky.entities.BeverageCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class DefaultControllerTests {
	
	@Test
	public void testIndex() {
		given().get("/")
		.then().statusCode(HttpStatus.OK.value())
		.and().extract().response();
	}
	
	@Test
	public void testAddBeverage() {
		Beverage newBev = new Beverage("Ice Tea", 1.99, "Yummy tea", BeverageCategory.NONALCOHOLIC);
		newBev.setId(-1);
		Beverage queryBev =
		given().contentType(MediaType.APPLICATION_JSON_VALUE).body(newBev).post("/addmenuitem")
		.then().statusCode(HttpStatus.CREATED.value())
		.and().extract().as(Beverage.class);
		
		assertNotEquals(0, queryBev.getId());
	}
}
