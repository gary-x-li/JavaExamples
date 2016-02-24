package demo.concurrent.rateLimiter;

public class RateLimiterDemo {

	public static void main(String[] args) {
		Processor p = new Processor();
		for (int i = 0; i < 5; i++) {
			p.process("Request " + i);
		}

	}

}
