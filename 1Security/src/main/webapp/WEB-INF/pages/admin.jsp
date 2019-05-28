<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>


	 <form method = "post" modelAttribute="emp"  action="/hello">
            <input id ="id" name="id" value="id"/>
            <input id ="name" name="name" value="name"/>
            <input type="SUBMIT" value="Submit" />
            </form>

	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>


    <script>
        jQuery(document).ready(function($) {
          $.ajax({
            type: 'GET',
            url: '/hello'
          }).done(function (data, textStatus, jqXHR) {
            alert("demo");
            var csrfToken = jqXHR.getResponseHeader('X-CSRF-TOKEN');
            if (csrfToken) {
              var cookie = JSON.parse($.cookie('helloween'));
              cookie.csrf = csrfToken;
              $.cookie('helloween', JSON.stringify(cookie));
              alert(cookie);
            }
            $('#helloweenMessage').html(data.message);
          }).fail(function (jqXHR, textStatus, errorThrown) {
            if (jqXHR.status === 401) { // HTTP Status 401: Unauthorized
              alert("sdf");              var cookie = JSON.stringify({method: 'GET', url: '/', csrf: jqXHR.getResponseHeader('X-CSRF-TOKEN')});
              $.cookie('helloween', cookie);
              window.location = '/login.jsp';
            } else {
              console.error('Houston, we have a problem...');
            }
          });
});
    </script>

</body>
</html>