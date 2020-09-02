package com.webservice.asix2.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
//import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpsConnectionExample_GetVersion {
	
	
	private final String USER_AGENT = "Mozilla/5.0"; 
	
	public static void main(String[] args) throws Exception { 
		HttpsConnectionExample_GetVersion http = new HttpsConnectionExample_GetVersion(); 
		System.out.println("GET으로 데이터 가져오기"); 
//		http.HttpsSendGet("https://www.naver.com");
		//http.HttpsSendGet("http://localhost:8080/services/Version?method=getVersion"); 
		System.out.println("POST로 데이터 가져오기"); 
		String urlParameters = "?req=webmap"; 
		http.httpsSendPost("http://localhost:8080/services/Axis2WebServiceMap", urlParameters); 
	} 
	
	// HTTP GET request 
	public void HttpsSendGet(String targetUrl) throws Exception 
	{ 
		URL url = new URL(targetUrl); 
		HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
		con.setRequestMethod("GET"); // optional default is GET 
		con.setRequestProperty("User-Agent", USER_AGENT); // add request header 
		
		int responseCode = con.getResponseCode(); 
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
		String inputLine; StringBuffer response = new StringBuffer(); 
		
		while ((inputLine = in.readLine()) != null) { 
			response.append(inputLine); 
		} 
		
		in.close(); 
		// print result 
		System.out.println("HTTP 응답 코드 : " + responseCode); 
		System.out.println("HTTP body : " + response.toString()); 
	} 
		
	// HTTP POST request 
	public void httpsSendPost(String targetUrl, String parameters) throws Exception { 
		URL url = new URL(targetUrl); 
		HttpURLConnection con = (HttpURLConnection) url.openConnection(); 
		
		con.setConnectTimeout(15000); //접속하는 커넥션 타임 15초동안 접속안되면 접속안되는 것으로 간주 (ms)
		//con.setReadTimeout(100000); //10초동안 서버로부터 반응없으면 에러
		
		con.setRequestMethod("POST"); // HTTP POST 메소드 설정 
		con.setRequestProperty("User-Agent", USER_AGENT); 
		con.setDoOutput(true); // POST 파라미터 전달을 위한 설정 
		
		// Send post request 
		DataOutputStream wr = new DataOutputStream(con.getOutputStream()); 
		wr.writeBytes(parameters); 
		wr.flush(); 
		wr.close(); 
		int responseCode = con.getResponseCode(); 
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); 
		String inputLine; 
		StringBuffer response = new StringBuffer(); 
		while ((inputLine = in.readLine()) != null) { 
			response.append(inputLine); 
		} 
		in.close(); 
		
		// print result 
		System.out.println("HTTP 응답 코드 : " + responseCode); 
		System.out.println("HTTP body : " + response.toString()); 
	} 

}
