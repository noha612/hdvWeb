/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.List;
import model.Product;
import model.User;

/**
 *
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
public class OrderDTO {

    private User user;
    private String method;
    private String date;
    private String status;

    private List<Product> items;

    public OrderDTO() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "user=" + user + ", method=" + method + ", date=" + date + ", status=" + status + ", items=" + items + '}';
    }

}
