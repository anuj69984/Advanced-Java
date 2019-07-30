package assignment_02;
/**
 * 
 * @author Anuj2.Kumar
 *
 */

public class StateOne extends State implements StateType{
	private StateMachineController controllerParent;
	public void doSomething () throws NullPointerException
	{
		System.out.println("State One");
		controllerParent =new StateMachineController();
		controllerParent.setState(new StateTwo());
	}

}
