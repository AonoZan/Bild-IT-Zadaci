
package group_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class SearchDatabase {
	// default login variables
	private static String user = null;
	private static String pass = null;
	private static String base = null;
	
	// process login
	public static void logIn(String userS, String passS, String baseS){
		user = userS;
		pass = passS;
		base = baseS;
	}
	/* Method builds search command for mysql console and executes command so that it can return input stream. */
	public static String search(String what, String from, String where) throws IOException {
		// build command for console
		String[] commands = 
			{ "mysql"
			, "--user="+user
			, "--password=\""+pass+"\""
			, base
			, "-e SELECT "+what+" FROM "+from+""
			+ new String(where.equals("null") ? "" : "WHERE "+where)
			+ ";"
		};
		// execute command and return output
		return runMySQLCommand(commands);
	}
	//http://stackoverflow.com/questions/5711084/java-runtime-getruntime-getting-output-from-executing-a-command-line-program
	/* Method builds Runnable process, executes command and returns output of input stream. */
	public static String runMySQLCommand(String[] command) throws IOException {
		// build process and execute command
		Runtime runCmd = Runtime.getRuntime();
		Process process = runCmd.exec(command);
		// construct input stream and buffer
		BufferedReader stdInput = new BufferedReader(new 
				InputStreamReader(process.getInputStream()));
		StringBuilder buffer = new StringBuilder();
		// read all lines from input stream in to buffer
		String line = null;
		while ((line = stdInput.readLine()) != null) {
			buffer.append(line + "\n");
		}
		
		return buffer.toString();
}
	/*
	 * Method asks for user login in to MySQL database and executes user search string.
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		// get name and password
		System.out.println("Enter your login name and password.");
		
		System.out.println("Enter name: ");
		String name = input.nextLine();
		
		System.out.println("Enter password: ");
		String pass = input.nextLine();
		// get default database name
		System.out.println("Enter default database name: ");
		String base = input.nextLine();
		// set up login (root pass world)
		logIn(name, pass, base);
		
		// get MySQL String for SELECT
		System.out.println("You want to select? ");
		String what = input.nextLine();
		// get String for FROM keyword
		System.out.println("You are searching from? ");
		String from = input.nextLine();
		// get WHERE keyword (null will result in no using that keyword)
		System.out.println("Any other modifiers?\n(WHERE keyword, null = dont-use) ");
		String where = input.nextLine();
		
		// search database and get output (* `world`.`city` CountrCode = 'BIH')
		String output = search(what, from, where);
		// print results
		System.out.println("Results from MySQL console:\n");
		System.out.println(output);
		
		input.close();
	}
}
