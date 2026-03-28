package secondpart.threads.synchronizingthreads.bank;
import firstpart.graphics.Utils;

public class ThreadToRun implements Runnable {
	private Bank bank;
	
	public ThreadToRun(Bank bank) {
		this.bank = bank;
	}
	
	@Override
	public void run() {
		while(true) {
			int origin = (int)(Math.random()*this.bank.getNumberOfAccounts());
			int target = (int)(Math.random()*this.bank.getNumberOfAccounts());
			double amount = Utils.round(Math.random()*3000, 2);
			
			this.bank.transfer(origin, target, amount);
		}
	}
}