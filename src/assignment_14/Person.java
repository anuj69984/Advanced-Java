package assignment_14;

/**
 * 
 * @author Anuj2.Kumar
 *
 */

public class Person {
	private int age;
	private String name;
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person person = (Person) obj;
			if (this.age == person.age && this.name.equalsIgnoreCase(person.name)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "[ Name: "+name+
				", Age: "+age+
				" ]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
