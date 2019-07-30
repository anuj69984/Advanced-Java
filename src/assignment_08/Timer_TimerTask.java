package assignment_08;

/**
 * @author Anuj2.Kumar
 * 
 * Study Timer & Timer Task. Now create a task of scheduling the timer (for let’s say 2 seconds), and
 *  each time the timer fires, increments a counter value and prints the same.
 */


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Timer_TimerTask extends TimerTask {
	int counter=1;
    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        System.out.println("Counter = " + counter);
        counter++;
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
    }

    private void completeTask() {
        try {
            //assuming it takes 2 secs to complete the task
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String args[]){
        TimerTask timerTask = new Timer_TimerTask();
        
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        /*scheduleAtFixedRate(TimerTask task,Date firstTime,long period)
        task − This is the task to be scheduled.
		firstTime − This is the first time at which task is to be executed.
		period − This is the time in milliseconds between
		 successive task executions.
       */
        timer.scheduleAtFixedRate(timerTask, 0, 10*500);
        System.out.println("TimerTask started");
        
        //cancel after sometime
        try {
            Thread.sleep(32000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled");
    }

}
