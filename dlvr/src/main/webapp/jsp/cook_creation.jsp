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
		              <a href="/account/admin_page/create_cook">Создать повара</a>
	  			</nobr>
	  			
		  		<nobr>
		  			 <a href="/account/admin_page/create_courier">Создать курьера</a>
		  		</nobr>
		  		<nobr>
		  			 <a href="/account/admin_page/show_wishes">Пожелания</a>
		  		</nobr>
		  		<nobr>
		  			 <a href="/account/logout">Выйти</a>
		  		</nobr>
		  		<br><br><br><br>
		  		<nobr>
		  			 <a href="/account/admin_page/assign_cook">Назначить повара</a>
		  		</nobr>
		  		<nobr>
		  			 <a href="/account/admin_page/assign_courier">Назначить курьера</a>
		  		</nobr>
		  	</div>
			  	<div class="container-account-info">			  	
		   		<form action="/account/admin_page/create_cook/create" method = POST>
		   			<h1>Создание повара</h1>
			   		Логин:  <input type="text" name="login" pattern = "^[a-zA-Z_0-9]{3,15}$" required><br><br>
			   		Пароль: <input type="password" name="password"  pattern = "^[a-zA-Z_0-9]{3,15}$" required><br><br>
			   		Телефон:<input type="text" name="telephone" value="+38(093)388-32-65" pattern="[\+]\d{2}[\(]\d{3}[\)]\d{3}[\-]\d{2}[\-]\d{2}" required><br><br>
			   		Адресc:  <input type="text" name="address" value="ул. Жукова 24, 145 кв..." required>
			   		<input type="submit" value="Создать">
			   </form>
		   	</div>
	   	</div>
	</div>
</body>
</html>