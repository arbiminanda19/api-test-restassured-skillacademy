package apiTestRunner;

import payload.ListAPI;
import payload.APIdata;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAPI {

	ListAPI ip = new ListAPI();
	Response response;
	Random rand = new Random();
		
	@BeforeMethod
    public void setUp() {
        RestAssured.baseURI = ip.getSkillAcademyAPI();
    }
	
	@Test(priority = 0)
    public void basicSearch(){
		response = given()
                .when()
                .get("?searchQuery=SMA")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
	}
	
	@Test(priority = 1)
    public void searchWithSetPageResult(){
		response = given()
                .when()
                .get("?page=2&pageSize=20&searchQuery=SMA")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
	}
	
	@Test(priority = 2)
    public void searchWithPriceFilter(){
		response = given()
                .when()
                .get("?minPrice=0&maxPrice=180000&searchQuery=SMA")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
	}
	
	@Test(priority = 3)
    public void searchWithDurationFilter(){
		response = given()
                .when()
                .get("?min_duration=0&max_duration=1&searchQuery=SMA")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
	}
	
	@Test(priority = 4)
    public void searchAndSortResults(){
		response = given()
                .when()
                .get("?sortBy=total_rating&orderBy=desc&searchQuery=SMA")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
	}
	
	@Test(priority = 5)
    public void searchWithAllParam(){
		response = given()
                .when()
                .get("?page=1&pageSize=10&minPrice=150000&maxPrice=280000&sortBy=price&orderBy=asc&min_duration=2&max_duration=3&searchQuery=SMA")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response();
	}
	
}
