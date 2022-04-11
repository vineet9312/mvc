package com.nt.dependency;

public class DHL implements ICourier{

	
	// this is one of the dependent classes 
	@Override
	public String deliver(int oid) {
		// TODO Auto-generated method stub
		return "deleivered through DHL" ; 
	}

}
