<%@page import="beo.StudentVO"%>
<%@page import="java.util.*"%>

<%
	List<StudentVO> students = (List<StudentVO>) session.getAttribute("students");
%>
<html>
<script language="javascript">
    function setSelectedItem(elementId) {
        if (confirm("Do you really want to delete this item?")){
        	document.forms["student"].selecteditem.value = elementId;
        	document.forms["student"].task.value = 'DELETE';
        	document.forms["student"].submit();
        }
    }
    
    function sendTask(task) {
		document.forms["student"].task.value = task;
    	document.forms["student"].submit();
    }
</script>
<body>
	<form action="/jee/MainServlet" method="GET" name="student">
		<input name="selecteditem" type="hidden" value="" />
		<input name="task" type="hidden" value="" />
		<br/></br><br/><br/>
		<div align="center">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="txtId"/></td>
					<td>NAME</td>
					<td><input type="text" name="txtName"/></td>
					<td>GENDER</td>
					<td><select name="cmbGender">
						<option value=""></option>
						<option value="MALE">MALE</option>
						<option value="FEMALE">FEMALE</option>
					</select></td>	
				<tr>
				<tr>
					<td colspan="6">
						<input type="button" value="search" onclick="sendTask('SEARCH');"/>
						<input type="button" value="save" onclick="sendTask('SAVE');"/>
						<input type="button" value="update" onclick="sendTask('UPDATE');"/>
					</td>
				<tr>
			</table>
			<br/>
			<table border="1" width="50%">
				<caption>Student List :</caption>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>GENDER</th>
					<th>DELETE</th>
				<%
					if (students != null) {
						for (StudentVO studentVO : students) {
							%>
							<tr>
								<td align="center"><%=studentVO.getId()%></td>
								<td align="center"><%=studentVO.getName()%></td>
								<td align="center"><%=studentVO.getGender()%></td>
								<td align="center"><input type="button"  value="Delete" onclick="setSelectedItem('<%=studentVO.getId()%>');"/></td>
							</tr>
							<%
						}
					}
				%>
			</table>
		</div>
		
	</form>
</body>
</html>