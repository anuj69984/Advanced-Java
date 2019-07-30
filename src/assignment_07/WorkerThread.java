package assignment_07;

/*Author: Anuj Kumar
 * 
 * Create a thread pool (of say 3 threads) using thread pool executor service provided by java. Now create a task
 *  which this thread pool will execute. Implement this situation so that each thread in thread pool will be used
 *   by executor service – possibly by applying some loop of task
 * 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Date;


/*
 * Java thread pool manages the pool of worker threads, it contains
 *  a queue that keeps tasks waiting to get executed. We can can use
 ThreadPoolExecutor to create thread pool in Java.
 */
public class WorkerThread implements Runnable {
  
    private String command;
    
    public WorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
    	//System.out.println(new Date());
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command + " " + new Date());
        processCommand();
      //  System.out.println(new Date());
        System.out.println(Thread.currentThread().getName()+" End." + " " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}
/*
 * In this program, we are creating a fixed size thread pool of 5 worker
 *  threads. Then we are submitting 10 jobs to this pool, since the pool
 *   size is 3, it will start working on 3 jobs and other jobs will be
 *    in wait state, as soon as one of the job is finished, another job
 *     from the wait queue will be picked up by worker thread and get�s
 *      executed.
 */

class SimpleThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}

