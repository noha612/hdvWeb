/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import constant.Constants;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import service.ProductService;

/**
 *
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
public class ApiCaller {

    public static String doGet(String host, String endpoint, Map<String, String> parameters) {
        String result = "";
        try {
            URIBuilder builder = new URIBuilder(host + endpoint);
            if (parameters != null) {
                for (String key : parameters.keySet()) {
                    builder.setParameter(key, parameters.get(key));
                }
            }
            HttpGet get = new HttpGet(builder.build());

            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(get);

            result = EntityUtils.toString(response.getEntity());
        } catch (IOException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static String doPost(String host, String endpoint, Map<String, String> parameters, String jsonString) {
        String result = "";
        try {
            URIBuilder builder = new URIBuilder(host + endpoint);
            if (parameters != null) {
                for (String key : parameters.keySet()) {
                    builder.setParameter(key, parameters.get(key));
                }
            }
            HttpPost post = new HttpPost(builder.build());

            post.addHeader("Content-Type", "application/json");
            if (jsonString != null && !jsonString.equals("")) {
                post.setEntity(new StringEntity(jsonString));
            }

            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(post);

            result = EntityUtils.toString(response.getEntity());
        } catch (IOException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    public static String doPut(String host, String endpoint, Map<String, String> parameters, String jsonString) {
        String result = "";
        try {
            URIBuilder builder = new URIBuilder(host + endpoint);
            if (parameters != null) {
                for (String key : parameters.keySet()) {
                    builder.setParameter(key, parameters.get(key));
                }
            }
            HttpPut put = new HttpPut(builder.build());

            put.addHeader("Content-Type", "application/json");
            if (jsonString != null && !jsonString.equals("")) {
                put.setEntity(new StringEntity(jsonString));
            }

            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(put);

            result = EntityUtils.toString(response.getEntity());
        } catch (IOException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    public static String doDelete(String host, String endpoint, Map<String, String> parameters) {
        String result = "";
        try {
            URIBuilder builder = new URIBuilder(host + endpoint);
            if (parameters != null) {
                for (String key : parameters.keySet()) {
                    builder.setParameter(key, parameters.get(key));
                }
            }
            HttpDelete delete = new HttpDelete(builder.build());

            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(delete);

            result = EntityUtils.toString(response.getEntity());
        } catch (IOException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }

    public static void main(String[] args) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("query_name", "bi");
        System.out.println(ApiCaller.doGet(Constants.HOST, Constants.PRODUCT_SERVICE_ENDPOINT, parameters));
    }
}
