package fr.duquenet.alexis.cefimspring.classes;

import java.math.BigDecimal;

public class ProductDtoWithCategory extends ProductDto {

    private int id_category;


    public ProductDtoWithCategory(int id, int id_category, String name, String description, BigDecimal price) {
        super(id, name, description, price);
        this.id_category = id_category;
    }
}
