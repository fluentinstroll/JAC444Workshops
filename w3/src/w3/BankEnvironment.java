package w3;

import java.util.Scanner;

public class BankEnvironment {
	public static int bankNumber;
	public static double minAssets;
	public static Scanner input = new Scanner(System.in);
	public static Bank[] bankArray;
	public static int banksLoaned;
	public static Loan[] loanArray;
	public static boolean loop;

	public static void main(String[] args) {
		do {
			loop = false;
			System.out.print("Number of banks: ");
			if (input.hasNextInt()) {
				bankNumber = input.nextInt();
				if (bankNumber <= 0) {
					System.out.println("Please enter an integer larger than 0.");
					input.nextLine();
					loop = true;
				}
			}
			else {
				System.out.println("Please enter an integer relating to the number of banks.");
				input.nextLine();
				loop = true;
			}
			
		} while (loop);

		bankArray = new Bank[bankNumber];
		for (int b = 0; b < bankNumber; b++) {
			bankArray[b] = new Bank();
			bankArray[b].setBankID(b);
		}

		do {
			loop = false;
			System.out.print("Minimum asset limit: ");
			if (input.hasNextDouble())
				minAssets = input.nextDouble();
			else {
				System.out.println("Please enter a double integer indicating the asset limit for the banks.");
				input.nextLine();
				loop = true;
			}
		} while (loop);

		for (int i = 0; i < bankNumber; i++) {
			do {

				loop = false;
				System.out.print("Bank #" + i + " Balance: ");

				if (input.hasNextDouble()) {
					double tempBalance = input.nextDouble();
					bankArray[i].setInitialBalance(tempBalance);
				}

				else {
					System.out.println("Please enter a double integer indicating the balance for the bank.");
					input.nextLine();
					loop = true;
				}
			} while (loop);
			do {
				loop = false;
				System.out.print("Number of banks loaned: ");
				if (input.hasNextInt()) {
					int tempBanksLoaned = input.nextInt();
					if (tempBanksLoaned < bankArray.length) {
						banksLoaned = tempBanksLoaned;
					} else {
						System.out.println(
								"Please enter a number of banks loaned that does not include the current bank.");
						input.nextLine();
						loop = true;
					}
				} else {
					System.out
							.println("Please enter an integer indicating the number of banks loaned to by bank #" + i);
					input.nextLine();
					loop = true;
				}
			} while (loop);

			loanArray = new Loan[banksLoaned];
			for (int l = 0; l < loanArray.length; l++) {
				loanArray[l] = new Loan();
			}

			for (int x = 0; x < banksLoaned; x++) {
				do {
					loop = false;
					System.out.print("Bank ID: ");

					if (input.hasNextInt()) {
						int tempID = input.nextInt();
						if (tempID <= bankArray.length && tempID > 0) {
							loanArray[x].setLoanParticipants(i, tempID);
						} else {
							System.out.println("This bank does not exist, please enter a Bank ID between 0 and "
									+ (bankArray.length - 1));
							input.nextLine();
							loop = true;
						}
					} else {
						System.out.println("Please enter an integer indicating the Bank ID of the bank loaned to.");
						input.nextLine();
						loop = true;
					}

				} while (loop);

				do {
					loop = false;
					System.out.print("Amount: ");
					if (input.hasNextDouble()) {
						double tempBalance = input.nextDouble();
						loanArray[x].setLoanAmount(tempBalance);
					} else {
						System.out.println(
								"Please enter a double integer indicating the amount of money loaned to that bank.");
						input.nextLine();
						loop = true;
					}

				} while (loop);

			}

			bankArray[i].setLoans(loanArray, banksLoaned);
			bankArray[i].setTotalBalance();
		}
		// check all for safety
		for (int y = 0; y < bankNumber; y++) {
			// if a bank isn't safe, go back and deduct the loans from other banks
			if (bankArray.length > 1) {
				if (!isSafe(bankArray[y])) {
					for (int z = 0; z < bankNumber; z++) {
						bankArray[z].deductLoans(y);
					}
				}
			}
		}

		// display safety
		for (int a = 0; a < bankNumber; a++) {
			if (!isSafe(bankArray[a])) {
				System.out.println("Bank #" + bankArray[a].bankID + " is unsafe.");
			}
		}
	}

	public static boolean isSafe(Bank b) {
		if (b.getTotalBalance() < minAssets) {
			return false;
		} else {
			return true;
		}
	}

}
