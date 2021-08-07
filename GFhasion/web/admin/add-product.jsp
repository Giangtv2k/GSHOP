<%-- 
    Document   : add-product
    Created on : Jul 12, 2021, 12:08:49 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/manage.css" rel="stylesheet" type="text/css"/>
        <title></title>
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
                    <form action="/GFhasion/addProduct" method="POST">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>ID</label>
                                <input name="id" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Name</label>
                                <input name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Category ID</label><br/>
                                <input type="radio" name = "cid" value="1" required=""/>1-(T-Shirt) &nbsp;&nbsp;
                                <input type="radio" name = "cid" value="2" required=""/>2-(Hoodie)  &nbsp;&nbsp;
                                <input type="radio" name = "cid" value="3" required=""/>3-(Jacket)  &nbsp;&nbsp;
                                <input type="radio" name = "cid" value="4" required=""/>4-(Pants) 
                                <!--<input name="cid" class="form-control" required/>-->
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="image" type="file" class="form-control" onchange="readURL(this);" accept="image/*" required>
                                <img id="blah" width="100px" alt="image" />
                            </div>		
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <input name="description" type="text" class="form-control" required>
                            </div>	
                            <div class="form-group">
                                <label>Date Created</label>
                                <!--<p id="today"> <p>-->

                                <input name="dateCreated" type="date" id="today" class="form-control" value="" readonly="">
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

                                </script>
                            </div>	
                            <div class="form-group">
                                <label>Size</label> <br/>
                                M <input type="radio" name = "size" value="M" required=""/> &nbsp;&nbsp;
                                L <input type="radio" name = "size" value="L" required=""/> &nbsp;&nbsp;
                                XL <input type="radio" name = "size" value="XL" required=""/> 
                                <!--                                <input name="size" type="text" class="form-control" required>-->
                            </div>
                            <div class="form-group">
                                <label>Size Quantity</label>
                                <input name="quantity" type="number" min="1" class="form-control" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="managerProduct"><input type="button" value="Cancel"></a>
                            <input type="submit" value="Add">
                        </div>
                    </form>
                </div> 
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