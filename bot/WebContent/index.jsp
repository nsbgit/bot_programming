<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h1 align="center">Register</h1>
	<form action="<%= request.getContextPath() %>/BS.do?linkId=1" method="post">
		<table align="center">
			<tr>
				<td>Sender's email address</td>
				<td><input type="text" name="semail" id="semail"></td>
			</tr>
			
			<tr>
				<td>Sender's password address</td>
				<td><input type="password" name="spass" id="spass"></td>
			</tr>
			
			<tr>
				<td>Reciever's email address</td>
				<td><input type="text" name="remail" id="remail"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit" align="middle">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>