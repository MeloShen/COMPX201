import java.io.File;
import java.util.Scanner;

class XProcess{
  private BankBST Data;
  
	public static void main(String [] args){
    XProcess Bank = new XProcess();
    Bank.Data = new BankBST();
    //make sure input the file
		if(args.length != 1){
			System.err.println("Usage:  java TestRead <filename>");
			return;
		}
		try{
      //start to scanner the file
			Scanner file = new Scanner(new File(args[0]));
			String[] strings;
			int account;
			String transaction;
			double balance;
      //to the end
			while(file.hasNextLine()){
        //split the line buy space to array
				strings = file.nextLine().split(" ");
        //to check it is enable
        if(Bank.check(strings) == true ){
          //get the value to each valuable
				  account = Integer.parseInt(strings[0]);
          transaction = strings[1];
				  balance = Double.parseDouble(strings[2]);
          //start to dispose
				  Bank.dispose(account,transaction,balance);
        }
			}
      //print the whole tree
		  System.out.println("RESULT");
			Bank.Data.traverse();
		}
    //print the error message
		catch(Exception e){
      e.printStackTrace();
		}
	}
  //method to do the opeartion for each value
  public void dispose(int account,String transaction,double balance){
		Account findresult;
    //creat the new account
    Account newAccount = new Account(account,balance);
    //insert the new account
    Data.insert(newAccount);
    //judege the transaction and do different operation
    findresult = Data.find(account);
    //deposit 
    if(transaction.equals("d")){
      findresult.setBalance(findresult.getBalance() + balance);
      System.out.print("DEPOSIT");
    }
    //withdraw
    else if(transaction.equals("w")){
      findresult.setBalance(findresult.getBalance() - balance);
      System.out.print("WITHDRAW");
    }
    //remove
    else if(transaction.equals("c")){
	    Data.remove(account);
      System.out.print("CLOSE");
    }
		System.out.println();
  } 
  
  public boolean check(String[] strings){
    int account;
    String transaction;
    double balance;
    if(strings.length != 3) return false;
    try{
     account = Integer.parseInt(strings[0]);
    }
    catch(Exception e){
      return false;
    }
    try{
     balance = Double.parseDouble(strings[2]);
    }
    catch(Exception e){
      return false;
    }
    if(strings[1].equals("w") || strings[1].equals("d") || strings[1].equals("c")) return true;
    return false;
  }
}
