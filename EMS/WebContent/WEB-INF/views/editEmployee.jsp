<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="empForm" method="post" action="editEmp" modelAttribute="empMaster">
    <input type="text" name="emp_id" value="${empMaster.emp_id}">
        <div align="center">
            <h1>Add Empoyee</h1>
            
            <table border="1">
                <tr>
                     <th>Emp Name</th>   
                     <td> <input name="emp_name" value="${empMaster.emp_name}"></td>
                </tr>
             	<tr>
                     <th>emp Phone</th>   
                     <td> <input name="emp_phone" value="${empMaster.emp_phone}"></td>
                </tr>
                <tr>
                       <th> <input type="submit" value="Add New Item"></th>   
                       <th></th> 
                </tr>
            </table>
        </div>

        </form>
        
        <form action="deleteEmp">
        	<input type="text" name="del_emp_id" value="${empMaster.emp_id}">
        	<input type="submit" value="Delete Emp">
        </form>
</body>
</html>