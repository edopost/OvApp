package com.REST.actor;

public abstract class AbstractActor {

	private String id;
	private String depTime;
	private boolean depError;
	
	public AbstractActor(String id, String depTime, boolean depError) {
		this.id = id;
		this.depTime = depTime;
		this.depError = depError;
	}

	/**
	 * @return the depTime
	 */
	public String getDepTime() {
		return depTime;
	}

	/**
	 * @param depTime the depTime to set
	 */
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}

	/**
	 * @return the depError
	 */
	public boolean isDepError() {
		return depError;
	}

	/**
	 * @param depError the depError to set
	 */
	public void setDepError(boolean depError) {
		this.depError = depError;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
}
