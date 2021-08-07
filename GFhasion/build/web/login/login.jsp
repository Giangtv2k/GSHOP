<%-- 
    Document   : login
    Created on : Jul 5, 2021, 6:03:09 PM
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
                    <form action="${pageContext.request.contextPath}//LoginController" method="POST" style="margin:auto">
                        <div style="width: 300px; border: 2px solid blue; padding: 30px; margin: auto;background: white;text-align: center;margin-top: 100px">
                            <p style="padding-bottom: 30px; color: blue; font-size: 30px">ĐĂNG NHẬP</p>
                            <%
                                String account = "";
                                if (request.getAttribute("account") != null) {
                                    account = (String) request.getAttribute("account");
                                }
                            %>
                            <b style="text-align: center; color: black"><%=(request.getAttribute("error")) == null ? "" : request.getAttribute("error")%><br></b>
                            Account: <input type="text" placeholder="Username" name="account" value="<%=account%>" style="margin-bottom: 30px;background-color: aqua"><br>
                            Password: <input type="password" placeholder="Password" name="pass" value="<%=(request.getAttribute("pass")) == null ? "" : request.getAttribute("pass")%>" style="margin-bottom: 30px;background-color: aqua"><br>
                            <input type="submit" name="submit" value="Đăng nhập">
                            <!--                            <input type="reset" value="Xóa" width="60px" style="margin-bottom: 30px"><br>-->


                            <a href="RegisterController">Đăng ký</a> 
                            <br><%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%>
                        </div>
                    </form>
                </div> 
                <div class="cleaner"></div>
            </div> 
        </div>
    </div>
</body>
</html>
