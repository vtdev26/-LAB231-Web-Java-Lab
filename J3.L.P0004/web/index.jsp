<%-- 
    Document   : index.jsp
    Created on : May 9, 2021, 9:32:01 PM
    Author     : s1tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css" />
        <title>Home Page</title>
    </head>
    <body>
        <div class="container">

            <!-- Header -->
            <%@include file="/components/header.jsp" %>

            <!-- Content -->
            <div class="content">
                <!-- Left -->
                <div class="main">
                    <div class="title">
                        ${articleModel.title}
                    </div>
                    <div class="image">
                        <img src="${articleModel.image}" />
                    </div>
                    <div class="text">
                        ${articleModel.content}
                    </div>
                    <div class="signature">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        By ${articleModel.author} | ${articleModel.date}
                    </div>
                </div>
                <!-- Right -->
                <%@include file="/components/body_common.jsp" %>
            </div>
            <!-- Footer -->
            <%@include file="/components/footer.jsp" %>
        </div>
    </body>
</html>
