<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<h1 style="color:red;text-align:center"> Edit employee page</h1>



<script language = "JavaScript" src="js/Validations.js">
</script>

<form:form modelAttribute="emp" onsubmit="return validation(this)">

<p style="color:red; text-align:center">
<li>
	
	<form:errors path="*"/>	
</li>
</p>
	<table border = "1" bgcolor = "cyan" align="center">
		<tr>
			<td>employee no</td>
			<td><form:input path = "empNo" readonly="true"/> </td>	
		</tr>
		
		<tr>
			<td>employee name</td>
			<td><form:input path = "ename"/> </td> <span id="EnameErr"/>
		</tr>
		
		<tr>
			<td>employee designation</td>
			<td><form:input path = "job"/> </td><span id="JobErr"/>	
		</tr>
		
		<tr>
			<td>employee salary</td>
			<td><form:input path = "esal"/> </td>	<span id="SalErr"/>
		</tr>
		
			<tr>
				<td colspan="2" align="center"> <input type="submit" value = "edit employee"/> </td>
			</tr>
		
		
	</table>
	
		
	<form:hidden path="vflag"/> 
</form:form>


