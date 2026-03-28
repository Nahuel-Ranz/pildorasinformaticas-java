package secondpart.threads.waystocreate.implementingrunnable;

public class ImplementingRunnable implements Runnable {

	private int number;
	
	public ImplementingRunnable(int number) {
		this.number = number;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			IO.println("%s) Executing thread %s".formatted(i, this.number));
			
			try { Thread.sleep(600); }
			catch(InterruptedException e) {}
		}
	}
}