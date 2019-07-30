package assignment_11;

/*
 * Author- Anuj Kumar
 * 
 * Task for this tutorial:
	1. Write properties file called demo.properties. It should have the following entry: dbpolicy=jdbc. This variable
 		can have 2 more entries namely: jpa, toplink. 
 	2. Write a class DBFactory which should be a singleton, getDBAccessor()
  		is a public method of this class. 
  	3. Use the “Properties” class of the JVM to load this file and read the dbpolicy variable.
   		Store its value in an instance variable of DBFactory. 
   	4. Read the properties file in the constructor of the DBFactory singleton
   5. Now write an abstract class called GenericDBAccessFactory. This class should implement an interface called DatabaseAPI. 
   6. This interface has the following methods: create(), insert(), delete(), update(), batchUpdate().
   7. Extend the GenericDBAccessFactory abstract class and write 3 concrete classes named JDBCFactory, JPAHibernateFactory and ToplinkFactory. 
   8. Based on the value of the dbpolicy variable, the DBFactory singleton creates an object of the appropriate
     factory class. Eg: if dbpolicy=jdbc, then JDBCFactory class is instantiated. 
   9. The singleton stores the database factory class instance in a private variable which is like this: private GenericDatabaseFactory dbAccessor;
   10. Write a class Tutorial4 which has the main method. In this class, get the instance of the singleton DBFactory
        and invoke a mehod getDBAccessorFactory(). This method should return the dbAccessor variable. This variable may be of type
         JDBCFactory, JPAHibernateFactory or ToplinkFactory based on the value of dbpolicy.
    11. After calling getDBAccessorFactory, invoke all the public methods of the return value (dbFactory was returned). 
    12. Repeat this tutorial with the values of dbpolicy=jpa and again with dbpolicy=toplink to see if the correct DB accessor
     factory was instantiated by DBFactory or not
 */

import java.io.*;
import java.util.Properties;
import java.io.IOException;

class RTJioTutorial4Class {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DBFactory s = DBFactory.getInstance();
		
		GenericDBAccessFactory obj = s.getDBAcessor();
		obj.create();
		obj.delete();
		obj.batchUpdate();
		obj.insert();
		obj.update();
	}

}

class DBFactory {
	private static DBFactory s;
	String val;
	private GenericDBAccessFactory dbAccessor;
	
	private DBFactory() throws IOException {
		FileReader reader=new FileReader("C:\\Users\\anuj2.kumar\\eclipse-workspace\\AdvanceJava\\src\\assignment_11\\Demo.properties");  
	      
	    Properties p=new Properties();  
	    p.load(reader);
	    this.val=p.getProperty("dbpolicy");
	    System.out.println("valuiee"+this.val);
	}
	
	public static DBFactory getInstance() throws IOException {
        if (s == null) {
            synchronized (DBFactory.class) {
                s = new DBFactory();
            }
            return s;
        }
        return null;
    }

	public GenericDBAccessFactory getDBAcessor() {
		if(this.val.contentEquals("jdbc")) {
			dbAccessor = new JDBCFactory();
		} else if(this.val.contentEquals("jpa")) {
			dbAccessor = new JPAHibernateFactory();
		} else {
			dbAccessor = new ToplinkFactory();
		}
		return dbAccessor;
		
	}
}

abstract class GenericDBAccessFactory implements DatabaseAPI {
	
}

class JDBCFactory extends GenericDBAccessFactory {

	public void create() {
		System.out.println("JDBC created");
	}
	
	public void insert() {
		System.out.println("JDBC inserted");
	}
	
	public void delete() {
		System.out.println("JDBC deleted");
	}
	
	public void update() {
		System.out.println("JDBC updated");
	}
	
	public void batchUpdate() {
		System.out.println("JDBC batchupdated");
	}
}

class ToplinkFactory extends GenericDBAccessFactory{

	public void create() {
		System.out.println("ToplinkFactory created");
	}
	
	public void insert() {
		System.out.println("ToplinkFactory inserted");
	}
	
	public void delete() {
		System.out.println("ToplinkFactory deleted");
	}
	
	public void update() {
		System.out.println("ToplinkFactory updated");
	}
	
	public void batchUpdate() {
		System.out.println("ToplinkFactory batchupdated");
	}
}


class JPAHibernateFactory extends GenericDBAccessFactory {
	
	public void create() {
		System.out.println("JPAHibernateFactory created");
	}
	
	public void insert() {
		System.out.println("JPAHibernateFactory inserted");
	}
	
	public void delete() {
		System.out.println("JPAHibernateFactory deleted");
	}
	
	public void update() {
		System.out.println("JPAHibernateFactory updated");
	}
	
	public void batchUpdate() {
		System.out.println("JPAHibernateFactory batchupdated");
	}
}


interface DatabaseAPI {
	public void create();
	public void insert();
	public void delete(); 
	public void update();
	public void batchUpdate(); 
}
