package fr.duquenet.alexis.cefimspring.interfaces;

import fr.duquenet.alexis.cefimspring.classes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}