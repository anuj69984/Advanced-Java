package assignment_13;

/*
 * @Author - Anuj Kumar
 * 
 * Task for this tutorial
Write an Enum named EnumParam with -
1. Enums: Bank_Name, Branch, Branch_code, No_of_accounts
create above enum using some value like
for Bank_Name - dataType String, Value:HDFC
for Branch - dataType String, Value:RCP Branch
for Branch_code - dataType integer, Value:831
for No_of_accounts - dataType atomiclong, Value:50000
Ex. Bank_Name("String", "HDFC");
2. And Create variables and getter setters for variable: //Please note atomiclong API has methods for operations like increment, decrement, compare etc.
int intValue;
String stringValue;
atomiclong atomicongValue;
String dataType;
3. Create Constructors
EnumParam(String dataType, String stringValue)
EnumParam(String dataType, AtomicLong atomiclongvalue)
EnumParam(String dataType, int intvalue)
4. Create method for setting enum value as setValue(String Value),
where if Enum datatype is String method will set stringvalue
if Enum datatype is int method will set intvalue
if Enum datatype is atomiclong method will set atomiclongvalue
Write an Account class with int variables currentAccounts and savingAccounts with initial value(20000 and 30000), add two method to this class incrementCurrentAccounts()
and incrementSavingAccounts() these methods will increment currentaccounts and savingaccounts resp. and also increment and set no_of_accounts using method from EnumParam.

Write a main class Bank which will
read bank_name, branch, branch_code, no_of_accounts from property file and set these values to EnumParam.
Prints all Enum Values.
calls incrementCurrentAccounts() and incrementSavingAccounts() method from Account class
Print No_of_accounts value


 */

import java.util.concurrent.atomic.AtomicLong;

public class Account {
	int currentAccount = 20000;
	int savingAccount = 30000;
	
	 void incrementCurrentAccounts() {
		 currentAccount++;
		 EnumParam ep = EnumParam.No_of_accounts;
		 ep.atomicLongValue.getAndIncrement();
	 }
	 
	 void incrementSavingAccounts() {
		 savingAccount++;
		 EnumParam ep = EnumParam.No_of_accounts;
		 ep.atomicLongValue.getAndIncrement();
	 }
	 
	 
}
