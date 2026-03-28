package secondpart.threads.synchronizingthreads.bank;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Runnable runnable = new ThreadToRun(bank);
		Thread r = new Thread(runnable);
		Thread r1 = new Thread(runnable);
		
		r.start();
		r1.start();
	}
}