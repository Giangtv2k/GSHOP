<%-- 
    Document   : Home
    Created on : Jul 5, 2021, 2:29:17 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <marquee style="color:black; font-weight:bold"  scrollamount="8" behavior="alternate">
        CHÀO MỪNG CÁC BẠN ĐẾN VỚI TRANG WEB GFASHION.COM!!!
    </marquee>

    <div id="templatemo_body_wrapper">
        <div id="templatemo_wrapper">
            <jsp:include page="../common/menu.jsp"></jsp:include>
                <div class="templatemo_main">
                <jsp:include page="../common/menu1.jsp"></jsp:include>
                    <div id="content" class="float_r">
                        <div id="slider-wrapper">
                            <img style="width: 620px; height: 300px" src="images/Demo.jpg" alt="" />
                        </div>
                        <marquee  style="color:red;font-weight:bold " scrollamount="8" behavior="alternate">
                            <h1 style="background:url(images/templatemo_list.png)">Sản Phẩm </h1></marquee>
                        
                        <c:forEach items="${listProduct1}" var="p">

                            <a href="ItemList?code=${p.getId()}"><img src="${p.getImage()}" /></a>
                            <h3 style="text-align:center">
                                ${p.getName()}
                            </h3>
                            <p class="product_price">${p.getPrice()}</p>
                            <!--                            <a href="thanhtoan28.html" class="addtocart"></a>
                                                        <a href="chitiet28.html" class="detail"></a>-->

                        </c:forEach>
                </div> 
                <div class="cleaner"></div>
            </div> 
        </div>
    </div>
</body>
</html>
