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
