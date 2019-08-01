<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	   	<div class="container">
	   	<p1>Напитки</p1>
			<div class="container-product">
				<img src="photo/Bon_Aqua.png" style = "width: 180px; height: auto; margin-left: 11.5%;">
				<p>Бонаква</p>
					<form action="drinks/addtobasket/22" method = POST>
						<p>20.00грн/шт </p>
					    <input type="number" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<div class="container-product">
				<img src="photo/Coca_Cola.png" style = "width: 180px; height: auto; margin-left: 11.5%;">
				<p>Кока-Кола</p>
					<form action="drinks/addtobasket/23" method = POST>
						<p>24.00грн/шт </p>
					    <input type="number" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<div class="container-product">
				<img src="photo/Fuze_tea_лимон.png" style = "width: 270px; height: 270px; margin-left: 0%;">
				<p>Fuze Tea лимон</p>
					<form action="drinks/addtobasket/25" method = POST>
						<p>26.00грн/шт </p>
					    <input type="number" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<br>
			<hr>
			
			<div class="container-product">
				<img src="photo/Fuze_tea_персик.png" style = "width: 270px; height: 270px; margin-left: 0%;">
				<p>Fuze Tea персик</p>
					<form action="drinks/addtobasket/26" method = POST>
						<p>26.00грн/шт </p>
					    <input type="number" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
	</div>	
</div>
</body>
</html>