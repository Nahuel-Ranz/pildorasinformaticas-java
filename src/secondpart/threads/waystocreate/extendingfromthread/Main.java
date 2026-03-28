package secondpart.threads.waystocreate.extendingfromthread;

public class Main {
	public static void main(String[] args) {
		new ExtendingThread().start();
		new ExtendingThread().start();
	}
}