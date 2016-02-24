package demo.concurrent.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;

public class Processor {
	
	private RateLimiter rateLimiter = RateLimiter.create(1000);
	
	public void process(String request) {
		if (rateLimiter.tryAcquire()) {
			System.out.println(request + " processed");
		} else {
			System.out.println(request + " discarded");
		}
	}
}
