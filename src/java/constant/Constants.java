/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

/**
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
public class Constants {

    public static String GOOGLE_CLIENT_ID = "250584059643-ndla8ficei1eb1j986k7k2pnl7sqi2vt.apps.googleusercontent.com";
    public static String GOOGLE_CLIENT_SECRET = "7Kfb54MOIwXpNtLb3nnHw33R";
    public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/webserver/login-google";
    public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static String GOOGLE_GRANT_TYPE = "authorization_code";

    public static String FACEBOOK_APP_ID = "641817340020177";
    public static String FACEBOOK_APP_SECRET = "d18f4f99e787280dc91a4ffd331630c6";
    public static String FACEBOOK_REDIRECT_URL = "http://localhost:8080/webserver/login-fb";
    public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";

    public static String PAYPAL_CLIENT_ID = "AaKBrGthKZ9NK8HtluqXIRUMiSbHu030_mZjaxg6IJM9sbDiPhAtJw1xbkhi7p90IuLzdpnNX2Go7TuH";
    public static String PAYPAL_CLIENT_SECRET = "ECL9wbGde_1eR5EFgZ7-iB9mJeKA_yAvJtjHqPlDWdsjtHVrpGfVCwDNAPSHTXYJ9ObwmZr68P7ByXzT";
    public static String PAYPAL_MODE = "sandbox";

    public static String HOST = "http://localhost:8888";
    public static String PRODUCT_SERVICE_ENDPOINT = "/products";
    public static String USER_SERVICE_ENDPOINT = "/user";
    public static String ORDER_SERVICE_ENDPOINT = "/order";
}
