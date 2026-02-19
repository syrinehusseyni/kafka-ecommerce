package tn.enis.kafka_ecommerce;

public class OrderRequest {
    private String orderId;
    private String product;
    private int quantity;
    private String customerEmail;

    // Getters & Setters
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
