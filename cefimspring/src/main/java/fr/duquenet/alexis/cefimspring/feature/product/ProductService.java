package fr.duquenet.alexis.cefimspring.feature.product;

import fr.duquenet.alexis.cefimspring.classes.Product;
import fr.duquenet.alexis.cefimspring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product insertNewProduct(Product produit){
        return productRepository.save(produit);
    }
    public void deleteProduct(Integer produitId){
        productRepository.deleteById(produitId);
    }
}

