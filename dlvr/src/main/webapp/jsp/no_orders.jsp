<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/content.css">
<link type="text/css" rel="stylesheet" href="css/header.css">
</head>
<body>
<div class="body">
		<div class="header-top">
		<a href="/">D L V R</a>
		</div>
		
	    <div class="header-mid">
	    	<div class="header-mid-telephone">
			    	<p>
				    	<img src="photo/telephone_icon.png">
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
		    	<img src="photo/pizzas_icon.png">
		    	<a href="pizza">Пицца</a>
		    </nobr>
		    <nobr>
		    	<img src="photo/burgers_icon.png">
		    	<a href="burgers">Бургеры</a> 
		    </nobr>
		    <nobr>
		    	<img src="photo/drinks_icon.png">
		    	<a href="drinks">Напитки</a>
		    </nobr>
		    <nobr>
		    	<img src="photo/desserts_icon.png">
		    	<a href="desserts">Дессерты</a>
		    </nobr>
	   	</div> 
	   	<div class="container" style="padding-left:2%;">
	   		
		   		<h1>Вы еще ничего не заказали!</h1>
	   	</div>
</div>
</body>
</html>