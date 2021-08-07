<%-- 
    Document   : menu1
    Created on : Jul 5, 2021, 2:37:49 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>G_Fashion nơi thỏa sức đam mê</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/ddsmoothmenu.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="sidebar" class="float_l">
            <div class="sidebar_box"><span class="bottom"></span>
                <div class="sidebar_box"><span class="bottom"></span>
                    <div class="content"> 
                        <div class="imageshow">
                            <a href="CategoryServlet?cid=2">
                                <img src="images/icon-hoodie.png">
                            </a>
                        </div>
                        <div class="imageshow">
                            <a href="CategoryServlet?cid=1">
                                <img src="images/icon-t-shirt.png">
                            </a>
                        </div>
                        <div class="imageshow">
                            <a href="CategoryServlet?cid=3">
                                <img src="images/icon-jacket.png">
                            </a>
                        </div>
                        <div class="imageshow">
                            <a href="CategoryServlet?cid=4">
                                <img src="images/icon-pants.png">
                            </a>
                        </div>
                       
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
