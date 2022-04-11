package com.nt.client;

import com.nt.dependency.flipkart;
import com.nt.factory.factory;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		flipkart create = factory.create("dhl") ;
		
		String   f =  create.shopping(new String[] {"shirts", "pants"}, new double[] {1000,1200}) ; 
		
		
		
		System.out.println(f);
		
		
	}

}
