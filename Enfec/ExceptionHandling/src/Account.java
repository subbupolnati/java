import java.util.Scanner;
class InvalidAmountException extends RuntimeException{
	String msg;

	public InvalidAmountException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}
class LowBalanceException extends RuntimeException{
	String msg;

	public LowBalanceException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
}
public class Account {
	int deposit,withdraw;
	
	public Account(int deposit, int withdraw) {
		super();
		this.deposit = deposit;
		this.withdraw = withdraw;
	}
	public void depositAmount() {
		try {
			if(deposit<0) {
			throw new InvalidAmountException("amount is negative");
			}
			else
				System.out.println("amount suucessfully deposit");
			}
		catch(InvalidAmountException e) {
			System.out.println(e);
		}
	}
	public void withdrawAmount() {
		try {
			if(withdraw<500) {
			throw new LowBalanceException("amount is negative");
			}
			else
				System.out.println("amount suucessfully withdraw");
			}
		catch(LowBalanceException w) {
			System.out.println(w);
		}
	}
	public static void main(String[] args) {
	int deposit;
	int withdraw;
	Scanner sc=new Scanner(System.in);
	System.out.println("enter deposit amount");
	deposit=sc.nextInt();
	System.out.println("enter withdraw amount");
	withdraw=sc.nextInt();
	Account a=new Account(deposit,withdraw);
	a.depositAmount();
	a.withdrawAmount();
	}

}
