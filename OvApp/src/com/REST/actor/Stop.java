package com.REST.actor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.data.DetailedStopList;

/**
 * This class wil be needed to hold the bus stops
 * @author edopost
 * @version V1.0
 *
 */

public class Stop implements Comparable<Stop>{
	//stop code
	private String SpBern;
	//latitude
	private double Latitude;
	//stop name
	private String TimingPointName;
	//longitude
	private double Longitude;
	//stop town
	private String TimingPointTown;
	//detaild info
	private DetailedStopList details;
	//updateTime
	private Date lastUpdate;
	
	
	public Stop(String SpBern, double Latitude, String TimingPointName, double Longitude, String TimingPointTown) {
		this.SpBern = SpBern;
		this.Latitude = Latitude;
		this.TimingPointName = TimingPointName;
		this.Longitude = Longitude;
		this.TimingPointTown = TimingPointTown;
	}

	@SuppressWarnings("deprecation")
	public DetailedStopList getDetails() {
		Date timeNow = new Date();
		if(details == null || timeNow.getMinutes() < lastUpdate.getMinutes() || lastUpdate.getMinutes() == 0) {
			details = new DetailedStopList(SpBern);
			details.update();
			lastUpdate = new Date();
		} 
		return details;
	}
	
	
	/**
	 * @return the spBern
	 */
	public String getSpBern() {
		return SpBern;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return Latitude;
	}

	/**
	 * @return the timingPointName
	 */
	public String getTimingPointName() {
		return TimingPointName;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return Longitude;
	}

	/**
	 * @return the timingPointTown
	 */
	public String getTimingPointTown() {
		return TimingPointTown;
	}
	
	public int Compare(Object lhs, Object rhs)
	  {
	    Stop lhsStop = (Stop) lhs;
	    Stop rhsStop = (Stop) rhs;
	    return lhsStop.getTimingPointName().compareTo(rhsStop.getTimingPointName());
	  }

	@Override
	public int compareTo(Stop o) {
		return Compare(this, o);
	}
	
	
	
}
