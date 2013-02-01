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

/**
 * this class is made to get a JSON file from a REST based webserver
 * you will only need the methjos getJSONFromURL(String url);
 * 
 * @author edopost
 * @version V1.0
 */


public class RestClient {

		public static String URLPREFIX = null;
	
		/**
		 * because this class is only retruns a JSON object from a url,
		 * you don't have to make an instance of it
		 */
		private RestClient() {
		}
	

		/**
		 * 
		 * @param url, this is the url of the location of the JSON, for example:
		 * "http://www.ovapi.nl/api78/stopareacode/" it need to be given in a Java.lang.String
		 * @return if sucessful an JSONObject with the information you reqested
		 */
		@SuppressWarnings("finally")
		public static JSONObject getJSONFromURL(String url) {
			JSONObject jo = null;
			try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(URLPREFIX + url);
			HttpResponse response = client.execute(request);
			InputStreamReader in = new InputStreamReader(response.getEntity().getContent());
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(in);
			try {
	//			System.out.println(obj);
				jo = ((JSONObject) obj);
	//			System.out.println(jo);
			} catch(Exception e) {
				
			}
			} catch(ClientProtocolException cpe) { 
				cpe.printStackTrace();
			} catch(IOException IOe) {
				IOe.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				return jo;
			}
		}
	}

