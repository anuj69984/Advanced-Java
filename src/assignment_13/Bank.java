package assignment_13;

/**
 * @author Anuj2.Kumar
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Bank {
	public static void main(String[] args) throws IOException {
		String bankName = null;
		String branch = null;
		String branchCode = null;
		String noOfAccounts = null;
		
		String path = "C:\\Users\\anuj2.kumar\\eclipse-workspace\\AdvanceJava\\src\\assignment_13\\bank.properties";
		FileReader fr = new FileReader(path);
		Properties properties = new Properties();
		properties.load(fr);
		
		bankName = properties.getProperty("bank_name");
		branch =  properties.getProperty("branch");
		branchCode = properties.getProperty("branch_code");
		noOfAccounts = properties.getProperty("no_of_accounts");
		
		EnumParam _bankName = EnumParam.Bank_Name;
		_bankName.setValue(bankName);
		
		EnumParam _branch = EnumParam.Branch;
		_branch.setValue(branch);
		
		EnumParam _branchCode = EnumParam.Branch_code;
		_branchCode.setValue(Integer.parseInt(branchCode));
		
		Account a = new Account();
		a.incrementCurrentAccounts();
		a.incrementCurrentAccounts();
		
		System.out.println(EnumParam.Bank_Name.stringValue);
		System.out.println(EnumParam.Branch.stringValue);
		System.out.println(EnumParam.Branch_code.intValue);
		System.out.println(EnumParam.No_of_accounts.atomicLongValue);
		
	}
}
