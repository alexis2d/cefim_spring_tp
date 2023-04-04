package fr.duquenet.alexis.cefimspring.classes;

import jakarta.persistence.Tuple;

import java.math.BigDecimal;
import java.util.Optional;

public class Product {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product(Tuple tuple){
        this.id = (int) tuple.get("id");
        this.name = (String) tuple.get("name");
        this.description = Optional.ofNullable(tuple.get("description")).map(field -> (String) field).orElse(null);
        this.price = BigDecimal.valueOf((Double) tuple.get("price"));
    }

    public Product(int id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }
}
