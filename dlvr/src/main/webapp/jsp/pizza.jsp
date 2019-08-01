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
	   	<p1>Пицца</p1>
			<div class="container-product">
				<img src="photo/Pizza_pepperoni.png">
				<p>Пепперони с томатами</p>
					<form action="pizza/addtobasket" method = POST>
						<p><input name="id" type="radio" value="1">  22см = 50.00грн</p>
					    <p><input name="id" type="radio" value="2"> 30см = 100.00грн</p>
					    <p><input name="id" type="radio" value="3" checked> 36см = 150.00грн</p>
					    <p2>Моцарелла, Пепперони, Помидоры, Соус Барбекю</p2>
					    <input type="number" size="2" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<div class="container-product">
				<img src="photo/Pizza_hawai.png">
				<p>Гавайская</p>
					<form action="pizza/addtobasket" method = POST>
						<p><input name="id" type="radio" value="4"> 22см = 55.00грн </p>
					    <p><input name="id" type="radio" value="5"> 30см = 110.00грн</p>
					    <p><input name="id" type="radio" value="6" checked> 36см = 165.00грн</p>
					    <p2>Курица, Моцарелла, Ананас, Соус Domino's</p2>
					    <input type="number" size="2" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<div class="container-product">
				<img src="photo/Pizza_country.png">
				<p>Кантри</p>
					<form action="pizza/addtobasket" method = POST>
						<p><input name="id" type="radio" value="7"> 22см = 60.00грн </p>
					    <p><input name="id" type="radio" value="8"> 30см = 120.00грн</p>
					    <p><input name="id" type="radio" value="9" checked> 36см = 180.00грн</p>
					    <p2>Моцарелла, Лук, Бекон, Ветчина, Грибы, Огурцы маринованные, Соус Чесночный</p2>
					    <input type="number" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<hr>
			<div class="container-product">
				<img src="photo/Pizza_americano.png">
				<p>Американа</p>
					<form action="pizza/addtobasket" method = POST>
						<p><input name="id" type="radio" value="10"> 22см = 80.00грн </p>
					    <p><input name="id" type="radio" value="11"> 30см = 160.00грн</p>
					    <p><input name="id" type="radio" value="12" checked> 36см = 240.00грн</p>
					    <p2>Моцарелла, Бекон, Ветчина, Пепперони, Соус Domino's</p2>
					    <input type="number" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<div class="container-product">
				<img src="photo/Pizza_5_cheese.png">
				<p>Пять сыров</p>
					<form action="pizza/addtobasket" method = POST>
						<p><input name="id" type="radio" value="13"> 22см = 100.00грн</p>
					    <p><input name="id" type="radio" value="14"> 30см = 200.00грн</p>
					    <p><input name="id" type="radio" value="15" checked> 36см = 300.00грн</p>
					    <p2>Фета, Моцарелла, Пармезан, Бергадер Блю, Соус Альфредо, Чедер</p2>
					    <input type="number" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
	</div>	
</div>

</body>
</html>