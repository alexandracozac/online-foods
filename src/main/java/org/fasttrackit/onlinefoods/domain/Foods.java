package org.fasttrackit.onlinefoods.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Foods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 1, max = 300)
    private String name;
    @NotNull
    private String properties;
    @NotNull
    private int quantity;
    @NotNull
    @Size(min = 1, max = 200)
    private String category;
    private boolean eaten;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return "Foods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", properties='" + properties + '\'' +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", eaten=" + eaten +
                '}';
    }
}

