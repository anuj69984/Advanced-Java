package assignment_10;
/*
 * @Author : Anuj Kumar
 * 
 * Task for this tutorial:-
1) Write a singleton class named MobileSingleton.
2) This singleton needs to have 1 data members, of private
ConcurrentHashMap<String, ArrayList<Mobile>>
3) Name ConcurrentHashMap as mobileDataMap. This map will keep the BrandName as the key and List of MobileData of given brand as value.
4) Mobile Class will have following attribute model,imei,color,ram,storage
5) The MobileSingleton should have the following methods:
a) addNewMobileData(String brandName, String model, String imei, String color, String ram, String storage)
b) printAllBrandWithMobileData
c) printAllMobileDataByBrand(String brandName)
d) deleteMobileData(String brandName,String model)
6) Now write a class named TutorialMain. This class should contain the main () method. In the main method, Display option to user as
1: Add MobileData
2: PrintAllData
3: PrintDataByBrandName
4: DeleteMobileData
7) On selected option , take further appropriate input and invoke the methods
(Add at least 5 brand each having 5 models)
8) Brand Name should exists only if it has at least one mobile data in the list
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class MobileSingleton {
       private static MobileSingleton Mobile_instance=null;
       private ConcurrentHashMap<String,ArrayList<Mobile>> mobileDataMap;
       private MobileSingleton() 
    { 
      mobileDataMap=new ConcurrentHashMap<String,ArrayList<Mobile>>();
      ArrayList<Mobile> asam=new ArrayList<Mobile>();
      Mobile m2=new Mobile("Edge 4","EE24374849","White","4GB","128GB");
      Mobile m3=new Mobile("Edge 6","EE24374869","Black","6GB","128GB");
      asam.add(new Mobile("Edge 2","EE24374839","Black","4GB","64GB"));
      asam.add(m2);
      asam.add(m3);
       
      mobileDataMap.put("Nokia",asam);
      ArrayList<Mobile> rm=new ArrayList<Mobile>();
      Mobile rm1=new Mobile("Note2","EE24374861","Black","4GB","64GB");
      Mobile rm2=new Mobile("Note4","EE24374862","Red","6GB","128GB");
      Mobile rm3=new Mobile("Note6","EE24374863","Blue","8GB","256GB");
      rm.add(rm1);
      rm.add(rm2);
      rm.add(rm3);
      mobileDataMap.put("redmi",rm);
    } 
       public static MobileSingleton getInstance() 
    { 
        if (Mobile_instance == null) 
        { 
             Mobile_instance = new MobileSingleton(); 
        } 
        return Mobile_instance; 
    } 
       // function to add new mobile data
       void addNewMobileData(String brandName, String  model, String imei, String  color, String  ram, String  storage) {
              Mobile m1=new Mobile(model,imei,color,ram,storage);
//            ArrayList<Mobile> am1=new ArrayList<Mobile>();
//            am1.add(m1);
              if(mobileDataMap.containsKey(brandName))
              {
                     mobileDataMap.get(brandName).add(m1);
              }
              else
              {
                     ArrayList<Mobile> l=new ArrayList<Mobile>();
                     mobileDataMap.put(brandName, l);
              }
                     
       }
       
       
       //printing the names of all mobiles
       void printAllBrandWithMobileData(){
              for(ConcurrentHashMap.Entry<String,ArrayList<Mobile>> entry: mobileDataMap.entrySet()) {
                     System.out.println(entry.getKey());
                     Iterator<Mobile> itr=entry.getValue().iterator();
                     while(itr.hasNext()){  
                      Mobile st=(Mobile)itr.next();  
                      System.out.println(st.model+" "+st.imei+" "+st.color+" "+st.ram+" "+st.storage);
                    }
                     
              }
              
              
       }
       void printAllMobileDataByBrand(String brandName) {
              System.out.println(mobileDataMap.get(brandName));
       }
       
       // function to delete mobile data
       void deleteMobileData(String brandName,String model) {
              if(mobileDataMap.containsKey(brandName))
              {
                     for(Mobile m : mobileDataMap.get(brandName)) {
                           if(m.model.equals(model)) {
                                  mobileDataMap.get(brandName).remove(m);
                                  break;
                           }
                     }
              }
       }
       void after() {
              for(ConcurrentHashMap.Entry<String,ArrayList<Mobile>> entry: mobileDataMap.entrySet()) {
                     System.out.println(entry.getKey());
                     Iterator<Mobile> itr=entry.getValue().iterator();
                     while(itr.hasNext()){  
                      Mobile st=(Mobile)itr.next();  
                      System.out.println(st.model+" "+st.imei+" "+st.color+" "+st.ram+" "+st.storage);
                    }
       }
       }
}
class Mobile{
       String model,imei,color,ram,storage;
       Mobile(String a,String b,String c,String d,String e){
              model=a;
              imei=b;
              color=c;
              ram=d;
              storage=e;
       }
}

// main class 
class  TutorialMain{
       public static void main(String[] args) {
              MobileSingleton ms=MobileSingleton.getInstance();
              Scanner s=new Scanner(System.in);
              System.out.println("1: Add MobileData");
              System.out.println("2: PrintAllData ");
              System.out.println("3: PrintDataByBrandName ");
              System.out.println("4: DeleteMobileData ");
              System.out.println("Select one: ");
              int inputoption=s.nextInt();
              switch(inputoption) {
              case(1):
                     String a,b,c,d,e,f;
                     Scanner s1=new Scanner(System.in);
                     System.out.println("Enter Brandname: ");
                     a=s1.nextLine();
                     System.out.println("Enter Model: ");
                     b=s1.nextLine();
                     System.out.println("Enter IMEI: ");
                     c=s1.nextLine();
                     System.out.println("Enter Color: ");
                     d=s1.nextLine();
                     System.out.println("Enter Ram: ");
                     e=s1.nextLine();
                     System.out.println("Enter Storage: ");
                     f=s1.nextLine();
                     ms.addNewMobileData(a,b,c,d,e,f);
                     s1.close();
                     break;
              case(2):ms.printAllBrandWithMobileData();
              break;
              
              case(3):
                     String Brandname;
                     System.out.println("Enter Brandname: ");
                     Brandname=s.nextLine();
                     ms.printAllMobileDataByBrand(Brandname);
              break;
              case(4):
                     Scanner s2=new Scanner(System.in);
                     String Bname,Model;
                     System.out.println("Enter Brandname and Model");
                     Bname=s2.nextLine();
                     Model=s2.nextLine();
                     ms.deleteMobileData(Bname,Model);
                     s2.close();
                     break;
              default:System.out.println("You must select in between 1-4");
              }
              ms.after();
              s.close();
       }
}
