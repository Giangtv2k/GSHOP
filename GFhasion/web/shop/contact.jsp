<%-- 
    Document   : contact
    Created on : Jul 5, 2021, 5:42:37 PM
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
                    <!-- InstanceBeginEditable name="9080" --><div id="content" class="float_r">
                        <marquee  style="color:red;font-weight:bold " scrollamount="8" behavior="slide">
                            <h1 style="background:url(../images/templatemo_list.png)">Liên Hệ</h1></marquee>
                        <div class="content_half float_l">
                            <p>Mọi Thắc Mắc Hay Góp ý Về Sản Phẩm.Xin Qúy Khách Vui Long Liên Hệ Địa Chỉ Hoặc Để Lại Thông Tin Để Nhân Viên Có Thể Tư Vấn Tốt Nhất Đến Qúy Khách Hàng.^-^</p>
                            <div id="contact_form">
                                <form method="post" name="contact" action="#">

                                    <label for="author">Họ Tên:</label> <input type="text" id="author" name="author" class="required input_field" />
                                    <div class="cleaner h10"></div>
                                    <label for="email">Email:</label> <input type="text" id="email" name="email" class="validate-email required input_field" />
                                    <div class="cleaner h10"></div>

                                    <label for="phone">Điện Thoại:</label> <input type="text" name="phone" id="phone" class="input_field" />
                                    <div class="cleaner h10"></div>

                                    <label for="text">Tin Nhắn:</label> <textarea id="text" name="text" rows="0" cols="0" class="required"></textarea>
                                    <div class="cleaner h10"></div>
                                    
                                    <input type="submit" class="submit_btn" name="submit" id="submit" value="Gửi" />

                                </form>
                            </div>
                        </div>
                        <div class="content_half float_r">
                            <h5>Văn Phòng Chi Nhánh</h5>
                            Trường ĐH-FPT <br />
                            Hòa Lạc, Thạch Hòa, Thạch Thất<br />
                            Hà Nội<br /><br />

                            Phone: 0362440656<br />
                            Email: <a href="mailto:trieuvangiang00@gmail.com">trieuvangiang00@gmail.com</a><br/>

                            <div class="cleaner h40"></div>

                            <h5>Tổng chi nhánh Shop</h5>
                            Trường ĐH-FPT <br />
                            Hòa Lạc, Thạch Hòa, Thạch Thất<br />
                            Hà Nội<br /><br />

                            Điện thoại: 0362440656<br />
                            Email: <a href="mailto:trieuvangiang00@gmail.com">trieuvangiang00@gmail.com</a><br/>
                            <br />

                        </div>

                        <div class="cleaner h40"></div>

                        <iframe width="680" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d114950.8966377376!2d105.49027568612838!3d21.021913727383172!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31345b465a4e65fb%3A0xaae6040cfabe8fe!2sFPT%20University!5e0!3m2!1sen!2sus!4v1623323320150!5m2!1sen!2sus" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>

                    </div>
                </div> 
                <div class="cleaner"></div>
            </div> 
        </div>
    </div>
</body>
</html>
