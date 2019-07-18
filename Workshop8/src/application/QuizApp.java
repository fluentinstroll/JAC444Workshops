package application;

public class QuizApp {
	private int firstNum;
	private int secondNum;

	public QuizApp() {
		firstNum = 0;
		secondNum = 0;
	}

	public void generateNumbers() {
		firstNum = (int) Math.round(Math.random() * 10 + 1);
		secondNum = (int) Math.round(Math.random() * 10 + 1);
	}

	public int getFirstNum() {
		return firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public boolean checkAddition(int rec) {
		if (rec == firstNum + secondNum) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkSubtraction(int rec) {
		if (rec == firstNum - secondNum) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkMultiplication(int rec) {
		if (rec == firstNum * secondNum) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDivision(int rec) {
		double div = ((double) (firstNum / secondNum));
		if (rec == div) {
			return true;
		} else {
			return false;
		}
	}

	public void clear() {
		firstNum = 0;
		secondNum = 0;
	}
}
