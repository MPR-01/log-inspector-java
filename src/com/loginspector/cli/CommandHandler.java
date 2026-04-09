/*
 *  Handles command-line interaction for the LogInspector application.
 * Parses user arguments, triggers log analysis, and coordinates the
 * execution flow between CLI input and the analysis engine.
 */

package com.loginspector.cli;

import java.io.IOException;
import java.util.List;

import com.loginspector.analyzer.LogAnalyzer;
import com.loginspector.utils.FileUtils;

public class CommandHandler {

	public void execute(String args[]) {
		if (args.length < 2) {
			printUsage();
			return;
		}
		
		String command = args[0];
		String filePath = args[1];
		
		if ("analyze".equalsIgnoreCase(command)) {
			
			try {
				List<String> logLines = FileUtils.readLogFile(filePath);
				
				LogAnalyzer analyzer = new LogAnalyzer();
				analyzer.analyze(logLines);
				analyzer.printReport();
			} catch (IOException e) {
				System.out.println("Error reading the log file: " + e.getMessage());
			}
			
		} else {
			printUsage();
		}
		
	}
	
	private void printUsage() {
		System.out.println("Usage:");
		System.out.println("java LogInspector analyze <log_file_path>");
	}
	
}
