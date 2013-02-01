package com.init;

import com.REST.client.RestClient;
import com.data.StopList;
import com.gui.MainInterface;
import com.gui.start.StartUpLoader;

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
		StartUpLoader loader = new StartUpLoader();
		Thread loaderT = new Thread(loader, "StartUpLoader");
		loaderT.start();
		loader.setProcent(5);
		
		//laod the bus stops
		RestClient.URLPREFIX = "http://94.23.144.45:8080/";
		loader.setProcent(6);
		loader.setComment("recieving stop\'s");
		StopList stopList = new StopList(RestClient.getJSONFromURL("stopareacode/"));
		loader.setProcent(25);
		MainInterface mainI = new MainInterface(loader);
		Thread interfaceT = new Thread(mainI, "Interface");
		interfaceT.start();
		loader.done = true;
	}
	
}
