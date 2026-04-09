/*
 * This is the main application class
 */

package com.loginspector;

import com.loginspector.cli.CommandHandler;

public class LogInspectorApp {

	public static void main(String args[]) {
		
		CommandHandler handler = new CommandHandler();
		handler.execute(args);
		
	}
	
}