<%@page session="false"%>
<html>
<body>
	<h1>Title : ${title}</h1>	

<a href="admin">admin</a>


	Hi JavaInUse



    <form method = "post" action="http://localhost:8080/hello">
    <input id ="empName" type="hidden" name="empName" value="hacker"/>
    <input type="SUBMIT" value="Surprise..Surprise..See What This Does" />
    </form>


</body>
</html>