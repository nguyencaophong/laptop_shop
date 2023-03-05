package models;

import java.util.List;

public class Category {
    private  String nameCagetory;
    private List<Product> products;

    public Category(String nameCagetory, List<Product> products) {
        this.nameCagetory = nameCagetory;
        this.products = products;
    }

    public String getNameCagetory() {
        return nameCagetory;
    }

    public void setNameCagetory(String nameCagetory) {
        this.nameCagetory = nameCagetory;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
