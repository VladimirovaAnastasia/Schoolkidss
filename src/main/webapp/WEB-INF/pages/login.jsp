<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<style>
	body {
		width: 100%;
		height:100%;
		background: #092756;
		background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%),-moz-linear-gradient(top,  rgba(57,173,219,.25) 0%, rgba(42,60,87,.4) 100%), -moz-linear-gradient(-45deg,  #670d10 0%, #092756 100%);
		background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -webkit-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -webkit-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
		background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -o-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -o-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
		background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -ms-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -ms-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
		background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), linear-gradient(to bottom,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), linear-gradient(135deg,  #670d10 0%,#092756 100%);
		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );

	}
	.content {
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}

	h1, h3 {
		color: #ffffff;
		text-align: center;
	}
	.error {
		padding: 15px;
		margin-bottom: 20px;
		border: 1px solid transparent;
		border-radius: 4px;
		color: #a94442;
		background-color: #f2dede;
		border-color: #ebccd1;
	}

	.msg {
		padding: 15px;
		margin-bottom: 20px;
		border: 1px solid transparent;
		border-radius: 4px;
		color: #31708f;
		background-color: #d9edf7;
		border-color: #bce8f1;
	}

	#login-box {
		background: #ffffff33;
		border-radius: 3px;
		display: flex;
		flex-direction: column;
		justify-content: center;
		width: 400px;
		padding: 40px;
	}
	input {
		width: 100%;
		margin-bottom: 10px;
		background: rgba(0,0,0,0.3);
		border: none;
		outline: none;
		padding: 10px;
		font-size: 13px;
		color: #fff;
		text-shadow: 1px 1px 1px rgba(0,0,0,0.3);
		border: 1px solid rgba(0,0,0,0.3);
		border-radius: 4px;
		box-shadow: inset 0 -5px 45px rgba(100,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2);
		-webkit-transition: box-shadow .5s ease;
		-moz-transition: box-shadow .5s ease;
		-o-transition: box-shadow .5s ease;
		-ms-transition: box-shadow .5s ease;
		transition: box-shadow .5s ease;
	}
	form {
		display: flex;
		flex-direction: column;
	}
	.input-button {
		cursor: pointer;
		width: 305px;
		margin-left: 89px;
	}
</style>
</head>
<body onload='document.loginForm.username.focus();'>

	<div class="content">
		<h1>Добро пожаловать</h1>

		<div id="login-box">

			<h3>Войти</h3>

			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>

			<form name='loginForm'
				  action="<c:url value='/login' />" method='POST'>

				<table>
					<tr>
						<td>Логин</td>
						<td><input type='text' name='username'></td>
					</tr>
					<tr>
						<td>Пароль</td>
						<td><input type='password' name='password' /></td>
					</tr>
					<tr>
						<td colspan='2'><input class="input-button" name="submit" type="submit"
											   value="Войти" /></td>
					</tr>
				</table>

				<input type="hidden" name="${_csrf.parameterName}"
					   value="${_csrf.token}" />

			</form>
		</div>
	</div>



</body>
</html>