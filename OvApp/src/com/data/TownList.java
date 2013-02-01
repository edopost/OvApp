package com.data;

import java.util.ArrayList;
import java.util.Collections;

import com.REST.actor.Stop;

/**
 * This list will hold a lsit of all availible towns
 * @author edopost
 * @version V1.0
 *
 */

public class TownList {

	private ArrayList<String> townList;
	
	public TownList(StopList stop) {
		townList = new ArrayList<String>();
		ArrayList<Stop> stopList = stop.getStopList();
		for(int i = 0;i<stopList.size();i++) {
			if(!townList.contains(stopList.get(i).getTimingPointTown())) {
				townList.add(stopList.get(i).getTimingPointTown());
			}
		}
		Collections.sort(townList);
	}
	
	public ArrayList<String> getTownList() {
		return townList;
	}
	
	public String[] toArray() {
		String[] array = new String[townList.size()];
		for(int i = 0;i<array.length;i++) {
			array[i] = townList.get(i);
		}
		return array;
	}
}
