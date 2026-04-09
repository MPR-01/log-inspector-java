/*
 * Core analysis engine of the LogInspector system.
 * Coordinates file reading, log parsing, and statistics aggregation.
 * Processes raw log lines and generates summarized insights from them.
 */

package com.loginspector.analyzer;

import java.util.List;

import com.loginspector.model.LogEntry;
import com.loginspector.parser.LogParser;

public class LogAnalyzer {
	
	private StatisticsCollector statsCollector;
	private LogParser parser;
	
	public LogAnalyzer() {
		this.statsCollector = new StatisticsCollector();
		this.parser = new LogParser();
	}
	
	public void analyze(List<String> logLines) {
		for (String line : logLines) {
			LogEntry entry = parser.parse(line);
			
			if (entry == null) {
				continue;
			}
			
			statsCollector.incrementLevel(entry.getLevel());
			statsCollector.incrementModule(entry.getModule());
			
			if ("ERROR".equals(entry.getLevel())) {
				statsCollector.incrementError(entry.getMessage());
			}
		}
	}
	
	public void printReport() {
		System.out.println("\n=====  Log Analysis Report  =====\n");
		
		System.out.println("Log Level Counts:");
		statsCollector.getLevelCount().forEach((k,v) -> System.out.println(k + " : " + v));
		
		System.out.println("\nModule Activity:");
		statsCollector.getModuleCount().forEach((k,v) -> System.out.println(k + " : " + v));
		
		System.out.println("\nFrequent Errors:");
		statsCollector.getErrorMessages().forEach((k,v) -> System.out.println(k + " : " + v));
	}
	
}