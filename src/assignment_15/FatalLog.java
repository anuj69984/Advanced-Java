package assignment_15;
/**
 * 
 * @author Anuj2.Kumar
 *
 */
public class FatalLog implements Log4J2Interface {

	@Override
	public void writeLog(String className, String methodName, String message) {
		// TODO Auto-generated method stub
		System.out.println(className+" "+message+" in "+methodName+" of "+className);
	}

}
