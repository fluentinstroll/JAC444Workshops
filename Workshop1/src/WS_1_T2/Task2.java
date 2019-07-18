package WS_1_T2;

public class Task2 {
	static int[] Lockers;
	
	
	public static void main(String[] args) {
		
		System.out.println("Sending 100 students through to open and close 100 lockers...");
		
		Lockers = getOpenLockers(100, 100);
		displayOpenLockers(Lockers);
	}
	
	public static int[] getOpenLockers(int students, int lockers) {
		int[] tempLockers = new int[lockers+1];
		// a nested for loop to cycle through each student and have them open/close the lockers
		
		/**decided to make 0 equal "open" since arrays are initialized as 0 and skip the first student 
		 * since they will open every single locker
		 * ********************************************************************************************/
		for (int currentStudent = 2; currentStudent < students; currentStudent++) {
			for(int currentLocker = 1; currentLocker < lockers; currentLocker++) {
				/** might be able to cut down on time by, instead of going through every locker, just adding the student number
				 * to itself over an over until it's over 100 then quitting the loop when it goes over
				*/
				if (currentLocker % currentStudent == 0) {
					if (tempLockers[currentLocker] == 0)
						tempLockers[currentLocker] = 1;
					else
						tempLockers[currentLocker] = 0;
				}
			}
		}
	return tempLockers;
	}
	
	
	public static void displayOpenLockers(int[] allLockers) {
		System.out.print("Lockers open: ");
		//loop through the lockers and display which ones are set to 0
		for (int i = 1; i < allLockers.length; i++) {
			if (allLockers[i] == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
