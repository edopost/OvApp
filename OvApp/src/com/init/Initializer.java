package com.init;

import com.REST.client.RestClient;
import com.data.StopList;
import com.gui.start.StratUpLoader;

/**
 * this class will boot the application;
 * @author edopost
 * @version V1.0
 *
 */

public class Initializer {

	public static void main(String[] arg) {
		new Initializer();
	}
	
	/**
	 * this will inintilaze the apllication
	 */
	public Initializer() {
		//build the loader
		StratUpLoader loader = new StratUpLoader();
		Thread loaderT = new Thread(loader, "StartUpLoader");
		loaderT.start();
		
		//laod the bus stops
		StopList stopList = new StopList(RestClient.getJSONFromURL("http://www.ovapi.nl/api78/stopareacode/"));
	}
	
}
