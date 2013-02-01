package com.REST.client;

import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.simple.*;
import org.json.simple.parser.*;


public class RestClient {

	
		private RestClient() {
		}
	

		
		public static JSONObject getJSONFromURL(String url) throws ClientProtocolException, IOException, Exception{
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			InputStreamReader in = new InputStreamReader(response.getEntity().getContent());
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(in);
			try {
				return	((JSONObject) obj);
			} catch(Exception e) {
				
			}
			return null;
		}
	}

