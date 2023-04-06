package fr.duquenet.alexis.cefimspring.classes;

import jakarta.persistence.Tuple;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class ProductDto {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductDto(Tuple tuple){
        this.id = (Short) tuple.get("id");
        this.name = (String) tuple.get("name");
        this.description = Optional.ofNullable(tuple.get("description")).map(field -> (String) field).orElse(null);
        this.price = (BigDecimal) tuple.get("price");
    }

    public ProductDto(int id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id && name.equals(that.name) && Objects.equals(description, that.description) && price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }
}
