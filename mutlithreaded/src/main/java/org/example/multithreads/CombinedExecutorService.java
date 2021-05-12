package org.example.multithreads;

import java.util.concurrent.*;

public class CombinedExecutorService {

    ExecutorService executorService;

    ScheduledFuture scheduledFuture;

    ScheduledExecutorService scheduledExecutorService;

    CombinedExecutorService (){
        executorService = Executors.newFixedThreadPool(1);
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public void execute() throws ExecutionException, InterruptedException {
        executorService.execute(() -> {});
        scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(()-> {}, 1, 1,TimeUnit.DAYS);
        scheduledFuture.get();
    }

}
