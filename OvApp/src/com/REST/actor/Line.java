package com.REST.actor;

public class Line {

	
	private String ColectionName;
	private boolean LineWheelchairAccessible;
	private String TransportType;
	private String DestinationName50;
	private String LinePublicNumber;
	private String DataOwnerCode;
	private String DestinationCode;
	private String LineName;
	private String LinePlanningNumber;
	private long LineDirection;
	
	
	
	public Line(String colectionName, boolean lineWheelchairAccessible, String transportType, String destinationName50, String linePublicNumber, String dataOwnerCode, String destinationCode,
			String lineName, String linePlanningNumber, long lineDirection) {
		ColectionName = colectionName;
		LineWheelchairAccessible = lineWheelchairAccessible;
		TransportType = transportType;
		DestinationName50 = destinationName50;
		LinePublicNumber = linePublicNumber;
		DataOwnerCode = dataOwnerCode;
		DestinationCode = destinationCode;
		LineName = lineName;
		LinePlanningNumber = linePlanningNumber;
		LineDirection = lineDirection;
	}



	/**
	 * @return the colectionName
	 */
	public String getColectionName() {
		return ColectionName;
	}



	/**
	 * @return the lineWheelchairAccessible
	 */
	public boolean isLineWheelchairAccessible() {
		return LineWheelchairAccessible;
	}



	/**
	 * @return the transportType
	 */
	public String getTransportType() {
		return TransportType;
	}



	/**
	 * @return the destinationName50
	 */
	public String getDestinationName50() {
		return DestinationName50;
	}



	/**
	 * @return the linePublicNumber
	 */
	public String getLinePublicNumber() {
		return LinePublicNumber;
	}



	/**
	 * @return the dataOwnerCode
	 */
	public String getDataOwnerCode() {
		return DataOwnerCode;
	}



	/**
	 * @return the destinationCode
	 */
	public String getDestinationCode() {
		return DestinationCode;
	}



	/**
	 * @return the lineName
	 */
	public String getLineName() {
		return LineName;
	}



	/**
	 * @return the linePlanningNumber
	 */
	public String getLinePlanningNumber() {
		return LinePlanningNumber;
	}



	/**
	 * @return the lineDirection
	 */
	public long getLineDirection() {
		return LineDirection;
	}



	
}
