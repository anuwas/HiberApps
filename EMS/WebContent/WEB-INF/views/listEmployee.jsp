<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
        <div align="center">
            <h1>Item List</h1>
            <table border="1">
            <tr>
                <th>S.No.</th>
                <th>Item Code</th>
                <th>Item Name</th>
                <th>Price</th>
                <th>Quantity</th>
              </tr>  
                 
                <c:forEach var="item" items="${itemList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${item.emp_id}</td>
                    <td>${item.emp_name}</td>
                    <td>${item.emp_phone}</td>                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</body>
</html>