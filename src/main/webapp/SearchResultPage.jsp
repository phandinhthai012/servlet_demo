<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" content="text/html" http-equiv="Content-Type">
<title>SearchResultPage</title>
<link rel="stylesheet" type="text/css" href="css/style2.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />

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
				<c:forEach items="${listSearch}" var="x">
					<div class="title">
						<a href="detail?id=${x.id}"> ${x.title}</a>
					</div>
					<div class="image">
						<img src="images/${x.image}" alt="" />
					</div>
					<div class="description">${x.shortDes}</div>
				</c:forEach>
				<div class="paging">
					<c:if test="${maxPage < 1}">
						<h3>Not Found !!</h3>
					</c:if>
					<c:if test="${maxPage >= 1}">
						<c:forEach begin="1" end="${maxPage}" var="i">
							<a class="${i==index?"
								active":""}" href="SearchControl?index=${i}&txtSearch=${txt}">${i}</a>
						</c:forEach>
					</c:if>
				</div>
				<%-- This is JSP comment
			<div class="paging">
					<c:if test="${3 > 1}">
						<c:forEach begin="1" end="3" var="i">
							<a href="#">${i}</a>
						</c:forEach>
					</c:if>
				</div> --%>


			</div>
			<div class="right">
				<div class="new">Digital news</div>
				<div class="contentNews">${t.top1.shortDes}</div>
				<div class="newR">Search</div>
				<div class="search">
				<form action="SearchControl" method="post">
					<input type="text" name="txtSearch" placeholder="search here" class="iputText"> 
					<input class="submitTxt" type="submit" value="go">
				</form>
					
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