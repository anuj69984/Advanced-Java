package assignment_05;
/*
 * @Author- Anuj Kumar
 * 
 * Write a program
a. That prints the list of elements in random order. Do not make a copy of the argument array.
b. Sort the elements of the list.
Demonstrate how to print out the elements using both streams and the traditional enhanced for statement.
 */


import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.*; 

public class ListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l1=new ArrayList<>();
		l1.add(12);l1.add(1); l1.add(15); l1.add(2);
		System.out.println("Before shuffling");
		for(int i : l1) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
	//every time we run the program, we get different output
		Collections.shuffle(l1);
		System.out.println("After shuffling");
		for(int i : l1) {
			System.out.print(i + " ");
		}
		
		Collections.sort(l1);
		System.out.println("\n");
		System.out.println("After sorting");
		//enhanced for loop
		for(int i : l1) {
			System.out.print(i + " ");
		}
		
		/*
		 * There are 3 ways to print the elements of a Stream
		 *  in Java:
		forEach()
		println() with collect()
		peek()
		 */
		System.out.println("\n");
		System.out.println("Printing using stream");
		l1.forEach(System.out::println);
	}
}