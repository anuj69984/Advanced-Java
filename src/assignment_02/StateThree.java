package assignment_02;
/**
 * 
 * @author Anuj2.Kumar
 *
 */

public class StateThree extends State implements StateType {
	private StateMachineController controllerParent;
	public void doSomething() throws NullPointerException
	{
		System.out.println("State Three");
		controllerParent =new StateMachineController();
		controllerParent.setState(new StateOne());
	}

}
