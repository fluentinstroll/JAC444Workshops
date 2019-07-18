package w3;

public class Loan {
	double loanBalance;
	int loanHolderID;
	int owingID;
	
	public Loan() {
		loanBalance = 0;
		loanHolderID = 0;
		owingID = 0;
	}
	
	public void setLoanAmount(double a) {
		loanBalance = a;
	}
	
	public void setLoanParticipants(int hID, int oID) {
		loanHolderID = hID;
		owingID = oID;
	}
	
	public double getLoanBalance() {
		return loanBalance;
	}
}
