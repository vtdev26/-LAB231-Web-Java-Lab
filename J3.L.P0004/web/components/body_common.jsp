<%-- 
    Document   : body
    Created on : May 9, 2021, 9:39:53 PM
    Author     : s1tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/body_common.css" rel="stylesheet" type="text/css" />
        <title>Home</title>
    </head>
    <body>
        <div class="right">
            <div class="recent">
                <div class="titleNews">
                    <span>Digital News</span>
                </div>
                <div class="contentNews">
                    ${mostRecentArticle.shortDescription}
                </div>
            </div>
            <div class="recent">
                <div class="titleNews">
                    Search
                </div>
                <form action="search" method="post">
                    <input class="searchBox" type="text" name="txtSearch" size="15" required>
                    <input class="searchButton" type="submit" name="btnGo" value="Go">
                </form>
            </div>
            <div class="recent">
                <div class="titleNews">
                    <span> Last Articles </span><br>
                </div>
                <c:forEach var="item" items="${fiveRecentArticle}">
                    <div class="lastArticles">
                        <a href="detail?id=${item.id}">${item.title}</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
