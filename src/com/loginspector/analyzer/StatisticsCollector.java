/*
 * Collects aggregated statistics from parsed log entries.
 * Tracks frequency of log levels, modules, and error messages.
 * Used by LogAnalyzer to compute summary insights form log data. 
 */

package com.loginspector.analyzer;

import java.util.HashMap;
import java.util.Map;

public class StatisticsCollector {

	private Map<String, Integer> levelCount = new HashMap<>();
	private Map<String, Integer> moduleCount = new HashMap<>();
	private Map<String, Integer> errorMessages = new HashMap<>();
	
	public void incrementLevel(String level) {
		levelCount.put(level, levelCount.getOrDefault(level,  0) + 1);
	}
	
	public void incrementModule(String module) {
		moduleCount.put(module,  moduleCount.getOrDefault(module,  0) + 1);
	}
	
	public void incrementError(String message) {
		errorMessages.put(message,  errorMessages.getOrDefault(message,  0) + 1);
	}
	
	public Map<String, Integer> getLevelCount() {
		return levelCount;
	}
	
	public Map<String, Integer> getModuleCount() {
		return moduleCount;
	}
	
	public Map<String, Integer> getErrorMessages() {
		return errorMessages;
	}
	
}
