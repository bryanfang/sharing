package com.cscsharing.utils;

public final class Constraints {
	public static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
	public static final String OAUTH_CONSUMER_SECRET = "oauth_consumer_secret";
	public static final String REQUEST_TOKEN = "reqeust_token";
	public static final String OAUTH_VERIFIER = "oauth_verifier";
	public static final String ACCESS_TOKEN = "access_token";
	public static final String ACCESS_TOKEN_SECRET = "oauth_secret";

	public static final String VALUE_OF_APPLICATION_KEY = "VOvQlNjNm0dOYm7rkJD9";
	public static final String VALUE_OF_APPLICATION_SECRET = "xajDJkYbxumNrHfZJDTHXNq8XciH956meySBkXdJ";
	
	public static final String OAUTH_NONCE = "oauth_nonce";
	public static final String VALUE_OF_OAUTH_NONCE = "mytestbryan";
	
	public static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
	public static final String VALUE_OF_OAUTH_SIGNATURE_METHOD = "HMAC-SHA1";
	
	public static final String OAUTH_VERSION = "oauth_version";
	public static final String VALUE_OF_OAUTH_VERSION = "1.0";
	
	public static final String OAUTH_CALLBACK = "oauth_callback";
	public static final String VALUE_OF_OAUTH_CALLBACK = "oob";
	
	public static final String REQUEST_TOKEN_URL = "https://developer.sapjam.com/oauth/request_token/";
	
	public static final String OATH2_ACCESSTOKEN = "uXusJq3PBVQqHOx3Z5Un6XugMiuXMNQKaEq8q7zx";
	
	//Base URL of JAM OData Service
	public static final String BASE_SERVICE_URL = "https://developer.sapjam.com/api/v1/OData/";
	
	//Group service address
	public static final String GROUP_SERVICE_URL = "https://developer.sapjam.com/api/v1/OData/Groups";
	
	//JAM Address
	public static final String JAM_COMMUNICATION_URL = "https://developer.sapjam.com";
	
	//Session Type and bonus rate for configuration
	public static final double ST_P = 1;  //Only has presentation
	public static final double ST_PD = 1.10;  //Presentation and Demo
	public static final double ST_PH = 1.20;  //Presentation and Hands-on
	
	//valid feedback threshold
	public static final double SERVY_RATE_THRESHOLD = 0.2;  //when reach 20%, consider to be valid
	
	//Feedback bonus rate
	public static final double FB_FIRST_LEVEL = 1.5;  //4.8 ~ 5
	public static final double FB_SECOND_LEVEL = 1.2; //4.5 ~ 4.79
	
	//Default score for giving participant 
	public static final int DEFAULT_SCORE_P = 2;
	public static final int DEFAULT_ENTITLED = 5;
	
}
