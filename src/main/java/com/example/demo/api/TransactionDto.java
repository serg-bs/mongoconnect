package com.example.demo.api;


public class TransactionDto {


    private String id;
    private String store;
    private int quantity;
    private String category;

    public TransactionDto(String id, String name, int quantity, String category) {
        super();
        this.id = id;
        this.store = name;
        this.quantity = quantity;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
