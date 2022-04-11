<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<noscript>
	<h1 style="color: red";text-align:center">Please enable the java
		script</h1>


</noscript>

<style media="all">
body {
	background-color: pink;
}

span {
	color: red;
}
</style>

<script language="JavaScript" src="js/Validations.js">
	
</script>


<h1 style="color: red; text-align: center"></h1>


<form:form modelAttribute="emp" onsubmit="return validation(this)" name="frm"> 

	<p style="color: red; text-align: center">
	<li><form:errors path="*" /></li>
	</p>

	<table border="1" bgcolor="cyan" align="center">
		<tr>
			<td>employee name</td>
			<td><form:input path="ename" /></td>
			<form:errors path="ename" />
			<span id="EnameErr" />
		</tr>

		<tr>
			<td>employee designation</td>
			<td><form:input path="job" /></td>
			<form:errors path="job" />
			<span id="JobErr" />
		</tr>

		<tr>
			<td>employee salary</td>
			<td><form:input path="esal" /></td>
			<form:errors path="esal" />
			<span id="SalErr" />
		</tr>


		<!-- below complete tr tag has been added  for the reference data of the countries list data to be populated automatically for the user
 -->

		<script language="JavaScript">
			function sendReqForStates() {
				frm.action = "statesUrl";
				frm.submit();
			}
		</script>

		<tr>
			<td>Select the country</td>
			<td><form:select path="country" onchange="sendReqForStates(this)">
					<form:options items="${countriesInfo}" />
				</form:select></td>
		</tr>


		<tr>
			<td>Select State</td>
			<td><form:select path="state">
					<form:options items="${statesInfo}" />
				</form:select></td>
		</tr>




		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="register employee" /></td>
		</tr>


	</table>

	<form:hidden path="vflag" />



</form:form>


