package loginMechanism;


import java.util.Scanner;

import Interface.WelcomeCustomer;
public class Customer extends User {
	
//	Cart newCart = new Cart();	
	public void loggedIn(){

		System.out.println("Logged In as Customer");
		WelcomeCustomer.main(null);
	
	}
	Customer(String u,String p){
		super(u,p);
	}
	Customer(){
		
	}
}