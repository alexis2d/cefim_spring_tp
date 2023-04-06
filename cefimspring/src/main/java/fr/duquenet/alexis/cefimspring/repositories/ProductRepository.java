package fr.duquenet.alexis.cefimspring.repositories;

import fr.duquenet.alexis.cefimspring.classes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}