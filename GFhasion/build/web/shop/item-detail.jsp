<%-- 
    Document   : list-item
    Created on : Jul 9, 2021, 10:22:05 AM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <div class="left-item">
                            <img width="100%" class="image-detail" src="${detail.image}" alt=""/>
                    </div>
                    <div class="right-item border-detail">
                        <div class="center-content">
                            <b><p style="text-align: center; font-size: 30px; font-family: serif;color: red"> ${detail.name}</p></b>
                            
                            <b><p style="text-align: center; font-size: 30px; font-family: serif; color: blue"> <fmt:formatNumber type="number" value="${detail.price}"/> ₫</p></b>
                            <strong><h3> MÔ TẢ</h3></strong>
                            <p style="text-align: center; font-size: 30px; font-family: serif;color: black">${detail.description}</p>
                            <strong><h3>HƯỚNG DẪN BẢO QUẢN</h3></strong>
                            <p style=" font-size: 15px; font-family: serif;color: black">
                                – Hạn chế giặt máy, nên giặt tay<br>
                                – Lộn trái khi giặt, nên phơi nơi nắng nhẹ, tránh ánh nắng trực tiếp.<br>
                                – Không giặt máy với các sản phẩm có tag nhựa 3D</p>
                        </div>

                        

                        <form action="addcart" method="POST">
                            <label class="font-bold">Product ID</label> 
                            <input type="text" name="pid" value="${pid}" readonly="" /><br/><br/>
                            <label class="font-bold">Size:</label>
                            <input type="radio" class="circle" name="size" value="M" onclick="showQuantity()" required="">M 
                            <input type="radio" class="circle" name="size" value="L" onclick="showQuantity()" required="">L
                            <input type="radio" class="circle" name="size" value="XL" onclick="showQuantity()" required="">XL
                            <p  class="hidden grey-text description" id="stock1"> ${requestScope.sizeM} </p>
                            <p  class="hidden grey-text description" id="stock2"> ${requestScope.sizeL} </p>
                            <p  class="hidden grey-text description" id="stock3"> ${requestScope.sizeXL} </p>


                            <div class="sub-form">
                                <label class="font-bold">Quantity:</label>
                                <input class="quantity-input" type="number" min="1" name="quantity" required=""/>
                                <c:if test="${sessionScope.user.role != 1}">
                                <button class="submit-bt" type="submit"/>Add to cart
                                </c:if>
                            </div>
                        </form>
                    </div>         
                </div> 
                <div class="cleaner"></div>
            </div> 
        </div>
    </div>
</body>
</html>

<script>

//    var showQuantity = function (n) {
    function showQuantity() {
        var sizeM = document.getElementById("stock1");
        var sizeL = document.getElementById("stock2");
        var sizeXL = document.getElementById("stock3");
        var radio = document.getElementsByName("size");
        for (var i = 0; i < radio.length; i++) {
            if (radio[0].checked === true) {
                sizeM.style.display = "block";
                sizeL.style.display = "none";
                sizeXL.style.display = "none";
            } else if (radio[1].checked === true) {
                sizeL.style.display = "block";
                sizeM.style.display = "none";
                sizeXL.style.display = "none";
            } else if (radio[2].checked === true) {
                sizeXL.style.display = "block";
                sizeM.style.display = "none";
                sizeL.style.display = "none";
            }
        }
    }
    ;

</script>
