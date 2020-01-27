package org.fasttrackit.onlinefoods.transfer;

import javax.validation.constraints.NotBlank;

public class UpdateFoodsRequest {
    @NotBlank
    private String name;
    private String properties;
    private int quantity;
    @NotBlank
    private String category;
    private boolean eaten;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
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

    public boolean isEaten() {
        return eaten;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    @Override
    public String toString() {
        return "UpdateFoodsRequest{" +
                "name='" + name + '\'' +
                ", properties='" + properties + '\'' +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", eaten=" + eaten +
                '}';
    }
}
