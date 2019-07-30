package assignment_09;

/*
 * Author - Anuj Kumar
 * 
 * ConcurrentHashMap is a special type of HashMap which is synchronized internally. Its behavior is identical to a normal HashMap. The tasks for this tutorial is :-
 Write a singleton class named MySingleton.
 This singleton needs to have 2 data members, both of which are private ConcurrentHashMap types.
 Name ConcurrentHashMap -1 as EmployeeNameMap. This map will keep the employee name as the key and the employee number (of type long) as its value.
 Name ConcurrentHashMap-2 as EmployeeTeamMap. This map will keep the employee number as the key and the team name as the value.
 Now write a class known as EmployeeDatabase. This class should instantiate the two concurrent hash maps of the singleton class in its constructor and fill them with some values as given below:
For the EmployeeNameMap we should fill the following values:
Aayush 123456 Sumeet 111111 Sandeep 121212 Gaurav 112233 Vikash 223344
For the EmployeeTeamMap, we should have the following values: 123456 Sdp1 111111 Sdp2 121212 Sdp3 112233 Sdp4 223344 Sdp5


The Employee database should have the following methods: a. printAllEmployeeNames(); b. printAllEmployeeIDS(); c. printEmployeeIdByName(String name); d. printEmployeeTeambyID(long id);
 For printing the information above, EmployeeDatabase class needs to consult the singleton class. So, the singleton class should provide appropriate public getter methods to EmployeeDatabase class, as the concurrent hash maps are private.
 Now write a class named TutorialThree. This class should contain the main () method. In the main method, first create an instance of EmployeeDatabase class. Now make the main Thread sleep for 1 second.
 Now, create a for loop which iterates 30 times. Inside this loop, create a new Threaded class called EmployeeDetailsThread. This class should implement Runnable interface.
 In the run() method of EmployeeDetailsThread, you need to invoke the 4 methods given in point-6 above
 */

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// singleton class
public class MySingleton {
    private static MySingleton single_instance=null;
    private ConcurrentHashMap<String, Long>  EmployeeNameMap;
    private ConcurrentHashMap<Long,String>  EmployeeTeamMap;
    
    //Constructor
    private MySingleton() 
 { 
           EmployeeNameMap= new ConcurrentHashMap<String, Long>();
           EmployeeTeamMap= new ConcurrentHashMap<Long, String>();
           EmployeeNameMap.put("Aayush",(long)123456);
           EmployeeNameMap.put("Sumeet", (long) 111111);
           EmployeeNameMap.put("Sandeep", (long) 121212);
           EmployeeNameMap.put("Guarav", (long) 112233);
           EmployeeNameMap.put("Vikash", (long) 223344);
           EmployeeTeamMap.put((long) 123456, "sdp1");
           EmployeeTeamMap.put((long) 111111, "sdp2");
           EmployeeTeamMap.put((long) 121212, "sdp3");
           EmployeeTeamMap.put((long) 112233, "sdp4");
           EmployeeTeamMap.put((long) 223344, "sdp5");
           
 } 
    // return type is singleton object
    public static MySingleton getInstance() 
 { 
     if (single_instance == null) 
     { 
         single_instance = new MySingleton(); 
     } 
     return single_instance; 
 } 
    // Printing the names of Employees
    void printAllEmployeeNames(){
           Set<String> keys = EmployeeNameMap.keySet();
            for(String key: keys){
                System.out.println(key);
            }
           
    }
    // Printing the IDs of Employees
 void printAllEmployeeIDS() {
     Set<Long> keys = EmployeeTeamMap.keySet();
            for(long key: keys){
                System.out.println(key);
            }
 }
 
 // Printing Employee Id by names
 void printEmployeeIdByName(String name) {
     System.out.println(EmployeeNameMap.get(name));
 }
 void printEmployeeTeambyID(long id) {
     System.out.println(EmployeeTeamMap.get(id));
 }
}
//class of Employee Database
class  EmployeeDatabase{
    MySingleton x=MySingleton.getInstance();
    void printAllEmployeeNames(){
        x.printAllEmployeeNames();
    }
  void printAllEmployeeIDS() {
     x.printAllEmployeeIDS();
  }
  void printEmployeeIdByName(String name) {
     x.printEmployeeIdByName(name);
  }
  void printEmployeeTeambyID(long id) {
     x.printEmployeeTeambyID(id);
  }
}
class  TutorialThree{
    public static void main(String[] args) {
          EmployeeDatabase ed=new EmployeeDatabase();
           try {
                  Thread.sleep(1000);
           }
           catch(Exception e) {
                  System.out.println(e);
           }
           for(int i=0;i<1;i++)
           {
                  class EmployeeDetailsThread implements Runnable{
                        public void run() {
                               ed.printAllEmployeeNames();      
                               ed.printAllEmployeeIDS();
                               ed.printEmployeeIdByName("Sandeep");
                               ed.printEmployeeTeambyID(123456);
                               }
                  }
                  Runnable k=new EmployeeDetailsThread();
                  Thread t=new Thread(k);
                  t.start();
           }
           
    }
    
}
