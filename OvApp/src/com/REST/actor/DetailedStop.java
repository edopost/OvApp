package com.REST.actor;

import java.util.Date;

public class DetailedStop {

	private String StopDetailed; //"QBUZZ_276959_g004_6017_0":{
	private boolean IsTimingStop; //"IsTimingStop":false,
	private String DestinationName50; //"DestinationName50":"Hoogkerk via Peizerweg",
	private long LineDirection; //"LineDirection":1,
	private String OperationDate; //"OperationDate":"2013-02-02",
	private String TimingPointCode; //"TimingPointCode":"10009031",
	private String LineName; //"LineName":"Hoogkerk - Oosterpark",
	private String LinePublicNumber; //"LinePublicNumber":"4",

	private String SideCode; //"SideCode":"V",

	private String TimingPointName;//	"TimingPointName":"Groningen, Centraal Station",

	private String TripStopStatus; //"TripStopStatus":"PLANNED",
	private String UserStopCode; //"UserStopCode":"10009031",
	private String JourneyStopType;//	"JourneyStopType":"INTERMEDIATE",
	private String TargetArrivalTime; //"TargetArrivalTime":"2013-02-02T11:19:00",
	private String TargetDepartureTime;//	"TargetDepartureTime":"2013-02-02T11:21:00",
	private String ExpectedArrivalTime;//	"ExpectedArrivalTime":"2013-02-02T11:19:00"},
	
	
	/**
	 * @param stopDetailed
	 * @param isTimingStop
	 * @param destinationName50
	 * @param lineDirection
	 * @param operationDate
	 * @param timingPointCode
	 * @param lineName
	 * @param linePublicNumber
	 * @param sideCode
	 * @param timingPointName
	 * @param tripStopStatus
	 * @param userStopCode
	 * @param journeyStopType
	 * @param targetArrivalTime
	 * @param targetDepartureTime
	 * @param expectedArrivalTime
	 */
	public DetailedStop(String stopDetailed, boolean isTimingStop, String destinationName50, long lineDirection, String operationDate, String timingPointCode, String lineName, String linePublicNumber,
			String sideCode, String timingPointName, String tripStopStatus, String userStopCode, String journeyStopType, String targetArrivalTime, String targetDepartureTime,
			String expectedArrivalTime) {
		StopDetailed = stopDetailed;
		IsTimingStop = isTimingStop;
		DestinationName50 = destinationName50;
		LineDirection = lineDirection;
		OperationDate = operationDate;
		TimingPointCode = timingPointCode;
		LineName = lineName;
		LinePublicNumber = linePublicNumber;
		SideCode = sideCode;
		TimingPointName = timingPointName;
		TripStopStatus = tripStopStatus;
		UserStopCode = userStopCode;
		JourneyStopType = journeyStopType;
		TargetArrivalTime = targetArrivalTime;
		TargetDepartureTime = targetDepartureTime;
		ExpectedArrivalTime = expectedArrivalTime;
	}


	/**
	 * @return the stopDetailed
	 */
	public String getStopDetailed() {
		return StopDetailed;
	}


	/**
	 * @return the isTimingStop
	 */
	public boolean isIsTimingStop() {
		return IsTimingStop;
	}


	/**
	 * @return the destinationName50
	 */
	public String getDestinationName50() {
		return DestinationName50;
	}


	/**
	 * @return the lineDirection
	 */
	public long getLineDirection() {
		return LineDirection;
	}


	/**
	 * @return the operationDate
	 */
	public String getOperationDate() {
		return OperationDate;
	}


	/**
	 * @return the timingPointCode
	 */
	public String getTimingPointCode() {
		return TimingPointCode;
	}


	/**
	 * @return the lineName
	 */
	public String getLineName() {
		return LineName;
	}


	/**
	 * @return the linePublicNumber
	 */
	public String getLinePublicNumber() {
		return LinePublicNumber;
	}


	/**
	 * @return the sideCode
	 */
	public String getSideCode() {
		return SideCode;
	}


	/**
	 * @return the timingPointName
	 */
	public String getTimingPointName() {
		return TimingPointName;
	}


	/**
	 * @return the tripStopStatus
	 */
	public String getTripStopStatus() {
		return TripStopStatus;
	}


	/**
	 * @return the userStopCode
	 */
	public String getUserStopCode() {
		return UserStopCode;
	}


	/**
	 * @return the journeyStopType
	 */
	public String getJourneyStopType() {
		return JourneyStopType;
	}


	/**
	 * @return the targetArrivalTime
	 */
	public String getTargetArrivalTime() {
		return TargetArrivalTime;
	}


	/**
	 * @return the targetDepartureTime
	 */
	public String getTargetDepartureTime() {
		return TargetDepartureTime;
	}


	/**
	 * @return the expectedArrivalTime
	 */
	public String getExpectedArrivalTime() {
		return ExpectedArrivalTime;
	}

//	"DataOwnerCode":"QBUZZ",
//	"FortifyOrderNumber":0,
//	"TransportType":"BUS",
//	"Longitude":6.5679762,§
//	"Latitude":53.2113389,
//	"JourneyNumber":6017,
//	"JourneyPatternCode":39999,
//	"LocalServiceLevelCode":276959,
//	"WheelChairAccessible":"ACCESSIBLE",
//	"LastUpdateTimeStamp":"2013-02-02T09:29:58",
//	"DestinationCode":"119",
//	"ExpectedDepartureTime":"2013-02-02T11:21:00",
//	"UserStopOrderNumber":16,
//	"ProductFormulaType":"18",
//	"LinePlanningNumber":"g004",
//	"StopAreaCode":"gngcs",
//	"TimingPointDataOwnerCode":"ALGEMEEN",
//	"TimingPointTown":"Groningen",
	
	
}
