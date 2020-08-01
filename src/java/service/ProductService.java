/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import api.ApiCaller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Product;
import org.apache.http.ParseException;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import constant.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SA Nice
 */
public class ProductService {

    public boolean addProduct(Product product) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(product);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String result = "";
        result = ApiCaller.doPost(
                Constants.HOST,
                Constants.PRODUCT_SERVICE_ENDPOINT,
                null,
                jsonString);
        return result.equals("ok");
    }

    public List<Product> getProductByType(int type_product_id) {
        List<Product> lp = new ArrayList<>();
        try {
            String result = "";
            Map<String, String> parameters = new HashMap<>();
            parameters.put("type_product_id", type_product_id + "");
            result = ApiCaller.doGet(
                    Constants.HOST,
                    Constants.PRODUCT_SERVICE_ENDPOINT,
                    parameters);
            ObjectMapper mapper = new ObjectMapper();
            Product[] products = mapper.readValue(result, Product[].class);
            lp = Arrays.asList(products);
        } catch (IOException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }

    public Product getProductByID(int id) {
        try {
            String result = "";
            result = ApiCaller.doGet(
                    Constants.HOST,
                    Constants.PRODUCT_SERVICE_ENDPOINT + "/" + id,
                    null);
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(result, Product.class);
            return product;
        } catch (IOException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean editProduct(int id, String name, int type_product_id, float price, String color, int quantity, String description, String link_image, String size) {
        Product product = new Product(id, name, size, type_product_id, price, link_image, color, quantity, description);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(product);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        String result = "";
        result = ApiCaller.doPut(
                Constants.HOST,
                Constants.PRODUCT_SERVICE_ENDPOINT,
                null,
                jsonString);
        return result.equals("ok");
    }

    public List<Product> searchProduct(String text_search) {
        List<Product> lp = new ArrayList<>();
        try {
            String result = "";
            Map<String, String> parameters = new HashMap<>();
            parameters.put("query_name", text_search);
            result = ApiCaller.doGet(
                    Constants.HOST,
                    Constants.PRODUCT_SERVICE_ENDPOINT,
                    parameters);
            ObjectMapper mapper = new ObjectMapper();
            Product[] products = mapper.readValue(result, Product[].class);
            lp = Arrays.asList(products);
        } catch (IOException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }

    public void deleteProductByID(int product_id) {
        try {
            String result = "";
            result = ApiCaller.doDelete(
                    Constants.HOST,
                    Constants.PRODUCT_SERVICE_ENDPOINT + "/" + product_id,
                    null);
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(result, Product.class);
        } catch (IOException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
