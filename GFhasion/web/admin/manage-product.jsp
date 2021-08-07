<%-- 
    Document   : manage-product
    Created on : Jul 10, 2021, 5:06:17 PM
    Author     : hp
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <div style="font-size: 15px">
                                <a href="HomeServlet" class="btn btn-success">Back to shop</a>                 
                                <a style="margin-left: 450px" href="addProduct">Add New Product</a>
                            </div>
                        <table border="1" style="width: 100%;color: black;font-size: 15px; text-align: center">
                            <thead>
                            <tr>
                                <td style="height: 40px">ID</td>
                                <td>Name</td>
                                <td>Cid</td>
                                <td>Image</td>
                                <td>Price</td>
                                <td>Description</td>
                                <td>Date create</td>
                                <td>Size</td>
                                <td>Quantity</td>
                                <td>Action</td>
                            </tr>
                            </thead>
                        <c:forEach items="${listProduct}" var="p">
                            <tr>
                                <td style="height: 30px">${p.id}</</td>
                                <td>${p.name}</td>
                                <td>${p.cid}</td>
                                <td><img width="90px" src="${p.image}" /></td>
                            
                                <td><fmt:formatNumber type="number" value="${p.price}"/></td>
                            <td>${p.description}</td>
                            <td>${p.dateCreated}</td>
                            <td>
                                <!--if productID equal size.pid -> print nameSize and calculate total quantity of each size-->
                                <c:set var="totalQuantity" value="${0}" /> 

                                <c:forEach items="${listSize}" var="s">
                                    <c:if test="${p.id == s.pid}">

                                        ${s.name} (${s.size_quantity}) <br/>

                                        <c:set var="totalQuantity" value="${totalQuantity + s.size_quantity}" />
                                    </c:if>
                                </c:forEach>

                            </td>
                            <td>
                                ${totalQuantity}
                            </td>

                            <td>
                                <!--#editEmployeeModal-->
                                <a href="loadDataToEditForm?pid=${p.id}">Edit</a>
                                <a href="DeleteProductServlet?pid=${p.id}">Delete</a>
                            </td>
                        </c:forEach>

                    </table>
                </div> 
                <div class="cleaner"></div>
            </div> 
        </div>
    </div>
</body>
</html>
