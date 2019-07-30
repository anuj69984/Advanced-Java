package assignment_02;
/**
 * 
 * @author Anuj2.Kumar
 *
 */

public class StateTwo extends State implements StateType{
	private StateMachineController controllerParent;
	public void doSomething() throws NullPointerException
	{
		System.out.println("State Two");
		controllerParent =new StateMachineController(); 
		controllerParent.setState(new StateThree());
	}

}
