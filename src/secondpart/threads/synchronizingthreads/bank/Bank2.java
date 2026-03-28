package secondpart.threads.synchronizingthreads.bank;
import firstpart.graphics.Utils;

public class Bank2 {
	private final double[] accounts;
	
	public Bank2() {
		this.accounts = new double[100];
		for(int i=0; i<accounts.length; i++) this.accounts[i] = 2000;
	}
	
	public synchronized void transfer(int origin, int target, double amount) throws InterruptedException {
		
		if(
			origin >= this.accounts.length ||
			origin < 0 ||
			target >= this.accounts.length ||
			target < 0 ||
			amount <= 0 ||
			amount > this.accounts[origin]
		) super.wait();
		
		this.accounts[origin] -= amount;
		
		try { Thread.sleep(Utils.randomBetween(200, 600)); }
		catch (InterruptedException e) { e.printStackTrace(); }
		
		this.accounts[target] += amount;
		
		System.out.printf(
			"%s -- $%.2f	from %d to %d	-- Total salaries: $%.2f\n",
			Thread.currentThread(),
			amount,
			origin,
			target,
			getTotalSalaries()
		);
		
		super.notifyAll();
	}
	
	public double getTotalSalaries() {
		double result=0;
		for(double account : this.accounts) result += account;
		
		return result;
	}
	
	public int getNumberOfAccounts() { return this.accounts.length; }
}