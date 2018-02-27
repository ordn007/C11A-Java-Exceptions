//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author orden
 *
 */
public class NegativeBalanceException extends Exception {
	private BigDecimal negativeBalance;
	//private Writer outputFile;
	//private String message;
	
	/**
	 *  Default Constructor
	 */
	public NegativeBalanceException() {
		super("Error: negative balance");
		//this.message = getMessage();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param negBalance Parameter for returned negative balance
	 * @throws IOException		Throws exception 
	 */
	public NegativeBalanceException(BigDecimal negBalance) throws IOException {
		super("Amount exceeds balance by" + NumberFormat.getCurrencyInstance().format(negBalance));
		this.negativeBalance = negBalance;
		
		FileWriter fw = new FileWriter("logfile.txt", true);	// this appended to the file if it already exists
		PrintWriter out = new PrintWriter(fw);
		out.println("Amount exceeds balance by " + NumberFormat.getCurrencyInstance().format(negBalance));
		out.close();
	}
	
	/**
	 * To string method to output remain balance.
	 */
	@Override
	public String toString() {
		try {
			return "Balance of -" + NumberFormat.getCurrencyInstance().format(negativeBalance) + "not allowed";
		}catch(IllegalArgumentException i) {
			return "\n" + "Illegeal Argument Is Not Allowed";
		}
	}
}
