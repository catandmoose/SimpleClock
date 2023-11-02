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
			
			durationSeconds = durationSeconds -1;
			
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
		int durationSeconds = 0, durationSeconds1 = 0, durationMinutes = 0, durationMinutes1 = 0, durationHours = 0, durationHours1 = 0;
		
		while (true) {
			
			System.out.print(durationHours);
			System.out.println(durationHours1 + ":" + durationMinutes + durationMinutes1 + ":" + durationSeconds + durationSeconds1);
			Thread.sleep(1000);
			clearScreen();
			
			durationSeconds1 = durationSeconds1 +1;
			
			if (durationSeconds1 == 10) {
				
				durationSeconds1 = 0;
				durationSeconds = durationSeconds + 1;
			}
			
			if (durationSeconds == 6) {
				
				durationMinutes1 = durationMinutes1 + 1;
				durationSeconds = 0;
				durationSeconds1 = 0;
			}
			
			if (durationMinutes1 == 10) {
				
				durationMinutes1 = 0;
				durationMinutes = durationMinutes + 1;
			}
			
			if (durationMinutes == 6) {
				
				durationMinutes = 0;
				durationMinutes1 = 0;
				durationHours1 = durationHours1 + 1;
				
			}
			
			if (durationHours1 == 10) {
				
				durationHours1 = 0;
				durationHours = durationHours + 1;
			}
		}
		
		
	}
}