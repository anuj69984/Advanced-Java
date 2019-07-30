package assignment_06;

/*
 * @Author- Anuj Kumar
 * 
 * Write a program to sort Employee objects based on highest salary using Comparator.
 */


//Java program to demonstrate working of Comparator interface 
import java.util.*; 

//A class to represent a Employee. 
class Employee 
{ 
 int salary; 
 String name, address; 

 // Constructor 
 public Employee(int salary, String name,String address) 
 { 
     this.salary = salary; 
     this.name = name; 
     this.address = address; 
 } 

 // Used to print Employee details in main() 
 public String toString() 
 { 
     return this.salary + " " + this.name +" " + this.address; 
 } 
} 

class Sortbysalary implements Comparator<Employee> 
{ 
 // Used for sorting in ascending order of salary 
 public int compare(Employee a, Employee b) 
 { 
     return a.salary - b.salary; //Compare method returns -1, 0 or 1 to say
     					//if it is less than, equal, or greater to the other
 } 
} 

class Sortbyname implements Comparator<Employee> 
{ 
 // Used for sorting in ascending order of name 
 public int compare(Employee a, Employee b) 
 { 
     return a.name.compareTo(b.name); 
 } 
} 

class Sortbyaddress implements Comparator<Employee>{
	public int compare(Employee a, Employee b) {
		return a.address.compareTo(b.address);
	}
}

//Driver class 
class Main 
{ 
 public static void main (String[] args) 
 { 
     ArrayList<Employee> ar = new ArrayList<Employee>(); 
     ar.add(new Employee(70000, "Jeevan", "Andhra"));
     ar.add(new Employee(100000, "Anuj", "Banaras")); 
     ar.add(new Employee(50000, "Ashutosh", "IIT BHU")); 
     

     System.out.println("--------Unsorted---------"); 
     for (int i=0; i<ar.size(); i++) 
         System.out.println(ar.get(i)); 

    Collections.sort(ar, new Sortbysalary()); 

     System.out.println("\n----------Sorted by Salary--------"); 
     for (int i=0; i<ar.size(); i++) 
         System.out.println(ar.get(i)); 

     Collections.sort(ar, new Sortbyname()); 

     System.out.println("\n----------Sorted by name------------"); 
     for (int i=0; i<ar.size(); i++) 
         System.out.println(ar.get(i)); 
     
     Collections.sort(ar, new Sortbyaddress());
     System.out.println("\n----------Sorted by address------------"); 
     for (int i=0; i<ar.size(); i++) 
         System.out.println(ar.get(i)); 
 } 
}