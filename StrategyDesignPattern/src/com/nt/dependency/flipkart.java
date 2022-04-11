package com.nt.dependency;

import java.util.Arrays;
import java.util.Random;



// this is the target class 
public class flipkart {
	private ICourier courier ; 
	
	public void setcourier(ICourier courier)
	{
		this.courier=courier ; 
		
	}
	
	public String shopping(String[] items, double[] prices )
	{
		
		double billAmt = 0.0 ;
		
		for(double v:prices)
				billAmt += v ; 
		String g = Arrays.toString(items) +" with prices "+ Arrays.toString(prices) + "bill amount is " + billAmt ; 
		int oid  = new Random().nextInt(1000) ; 
		String deliver = courier.deliver(oid) ;
		
		return g+ " ========="+deliver  ; 
		
		
	}
	
	

}
