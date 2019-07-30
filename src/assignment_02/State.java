package assignment_02;
/**
 * 
 * @author Anuj2.Kumar
 * 
 * Write a class StateMachineController.
1. Let this class have one instance variable: protected State state;
2. This class also has a setState(State nextState) method and a void start() method.
3. Write an interface StateType, which has one method known as doSomething();
4. Write three classes called StateOne, StateTwo and StateThree that implement this interface. These three classes maintain a reference to StateMachineController in the instance variable (Eg: private StateMachineController controllerParent).
5. In the doSomething method of each State class, just print the state name.
6. Write a class StateMachineDemo which contains our main method.
7. Create an object of type StateMachineController now (Eg: StateMachineController controller = new StateMachineController())
8. In the main method, write an infinite loop (while (true)), and call the controller.start() method inside it.
9. In the constructor of the StateMachineController, set the “state” instance variable to StateOne’s object. (state = new StateOne()).
10. In this start method of StateMachineController, simply call state.doSomething(this);
11. In the doSomething implementation of StateOne, you can set the next state by calling controllerParent.setState(new StateTwo()). Similarly in StateTwo, the next state is StateThree. The next state for StateThree is again StateOne.
 *
 */

public class State {
	void doSomething(StateMachineController c)
	{
		c.setState(c.state);
	}
	void doSomething()
	{
		
	}
}
