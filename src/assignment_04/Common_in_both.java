package assignment_04;

/*
 * @Author- Anuj Kumar
 * 
 * Consider two ArrayList A, B having some values. List down the following
1. Print the values which are common in both of the lists A and B.
2. Print the values which are not common in both of the list.
3. Print the values which are only present in A.
4. Print the values which are only present in B.
 */


//Java Program to find common elements 
//in two ArrayLists 
//Using retainAll() method 

//import ArrayList package 
import java.util.ArrayList; 

public class Common_in_both { 

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

     /* Find the common elements. This method keeps only the
     *common elements of both Collection in Collection1.
      *The List 1 now contains the common elements only
      */
     list1.retainAll(list2); 

     // print list 1 
     System.out.println("Common elements: " + list1); 
 } 
}
