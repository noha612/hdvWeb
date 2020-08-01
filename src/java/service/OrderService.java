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
import dto.OrderDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
public class OrderService {

    public void order(OrderDTO orderDTO) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(orderDTO);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String result = "";
        result = ApiCaller.doPost(
                Constants.HOST,
                Constants.ORDER_SERVICE_ENDPOINT,
                null,
                jsonString);
    }
}
