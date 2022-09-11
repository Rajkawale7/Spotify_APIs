package com.bridgelabz.spotify;

import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SpotifyPlaylist {
	/**
	 * Method: This method is used to creating one playlist on spotify 
	 */
	
	String uri = "https://api.spotify.com/v1";
	String token = "Bearer BQD_X-DfKNbohNwDqbeaCXP7MC3InW5R2o8w7W8mJDYcx0CVum4fnPs6PtMD1RP-ZRtwaglYUWw7BX3JEuX_EPfu78vrtLkEQeKYsgvTuML6t1d912EKOAAlNcVCOAaccg_B7gqb82YcMMljbPUl5MRGlLCeBO08PG9eGVhl6-DWwFJefsuoCM2ZAfatGurMsuOsJ3XX5X4xhuI";
	
	@Test
	public void CreatePlaylist() {
	System.out.println("\n*****For Post Request-Create Playlist******");
	
	//Specifying the the URl
	RestAssured.baseURI = uri;
	
	//Getting requestSpecification of request
	RequestSpecification httpRequest = RestAssured.given();
	httpRequest.header("Authorization",token);
	
	//Passing values and parameters into body
	httpRequest.body("{\r\n"
			+ "  \"name\": \"CQA_Raj\",\r\n"
			+ "  \"description\": \"This playlist has been created by using Rest Assured API tool\",\r\n"
			+ "  \"public\": false\r\n"
			+ "}");
			
	//Passing the request "Post"
	Response response = httpRequest.request(Method.POST, "/users/kp3h8vi2tcgpixazjqzqsurj6/playlists");
	
	//https://api.spotify.com/v1/users/{user_id}/playlists
	//Printing the Status and response of server
	System.out.println("The result of status code is: " + response.getStatusCode());
	System.out.println("The response Time has taken: " + response.getTime());
	System.out.println("The Result of Creating playlist is: " + response.asPrettyString());
	System.out.println("________________________________________________________________");
	}

	@Test
	public void getPlaylist() {
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().baseUri(uri);
		
		Response response1 = RestAssured.given().header("Authorization", token).get(uri + "/users/kp3h8vi2tcgpixazjqzqsurj6/playlists");
		
		System.out.println("Current User's Playlists: " + response1.asPrettyString());
		System.out.println("The result of status code is : " + response1.getStatusCode());
		System.out.println("The response Time has taken : " + response1.getTime());
		System.out.println("________________________________________________________________");
	}
	
	@Test
    public void addItemsToPlaylist() {
        Response response2 = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .get(uri + "/playlists/1e8xIRPe0z9Lq3zi22G63t/tracks?uris=spotify:track:6EtKlIQmGPB9SX8UjDJG5s");
        
        System.out.println("Current User's Playlists: " + response2.prettyPrint());
        System.out.println("The result of status code is : " + response2.getStatusCode());
		System.out.println("The response Time has taken : " + response2.getTime());
		System.out.println("________________________________________________________________");    }
}
