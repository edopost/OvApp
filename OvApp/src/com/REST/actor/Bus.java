package com.REST.actor;

public class Bus extends AbstractActor{

	
	private String line;
	private String destination;
	private String platform;
	
	public Bus(String id, String depTime, boolean depError, String line, String destination, String platform) {
		super(id, depTime, depError);
		this.line = line;
		this.destination = destination;
		this.platform = platform;
	}

	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
	
}
