package demo.concurrent.executor;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumberCallable implements Callable<String> {
	
	private int id;
	
	public RandomNumberCallable(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		System.out.println(String.format("Callable ID %s in %s started.", id, Thread.currentThread().getName()));
		Thread.sleep(1000);
		Random random = new Random();
		int number = random.nextInt(100);
		return String.format("Callable ID %s returned %s", id, number);
	}

}
