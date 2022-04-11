<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1 style="color:red;text-align:center">EMPLOYEE report is here buddy</h1>


<c:choose>
<c:when test="${!empty empData}">
	<table border ="1" align="center" bgcolor="cyan">
	<tr>
	<th>empNo</th><th>empName</th><th>empJob</th><th>empSal</th>
	
	</tr>		
	
	<c:forEach var="emp" items="${empData}">
		<tr>
			<td>${emp.empNo}</td>
			<td>${emp.ename}</td>
			<td>${emp.esal}</td>
			<td>${emp.job}</td>
			<td><a href = "edit?no=${emp.empNo}">edit employee </a> &nbsp; &nbsp;
				 <a onclick="return confirm('Do you want to delete')" href = "delete?no=${emp.empNo}">delete employee </a></td>
			
		</tr>>
	</c:forEach>
	</table>
</c:when>
<c:otherwise>
<h1 style="color:red;text-align:center">records not found </h1>

</c:otherwise>
</c:choose>
	
	
		<c:if test="${!empty resultMsg}">   
			<h3 style="color:green;text-align:center">${resultMsg}</h3>
		</c:if>



<br>
<br>
<hr>
<h1><a href = "./"> <img src = "images/home.png" width = "200" height = "200"/> HOME</a> </h1>>
<hr>

<h1><a href = "add"> <img src = "images/add.png" width = "90" height = "90"/>add employee </a> </h1>>


