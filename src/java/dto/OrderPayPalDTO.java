package dto;

public class OrderPayPalDTO {

    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;

    public OrderPayPalDTO() {
    }

    public OrderPayPalDTO(double price, String currency, String method, String intent, String description) {
        this.price = price;
        this.currency = currency;
        this.method = method;
        this.intent = intent;
        this.description = description;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "price=" + price + ", currency=" + currency + ", method=" + method + ", intent=" + intent + ", description=" + description + '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
