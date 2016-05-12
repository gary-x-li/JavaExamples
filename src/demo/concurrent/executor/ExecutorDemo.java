package demo.concurrent.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		List<Future<String>> list = new ArrayList<>();
		for(int i=0; i< 10; i++){
			Callable<String> callable = new RandomNumberCallable(i);
            Future<String> future = pool.submit(callable);
            list.add(future);
        }
		
		System.out.println("Submission Done.");
		
        for(Future<String> fut : list){
            try {
                System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        
        pool.shutdown();
        
	}

}
