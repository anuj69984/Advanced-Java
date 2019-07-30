package assignment_03;

/*
 * @Author- Anuj Kumar
 * 
 * Create a singleton class - which has no methods synchronized. Now create a thread pool, a worker thread to be submitted to
 *  the pool for execution. The singleton shall have an integer counter which is incremented by each thread and then a getter
 *   is called to display the value. The code to increment the counter has to be encapsulated by write locks and the getter has
 *    to have read locks. Refer to javadoc.
 */

import java.util.*;

public class ASingleton {

	public static void main(String[] args) {
		/*even if we create two or more than two object,
		we are getting the same object every time. */
//		singleton obj1=singleton.getInstance();
//		singleton obj2=singleton.getInstance();
		
		Thread t1=new Thread(new Runnable() {

			@Override
			public void run() {
				singleton obj=singleton.getInstance();				
			}
			
		});
		
		Thread t2=new Thread(new Runnable() {

			@Override
			public void run() {
				singleton obj=singleton.getInstance();			}
			
		});
		t1.start();
		
/*		try {
			Thread.sleep(10); // one way to solve the problem of calling
							//twice as one object would have already created
							//so second one after 10ms will not be created
							 // we can also use double checked locking
		} catch (InterruptedException e) {
			e.printStackTrace();
		} */
		
		t2.start();
	}

}


// creating a singleton class
//we can create only one instance of Singleton class at a time
class singleton {
	/*static singleton obj=new singleton();-->eager instantiation
					wasting memory by declaring here
	*/
	
	static singleton obj;
	private singleton(){
		System.out.println("Instance created..");
		
	}
	/*
	 * public static synchronized singleton getInstance(). if we add 
	 * synchronized, the speed of execution of getInstance method reduces
	 * drastically to around 100 times.
	 */
	public static singleton getInstance() {
		if(obj==null) { // lazy instantiation (better than eager instantiation)
			synchronized (singleton.class) {
				if(obj==null) { // Double checked locking
					obj=new singleton();
				}
			}			
		}
		return obj;
	}
}
