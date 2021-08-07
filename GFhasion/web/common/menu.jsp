<%-- 
    Document   : menu
    Created on : Jul 5, 2021, 2:24:40 PM
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>G_Fashion nơi thỏa sức đam mê</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="../css/style.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/ddsmoothmenu.js" type="text/javascript"></script>
        <script type="text/javascript">

            ddsmoothmenu.init({
                mainmenuid: "top_nav", //menu DIV id
                orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
                classname: 'ddsmoothmenu', //class added to menu's outer DIV
                contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
            })

        </script>
    </head>
    <body>
        <div class="menubar">
            <div id="top_nav" class="ddsmoothmenu">
                <ul>
                   
                    <li><a href="HomeServlet" class="selected">Trang Chủ</a></li>
                    <li><a href="about">Giới thiệu</a></li>
                    <li><a href="contact">Liên Hệ</a></li>
                    <li><a href="https://www.facebook.com/giang.trieu.75685/" target="_blank">Facebook</a></li>
                    <c:set var="size" value="${sessionScope.numOfItems}"/>
                    <li><a href="addcart">${size}<i class="fas fa-shopping-cart fa-lg"></i><img ></a></li>
                    <li><c:if test="${sessionScope.user == null}"><a>Tài Khoản</a></c:if>
                        <c:if test="${sessionScope.user != null}"><a>${sessionScope.user.fullname}</a></c:if>
                        <ul>
                            <c:choose>
                                <c:when test="${sessionScope.user != null}">
                                    <li><a href="MyAccountController?code=${sessionScope.user.account}">${sessionScope.user.fullname}</a></li>
                                        <c:if test="${sessionScope.user.role == 1}">
                                        <li><a href="accountController">Quản lý tài khoản</a></li>
                                        <li><a href="managerProduct">Quản lý sản phẩm</a></li>
                                        </c:if>
                                    <li><a href="changPasswordController">Đổi mật khẩu</a></li>
                                    <li><a href="LogoutController">Đăng xuất</a></li>
                                    </c:when>
                                    <c:otherwise>
                                    <li><a href="LoginController">Đăng nhập</a></li>
                                    <li><a href="RegisterController">Đăng ký</a></li>
                                    </c:otherwise>
                                </c:choose>
                        </ul>
                    </li>
                </ul>
                <br style="clear: left" />
            </div> <!-- end of moothmenu -->
        </div><!-- END of menubar -->
    </body>
</html>
