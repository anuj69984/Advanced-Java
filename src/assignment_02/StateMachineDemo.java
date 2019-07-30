package assignment_02;
/**
 * 
 * @author Anuj2.Kumar
 *
 */
public class StateMachineDemo {
	public static void main(String[] args) throws NullPointerException {
		StateMachineController controller=new StateMachineController();
		try
		{
			while(true)
			{
				controller.start();
			}
		}
		catch(StackOverflowError e)
		{
			main(null);
		}
		// TODO Auto-generated method stub
	}
}
