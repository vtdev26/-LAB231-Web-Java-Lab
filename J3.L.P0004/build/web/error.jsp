<%-- 
    Document   : error
    Created on : May 10, 2021, 7:27:16 AM
    Author     : s1tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="public/css/style.css" rel="stylesheet" type="text/css" />
        <title>Error Page</title>
    </head>
    <body>
        <div class="container">
                        <!-- Header -->
            <%@include file="/components/header.jsp" %>

            <!-- Content -->
            <div class="content">
                <!-- Left -->
                <div class="main">
                    <h2>ERROR</h2>
                </div>
                <!-- Right -->
                <%@include file="/components/body_common.jsp" %>
            </div>
            <!-- Footer -->
            <%@include file="/components/footer.jsp" %>
        </div>
    </body>
</html>
