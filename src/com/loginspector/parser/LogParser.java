/*
 * This file parses the input given to it in the form of a String to return it to 'LogEntry.java' as a LogEntry object.
 */

package com.loginspector.parser;

import com.loginspector.model.LogEntry;

public class LogParser {

	public LogEntry parse(String line) {
		
		try {
			String[] parts = line.split(" ", 4);
			
			if(parts.length < 4) {
				return null;
			}
			
			String timestamp = parts[0] + " " + parts[1];
			String level = parts[2];
			
			String remaining = parts[3];
			
			String[] moduleSplit = remaining.split(" ", 2);
			
			String module = moduleSplit[0];
			String message = moduleSplit.length > 1 ? moduleSplit[1] : "";
			
			return new LogEntry(timestamp, level, module, message);
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
