package com.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;

import com.REST.actor.Line;
import com.gui.start.StartUpLoader;

public class LineList {

	private ArrayList<Line> lines;
	
	public LineList() {
		lines = new ArrayList<Line>();
	}
	
	public LineList(JSONObject jo) {
		lines = new ArrayList<Line>();
		buildList(jo);
	}
	
	public LineList(ArrayList<Line> lines) {
		this.lines = lines;
		
	}
	
	@SuppressWarnings("rawtypes")
	public void buildList(JSONObject jo) {
		//build from the JSONObejct a arrayList with stops
		try{
			if(!jo.isEmpty()) {
				Set set = jo.entrySet();
				Iterator i = set.iterator();
				
				int data = set.size();
				int total = 50; 
				double current = StartUpLoader.getInstance().getProcent();
				double stepSize = total/data;
				
				
				while(i.hasNext()) {
					Map.Entry me = (Map.Entry)i.next(); 
					
					 String ColectionName = (String) me.getKey();
					 boolean LineWheelchairAccessible = false;
					 String TransportType = null;
					 String DestinationName50 = null;
					 String LinePublicNumber = null;
					 String DataOwnerCode = null;
					 String DestinationCode = null;
					 String LineName = null;
					 String LinePlanningNumber = null;
					 long LineDirection = 0;
					 
					JSONObject job = (JSONObject) me.getValue();
					Set set2 = job.entrySet();
					Iterator i2 = set2.iterator();
					while(i2.hasNext()) {
						Map.Entry me2 = (Map.Entry)i2.next();
						if(((String) me2.getKey()).equalsIgnoreCase("LineWheelchairAccessible")) {
							String temp = (String) me2.getValue();
							if(temp.equalsIgnoreCase("true")) {
								LineWheelchairAccessible = true;
							} else {
								LineWheelchairAccessible = false;
							}
						} 
						else if(((String) me2.getKey()).equalsIgnoreCase("TransportType")) {
							TransportType = (String) me2.getValue();
						} else if(((String) me2.getKey()).equalsIgnoreCase("DestinationName50")) {
							DestinationName50 = (String) me2.getValue();
						} else if(((String) me2.getKey()).equalsIgnoreCase("LinePublicNumber")) {
							LinePublicNumber = (String) me2.getValue();
						} else if(((String) me2.getKey()).equalsIgnoreCase("DataOwnerCode")) {
							DataOwnerCode = (String) me2.getValue();
						} else if(((String) me2.getKey()).equalsIgnoreCase("DestinationCode")) {
							DestinationCode = (String) me2.getValue();
						} else if(((String) me2.getKey()).equalsIgnoreCase("LineName")) {
							LineName = (String) me2.getValue();
						} else if(((String) me2.getKey()).equalsIgnoreCase("LinePlanningNumber")) {
							LinePlanningNumber = (String) me2.getValue();
						} else if(((String) me2.getKey()).equalsIgnoreCase("LineDirection")) {
							LineDirection = (Long) me2.getValue();
						} 
					}
					lines.add(new Line(ColectionName, LineWheelchairAccessible, TransportType, DestinationName50, LinePublicNumber, DataOwnerCode, DestinationCode, LineName, LinePlanningNumber, LineDirection));
					current += stepSize;
					StartUpLoader.getInstance().setProcent((int) current);
 				}
				
			} else {
				System.out.println("JOSNObject containt no values");
			}
		} catch(NullPointerException ne) {
			System.out.println("JOSNObject is null, maybe connection issue");
		}
		
	}
	
	public String[] getNameInArray() {
		System.out.println(lines.size());
		String[] array = new String[lines.size()];
		for(int i = 0;i<array.length;i++) {
			array[i] = (lines.get(i).getLinePublicNumber() + " " + lines.get(i).getDestinationName50());
		}
		return array;
	}
	
	
}
