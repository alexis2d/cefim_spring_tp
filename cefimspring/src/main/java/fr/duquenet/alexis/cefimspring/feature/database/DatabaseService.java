package fr.duquenet.alexis.cefimspring.feature.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    public List<String> getProductNameList() {
        Query query = entityManager.createNativeQuery("SELECT name FROM product;");
        List<String> results = ((List<String>) query.getResultList());
        return results;
    }

}
