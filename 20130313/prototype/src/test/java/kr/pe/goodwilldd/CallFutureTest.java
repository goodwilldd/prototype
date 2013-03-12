package kr.pe.goodwilldd;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallFutureTest {

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		System.out
				.println("-------------- Callable, Future Demo --------------");
		runFutureGet();
		System.out
				.println("-------------- Comletion Service Demo --------------");
		runCompletionService();
		System.exit(0);
	}

	public static void runCompletionService() throws InterruptedException,
			ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
				executorService);

		completionService.submit(new WorkThread(1));
		completionService.submit(new WorkThread(2));
		completionService.submit(new WorkThread(100));
		completionService.submit(new WorkThread(4));
		completionService.submit(new WorkThread(5));
		completionService.submit(new WorkThread(6));

		int nCnt = 0;
		while (nCnt < 6) {
			// Blocking until job ends.
			Future<Integer> colmpletedJob = completionService.take();
			// Non-Blocking
			System.out
					.printf("1에서 20000까지의 총 합은 %d입니다.%n", colmpletedJob.get());
			nCnt++;
		}
		executorService.shutdown();
	}

	public static void runFutureGet() throws InterruptedException,
			ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		Future<Integer> f1 = executorService.submit(new WorkThread(1));
		Future<Integer> f2 = executorService.submit(new WorkThread());
		Future<Integer> f3 = executorService.submit(new WorkThread(100));
		Future<Integer> f4 = executorService.submit(new WorkThread());
		Future<Integer> f5 = executorService.submit(new WorkThread());
		Future<Integer> f6 = executorService.submit(new WorkThread());
		System.out.printf("[%s] 1에서 20000까지의 총 합은 %d입니다.%n", "f1", f1.get());
		System.out.printf("[%s] 1에서 20000까지의 총 합은 %d입니다.%n", "f2", f2.get());
		System.out.printf("[%s] 1에서 20000까지의 총 합은 %d입니다.%n", "f3", f3.get());
		System.out.printf("[%s] 1에서 20000까지의 총 합은 %d입니다.%n", "f4", f4.get());
		System.out.printf("[%s] 1에서 20000까지의 총 합은 %d입니다.%n", "f5", f5.get());
		System.out.printf("[%s] 1에서 20000까지의 총 합은 %d입니다.%n", "f6", f6.get());
		executorService.shutdown();
	}

	protected static class WorkThread implements Callable<Integer> {

		private int total;

		public WorkThread() {

		}

		public WorkThread(int i) {
			this.total += i;
		}

		public Integer call() throws Exception {
			for (int i = 1; i <= 20000; i++) {
				total += i;
			}

			return total;
		}

	}
}
