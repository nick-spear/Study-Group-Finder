<%--@elvariable id="userDatabase" type="java.util.Set<edu.usm.studygroupfinder.model.User>"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="edu.usm.studygroupfinder.model.User" %>
<%@ page import="edu.usm.studygroupfinder.model.Course" %>

<!DOCTYPE html>
<html>
 <head>
 <title>User Database</title>
 </head>
 <body>
 <pre>{</pre>
	<c:forEach items="${userDatabase}" var="user" varStatus="status">
 		<pre>	{</pre>
		<pre>	  "username": "${user.getUsername()}",</pre>
		<pre>	  "name": "${user.getName()}",</pre>
		<pre>	  "password": "${user.getPassword()}",</pre>
		<c:choose>
			<c:when test="${fn:length(user.getCourseList()) == 0}">
				<pre>	  "courseList": [],</pre>
			</c:when>
			<c:otherwise>
				<pre>	  "courseList": [</pre>
				<c:forEach items="${user.getCourseList()}" var="course" varStatus="courseListStatus">
					<pre>	               { "id": "${course.getId()}" }<c:if test="${!courseListStatus.last}" >,</c:if></pre>
				</c:forEach>
				<pre>	             ],</pre>
			</c:otherwise>
		</c:choose>
		<pre>	  "groupList": []</pre>
		<pre>	}<c:if test="${!status.last}" >,</c:if></pre>
	</c:forEach>
<pre>}</pre>
</body>
</html>

