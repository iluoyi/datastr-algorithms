package multithread;

import java.util.concurrent.*;

/**
 * Thread pool can be used to execute tasks efficiently.
 * Can manage the number (#) of tasks executing concurrently.
 * 
 * @author CSE User
 *
 */
public class ExecutorDemo {
	public static void main(String args[]) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		executor.execute(new PrintChar('a', 100));
		executor.execute(new PrintChar('b', 100));
		executor.execute(new PrintNum(100));
		
		executor.shutdown();
	}
}
