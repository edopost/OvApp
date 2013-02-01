package com.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.*;

import com.REST.actor.Stop;

/**
 * this class whil hold a list from all stops
 * @author edopost
 * @version V1.0
 *
 */

public class StopList {

	private ArrayList<Stop> stops;
	
	public StopList() {
		stops = new ArrayList<Stop>();
	}
	
	public StopList(JSONObject jo) {
		stops = new ArrayList<Stop>();
		buildList(jo);
	}
	
	public StopList(ArrayList<Stop> stops) {
		this.stops = stops;
		
	}
	
	public void buildList(JSONObject jo) {
		//build from the JSONObejct a arrayList with stops
		try{
			if(!jo.isEmpty()) {
				Set set = jo.entrySet();
				Iterator i = set.iterator();
				while(i.hasNext()) {
					Map.Entry me = (Map.Entry)i.next(); 
					String SpBern = (String) me.getKey();
					double Latitude = 0;
					String TimingPointName = null;
					double Longitude = 0;
					String TimingPointTown = null;
					JSONObject job = (JSONObject) me.getValue();
					Set set2 = job.entrySet();
					Iterator i2 = set2.iterator();
					while(i2.hasNext()) {
						Map.Entry me2 = (Map.Entry)i2.next();
						if(((String) me2.getKey()).equalsIgnoreCase("TimingPointName")) {
							TimingPointName = (String) me2.getValue();
						} else if(((String) me2.getKey()).equalsIgnoreCase("TimingPointTown")) {
							TimingPointTown = (String) me2.getValue();
						} else if(((String) me2.getKey()).equalsIgnoreCase("Latitude")) {
							Latitude = Double.parseDouble((String) me2.getValue());
						} else if(((String) me2.getKey()).equalsIgnoreCase("Longitude")) {
							Longitude = Double.parseDouble((String) me2.getValue());
						}
					}
					stops.add(new Stop(SpBern, Latitude, TimingPointName, Longitude, TimingPointTown));
				}
				
			} else {
				System.out.println("JOSNObject containt no values");
			}
		} catch(NullPointerException ne) {
			System.out.println("JOSNObject is null, 504 Gateway-Timeout");
		}
		
	}
	
	public void add(Stop stop) {
		stops.add(stop);
	}
	
	public Stop getStopByName(String stopName) {
		for(int i = 0;i<stops.size();i++) {
			if(stops.get(i).getTimingPointName().equalsIgnoreCase(stopName)) {
				return stops.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Stop> getStopsByTown(String Town) {
		ArrayList<Stop> stopsByTown = new ArrayList<Stop>();
		for(int i = 0;i<stops.size();i++) {
			if(stops.get(i).getTimingPointTown().equalsIgnoreCase(Town)) {
				stopsByTown.add(stops.get(i));
			}
		}
		return stopsByTown;
	}
	
	public ArrayList<Stop> getStopList() {
		return stops;
	}
 	
}
