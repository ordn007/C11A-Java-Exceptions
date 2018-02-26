//import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author orden
 *
 */
public class BankAccount {
	private double balance;
	
	/**
	 * 
	 * @param balance 	Set Balance of the account
	 */
	public BankAccount(double balance) {
		this.balance = balance;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *  Method for simple withdrawal; output balance left after transaction
	 * @param withdrawAmount	Method to handles withdrawal from the account
	 * @throws NegativeBalanceException		This is a custom exception 
	 * @throws IOException			Throws an Exception 
	 */
	public void withdraw(double withdrawAmount) throws NegativeBalanceException, IOException {
		BigDecimal bal, wit;
		bal = new BigDecimal(balance);
		wit = new BigDecimal(withdrawAmount);
		//NumberFormat nf = NumberFormat.getNumberInstance();
		
		if(wit.intValue() > bal.intValue()) {
		
			throw new NegativeBalanceException(bal.subtract(wit));
		}else if(wit.intValue() < bal.intValue()) {
			//nf.format(bal = bal.subtract(wit));
			balance -= withdrawAmount;
			//nf.format(balance -= withdrawAmount);
		}
	}
	
	/**
	 * 	Method for a quick Withdrawal, does NOT give remaining balance
	 * @param withdrawAmount	Method to handles withdrawal from the account
	 * @throws NegativeBalanceException		this is a custom exceotion
	 */
	public void quickWithdraw(double withdrawAmount) throws NegativeBalanceException {
		BigDecimal bal, wit;
		bal = new BigDecimal(balance);
		wit = new BigDecimal(withdrawAmount);
		//NumberFormat nf = NumberFormat.getNumberInstance();
		
		if(wit.intValue() > bal.intValue()) {
			throw new NegativeBalanceException();
		}else if(wit.intValue() < bal.intValue()) {
			//nf.format(bal = bal.subtract(wit));
			balance -= withdrawAmount;
		}
	}
}
