import java.io.IOException;
import java.util.*;

class Main {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		System.out.print("Enter what you want to do (Timer, stopwatch): ");
		String option = sc.nextLine().toLowerCase();
		
		switch (option) {
		default:
			System.out.println("Invalid option.");
			break;
		case "timer":
			timer();
			break;
		case "stopwatch":
			stopwatch();
			break;
		}
	}
	
	public static void clearScreen() throws InterruptedException, IOException {
		try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
	
	static void timer() throws InterruptedException, IOException {
		System.out.println("Enter timer duration; ");
		System.out.print("Hours: ");
		int durationHours = sc.nextInt();
		System.out.print("Minutes: ");
		int durationMinutes = sc.nextInt();
		System.out.print("Seconds: ");
		int durationSeconds = sc.nextInt();
		
		while (true) {
			
			System.out.println(durationHours + ":" + durationMinutes + ":" + durationSeconds);
			Thread.sleep(1000);
			clearScreen();
			
			//if (durationSeconds == 0 && durationMinutes == 0 && durationHours == 0) {
			//	System.out.println("Timer finished!");
			//	break;
			//}
			
			durationSeconds = durationSeconds -1;
			
			//if (durationSeconds == 0) {
				//if (durationMinutes != 0) {
					//durationMinutes = durationMinutes - 1;
				//}
				//durationSeconds = 59;
			//}
			if (durationSeconds == 0 && durationMinutes == 0) {
				durationHours = durationHours - 1;
				durationMinutes = 59;
				durationSeconds = 59;
			}
			
			if (durationSeconds == 0 && durationMinutes >= 0) {
				durationSeconds = 59;
				if (durationMinutes != 0) {
					durationMinutes = durationMinutes -1;
				}
		}
	}
}
		
	static void stopwatch() throws InterruptedException, IOException {
		int durationSeconds = 0, durationMinutes = 0, durationHours = 0;
		while (true) {
			System.out.println(durationHours + ":" + durationMinutes + ":" + durationSeconds);
			Thread.sleep(1000);
			clearScreen();
			
			durationSeconds = durationSeconds + 1;
			
			if (durationSeconds == 60) {
				durationSeconds = 0;
				durationMinutes = durationMinutes + 1;
			}
			
			if (durationMinutes == 60) {
				durationMinutes = 0;
				durationHours = durationHours + 1;
			}
		}
	}
}