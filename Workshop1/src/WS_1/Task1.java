package WS_1;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Task1 {
	static Scanner input = new Scanner(System.in);
	static long creditCard = 0;
	static long[] cardArray;
	static long[] tempCardArray;
	static int oddPlace = 0;
	static int evenPlace = 0;
	static int oddEvenSum = 0;
	static boolean valid = false;
	
	public static void main(String[] args) {
		/*
		 * accept input of credit card number as a long
		 * call isValid(input) to determine validity (ie: if (isValid(input)))
		 * 
		 * 
		 * step 1+2: send input to sumOfDoubleEvenPlace(input)
		 * step 3: send input to sumOfOddPlace(input)  
		 * step 4: Add together the return values of steps 1+2 and 3
		 * step 5: divide by 10, if there is no remainder, it is valid
		 */
		do {
			try {
				System.out.print("Please enter a credit card number as a long integer between 13 and 16: ");
		
				creditCard = input.nextLong();
				System.out.println("Checking if number is valid...");
			} catch (InputMismatchException e) {
				System.out.println("You have not entered a long integer, please try again.");
				input.nextLine();
			}
			valid = isValid(creditCard);
			if (!valid)
				System.out.println( "Your card is invalid.");
		} while(!valid);
		
		//step 1+2
		evenPlace = sumOfDoubleEvenPlace(creditCard);
		
		//step 3
		oddPlace = sumOfOddPlace(creditCard);
		
		//step 4
		oddEvenSum = evenPlace + oddPlace;
		
		//step 5
		if (oddEvenSum % 10 == 0)
			System.out.println( "Your card, " + creditCard + ", is valid!");
		else
			System.out.println( "Your card is invalid. Try again!");
				
	}
	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		long workingLong = number;
		// check size of the long first
		if(getSize(workingLong) < 16 || getSize(workingLong) > 13 ) {
			// next, check the prefix for validity (4 for Visa cards 5 for Master cards 37 for American Express cards 6 for Discover cards)
			if (prefixMatched(workingLong, 4))
				return true;
			else if (prefixMatched(workingLong, 5))
				return true;
			else if (prefixMatched(workingLong, 37))
				return true;
			else if (prefixMatched(workingLong, 6))
				return true;
			else
				return false;
		}else {
			System.out.println("The number is not between 16 and 13 characters.");
			return false;
		}
		
	}
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		/*
		 * for loop to separate each digit in the number into an array
		 * double each second digit and send to getDigit(input)
		 * each value of getDigit(input) is added together
		 * return that value
		 */
		long sum = 0;
		long tempNumber = number;
		int numberLength = getSize(number);
		cardArray = new long[numberLength];
		
		for (int i = 0; i < numberLength; i++) {
			cardArray[i] = tempNumber % 10;
			tempNumber /= 10;
		}
		
		for (int i = 0; i < numberLength; i++) {
			if ((double)i % 2 != 0) {
				sum = sum + (getDigit((int)cardArray[i]*2));
			}
		}
		
		return (int)sum;
	}
	
	public static int getDigit(int number) {
		/** Return this number if it is a single digit, otherwise,
		* return the sum of the two digits */
		int[] digitArray = {0,0};
		if (getSize(number) == 1)
			return number;
		else {
			digitArray[0] = number % 10;
			number /= 10;
			digitArray[1] = number % 10;
			return digitArray[0] + digitArray[1];
		}
	}
	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number) {
		/*for loop to separate each digit in the number into an array
		 * return sum of those odd numbered digits
		 */
		
		long sum = 0;
		long tempNumber = number;
		int numberLength = getSize(number);
		cardArray = new long[numberLength];
		
		for (int i = 0; i < numberLength; i++) {
			cardArray[i] = tempNumber % 10;
			tempNumber /= 10;
			
			if (i % 2 == 0)
				sum = sum + cardArray[i];
		}
		return (int)sum;
	}
	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		// check if any of these are the first numbers of the long number entered using getPrefix(input, 1 or 2)
		if (getPrefix(number, 1) == (long)d)
			return true;
		else if (getPrefix(number, 2) == (long)d)
			return true;
		else
			return false;
	}
	
	public static int getSize(long d) {
		/** Return the number of digits in d */
		int numberLength = String.valueOf(d).length();
		return numberLength;
	}
	
	public static long getPrefix(long number, int k) {
		/** Return the first k number of digits from number. If the
		* number of digits in number is less than k, return number. */
		long tempNumber = number;
		int numberLength = getSize(number);
		
		if (numberLength > k) {
			for (int i = numberLength; i > 0; i--) {
				
				tempNumber /= 10;
				
				if (i == k)
					return tempNumber;
			}
		} 
		
		return tempNumber;
	}
}
