package fr.duquenet.alexis.cefimspring.feature.database;

import fr.duquenet.alexis.cefimspring.classes.Product;
import fr.duquenet.alexis.cefimspring.classes.ProductDto;
import fr.duquenet.alexis.cefimspring.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService {
    @Autowired
    private EntityManager entityManager;
    private Logger logger = LoggerFactory.getLogger(DatabaseService.class);

    @Autowired
    private ProductRepository productRepository;

    public List<String> getProductNameList() {
        Query query = entityManager.createNativeQuery("SELECT name FROM product;");
        return ((List<String>) query.getResultList());
    }

    public List<ProductDto> getProductList() {
        String request = "SELECT id, name, description, price FROM product";
        Query query = entityManager.createNativeQuery(request, Tuple.class);
        List<Tuple> resultList = query.getResultList();
        return resultList.stream().map(ProductDto::new).toList();
    }

    public List<Product> getListProductFromEntity(){
        return productRepository.findAll();
    }

    public ProductDto getOneProduct(Integer id) {
        String request = "SELECT id, name, description, price FROM product WHERE id = :id";
        Query query = entityManager.createNativeQuery(request, Tuple.class)
                .setParameter("id", id);
        Tuple result = (Tuple) query.getSingleResult();
        return new ProductDto(result);
    }

    public Product getOneProductEntity(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

}
