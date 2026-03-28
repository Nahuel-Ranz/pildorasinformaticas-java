package secondpart.threads.synchronizingthreads.relativetoanotherthread;

public class Main {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1(null, "Joaquín");
		Thread1 t2 = new Thread1(t1, "Nahue");
		
		t1.start();
		t2.start();
	}
}