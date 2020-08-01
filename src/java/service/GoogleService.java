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
public class GoogleService {

    private static String AUTHEN_TYPE = "oauth2";
    private static String SCOPE = "email";
    private static String REDIRECT_URI = "http://localhost:8080/webserver/login-google";
    private static String RESPONSE_TYPE = "code";
    private static String PROMPT = "force";

    public static String buildGoogleLoginLink() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://accounts.google.com/o/" + AUTHEN_TYPE + "/auth");
        sb.append("?scope=" + SCOPE);
        sb.append("&redirect_uri=" + REDIRECT_URI);
        sb.append("&response_type=" + RESPONSE_TYPE);
        sb.append("&client_id=" + Constants.GOOGLE_CLIENT_ID);
        sb.append("&approval_prompt=" + PROMPT);
        return sb.toString();
    }
}
