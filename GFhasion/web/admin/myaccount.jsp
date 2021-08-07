<%-- 
    Document   : myaccount
    Created on : Jul 6, 2021, 1:10:40 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
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
                        <a href='HomeServlet'>Back to home</a>
                        <form action="${pageContext.request.contextPath}//UpdateController" method="GET" style="margin: auto">
                        <div style="width: 300px; border: 2px solid blue; padding: 30px; margin: auto;background: white;text-align: center;margin-top: 100px">
                            <p style="padding-bottom: 30px; color: blue; font-size: 30px">Thông tin cá nhân</p>
                            Account:      <input style="margin-bottom: 20px" name="account" type="text" readonly value="${user.account}"><br>
                            Name:         <input style="margin-bottom: 20px" name="name" type="text" value="${user.getFullname()}"><br>
                            Address:      <input style="margin-bottom: 20px" name="address" type="text" value="${user.getAddress()}"><br>
                            Gender:       <input style="margin-bottom: 20px" type="radio" name="radio" value="Male" ${user.isGender() ? "checked" : ""}>Male
                            <input type="radio" name="radio" value="Female" ${user.isGender() ? "" : "checked"}> Female<br>
                            Date of birth:<input style="margin-bottom: 20px" name="dob" type="text" value="${user.getDob()}"><br>
                            Role:         <input style="margin-bottom: 20px" name="role" type="text" readonly value="${user.getRole()}"><br>
                            Points:       <input style="margin-bottom: 20px" name="points" type="number" readonly value="${user.getPoints()}"><br>
                            <p style="color: green"><%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%></p>
                            <input type="submit" value="Update">
                        </div>
                    </form>
                </div>
                <div class="cleaner"></div>
            </div> 
        </div>
    </div>
</body>
</html>
