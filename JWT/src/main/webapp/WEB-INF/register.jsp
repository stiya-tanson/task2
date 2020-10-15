<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<br>
<div align="center">
	<form action="reg" method="post">
	<h2>Registration page</h2>
	<h6 style="color:green">${match}</h6>
	<div class="form-group">UserName: <input type="text" name="username" required></div>
	<div class="form-group">Password: &nbsp<input type="password" name="password" required></div>
	<div class="form-group">Confirm: &nbsp &nbsp<input type="password" name="passwordc" required></div>
	<div class="form-group"><input type="submit" value="Register" class="btn btn-primary">
	<input type="submit" value="Go To Login" class="btn btn-outline-primary" onClick="Login()"></div>
	</form>
</div>
<script type="text/javascript">
	function Login(){
		alert("Redirecting to Login Microservice for Login")
		window.location.href="/";
		}
</script>
</body>
</html>>