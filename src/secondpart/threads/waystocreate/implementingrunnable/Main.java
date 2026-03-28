package secondpart.threads.waystocreate.implementingrunnable;

public class Main {
	public static void main(String[] args) {
		new Thread(new ImplementingRunnable(4)).start();
		new Thread(new ImplementingRunnable(8)).start();
	}
}