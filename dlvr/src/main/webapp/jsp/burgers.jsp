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
	   	<p1>Бургеры</p1>
			<div class="container-product">
				<img src="photo/Pablo_Escobar.png">
				<p>Пабло Эскобар</p>
					<form action="burgers/addtobasket/16" method = POST>
						<p>120.00грн/шт</p>
						<p2>Состав: белый соус, сыр чеддер, соус барбекю, огурец, лист салата, булочка для бургера, две котлеты из говядины, синий сладкий лук, хашбраун</p2>
					    <input type="number" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<div class="container-product">
				<img src="photo/El_classico.png">
				<p>Эль классико</p>
					<form action="burgers/addtobasket/17" method = POST>
						<p>90.00грн/шт </p>
						<p2>Состав: томатный соус, маринованный огурец, сыр чеддер, картофельные дольки, котлета из говядины, жареный лук, жареный бекон</p2>
					    <input type="number" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<div class="container-product">
				<img src="photo/Shaggy.png">
				<p>Шегги</p>
					<form action="burgers/addtobasket/18" method = POST>
						<p>80.00грн/шт </p>
						<p2>Состав: томат, сыр чеддер, зерна горчицы, лист салата, котлета из говядины, жареное яйцо, жареный бекон</p2>
					    <input type="number" name="number" min="1" value="1" style="margin-top: 25px;">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<br>
			<hr>
			<div class="container-product">
				<img src="photo/Chicago.png">
				<p>Чикаго</p>
					<form action="burgers/addtobasket/19" method = POST>
						<p>80.00грн/шт </p>
						<p2>Состав: белый соус, сыр чеддер, жареные грибы, лист салата, котлета из говядины, жареный лук</p2>
					    <input type="number" name="number" min="1" value="1" style="margin-top: 25px;">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<div class="container-product">
				<img src="photo/Jazz_night.png">
				<p>Jazz Night</p>
					<form action="burgers/addtobasket/20" method = POST>
						<p>190.00грн/шт </p>
						<p2>Состав: маринованный огурец, устричный соус, стручковая фасоль, салат коул слоу, котлета из свинины, лук красный, булка с чернилами каракатицы</p2>
					    <input type="number" name="number" min="1" value="1">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
			<div class="container-product">
				<img src="photo/Liverpool.png">
				<p>Ливерпуль</p>
					<form action="burgers/addtobasket/21" method = POST>
						<p>150.00грн/шт </p>
						<p2>Состав: томатный соус, горчица, маринованный огурец, котлета из говядины, синий сладкий лук</p2>
					    <input type="number" name="number" min="1" value="1" style="margin-top: 25px;">
					    <input type="submit" value="В Корзину">
				    </form>
			</div>
	</div>	
</div>

</body>
</html>