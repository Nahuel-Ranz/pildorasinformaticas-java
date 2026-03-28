package secondpart.threads.waystocreate.extendingfromthread;

public class ExtendingThread extends Thread {
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			IO.println("%s) Executing %s".formatted(i, super.getName()));
			
			try { super.sleep(500); }
			catch(InterruptedException e) {}
		}
	}
}