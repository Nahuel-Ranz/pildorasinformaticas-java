package secondpart.threads.synchronizingthreads;
import secondpart.threads.waystocreate.implementingrunnable.ImplementingRunnable;
import secondpart.threads.waystocreate.extendingfromthread.ExtendingThread;

public class Synchronizing {
	public static void main(String[] args) {
		Runnable r1 = new ImplementingRunnable(3);
		Runnable r2 = new ImplementingRunnable(7);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		ExtendingThread t3 = new ExtendingThread();
		ExtendingThread t4 = new ExtendingThread();
		
		try {
			t1.start();
			t1.join();
			
			t2.start();
			t2.join();
			
			t3.start();
			t3.join();
			
			t4.start();
			t4.join();
		} catch(InterruptedException e) {}
	}
}