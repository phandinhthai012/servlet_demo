<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8" content="text/html">

<title>Detail</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<div class="preHeader"></div>
		<div class="header">
			<h3>My digital news</h3>
		</div>
		<div class="menu">
			<a href="#">news</a>
		</div>
		<div class="main">
			<div class="left">

				<div class="title">${one.title}</div>
				<div class="image">
					<img alt="" src="images/${one.image}">
				</div>
				<div class="description">${one.description}</div>
				<div class="signature">
					<div class="icon1"></div>
					<div class="icon2"></div>
					By ${ one.author}| ${one.timePost}
				</div>
			</div>
			<div class="right">
				<div class="new">Digital news</div>
				<div class="contentNews">${one.shortDes}</div>
				<div class="newR">Search</div>
				<div class="search">
					<input type="text" name="txtSearch" placeholder="search here"
						class="iputText"> <input class="submitTxt" type="submit"
						value="go">
				</div>
				<div class="newR">Last Articles</div>
				<c:forEach items="${top5}" var="i">
					<div class="lastArticles">
						<a href="detail?id=${i.id}">${i.title}</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="footer"></div>
	</div>
</body>
</html>