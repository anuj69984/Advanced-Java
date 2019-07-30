package assignment_04;

/*
 * @Author- Anuj Kumar
 */

//Java Program to find common elements 
//in two ArrayLists 
//Using retainAll() method 

//import ArrayList package 
import java.util.ArrayList; 

public class Only_A { 

// main method 
public static void main(String[] args) 
{ 

   // create ArrayList list1 
   ArrayList<String> list1 = new ArrayList<String>(); 

   // Add values in ArrayList 
   list1.add("Hi"); list1.add("Hello"); 
   list1.add("Anuj"); list1.add("Jio"); 

   // print list 1 
   System.out.println("List1: " + list1); 

   // Create ArrayList list2 
   ArrayList<String> list2 = new ArrayList<String>(); 

   // Add values in ArrayList 
   list2.add("Anuj"); list2.add("works"); list2.add("Jio"); 

   // print list 2 
   System.out.println("List2: " + list2); 

   /* This method removes all common elements from list 1
    *  which are there in list 2
    */   
   list1.removeAll(list2);
   
   // print list 1 
   System.out.println("Common elements: " + list1); 
} 
}
