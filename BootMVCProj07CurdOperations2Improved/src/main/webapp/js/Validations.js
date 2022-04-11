
function validation(frm)
{
	alert("client side form validations")
	alert("0") ; 
	
	document.getElementById("EnameErr").innerHTML=""; 
	document.getElementById("JobErr").innerHTML=""; 
	document.getElementById("SalErr").innerHTML=""; 
	
	alert("1") ; 
	
	let ename=frm.ename.value ; 
	let esal=frm.esal.value ; 
	let job=frm.job.value ; 
	let flag = true ; 
	if (ename=="")
	{
		document.getElementById("EnameErr").innerHTMLL="employee name is mandatory from client side "  ;  
		flag =  false ; 
	}

	else if(ename.length>10)
	{
		document.getElementById("EnameErr").innerHTML="employee name can have max of 10 chars from client side"  ;  
		flag =  false ; 
	}
	
	alert("2") ; 
	
	if(job=="")
	{
		document.getElementById("JobErr").innerHTML="employee designation cannot be empty from client side"  ;
		flag =  false ;   
	}
	else if(job.length>9)
	{
		document.getElementById("JobErr").innerHTML="employee designation can have max of 9 chars from client side"  ;
		flag =  false ;   
	}
	alert("3") ; 
	
	if(esal=="")
	{
		document.getElementById("SalErr").innerHTML="employee salary is required from client side" ;
		flag =  false ;  
	}
	else if(isNaN(esal))
	{
		document.getElementById("SalErr").innerHTML="employee salary must be numeric value from cleint side " ; 
		flag = false ; 
		
	}
	

		
	else if (esal<0 || esal>100000)
	{
		document.getElementById("SalErr").innerHTML="employee salary must be within the proper range from the client side" ; 
		flag = false ; 
	}
		alert("4") ; 
		// making the vflag value to yes indicates that client side form validations are done
		frm.vflag.value="yes" ; 
	return flag ; 
}