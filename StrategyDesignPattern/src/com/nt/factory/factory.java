package com.nt.factory;

import com.nt.dependency.DHL;
import com.nt.dependency.ICourier;
import com.nt.dependency.bluedart;
import com.nt.dependency.flipkart;

public class factory {
	
	
	public static flipkart create(String type)
	{
		ICourier ic  =  null ; 
		if(type.equalsIgnoreCase("dhl"))
				ic = new DHL() ;
		
		if(type.equalsIgnoreCase("bluedart"))
				ic = new bluedart() ;
		
		
		flipkart f =  new flipkart() ; 
		f.setcourier(ic);
		
		
		
		return f ; 
		
		
		
		
		
	}
	
	

}
