package assignment_01;

/*
 * @Author- Anuj Kumar
 * 
 * Iterate over the entries of two array lists and then insert the values of list 1 as the key and the values of list 2
 *  as the value of a concurrent hash map. Use Iterator for list 1 and ListIterator for list 2.
 */

import java.util.*; 
import java.util.concurrent.*; 
  
public class abc { 
    public static void main(String[] args) 
    { 
    	ArrayList<Integer> a=new ArrayList<>();
    	a.add(1);a.add(2);a.add(3);a.add(4);
    	
    	ArrayList<String> b=new ArrayList<>();
    	b.add("Jio");b.add("Micro");b.add("Tower");b.add("Reliance");
    	
    	System.out.println(a);
    	
        // Creating an empty ConcurrentHashMap 
        ConcurrentHashMap<Integer, String> hash_map 
            = new ConcurrentHashMap<Integer, String>(); 
  
     Iterator it= a.iterator();
     Iterator bt=b.iterator();
     while(it.hasNext() && bt.hasNext()) {
    	 hash_map.put((Integer)it.next(),(String)bt.next());
    	 
     }         
        // Displaying the HashMap 
        System.out.println("Initial Mappings are: " + hash_map); 
  
        // Using keySet() to get the set view of keys 
        System.out.println("The Collection is: " + hash_map.values()); 
    } 
} 