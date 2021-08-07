<%-- 
    Document   : cart
    Created on : Jul 12, 2021, 10:59:41 PM
    Author     : hp
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styleCart.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form action="checkout" method="POST">
            <div class="container">
                <div class="heading">
                    <h1>
                        <span class="shopper"></span> Shopping Cart
                    </h1>
                    <p style="color: black">(${sessionScope.numOfItems}) items</p>
                    <p style="color: black"><%=(request.getAttribute("mes")) == null ? "" : request.getAttribute("mes")%></p>
                    <a href="#" class="visibility-cart transition is-open">X</a>    
                </div>

                <div class="cart transition is-open">

                    <a href="HomeServlet" class="btn btn-update">Back To Shopping</a>


                    <div class="table">
                        <div class="layout-inline row th">
                            <div class="col col-pro">Product</div>
                            <div class="col col-pid align-center "> 
                                Size
                            </div>
                            <div class="col col-pid align-center "> 
                                PID
                            </div>
                            <div class="col col-price align-center "> 
                                Price
                            </div>
                            <div class="col col-qty align-center">QTY</div>


                        </div>

                        <c:set var="o" value="${sessionScope.cart}"/>
                        <c:set var="total" value="${0}"/>

                        <%--<c:set var="t" value="0"/>--%>
                        <c:forEach items="${o.items}" var="i"> 
                            <%--<c:set var="t" value="${t+1}"/>--%>

                            <div class="layout-inline row">

                                <div class="col col-pro layout-inline">
                                    <img width="90px" src="${i.product.image}" alt="${i.product.name}" />
                                    <p>${i.product.name}</p>
                                </div>

                                <div class="col col-pid  align-center ">
                                    <input name="size" type="text" value="${i.size}" readonly=""/>
                                </div>

                                <div class="col col-pid  align-center ">
                                    <input name="pid" type="text" value="${i.product.id}" readonly=""/>
                                </div>

                                <div class="col col-price col-numeric align-center ">
                                    <p> <fmt:formatNumber type="number" value="${i.price}"/></p>
                                </div>

                                <div class="col col-qty layout-inline">
                                    <a href="cartProcess?quantity=-1&pid=${i.product.id}" class="qty qty-minus">-</a>
                                    <input type="text" readonly="" value="${i.quantity}" />
                                    <a href="cartProcess?quantity=1&pid=${i.product.id}" class="qty qty-plus">+</a>
                                    <div><input type="checkbox" name="checkout" value="${i.product.id}">Check out</div>
                                </div>


                                <div class="col col-total col-numeric">
                                    <c:set var="total" value="${total + i.price * i.quantity}"/>

                                </div>
                            </div>
                        </c:forEach>

                        <div class="tf">
                            <div class="row layout-inline">
                                <div class="col"></div>
                            </div>
                            <div class="row layout-inline">
                                <div class="col"></div>
                            </div>
                            <div class="row layout-inline">
                                <div class="">
                                    <p>Total</p>
                                    <p style="font-size: 1.5em;"><fmt:formatNumber type="number" value="${total}"/> VNĐ</p>
                                </div>
                                <div class="col">

                                </div>
                            </div>
                        </div>         
                    </div>

                    <c:if test="${total != 0}">

                        <input class="btn btn-update" type="submit" value="CHECK OUT"/>
                        <!--<a href="/myShop/checkout" class="btn btn-update">CHECK OUT</a>-->
                    </c:if>

                </div>
        </form>
    </body>
</html>
<script>
    $('.visibility-cart').on('click', function () {

        var $btn = $(this);
        var $cart = $('.cart');
        console.log($btn);

        if ($btn.hasClass('is-open')) {
            $btn.removeClass('is-open');
            $btn.text('O')
            $cart.removeClass('is-open');
            $cart.addClass('is-closed');
            $btn.addClass('is-closed');
        } else {
            $btn.addClass('is-open');
            $btn.text('X')
            $cart.addClass('is-open');
            $cart.removeClass('is-closed');
            $btn.removeClass('is-closed');
        }


    });
</script>