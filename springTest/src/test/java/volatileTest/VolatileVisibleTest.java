package volatileTest;

public class VolatileVisibleTest {

	public static void main(String[] args) throws Exception {
		PrimeGenerator gen = new PrimeGenerator();
		Thread thread1 = new Thread(gen);
		Thread thread2 = new Thread(gen);
		thread1.start();
		thread2.start();
		try {;
			Thread.sleep(3000);
		} finally {
			gen.cancel();
			System.out.println("main thread cancelled=true");
		}
	}

}

class PrimeGenerator implements Runnable {
	private volatile boolean cancelled;

	@Override
	public void run() {
		while (!cancelled) {
			System.out.println(Thread.currentThread().getId()+"Running...");
		}
	}

	public void cancel() {
		cancelled = true;
	}
}
