package assignment_15;
/**
 * 
 * @author Anuj2.Kumar
 *
 *Task for this tutorial:
1) Create an interface Log4j2Interface having method
writeLog (String className , String methodName, String message)
2) Create classes ErrorLog,InfoLog,FatalLog,DebugLog which implements Log4j2Interface
3) Create a Singleton class LogFactory having
a) Data member Log4j2Interface obj;
b) Method Log4j2Interface getLogLevel(String logLevel)
4) getLogLevel method will return the object of class based on the log level provided
5) Now create a Class Log4jDemo having main method which displays
1: Error
2: Info
3: Fatal
4: Debug
6) After selecting input , accepts ‘Class name ’ , ‘Method Name ’ and ‘Message’ from user
7) Call the method of appropriate class by using factory pattern based on the log level provided and print the entered details
8) Output should of format
‘Log level’ , ‘Message’+”in” +’Method Name’ +”of”+Class name
E.g “ Error Log : Null Pointer in Fetch Alarm Data of Class JDFCAccessFactory
 */

public class DebugLog implements Log4J2Interface
{

	@Override
	public void writeLog(String className, String methodName, String message) {
		// TODO Auto-generated method stub
		System.out.println(className+" "+message+" in "+methodName+" of "+className);
	}

	

}
