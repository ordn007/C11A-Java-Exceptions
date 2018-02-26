//import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author orden
 *
 */
public class ATM {
	private BankAccount account;
	//private double balance;
	
	/**
	 * Default constructor
	 */
	public ATM() {
		super();
		// TODO Auto-generated constructor stub
		account = new BankAccount(500.75);
	}
	
	/**
	 * Function that handles all the transactions
	 * @throws IOException	Throws exception when balance is negative.
	 */
	public void handTransactions() throws IOException{
		try {
			account.withdraw(600.1);
		}catch (NegativeBalanceException e){
			System.out.println(e);
			System.out.println(e.getMessage());
		}
		
		try {
			account.quickWithdraw(600.5);
		}catch (NegativeBalanceException e){
			System.out.println(e);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param args		Does nothing
	 * @throws IOException	throws Exception throwing 
	 */
	public static void main(String[] args) throws IOException {
		ATM myATM = new ATM();
		myATM.handTransactions();
	}

	

}
