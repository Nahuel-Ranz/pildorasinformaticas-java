package secondpart.threads.synchronizingthreads.relativetoanotherthread;

public class Thread1 extends Thread {
	
	private Thread thread;
	private String name;
	
	public Thread1(Thread thread, String name) {
		this.thread = thread;
		this.name = name;
	}
	
	@Override
	public void run() {
		try {
			if(this.thread != null) this.thread.join();
			else IO.println("Empty another thread");
		} catch(InterruptedException e) {}
		
		IO.println("This thread is called %s".formatted(name));
	}
}