package fit.se.edu.main;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * Main class
 * 
 * @author Admin
 *
 */
public class Main {

	public static void main(String[] args) {
		try {
			InetAddress myIP = InetAddress.getLocalHost();
			System.out.println("------------------------------");
			System.out.println("My IP address is:");
			System.out.println(myIP.getHostAddress());
			System.out.println("------------------------------");
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}finally {
			System.exit(0);
		}
		
	}

}
