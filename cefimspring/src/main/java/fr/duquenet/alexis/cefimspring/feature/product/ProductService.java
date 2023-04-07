package fr.duquenet.alexis.cefimspring.feature.product;

import fr.duquenet.alexis.cefimspring.classes.Product;
import fr.duquenet.alexis.cefimspring.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product insertNewProduct(Product product){
        return productRepository.save(product);
    }
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

    public Product updateProduct(Integer id, Product product) throws EntityNotFoundException, ConstraintViolationException {
        Optional<Product> byId = productRepository.findById(id);

        if (byId.isEmpty()) {
            throw new EntityNotFoundException("product with ID %d not exist".formatted(id));
        }

        List<Product> byName = productRepository.findByNameContainingIgnoreCase(product.getName());
        if (byName.size() > 0) {
            throw new ConstraintViolationException("Name for product " + product.getName() + " already exist", new SQLException(), "product::name INDEX UNIQUE");
        }

        Product findProduct = byId.get();
        findProduct.setName(product.getName());
        findProduct.setDescription(product.getDescription());
        return productRepository.save(findProduct);
    }
}

