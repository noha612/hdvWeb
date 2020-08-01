/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import constant.Constants;

/**
 *
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
public class FacebookService {

    private static String AUTHEN_TYPE = "oauth";
    private static String REDIRECT_URI = "http://localhost:8080/webserver/login-fb";

    public static String buildFacebookLoginLink() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://www.facebook.com/dialog/" + AUTHEN_TYPE);
        sb.append("?client_id=" + Constants.FACEBOOK_APP_ID);
        sb.append("&redirect_uri=" + REDIRECT_URI);
        return sb.toString();
    }
}
