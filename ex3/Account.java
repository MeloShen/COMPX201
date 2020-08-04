class Account{
	//hold the account number
	private int key;
	//hold the account balance
	private double balance;
	//the constructor that takes an account number and an opening balance as arguments
	public Account(int key,double balance){
		this.key = key;
		this.balance = balance;
	}
	/* public methods to "getKey()" and "getBalance()" to gain access to these values. And "setBalance()" public method to update the balance based upon the type and value of a transaction*/
	public int getkey(){
		return this.key;
	}
	public double getBalance(){
		return this.balance;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}

}
