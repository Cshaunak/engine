package CallCenter.utils;

import java.util.List;

import CallCenter.bin.Customer;
import CallCenter.bin.Enquiry;
import CallCenter.bin.Users;

public class Test {

	public static void main(String[] args) {
		
		CommonUtils u = new CommonUtils();
		
		Users user = u.validateUsers("man111@kom.moo", "1234","admin");
		
		if(user != null){
			System.out.println("VAlid user");
		}else{
			System.out.println("Invalid");
		}
List<Customer> cust= u.getAllCustomer();
if(cust != null){
	System.out.println("VAlid customer");
}else{
	System.out.println("Invalid");
	
}
List<Enquiry> enq= u.getAllEnquiry();

if(enq != null){
	System.out.println("VAlid Enquiry");
}else{
	System.out.println("Invalid");
	
	}
	Customer cu = u.getCustomer(2);

	if(cu != null){
		System.out.println("VAlid get customer");
	}else{
		System.out.println("Invalid");
	}

	Enquiry e = u.getenquiry(1);

	if(cu != null){
		System.out.println("VAlid get enquiry");
	}else{
		System.out.println("Invalid");
	}
	
	}
	
	/*CustomerExUtils1 cue = new CustomerExUtils1();{
		Enquiry eq = cue.addenquiry("enquiry");
	}*/
	
}

