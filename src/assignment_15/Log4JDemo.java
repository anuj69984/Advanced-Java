package assignment_15;
/**
 * 
 * @author Anuj2.Kumar
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Log4JDemo {
public static void main(String args[]) throws IOException
{
	System.out.println("Enter class name : ");
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
	 String class_n=br.readLine();
	 
	 System.out.print("Enter Method name : ");
	 BufferedReader br1=new BufferedReader(new InputStreamReader(System.in)); 
	 String method_n=br1.readLine();
	 
	 System.out.print("Enter Message : ");
	 BufferedReader br2=new BufferedReader(new InputStreamReader(System.in)); 
	 String msg=br2.readLine();
	 
	 LogFactory l=LogFactory.getInstance();
	Log4J2Interface log = l.getLogLevel(class_n);
	log.writeLog(class_n,method_n,msg);
}
}
