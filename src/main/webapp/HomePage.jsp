<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:useBean id="t" class="dao.DigitalDao" scope="request" />
<meta charset="UTF-8" content="text/html" http-equiv="Content-Type">
<title>HomePage</title>
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

				<div class="title">${t.top1.title}</div>
				<div class="image">
					<img alt="" src="images/${t.top1.image}">
				</div>
				<div class="description">${t.top1.description}</div>
				<div class="signature">
					<div class="icon1"></div>
					<div class="icon2"></div>
				</div>
				<div class="infomation">${t.top1.author}| ${t.top1.timePost}</div>
			</div>
			<div class="right">
				<div class="new">Digital news</div>
				<div class="contentNews">${t.top1.shortDes}</div>
				<div class="newR">Search</div>
				<div class="search">
					<input type="text" name="txtSearch" placeholder="search here"
						class="iputText"> <input class="submitTxt" type="submit"
						value="go">
				</div>
				<div class="newR">Last Articles</div>
				<c:forEach items="${t.top5}" var="i">
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