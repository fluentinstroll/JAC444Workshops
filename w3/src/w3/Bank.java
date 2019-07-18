package w3;

public class Bank {
	double initialBalance;
	double totalBalance;
	Loan[] loans;
	int bankID;
	
	public Bank() {
		this.initialBalance = 0;
		this.bankID = 0;
	}
	
	public void setInitialBalance(double b) {
		this.initialBalance = b;

	}
	
	public void setBankID(int id) {
		this.bankID = id;
	}
	
	public void setLoans(Loan[] l, int num) {
		this.loans = new Loan[num];
		
		this.loans = l;
	}
	
	public void setTotalBalance() {
		this.totalBalance = initialBalance;
		for(int i = 0; i < this.loans.length; i++) {
			this.totalBalance = this.totalBalance + this.loans[i].getLoanBalance();
		}
	}
	
	public void deductLoans(int ID) {
		for (int x = 0; x < this.loans.length; x++) {
			if(ID == this.loans[x].owingID) {
				this.totalBalance -= this.loans[x].getLoanBalance();
			}
		}
	}
	
	public double getTotalBalance() {
		return totalBalance;
	}
}
