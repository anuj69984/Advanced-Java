package assignment_13;
import java.util.concurrent.atomic.AtomicLong;
/**
 * @author Anuj2.Kumar
 *
 */


public enum EnumParam {
	Bank_Name("String", "HDFC"), Branch("String", "RCP Branch"), Branch_code("Integer", 831),
	No_of_accounts("AtomicLong", new AtomicLong(5000));

	int intValue;
	String stringValue;
	AtomicLong atomicLongValue;
	String dataType;

	EnumParam(String dataType, String stringValue) {
		this.dataType = dataType;
		this.stringValue = stringValue;
	}

	EnumParam(String dataType, AtomicLong atomicLongValue) {
		this.dataType = dataType;
		this.atomicLongValue = atomicLongValue;
	}

	EnumParam(String dataType, int intValue) {
		this.dataType = dataType;
		this.intValue = intValue;
	}
	
	public void setValue(Integer value) {
		this.intValue = value;
	}
	public void setValue(String value) {
		this.stringValue = value;
	}
	public void setValueAtomic(AtomicLong value) {
		this.atomicLongValue = value;
	}
	
	
	AtomicLong getNoOfAccount() {
		return atomicLongValue;
	}
	

}
