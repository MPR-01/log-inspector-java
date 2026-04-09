/*
 * Represents a structured log record parsed from a raw log line.
 * Stores key components such as timestamp, log level, module, and message.
 * Created by LogParser after parsing a log line and later used by the analyzer layer to compute statistics and insights from the logs.
 */

package com.loginspector.model;

public class LogEntry {
	
	private String timestamp;
	private String level;
	private String module;
	private String message;
	
	public LogEntry(String timestamp, String level, String module, String message) {
		this.timestamp = timestamp;
		this.level = level;
		this.module = module;
		this.message = message;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public String getLevel() {
		return level;
	}
	
	public String getModule() {
		return module;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return timestamp + " " + level + " " + module + " " + message;
	}
	
}
