package com.bridgelabz.spotify;

import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SpotifyPlaylist {
	/**
	 * Method: This method is used to creating one playlist on spotify 
	 */
	
	String uri = "https://api.spotify.com/v1";
	String token = "Bearer BQCGlPwCjV9iEG6aQru4iV1vFTx6SS4tCoNUQjjWuBYnO6JqbCMxTHs4sDtBJKNlY8aqLDnz-ILkmqVSkMkScN0242OS6v6rkRXqhu4sEQGfU0YMp0jaXsBE4QBf7ZpelV4ejdCBYSgm05_nBk3r-X5ABz-tjoc1OS2e-QVc1Qsdjdr2PdNida3JpQ8eyGYJ_rzkmIQtIGkm";
	
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
}
