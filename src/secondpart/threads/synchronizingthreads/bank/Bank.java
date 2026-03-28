package secondpart.threads.synchronizingthreads.bank;
import firstpart.graphics.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

	private final double[] accounts;
	private Lock lock;
	private Condition sufficientBalance;
	
	public Bank() {
		this.accounts = new double[100];
		for(int i=0; i<accounts.length; i++) this.accounts[i] = 2000;
		
		this.lock = new ReentrantLock();
		this.sufficientBalance = lock.newCondition();
	}
	
	public void transfer(int origin, int target, double amount) throws InterruptedException {
		this.lock.lock();
		try {
			
			if(
				origin >= this.accounts.length ||
				origin < 0 ||
				target >= this.accounts.length ||
				target < 0 ||
				amount <= 0 ||
				amount > this.accounts[origin]
			) this.sufficientBalance.await();
			
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
			
			sufficientBalance.signalAll();
		} finally { this.lock.unlock(); }
		
	}
	
	public double getTotalSalaries() {
		double result=0;
		for(double account : this.accounts) result += account;
		
		return result;
	}
	
	public int getNumberOfAccounts() { return this.accounts.length; }
}