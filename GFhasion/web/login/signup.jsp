<%-- 
    Document   : signup
    Created on : Jul 5, 2021, 6:03:16 PM
    Author     : hp
--%>

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
                    <form action="${pageContext.request.contextPath}//RegisterController" method="POST" style="margin:auto">
                        <div style="width: 300px; border: 2px solid blue; padding: 30px; margin: auto;background: white;text-align: center;margin-top: 100px">
                            <p style="padding-bottom: 30px; color: blue; font-size: 30px">ĐĂNG KÝ</p>
                            <input type="text" placeholder="Username" name="account" value="<%=(request.getAttribute("account")) == null ? "" : request.getAttribute("account")%>" style="margin-bottom: 20px;background-color: aqua"><br>
                            <input type="password" placeholder="Password" name="pass" value="<%=(request.getAttribute("pass")) == null ? "" : request.getAttribute("pass")%>" style="margin-bottom: 20px;background-color: aqua"><br>
                            <input type="password" placeholder="Re-Password" name="repass" value="<%=(request.getAttribute("repass")) == null ? "" : request.getAttribute("repass")%>" style="margin-bottom: 20px;background-color: aqua"><br>
                            <input type="text" placeholder="Name" name="name" value="<%=(request.getAttribute("name")) == null ? "" : request.getAttribute("name")%>" style="margin-bottom: 20px;background-color: aqua"><br>
                            <b>Gender: <input ${male} type="radio" name="radio" required value="male" style="margin-bottom: 10px;background-color: aqua">Male
                                <input ${female} type="radio" name="radio" required value="female" style="margin-bottom: 20px;background-color: aqua">Female</b><br>
                            <input type="text" placeholder="address" name="address" value="<%=(request.getAttribute("address")) == null ? "" : request.getAttribute("address")%>" style="margin-bottom: 20px;background-color: aqua"><br>
                            Date of birth:<br><input type="date" name="dob" value="<%=(request.getAttribute("dob")) == null ? "" : request.getAttribute("dob")%>" style="margin-bottom: 20px;background-color: aqua"><br>

                            <input type="submit" name="submit" value="Đăng ký">
                            <input type="reset" value="Xóa" width="60px" style="margin-bottom: 20px">
                            <br><b style="color: red"><%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%></b>

                            <a href="LoginController">Đăng nhập</a>
                        </div>
                    </form>
                </div> 
                <div class="cleaner"></div>
            </div> 
        </div>
    </div>
</body>
</html>
