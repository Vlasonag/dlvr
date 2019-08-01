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
		   	<form action="make_order_with_info" method = POST>
			   		Телефон:<input type="text" name="telephone" value="+38(093)388-32-65" pattern="[\+]\d{2}[\(]\d{3}[\)]\d{3}[\-]\d{2}[\-]\d{2}" required><br><br>
			   		Адресc:  <input type="text" name="address" value="ул. Жукова 24, 145 кв..." required><br><br>
			   		Время:	 <input type="time" id="time" name="time" min="${mintime}" max="23:59" required> (время доставки: не меньше часа!)
			   		<input type="submit" value="Заказать">
			   		</form>
	   	</div>
</div>
</body>
</html>