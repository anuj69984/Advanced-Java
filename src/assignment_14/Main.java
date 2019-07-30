package assignment_14;
/**
 * @author Anuj2.Kumar
 * 
 * Task for this tutorial:
A ConcurrentMultiMap is an extension of ConcurrentHashMap which has following properties for our implementation:
 It uses ConcurrentHashMap<Object , ArrayList<String>> internally for transient storage.
 As it is concurrent, so our requirement is to make this thread safe. Means consistency of data should be maintained while working on multithreaded environment. One way to make it thread safe is by using locks (ReentrantReadWriteLock) at accessor & mutator methods.
 The uniqueness of Object (acts as key) should be maintained throughout. Now this key is the Object of a POJO class which has say two instance variables – age(int) and name(String).To make the uniqueness of Objects, override equals() method of Object class. Refer question no – 4 (2nd part).
 ConcurrentMultiMap class may have API’s like get(Object), put(Object), remove(Object). You can create your own API’s as well.
Finally create a class like described above and implement our requirements stated as it is. Take your time to solve this question.
 */

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	public static void main(String[] args) {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
		MyConcurrentMultiMap map = new MyConcurrentMultiMap(lock);
		map.put(new Person(10, "Anuj"));
		map.put(new Person(20, "Arun Kumar"));
		map.put(new Person(50, "Ramesh"));
		System.out.println(map.get());
	}

}
