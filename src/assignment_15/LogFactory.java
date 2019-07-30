package assignment_15;
/**
 * 
 * @author Anuj2.Kumar
 *
 */
public class LogFactory {
	Log4J2Interface obj;
	public static LogFactory l;
	
	Log4J2Interface getLogLevel(String logLevel)
	{
		if(logLevel.equalsIgnoreCase("ErrorLog")) {  
           obj= new ErrorLog();  
          }   
		if(logLevel.equalsIgnoreCase("InfoLog")) {  
          obj=new InfoLog();  
       }   
		if(logLevel.equalsIgnoreCase("FatalLog")) {  
            obj= new FatalLog();  
		}
         if(logLevel.equalsIgnoreCase("DebugLog")) {  
                obj=new DebugLog();  
         }
		return obj;
	}
	private LogFactory()
	{
		
	}

	public static LogFactory getInstance()
	{
		if(l==null)
			l=new LogFactory();
		return l;
		
	}
}
