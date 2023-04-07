package fr.duquenet.alexis.cefimspring.repositories;

import fr.duquenet.alexis.cefimspring.classes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContainingIgnoreCase(String name);

    @Query("SELECT p FROM Product p where p.category.name = ?1")
    List<Product> findByCategoryName(String categoryName);

}