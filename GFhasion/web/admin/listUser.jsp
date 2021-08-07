<%-- 
    Document   : listUser
    Created on : Jul 6, 2021, 12:14:43 PM
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
                        <table border="1" style="width: 100%;color: black;font-size: 15px; text-align: center">
                            <tr>
                                <td style="height: 40px">Account</td>
                                <td>Password</td>
                                <td>Name</td>
                                <td>Address</td>
                                <td>Gender</td>
                                <td>Date of birth</td>
                                <td>Role</td>
                                <td>Points</td>
                                <td>Detail</td>
                            </tr>
                            <c:forEach items="${listAccount}" var="account">
                            <tr>
                                <td style="height: 30px">${account.getAccount()}</td>
                                <td>${account.getPassword()}</td>
                                <td>${account.getFullname()}</td>
                                <td>${account.getAddress()}</td>
                                <td>${account.isGender()}</td>
                                <td>${account.getDob()}</td>
                                <td>${account.getRole()}</td>
                                <td>${account.getPoints()}</td>
                                
                               <td><a href='MyAccountController?code=${account.getAccount()}'>Detail</a>
                               || <a href='deleteAccount?code=${account.getAccount()}'>Delete</a></td>
                            </tr>
                        </c:forEach>
                       
                    </table>
                </div> 
                <div class="cleaner"></div>
            </div> 
        </div>
    </div>
</body>
</html>
