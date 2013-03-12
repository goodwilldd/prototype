package kr.pe.goodwilldd;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MakingImageTaskManager {
	private static volatile MakingImageTaskManager instance;
	
	private MakingImageTaskManager() {
		executorService = Executors.newCachedThreadPool();
		completionService = new ExecutorCompletionService<Integer>(
				executorService);
	}
	
	public static MakingImageTaskManager getInstance() {
		if ( instance != null ) {
			return instance;
		} else {
			synchronized(MakingImageTaskManager.class) {
				instance = new MakingImageTaskManager();
			}
			return instance;
		}
	}
	
	ExecutorService executorService;
	CompletionService<Integer> completionService;
	
	public void addTask(Callable<Integer> task) {
		completionService.submit(task);
	}
	
	@Override
	protected void finalize() throws Throwable {
		executorService.shutdown();
		super.finalize();
	}
}
