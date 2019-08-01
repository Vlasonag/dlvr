<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="http://localhost:8080/css/content.css">
<link type="text/css" rel="stylesheet" href="http://localhost:8080/css/header.css"> 
</head>
<body>
<div class="body">
		<div class="header-top">
		<a href="/">D L V R</a>
		</div>
		
	    <div class="header-mid">
	    	<div class="header-mid-telephone">
			    	<p>
				    	<img src="/photo/telephone_icon.png">
				  		(044)444-44-44
			  		</p>
	  			<hr>
	  		</div>
	    	
	  		<div class="header-mid-tools">
		  		<nobr>
		              <a href="/order_status">Статус заказа</a>
	  			</nobr>
				
		  		<nobr>
		              <a href="/basket">Корзина</a>
	  			</nobr>
		  		<nobr>
		  			<a href="/account">Моя страница</a> 
		  		</nobr>
		  		
	  		</div>
	    </div>
	    
	    <div class="header-navigation">
		    <nobr>
		    	<img src="/photo/pizzas_icon.png">
		    	<a href="/pizza">Пицца</a>
		    </nobr>
		    <nobr>
		    	<img src="/photo/burgers_icon.png">
		    	<a href="/burgers">Бургеры</a> 
		    </nobr>
		    <nobr>
		    	<img src="/photo/drinks_icon.png">
		    	<a href="/drinks">Напитки</a>
		    </nobr>
		    <nobr>
		    	<img src="/photo/desserts_icon.png">
		    	<a href="/desserts">Дессерты</a>
		    </nobr>
	   	</div>
	   	<div class="container">
	   		<div class="container-account-navigation">
	   			<nobr>
		              <a href="/account/info">Информация о Вас</a>
	  			</nobr>
	  			
		  		<nobr>
		  			 <a href="/account/history">История заказов</a>
		  		</nobr>
		  		<nobr>
		  			 <a href="/account/wish">Пожелания</a>
		  		</nobr>
		  		<nobr>
		  			 <a href="/account/logout">Выйти</a>
		  		</nobr>
		  	</div>
		  	<div class="container-account-info">		  	
			  	<form action="/account/info/change/submit" method = POST>
			  		<p3>Введите логин:    </p3><input type="text" name="login" value="${user.login}" pattern = "^[a-zA-Z_0-9]{3,15}$"> <br>
				  	<p3>Введите телефон:</p3><input type="text" name="telephone" value="${user.telephone}" pattern="[\+]\d{2}[\(]\d{3}[\)]\d{3}[\-]\d{2}[\-]\d{2}"> <br>
				  	<p3>Введите адресс: </p3><input type="text" name="address" value="${user.address}" pattern = "^{5,30}$"> <br><br>
			   		<input type="submit" value="Подтвердить">
			   	</form>
		   	</div>
	   	</div>
</div>
</body>
</html>