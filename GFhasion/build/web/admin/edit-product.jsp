<%-- 
    Document   : edit-product
    Created on : Jul 12, 2021, 4:22:56 PM
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
                    <form action="loadDataToEditForm" method="POST">
                        <div id="content" class="float_r">
                            <h4 class="modal-title">Edit Product</h4>
                            <label>ID</label>
                            <input value="${product.id}" name="id" type="text" readonly><br>
                        <label>Name</label>
                        <input value="${product.name}" name="name" type="text" required><br>
                        <label>Category ID</label><br/>
                        1-(T-Shirt) <input type="radio" name = "cid" value="1" required=""/> &nbsp;&nbsp;
                        2-(Hoodie) <input type="radio" name = "cid" value="2" required=""/> &nbsp;&nbsp;
                        3-(Jacket) <input type="radio" name = "cid" value="3" required=""/> &nbsp;&nbsp;
                        4-(Pants) <input type="radio" name = "cid" value="4" required=""/><br>
                        <label>Image</label>
                        <input value="${product.image}" name="image" type="file" onchange="readURL(this);" accept="image/*" required>
                        <img id="blah" width="100px" alt="image" /><br>
                        <label>Price</label>
                        <input value="${product.price}" name="price" type="text" required><br>
                        <label>Description</label>
                        <input value="${product.description}" name="description" type="text" required><br>
                        <label>Date Created</label>
                        <!--<p id="today"> <p>-->
                        <input value="" name="dateCreated" type="date" id="today" readonly="">
                        <script>
                            // body...
                            var today = new Date();
                            var dd = today.getDate();
                            var mm = today.getMonth() + 1; //January is 0!
                            var yyyy = today.getFullYear();

                            if (dd < 10) {
                                dd = '0' + dd;
                            }
                            if (mm < 10) {
                                mm = '0' + mm;
                            }

                            today = yyyy + '-' + mm + '-' + dd;
                            document.getElementById('today').value = today + "";
                        </script><br>
                        <label>Size</label> <br/>
                        M <input type="radio" name = "size" value="M" required=""/> &nbsp;&nbsp;
                        L <input type="radio" name = "size" value="L" required=""/> &nbsp;&nbsp;
                        XL <input type="radio" name = "size" value="XL" required=""/><br>
                        <label>Size Quantity</label>
                        <input name="quantity" type="number" min="0" required><br>
                        <a href="managerProduct"><input type="button" data-dismiss="modal" value="Cancel"></a>
                        <input type="submit" value="Save">
                    </div>
                </form>
                <div class="cleaner"></div>
            </div> 
        </div>
    </div>
</body>
</html>
<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>