/**
 * 
 */
package com.ashokponkumar.icsreader;

import java.util.Calendar;

/**
 * @author ashokponkumar
 * 
 */
public class CalendarEntry {
	private Calendar startTime, EndTime;
	private String summary;

	/**
	 * @return the startTime
	 */
	public Calendar getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Calendar getEndTime() {
		return EndTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Calendar endTime) {
		EndTime = endTime;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary
	 *            the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

}
