<%-- 
    Document   : paypal
    Created on : Jul 1, 2020, 10:43:46 PM
    Author     : Phạm Ngọc Hoàng - B16DCCN159
--%>

<%@page import="dto.CartDTO" %>
<%@page import="model.Product" %>
<%@page import="model.User" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <style>
            body {
                font-family: Arial;
                font-size: 17px;
                padding: 8px;
            }

            * {
                box-sizing: border-box;
            }

            .row {
                display: -ms-flexbox; /* IE10 */
                display: flex;
                -ms-flex-wrap: wrap; /* IE10 */
                flex-wrap: wrap;
                margin: 0 -16px;
            }

            .col-25 {
                -ms-flex: 25%; /* IE10 */
                flex: 25%;
            }

            .col-50 {
                -ms-flex: 50%; /* IE10 */
                flex: 50%;
            }

            .col-75 {
                -ms-flex: 75%; /* IE10 */
                flex: 75%;
            }

            .col-25,
            .col-50,
            .col-75 {
                padding: 0 16px;
            }

            .container {
                background-color: #f2f2f2;
                padding: 5px 20px 15px 20px;
                border: 1px solid lightgrey;
                border-radius: 3px;
            }

            input[type=text] {
                width: 100%;
                margin-bottom: 20px;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }
            select{
                width: 100%;
                margin-bottom: 20px;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 3px;                
            }

            label {
                margin-bottom: 10px;
                display: block;
            }

            .icon-container {
                margin-bottom: 20px;
                padding: 7px 0;
                font-size: 24px;
            }

            .btn {
                background-color: #4CAF50;
                color: white;
                padding: 12px;
                margin: 10px 0;
                border: none;
                width: 100%;
                border-radius: 3px;
                cursor: pointer;
                font-size: 17px;
            }

            .btn:hover {
                background-color: #45a049;
            }

            a {
                color: #2196F3;
            }

            hr {
                border: 1px solid lightgrey;
            }

            span.price {
                float: right;
                color: grey;
            }

            /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
            @media (max-width: 800px) {
                .row {
                    flex-direction: column-reverse;
                }

                .col-25 {
                    margin-bottom: 20px;
                }
            }

        </style>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="header.jsp"></jsp:include>
            </br></br>
        <% CartDTO cartDTO = (CartDTO) session.getAttribute("cartDTO"); %>
        <% User user = (User) session.getAttribute("user");%>
        <div class="row">
            <div class="col-75">
                <div class="container">
                    <form action="/webserver/paypal" method="post">
                        <div class="col-50">
                            <h3>Payment</h3>
                            <label>Accepted Cards</label>
                            <div class="icon-container">
                                <i class="fa fa-cc-visa" style="color:navy;"></i>
                                <i class="fa fa-cc-amex" style="color:blue;"></i>
                                <i class="fa fa-cc-mastercard" style="color:red;"></i>
                                <i class="fa fa-cc-discover" style="color:orange;"></i>
                            </div>
                            <label for="price">Total</label>
                            <input id="price" name="price" type="text" value="<%= cartDTO != null ? cartDTO.getTotalMoney() : 0%>" readonly>
                            <label for="currency">Currency</label>
                            <input id="currency" name="currency" placeholder="Enter Currency" type="text" value="USD" readonly>
                            <label for="method">Payment Method</label>
                            <select id="method" name="method" onchange="">
                                <option value="CashOnDelivery">Cash On Delivery</option>
                                <option value="PayPal">PayPal</option>                                
                            </select>
                            <!--<input id="method" name="method" placeholder="Payment Method" type="text">-->
                            <label for="description">Payment Description</label>
                            <input id="description" name="description" placeholder="Payment Description" type="text">

                        </div>

                        <input class="btn" type="submit" value="Continue to checkout">
                    </form>
                </div>
            </div>
            <div class="col-25">
                <div class="container">
                    <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b><%= cartDTO != null ? cartDTO.getList().size() : 0%></b></span></h4>

                    <%
                        if (cartDTO != null && cartDTO.getList().size() != 0) {
                            List<Product> listProduct = cartDTO.getList();
                            for (Product product : listProduct) {
                    %>
                    <p><a href="/webserver/detailProduct?product_id=<%= product.getId()%>"><%= product.getName()%></a> <span class="price">$<%= product.getPrice()%></span></p>
                    <%
                        }
                    } else {
                    %>
                    <h3>No Product</h3>
                    <%
                        }
                    %>
                    <hr>
                    <p>Total <span class="price" style="color:black"><b>$<%= cartDTO != null ? cartDTO.getTotalMoney() : 0%></b></span></p>
                </div>
            </div>
        </div>
        </br></br>
        <!--Footer-->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

