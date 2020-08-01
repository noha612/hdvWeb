/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import api.ApiCaller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constant.Constants;
import model.User;
import org.apache.http.client.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.logging.Level;
import java.util.logging.Logger;
import service.ProductService;

/**
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
public class UserService {

    public User login(User u) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(u);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String result = "";
        result = ApiCaller.doPost(
                Constants.HOST,
                Constants.USER_SERVICE_ENDPOINT + "/login",
                null,
                jsonString);

        User user;
        try {
            user = mapper.readValue(result, User.class);
            return user;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean register(User u) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(u);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String result = "";
        result = ApiCaller.doPost(
                Constants.HOST,
                Constants.USER_SERVICE_ENDPOINT + "/register",
                null,
                jsonString);

        return result.equals("ok");
    }

    public boolean edit(User u) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(u);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String result = "";
        result = ApiCaller.doPost(
                Constants.HOST,
                Constants.USER_SERVICE_ENDPOINT + "/editProfile",
                null,
                jsonString);

        return result.equals("ok");
    }
}
