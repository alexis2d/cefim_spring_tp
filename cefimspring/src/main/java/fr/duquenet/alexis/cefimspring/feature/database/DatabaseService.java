package fr.duquenet.alexis.cefimspring.feature.database;

import fr.duquenet.alexis.cefimspring.classes.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatabaseService {
    @Autowired
    private EntityManager entityManager;
    private Logger logger = LoggerFactory.getLogger(DatabaseService.class);

    public List<String> getProductNameList() {
        Query query = entityManager.createNativeQuery("SELECT name FROM product;");
        List<String> results = ((List<String>) query.getResultList());
        return results;
    }

    public List<Product> getProductList() {
        Query query = entityManager.createNativeQuery("SELECT id,name,description,price FROM product;");
        List<Tuple> results = ((List<Tuple>) query.getResultList());
        List<Product> products = new ArrayList<Product>();
        products.add((Product) results.get(0));
        return products;
        //return results.stream().map(tuple -> (Product) tuple.getElements()).collect(Collectors.toList());
    }

}
