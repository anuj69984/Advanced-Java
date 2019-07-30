package assignment_02;
/**
 * 
 * @author Anuj2.Kumar
 *
 */
public class StateMachineController {
	protected State state;
	StateMachineController()
	{
		state=new StateOne();
	}
	void setState(State nextState)
	{
		nextState.doSomething();
	}
	void start()
	{
		state.doSomething(this);
	}
}
