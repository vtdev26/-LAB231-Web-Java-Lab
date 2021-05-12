<%-- 
    Document   : search
    Created on : May 10, 2021, 7:16:31 AM
    Author     : s1tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css" />
        <title>Search Page</title>
    </head>
    <body>
        <div class="container">
            <!-- Header -->
            <%@include file="/components/header.jsp" %>

            <!-- Content -->
            <div class="content">
                <div class="main">
                    <c:choose>
                        <c:when test="${not empty searchResult}">
                            <c:forEach var="item" items="${searchResult}" >
                                <div class="title">
                                    ${item.title}
                                </div>
                                <div class="image_search">
                                    <img src="${item.image}" />
                                </div>
                                <div class="text_search">
                                    ${item.shortDescription}
                                </div>
                                <br>
                            </c:forEach>
                            <!--Paging-->
                            <div class="paging">
                                <c:forEach var="item" begin="1" end="${visiblePage}">
                                    <a class="${item == currentPage ? "active":""}" href="search?page=${item}">${item} </a>
                                </c:forEach>
                            </div>
                        </c:when>
                        <c:otherwise>
                            Not Found!
                        </c:otherwise>
                    </c:choose>
                </div>
                <!-- Right -->
                <%@include file="/components/body_common.jsp" %>
            </div>
            <!-- Footer -->
            <%@include file="/components/footer.jsp" %>
        </div>
    </body>
</html>
