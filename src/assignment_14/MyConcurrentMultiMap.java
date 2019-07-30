package assignment_14;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * @author Anuj Kumar
 *
 */
public class MyConcurrentMultiMap {
	transient private ConcurrentHashMap<Person, ArrayList<String>> concurrentHashMap = null;
	ReentrantReadWriteLock lock = null;
	
	public MyConcurrentMultiMap(ReentrantReadWriteLock lock) {
		this.lock = lock;  
		concurrentHashMap = new ConcurrentHashMap<Person, ArrayList<String>>(); 
	}
	
	
	public ArrayList<Person>  get(){
		ArrayList<Person> list = new ArrayList<Person>();
		lock.readLock().lock();
		for (Person personList  : concurrentHashMap.keySet()) {
				list.add(personList);
		}
		lock.readLock().unlock();
		return list;
	}
	void put(Person person){
		lock.writeLock().lock();
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(person.getName());
		concurrentHashMap.put(person, temp);
		lock.writeLock().unlock();
	}
	public void remove(Person person){
		lock.writeLock().lock();
		concurrentHashMap.remove(person);
		lock.writeLock().unlock();
	}
	
	
}
